package com.habittracker.app.network

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface UnsplashApiService {
    
    @GET("photos/random")
    suspend fun getRandomPhoto(
        @Query("client_id") clientId: String = "YOUR_UNSPLASH_ACCESS_KEY", // Replace with actual key
        @Query("query") query: String = "nature,landscape,motivation",
        @Query("orientation") orientation: String = "landscape",
        @Query("w") width: Int = 800,
        @Query("h") height: Int = 600
    ): Response<UnsplashPhoto>
    
    companion object {
        const val BASE_URL = "https://api.unsplash.com/"
        // For demo purposes, we'll use a placeholder service
        const val DEMO_BASE_URL = "https://picsum.photos/"
    }
}

data class UnsplashPhoto(
    val id: String,
    val urls: UnsplashUrls,
    val alt_description: String?,
    val description: String?,
    val user: UnsplashUser
)

data class UnsplashUrls(
    val raw: String,
    val full: String,
    val regular: String,
    val small: String,
    val thumb: String
)

data class UnsplashUser(
    val id: String,
    val username: String,
    val name: String
)
