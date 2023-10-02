package com.codepath.articlesearch
import android.support.annotation.Keep
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import java.net.URL

@Keep
@Serializable
data class SearchPeopleResponse(
    @SerialName("results")
    val response: List<Movie>?
)

//@Keep
//@Serializable
//data class BaseResponse(
//    @SerialName("docs")
//    val docs: List<Movie>?
//)

@Keep
@Serializable
data class Movie(
    @SerialName("first_air_date")
    val firstAirDate: String?,
    @SerialName("name")
    val title: String?,
    @SerialName("original_name")
    val originalTitle: String?,
    @SerialName("overview")
    val overview: String?,
    @SerialName("poster_path")
    val poster: String?,
    @SerialName("backdrop_path")
    val backdrop: String?,
    ): java.io.Serializable {
    val mediaImageUrl = "https://image.tmdb.org/t/p/w500${poster}"
    val movieImageUrl = "https://image.tmdb.org/t/p/w500${backdrop}"


//     Accessing an item within an item
//    @SerialName("name")
////    val title: Byline?,

//    //Multimedia Extraction
//    @SerialName("multimedia")
//    val multimedia: List<MultiMedia>?,
//): java.io.Serializable {
//    val mediaImageUrl = "https://www.nytimes.com/${multimedia?.firstOrNull { it.url != null }?.url ?: ""}"
}

//@Keep
//@Serializable
//data class HeadLine(
//    @SerialName("main")
//    val main: String
//) : java.io.Serializable
//
//@Keep
//@Serializable
//data class Byline(
//    @SerialName("original")
//    val original: String? = null
//) : java.io.Serializable

//@Keep
//@Serializable
//data class MultiMedia(
//    @SerialName("url")
//    val url: String?
//) : java.io.Serializable
