package com.habittracker.app.data.database;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\'\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&J\b\u0010\u0005\u001a\u00020\u0006H&J\b\u0010\u0007\u001a\u00020\bH&J\b\u0010\t\u001a\u00020\nH&\u00a8\u0006\f"}, d2 = {"Lcom/habittracker/app/data/database/HabitDatabase;", "Landroidx/room/RoomDatabase;", "()V", "habitDao", "Lcom/habittracker/app/data/dao/HabitDao;", "habitRecordDao", "Lcom/habittracker/app/data/dao/HabitRecordDao;", "motivationContentDao", "Lcom/habittracker/app/data/dao/MotivationContentDao;", "userSettingsDao", "Lcom/habittracker/app/data/dao/UserSettingsDao;", "Companion", "app_debug"})
@androidx.room.Database(entities = {com.habittracker.app.data.model.Habit.class, com.habittracker.app.data.model.HabitRecord.class, com.habittracker.app.data.model.MotivationContent.class, com.habittracker.app.data.model.UserSettings.class}, version = 1, exportSchema = false)
public abstract class HabitDatabase extends androidx.room.RoomDatabase {
    @kotlin.jvm.Volatile
    @org.jetbrains.annotations.Nullable
    private static volatile com.habittracker.app.data.database.HabitDatabase INSTANCE;
    @org.jetbrains.annotations.NotNull
    public static final com.habittracker.app.data.database.HabitDatabase.Companion Companion = null;
    
    public HabitDatabase() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public abstract com.habittracker.app.data.dao.HabitDao habitDao();
    
    @org.jetbrains.annotations.NotNull
    public abstract com.habittracker.app.data.dao.HabitRecordDao habitRecordDao();
    
    @org.jetbrains.annotations.NotNull
    public abstract com.habittracker.app.data.dao.MotivationContentDao motivationContentDao();
    
    @org.jetbrains.annotations.NotNull
    public abstract com.habittracker.app.data.dao.UserSettingsDao userSettingsDao();
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0001\fB\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007J\u0019\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0004H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000bR\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\r"}, d2 = {"Lcom/habittracker/app/data/database/HabitDatabase$Companion;", "", "()V", "INSTANCE", "Lcom/habittracker/app/data/database/HabitDatabase;", "getDatabase", "context", "Landroid/content/Context;", "populateDatabase", "", "database", "(Lcom/habittracker/app/data/database/HabitDatabase;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "DatabaseCallback", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.habittracker.app.data.database.HabitDatabase getDatabase(@org.jetbrains.annotations.NotNull
        android.content.Context context) {
            return null;
        }
        
        private final java.lang.Object populateDatabase(com.habittracker.app.data.database.HabitDatabase database, kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
            return null;
        }
        
        @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016\u00a8\u0006\u0007"}, d2 = {"Lcom/habittracker/app/data/database/HabitDatabase$Companion$DatabaseCallback;", "Landroidx/room/RoomDatabase$Callback;", "()V", "onCreate", "", "db", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "app_debug"})
        static final class DatabaseCallback extends androidx.room.RoomDatabase.Callback {
            
            public DatabaseCallback() {
                super();
            }
            
            @java.lang.Override
            public void onCreate(@org.jetbrains.annotations.NotNull
            androidx.sqlite.db.SupportSQLiteDatabase db) {
            }
        }
    }
}