package com.habittracker.app.data.repository;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\f\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJ\u0019\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000fJ\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013J\u0011\u0010\u0014\u001a\u00020\u0015H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0016J\u0012\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u00190\u0018J\u0017\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0019H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0016J\u0012\u0010\u001b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001c0\u00190\u0018J%\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00150\u001e2\u0006\u0010\u0012\u001a\u00020\u0011H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001fJ\u0012\u0010 \u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001c0\u00190\u0018J\u0013\u0010!\u001a\u0004\u0018\u00010\u001cH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0016J#\u0010\"\u001a\u0004\u0018\u00010#2\u0006\u0010$\u001a\u00020%2\u0006\u0010\u0012\u001a\u00020\u0011H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010&J\'\u0010\'\u001a\b\u0012\u0004\u0012\u00020#0\u00192\u0006\u0010(\u001a\u00020\u00112\u0006\u0010)\u001a\u00020\u0011H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010*J\u001a\u0010+\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020#0\u00190\u00182\u0006\u0010\u0012\u001a\u00020\u0011J\u001f\u0010,\u001a\b\u0012\u0004\u0012\u00020#0\u00192\u0006\u0010\u0012\u001a\u00020\u0011H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001fJ\u0006\u0010-\u001a\u00020\u0011J\u000e\u0010.\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010/0\u0018J\u0013\u00100\u001a\u0004\u0018\u00010/H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0016J\u0019\u00101\u001a\u00020%2\u0006\u0010\r\u001a\u00020\u000eH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000fJ\u0019\u00102\u001a\u00020%2\u0006\u00103\u001a\u00020\u001cH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u00104J)\u00105\u001a\u00020\f2\u0006\u0010$\u001a\u00020%2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u00106\u001a\u000207H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u00108J!\u00109\u001a\u00020\f2\u0006\u0010:\u001a\u00020%2\u0006\u0010;\u001a\u000207H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010<J\u0019\u0010=\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000fJ\u0019\u0010>\u001a\u00020\f2\u0006\u0010?\u001a\u000207H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010@J\u0019\u0010A\u001a\u00020\f2\u0006\u0010B\u001a\u00020\u0011H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006C"}, d2 = {"Lcom/habittracker/app/data/repository/HabitRepository;", "", "habitDao", "Lcom/habittracker/app/data/dao/HabitDao;", "habitRecordDao", "Lcom/habittracker/app/data/dao/HabitRecordDao;", "motivationContentDao", "Lcom/habittracker/app/data/dao/MotivationContentDao;", "userSettingsDao", "Lcom/habittracker/app/data/dao/UserSettingsDao;", "(Lcom/habittracker/app/data/dao/HabitDao;Lcom/habittracker/app/data/dao/HabitRecordDao;Lcom/habittracker/app/data/dao/MotivationContentDao;Lcom/habittracker/app/data/dao/UserSettingsDao;)V", "deleteHabit", "", "habit", "Lcom/habittracker/app/data/model/Habit;", "(Lcom/habittracker/app/data/model/Habit;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "formatDate", "", "date", "Ljava/util/Date;", "getActiveHabitsCount", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllActiveHabits", "Landroidx/lifecycle/LiveData;", "", "getAllActiveHabitsSync", "getAllMotivationContent", "Lcom/habittracker/app/data/model/MotivationContent;", "getCompletionStats", "Lkotlin/Pair;", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getFavoriteMotivationContent", "getRandomMotivationContent", "getRecord", "Lcom/habittracker/app/data/model/HabitRecord;", "habitId", "", "(JLjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getRecordsBetweenDates", "startDate", "endDate", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getRecordsByDate", "getRecordsByDateSync", "getTodayDateString", "getUserSettings", "Lcom/habittracker/app/data/model/UserSettings;", "getUserSettingsSync", "insertHabit", "insertMotivationContent", "content", "(Lcom/habittracker/app/data/model/MotivationContent;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertOrUpdateRecord", "isCompleted", "", "(JLjava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateFavoriteStatus", "id", "isFavorite", "(JZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateHabit", "updateReminderEnabled", "enabled", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateReminderTime", "time", "app_debug"})
public final class HabitRepository {
    @org.jetbrains.annotations.NotNull
    private final com.habittracker.app.data.dao.HabitDao habitDao = null;
    @org.jetbrains.annotations.NotNull
    private final com.habittracker.app.data.dao.HabitRecordDao habitRecordDao = null;
    @org.jetbrains.annotations.NotNull
    private final com.habittracker.app.data.dao.MotivationContentDao motivationContentDao = null;
    @org.jetbrains.annotations.NotNull
    private final com.habittracker.app.data.dao.UserSettingsDao userSettingsDao = null;
    
    public HabitRepository(@org.jetbrains.annotations.NotNull
    com.habittracker.app.data.dao.HabitDao habitDao, @org.jetbrains.annotations.NotNull
    com.habittracker.app.data.dao.HabitRecordDao habitRecordDao, @org.jetbrains.annotations.NotNull
    com.habittracker.app.data.dao.MotivationContentDao motivationContentDao, @org.jetbrains.annotations.NotNull
    com.habittracker.app.data.dao.UserSettingsDao userSettingsDao) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<java.util.List<com.habittracker.app.data.model.Habit>> getAllActiveHabits() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object getAllActiveHabitsSync(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.util.List<com.habittracker.app.data.model.Habit>> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object insertHabit(@org.jetbrains.annotations.NotNull
    com.habittracker.app.data.model.Habit habit, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.lang.Long> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object updateHabit(@org.jetbrains.annotations.NotNull
    com.habittracker.app.data.model.Habit habit, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object deleteHabit(@org.jetbrains.annotations.NotNull
    com.habittracker.app.data.model.Habit habit, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object getActiveHabitsCount(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.lang.Integer> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<java.util.List<com.habittracker.app.data.model.HabitRecord>> getRecordsByDate(@org.jetbrains.annotations.NotNull
    java.lang.String date) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object getRecordsByDateSync(@org.jetbrains.annotations.NotNull
    java.lang.String date, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.util.List<com.habittracker.app.data.model.HabitRecord>> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object getRecord(long habitId, @org.jetbrains.annotations.NotNull
    java.lang.String date, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.habittracker.app.data.model.HabitRecord> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object insertOrUpdateRecord(long habitId, @org.jetbrains.annotations.NotNull
    java.lang.String date, boolean isCompleted, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object getRecordsBetweenDates(@org.jetbrains.annotations.NotNull
    java.lang.String startDate, @org.jetbrains.annotations.NotNull
    java.lang.String endDate, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.util.List<com.habittracker.app.data.model.HabitRecord>> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object getCompletionStats(@org.jetbrains.annotations.NotNull
    java.lang.String date, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Pair<java.lang.Integer, java.lang.Integer>> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<java.util.List<com.habittracker.app.data.model.MotivationContent>> getAllMotivationContent() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<java.util.List<com.habittracker.app.data.model.MotivationContent>> getFavoriteMotivationContent() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object getRandomMotivationContent(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.habittracker.app.data.model.MotivationContent> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object insertMotivationContent(@org.jetbrains.annotations.NotNull
    com.habittracker.app.data.model.MotivationContent content, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.lang.Long> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object updateFavoriteStatus(long id, boolean isFavorite, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<com.habittracker.app.data.model.UserSettings> getUserSettings() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object getUserSettingsSync(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.habittracker.app.data.model.UserSettings> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object updateReminderTime(@org.jetbrains.annotations.NotNull
    java.lang.String time, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object updateReminderEnabled(boolean enabled, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getTodayDateString() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String formatDate(@org.jetbrains.annotations.NotNull
    java.util.Date date) {
        return null;
    }
}