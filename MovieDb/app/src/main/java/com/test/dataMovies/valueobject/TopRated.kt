package com.test.dataMovies.valueobject


import com.google.gson.annotations.SerializedName

data class TopRated(
    @SerializedName("page")
    val page: Int,
    @SerializedName("results")
    val topRatedList: List<TopRatedItem>,
    @SerializedName("total_pages")
    val totalPages: Int,
    @SerializedName("total_results")
    val totalResults: Int
)