package com.habittracker.app.data.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.habittracker.app.data.model.MotivationContent

@Dao
interface MotivationContentDao {
    
    @Query("SELECT * FROM motivation_content ORDER BY createdAt DESC")
    fun getAllContent(): LiveData<List<MotivationContent>>
    
    @Query("SELECT * FROM motivation_content WHERE isFavorite = 1 ORDER BY createdAt DESC")
    fun getFavoriteContent(): LiveData<List<MotivationContent>>
    
    @Query("SELECT * FROM motivation_content ORDER BY RANDOM() LIMIT 1")
    suspend fun getRandomContent(): MotivationContent?
    
    @Query("SELECT * FROM motivation_content WHERE isFavorite = 1 ORDER BY RANDOM() LIMIT 1")
    suspend fun getRandomFavoriteContent(): MotivationContent?
    
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertContent(content: MotivationContent): Long
    
    @Update
    suspend fun updateContent(content: MotivationContent)
    
    @Delete
    suspend fun deleteContent(content: MotivationContent)
    
    @Query("UPDATE motivation_content SET isFavorite = :isFavorite WHERE id = :id")
    suspend fun updateFavoriteStatus(id: Long, isFavorite: Boolean)
    
    @Query("DELETE FROM motivation_content WHERE isFromNetwork = 1 AND isFavorite = 0")
    suspend fun clearNonFavoriteNetworkContent()
    
    @Query("SELECT COUNT(*) FROM motivation_content")
    suspend fun getContentCount(): Int
}
