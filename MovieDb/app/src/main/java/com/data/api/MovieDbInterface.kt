package com.data.api

import com.data.valueobject.MovieDetails
import com.data.valueobject.MovieResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieDbInterface {
    //https://api.themoviedb.org/3/movie/top_rated?api_key=0df9205e22f071e24e5abeba2aded6c6&language=en-US&page=1
    // https://api.themoviedb.org/3/movie/155?api_key=0df9205e22f071e24e5abeba2aded6c6
    // https://api.themoviedb.org/3/

     @GET("movie/popular")
     fun getPopularMovie(@Query("page") page: Int): Single<MovieResponse>


    @GET("movie/{movie_id}")
    fun getMovieDetails(@Path("movie_id") id: Int): Single<MovieDetails>
}