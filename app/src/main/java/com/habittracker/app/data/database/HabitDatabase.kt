package com.habittracker.app.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.habittracker.app.data.dao.*
import com.habittracker.app.data.model.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Database(
    entities = [
        Habit::class,
        HabitRecord::class,
        MotivationContent::class,
        UserSettings::class
    ],
    version = 1,
    exportSchema = false
)
abstract class HabitDatabase : RoomDatabase() {
    
    abstract fun habitDao(): HabitDao
    abstract fun habitRecordDao(): HabitRecordDao
    abstract fun motivationContentDao(): MotivationContentDao
    abstract fun userSettingsDao(): UserSettingsDao
    
    companion object {
        @Volatile
        private var INSTANCE: HabitDatabase? = null
        
        fun getDatabase(context: Context): HabitDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    HabitDatabase::class.java,
                    "habit_database"
                )
                .addCallback(DatabaseCallback())
                .build()
                INSTANCE = instance
                instance
            }
        }
        
        private class DatabaseCallback : RoomDatabase.Callback() {
            override fun onCreate(db: SupportSQLiteDatabase) {
                super.onCreate(db)
                INSTANCE?.let { database ->
                    CoroutineScope(Dispatchers.IO).launch {
                        populateDatabase(database)
                    }
                }
            }
        }
        
        private suspend fun populateDatabase(database: HabitDatabase) {
            val habitDao = database.habitDao()
            val userSettingsDao = database.userSettingsDao()
            val motivationDao = database.motivationContentDao()
            
            // Insert default habits
            val defaultHabits = listOf(
                Habit(name = "是否锻炼", description = "每日运动锻炼", sortOrder = 0),
                Habit(name = "是否早睡", description = "保持良好作息", sortOrder = 1),
                Habit(name = "是否有良好穿搭", description = "注重个人形象", sortOrder = 2),
                Habit(name = "是否按时吃饭", description = "规律饮食习惯", sortOrder = 3)
            )
            
            defaultHabits.forEach { habit ->
                habitDao.insertHabit(habit)
            }
            
            // Insert default settings
            userSettingsDao.insertSettings(UserSettings())
            
            // Insert some default motivation quotes
            val defaultQuotes = listOf(
                MotivationContent(
                    imageUrl = "",
                    quote = "成功不是终点，失败不是末日，继续前进的勇气才最可贵。",
                    author = "温斯顿·丘吉尔",
                    isFromNetwork = false
                ),
                MotivationContent(
                    imageUrl = "",
                    quote = "你不能改变你的过去，但你可以让你的未来变得更好。",
                    author = "C.S.路易斯",
                    isFromNetwork = false
                ),
                MotivationContent(
                    imageUrl = "",
                    quote = "成功的秘诀在于坚持自己的目标。",
                    author = "本杰明·迪斯雷利",
                    isFromNetwork = false
                )
            )
            
            defaultQuotes.forEach { quote ->
                motivationDao.insertContent(quote)
            }
        }
    }
}
