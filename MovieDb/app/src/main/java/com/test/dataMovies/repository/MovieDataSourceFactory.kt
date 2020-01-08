package com.test.dataMovies.repository

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.test.dataMovies.api.MovieDbInterface
import com.test.dataMovies.valueobject.Movie
import io.reactivex.disposables.CompositeDisposable

class MovieDataSourceFactory (private val apiService : MovieDbInterface, private val compositeDisposable: CompositeDisposable)
    : DataSource.Factory<Int, Movie>() {

    val moviesLiveDataSource =  MutableLiveData<MovieDataSource>()

    override fun create(): DataSource<Int, Movie> {
        val MovieDetailDataSource = MovieDataSource(apiService,compositeDisposable)

        moviesLiveDataSource.postValue(MovieDetailDataSource)
        return MovieDetailDataSource
    }
}