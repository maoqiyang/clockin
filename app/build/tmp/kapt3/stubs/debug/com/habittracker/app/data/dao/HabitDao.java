package com.habittracker.app.data.dao;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\b\bg\u0018\u00002\u00020\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006J\u0019\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\nJ\u0011\u0010\u000b\u001a\u00020\fH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\rJ\u0014\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u00100\u000fH\'J\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\t0\u0010H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\rJ\u001b\u0010\u0012\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006J\u0019\u0010\u0013\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\nJ\u0019\u0010\u0014\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\nJ!\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\fH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0017\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0018"}, d2 = {"Lcom/habittracker/app/data/dao/HabitDao;", "", "deactivateHabit", "", "id", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteHabit", "habit", "Lcom/habittracker/app/data/model/Habit;", "(Lcom/habittracker/app/data/model/Habit;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getActiveHabitsCount", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllActiveHabits", "Landroidx/lifecycle/LiveData;", "", "getAllActiveHabitsSync", "getHabitById", "insertHabit", "updateHabit", "updateHabitOrder", "newOrder", "(JILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
@androidx.room.Dao
public abstract interface HabitDao {
    
    @androidx.room.Query(value = "SELECT * FROM habits WHERE isActive = 1 ORDER BY sortOrder ASC")
    @org.jetbrains.annotations.NotNull
    public abstract androidx.lifecycle.LiveData<java.util.List<com.habittracker.app.data.model.Habit>> getAllActiveHabits();
    
    @androidx.room.Query(value = "SELECT * FROM habits WHERE isActive = 1 ORDER BY sortOrder ASC")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getAllActiveHabitsSync(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.util.List<com.habittracker.app.data.model.Habit>> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM habits WHERE id = :id")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getHabitById(long id, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.habittracker.app.data.model.Habit> $completion);
    
    @androidx.room.Insert
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object insertHabit(@org.jetbrains.annotations.NotNull
    com.habittracker.app.data.model.Habit habit, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.lang.Long> $completion);
    
    @androidx.room.Update
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object updateHabit(@org.jetbrains.annotations.NotNull
    com.habittracker.app.data.model.Habit habit, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Delete
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object deleteHabit(@org.jetbrains.annotations.NotNull
    com.habittracker.app.data.model.Habit habit, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "UPDATE habits SET isActive = 0 WHERE id = :id")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object deactivateHabit(long id, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "SELECT COUNT(*) FROM habits WHERE isActive = 1")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getActiveHabitsCount(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.lang.Integer> $completion);
    
    @androidx.room.Query(value = "UPDATE habits SET sortOrder = :newOrder WHERE id = :id")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object updateHabitOrder(long id, int newOrder, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
}