package com.test.moviedb.ui.movies

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.test.dataMovies.api.MovieDbInterface
import com.test.dataMovies.api.POST_PER_PAGE
import com.test.dataMovies.repository.MovieDataSource
import com.test.dataMovies.repository.MovieDataSourceFactory
import com.test.dataMovies.repository.NetworkState
import com.test.dataMovies.valueobject.Movie
import io.reactivex.disposables.CompositeDisposable

class MoviePagedListRepository (private val apiService : MovieDbInterface) {

    lateinit var moviePagedList: LiveData<PagedList<Movie>>
    lateinit var moviesDataSourceFactory: MovieDataSourceFactory

    fun fetchLiveMoviePagedList (compositeDisposable: CompositeDisposable) : LiveData<PagedList<Movie>> {
        moviesDataSourceFactory = MovieDataSourceFactory(apiService, compositeDisposable)

        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setPageSize(POST_PER_PAGE)
            .build()

        moviePagedList = LivePagedListBuilder(moviesDataSourceFactory, config).build()

        return moviePagedList
    }

    fun getNetworkState(): LiveData<NetworkState> {
        return Transformations.switchMap<MovieDataSource, NetworkState>(
            moviesDataSourceFactory.moviesLiveDataSource, MovieDataSource::networkState)
    }
}