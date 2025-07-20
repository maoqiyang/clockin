package com.habittracker.app.ui.motivation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.habittracker.app.data.database.HabitDatabase
import com.habittracker.app.data.model.MotivationContent
import com.habittracker.app.data.repository.HabitRepository
import com.habittracker.app.network.NetworkClient
import kotlinx.coroutines.launch

class MotivationViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: HabitRepository
    
    private val _motivationContent = MutableLiveData<MotivationContent?>()
    val motivationContent: LiveData<MotivationContent?> = _motivationContent
    
    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading
    
    private val _errorMessage = MutableLiveData<String?>()
    val errorMessage: LiveData<String?> = _errorMessage
    
    private val _favoriteToggled = MutableLiveData<Boolean>()
    val favoriteToggled: LiveData<Boolean> = _favoriteToggled
    
    private var currentContent: MotivationContent? = null

    // Predefined motivational quotes
    private val defaultQuotes = listOf(
        "成功不是终点，失败不是末日，继续前进的勇气才最可贵。" to "温斯顿·丘吉尔",
        "你不能改变你的过去，但你可以让你的未来变得更好。" to "C.S.路易斯",
        "成功的秘诀在于坚持自己的目标。" to "本杰明·迪斯雷利",
        "每一个成功者都有一个开始。勇于开始，才能找到成功的路。" to "佚名",
        "不要等待机会，而要创造机会。" to "佚名",
        "今天的努力，明天的实力。" to "佚名",
        "坚持下去不是因为我很坚强，而是因为我别无选择。" to "佚名",
        "每天进步一点点，就是成功的开始。" to "佚名",
        "相信自己，你能做到的比你想象的更多。" to "佚名",
        "习惯决定性格，性格决定命运。" to "佚名"
    )

    init {
        val database = HabitDatabase.getDatabase(application)
        repository = HabitRepository(
            database.habitDao(),
            database.habitRecordDao(),
            database.motivationContentDao(),
            database.userSettingsDao()
        )
    }

    fun loadDailyMotivation() {
        viewModelScope.launch {
            _isLoading.value = true
            _errorMessage.value = null
            
            try {
                // Try to get random content from database first
                val cachedContent = repository.getRandomMotivationContent()
                
                if (cachedContent != null) {
                    currentContent = cachedContent
                    _motivationContent.value = cachedContent
                } else {
                    // Generate new content
                    generateNewContent()
                }
                
                // Try to load new image from network
                loadNetworkImage()
                
            } catch (e: Exception) {
                _errorMessage.value = "加载失败，显示缓存内容"
                // Fallback to cached content or default
                loadFallbackContent()
            } finally {
                _isLoading.value = false
            }
        }
    }

    private suspend fun generateNewContent() {
        val randomQuote = defaultQuotes.random()
        val imageUrl = NetworkClient.getDemoImageUrl()
        
        val newContent = MotivationContent(
            imageUrl = imageUrl,
            quote = randomQuote.first,
            author = randomQuote.second,
            isFromNetwork = true
        )
        
        val id = repository.insertMotivationContent(newContent)
        currentContent = newContent.copy(id = id)
        _motivationContent.value = currentContent
    }

    private suspend fun loadNetworkImage() {
        try {
            // Generate a new image URL for variety
            val newImageUrl = NetworkClient.getDemoImageUrl()
            currentContent?.let { content ->
                val updatedContent = content.copy(imageUrl = newImageUrl)
                currentContent = updatedContent
                _motivationContent.value = updatedContent
            }
        } catch (e: Exception) {
            // Network image loading failed, keep current content
        }
    }

    private suspend fun loadFallbackContent() {
        val fallbackContent = repository.getRandomMotivationContent()
        if (fallbackContent != null) {
            currentContent = fallbackContent
            _motivationContent.value = fallbackContent
        } else {
            // Create a default content
            val defaultQuote = defaultQuotes.random()
            val defaultContent = MotivationContent(
                imageUrl = "",
                quote = defaultQuote.first,
                author = defaultQuote.second,
                isFromNetwork = false
            )
            currentContent = defaultContent
            _motivationContent.value = defaultContent
        }
    }

    fun toggleFavorite() {
        viewModelScope.launch {
            currentContent?.let { content ->
                val newFavoriteStatus = !content.isFavorite
                
                if (content.id > 0) {
                    // Update existing content
                    repository.updateFavoriteStatus(content.id, newFavoriteStatus)
                } else {
                    // Insert new content as favorite
                    val favoriteContent = content.copy(isFavorite = newFavoriteStatus)
                    val id = repository.insertMotivationContent(favoriteContent)
                    currentContent = favoriteContent.copy(id = id)
                }
                
                currentContent = currentContent?.copy(isFavorite = newFavoriteStatus)
                _motivationContent.value = currentContent
                _favoriteToggled.value = newFavoriteStatus
            }
        }
    }
}
