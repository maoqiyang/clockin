package com.habittracker.app.data.dao;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\bg\u0018\u00002\u00020\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006J\u0019\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\nJ\u0019\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000fJ#\u0010\u0010\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000eH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0011J\'\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00132\u0006\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u000eH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0016J\'\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00050\u00132\u0006\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u000eH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0016J\u001c\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00130\u00192\u0006\u0010\r\u001a\u00020\u000eH\'J\u001f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00050\u00132\u0006\u0010\r\u001a\u00020\u000eH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000fJ\u0019\u0010\u001b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000fJ\u0019\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006J\u0019\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u001e"}, d2 = {"Lcom/habittracker/app/data/dao/HabitRecordDao;", "", "deleteRecord", "", "record", "Lcom/habittracker/app/data/model/HabitRecord;", "(Lcom/habittracker/app/data/model/HabitRecord;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteRecordsByHabitId", "habitId", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getCompletedCountByDate", "", "date", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getRecord", "(JLjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getRecordDates", "", "startDate", "endDate", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getRecordsBetweenDates", "getRecordsByDate", "Landroidx/lifecycle/LiveData;", "getRecordsByDateSync", "getTotalHabitsCountByDate", "insertRecord", "updateRecord", "app_debug"})
@androidx.room.Dao
public abstract interface HabitRecordDao {
    
    @androidx.room.Query(value = "SELECT * FROM habit_records WHERE date = :date ORDER BY habitId ASC")
    @org.jetbrains.annotations.NotNull
    public abstract androidx.lifecycle.LiveData<java.util.List<com.habittracker.app.data.model.HabitRecord>> getRecordsByDate(@org.jetbrains.annotations.NotNull
    java.lang.String date);
    
    @androidx.room.Query(value = "SELECT * FROM habit_records WHERE date = :date ORDER BY habitId ASC")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getRecordsByDateSync(@org.jetbrains.annotations.NotNull
    java.lang.String date, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.util.List<com.habittracker.app.data.model.HabitRecord>> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM habit_records WHERE habitId = :habitId AND date = :date")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getRecord(long habitId, @org.jetbrains.annotations.NotNull
    java.lang.String date, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.habittracker.app.data.model.HabitRecord> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM habit_records WHERE date BETWEEN :startDate AND :endDate ORDER BY date ASC")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getRecordsBetweenDates(@org.jetbrains.annotations.NotNull
    java.lang.String startDate, @org.jetbrains.annotations.NotNull
    java.lang.String endDate, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.util.List<com.habittracker.app.data.model.HabitRecord>> $completion);
    
    @androidx.room.Query(value = "SELECT DISTINCT date FROM habit_records WHERE date BETWEEN :startDate AND :endDate ORDER BY date ASC")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getRecordDates(@org.jetbrains.annotations.NotNull
    java.lang.String startDate, @org.jetbrains.annotations.NotNull
    java.lang.String endDate, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.util.List<java.lang.String>> $completion);
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object insertRecord(@org.jetbrains.annotations.NotNull
    com.habittracker.app.data.model.HabitRecord record, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Update
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object updateRecord(@org.jetbrains.annotations.NotNull
    com.habittracker.app.data.model.HabitRecord record, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Delete
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object deleteRecord(@org.jetbrains.annotations.NotNull
    com.habittracker.app.data.model.HabitRecord record, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "DELETE FROM habit_records WHERE habitId = :habitId")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object deleteRecordsByHabitId(long habitId, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "SELECT COUNT(*) FROM habit_records WHERE date = :date AND isCompleted = 1")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getCompletedCountByDate(@org.jetbrains.annotations.NotNull
    java.lang.String date, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.lang.Integer> $completion);
    
    @androidx.room.Query(value = "SELECT COUNT(DISTINCT habitId) FROM habit_records WHERE date = :date")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getTotalHabitsCountByDate(@org.jetbrains.annotations.NotNull
    java.lang.String date, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.lang.Integer> $completion);
}