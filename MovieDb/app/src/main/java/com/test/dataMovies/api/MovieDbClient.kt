package com.test.dataMovies.api


import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

const val API_KEY ="0df9205e22f071e24e5abeba2aded6c6"
const val BASE_URL = "https://api.themoviedb.org/3/"
const val POSTER_BASE_URL = "https://image.tmdb.org/t/p/w342"
const val TOP_RATED_URL ="https://api.themoviedb.org/3/movie/top_rated?api_key=0df9205e22f071e24e5abeba2aded6c6&language=en-US&page=1\n"

// https://api.themoviedb.org/3/movie/top_rated?api_key=0df9205e22f071e24e5abeba2aded6c6&language=en-US&page=1
// https://api.themoviedb.org/3/movie/155?api_key=0df9205e22f071e24e5abeba2aded6c6
// https://image.tmdb.org/t/p/w342/pKKvCaL1TPTVtbI6EeliyND3api.jpg

const val FIRST_PAGE = 1
const val POST_PER_PAGE= 99


    object MovieDbClient {

    fun getClient(): MovieDbInterface {

        val requestInterceptor = Interceptor { chain ->
            val url = chain.request()
                .url()
                .newBuilder()
                .addQueryParameter("api_key", API_KEY)
                .build()
            val request = chain.request()
                .newBuilder()
                .url(url)
                .build()

            return@Interceptor chain.proceed(request)
        }
        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(requestInterceptor)
            .connectTimeout(60, TimeUnit.SECONDS)
            .build()

        return Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(BASE_URL)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MovieDbInterface::class.java)


        }

    }
