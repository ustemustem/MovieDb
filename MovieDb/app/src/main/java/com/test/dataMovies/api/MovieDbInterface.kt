package com.test.dataMovies.api

import com.test.dataMovies.valueobject.MovieResponse
import com.test.dataMovies.valueobject.TopRated
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieDbInterface {
    //https://api.themoviedb.org/3/movie/top_rated?api_key=0df9205e22f071e24e5abeba2aded6c6&language=en-US&page=1
    // https://api.themoviedb.org/3/movie/155?api_key=0df9205e22f071e24e5abeba2aded6c6
    // https://api.themoviedb.org/3/

     @GET("movie/top_rated")
     fun getTopRatedMovie(@Query("page") page: Int): Single<TopRated>


    @GET("movie/{movie_id}")
    fun getMovieDetails(@Path("movie_id") id: Int): Single<MovieResponse>
}