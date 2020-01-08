package com.test.dataMovies.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.test.dataMovies.api.MovieDbInterface
import com.test.dataMovies.valueobject.TopRated
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers


class TopRatedDataSource(private val apiService : MovieDbInterface, private val compositeDisposable: CompositeDisposable) {
    private val _networkState  = MutableLiveData<NetworkState>()
    val networkState: LiveData<NetworkState>
        get() = _networkState
    private val _downloadedTopratedItem =  MutableLiveData<TopRated>()
    val downloadedTopRatedItem: LiveData<TopRated>
        get() = _downloadedTopratedItem

    fun fetchTopRated(movieId: Int) {

        _networkState.postValue(NetworkState.LOADING)


        try {
            compositeDisposable.add(
                apiService.getTopRatedMovie(movieId)
                    .subscribeOn(Schedulers.io())
                    .subscribe(
                        {
                            _downloadedTopratedItem.postValue((it))
                            _networkState.postValue(NetworkState.LOADED)
                        },
                        {
                            _networkState.postValue(NetworkState.ERROR)
                            Log.e("TopRatedDataSource", it.message)
                        }
                    )
            )

        }

        catch (e: Exception){
            Log.e("TopRatedDataSource",e.message)
        }


    }

}