package com.habittracker.app.data.dao;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0011\u0010\u0002\u001a\u00020\u0003H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0004J\u0019\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\bJ\u0014\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u000b0\nH\'J\u0011\u0010\f\u001a\u00020\rH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0004J\u0014\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u000b0\nH\'J\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0007H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0004J\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0007H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0004J\u0019\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0006\u001a\u00020\u0007H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\bJ\u0019\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\bJ!\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u0017H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0018\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0019"}, d2 = {"Lcom/habittracker/app/data/dao/MotivationContentDao;", "", "clearNonFavoriteNetworkContent", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteContent", "content", "Lcom/habittracker/app/data/model/MotivationContent;", "(Lcom/habittracker/app/data/model/MotivationContent;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllContent", "Landroidx/lifecycle/LiveData;", "", "getContentCount", "", "getFavoriteContent", "getRandomContent", "getRandomFavoriteContent", "insertContent", "", "updateContent", "updateFavoriteStatus", "id", "isFavorite", "", "(JZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
@androidx.room.Dao
public abstract interface MotivationContentDao {
    
    @androidx.room.Query(value = "SELECT * FROM motivation_content ORDER BY createdAt DESC")
    @org.jetbrains.annotations.NotNull
    public abstract androidx.lifecycle.LiveData<java.util.List<com.habittracker.app.data.model.MotivationContent>> getAllContent();
    
    @androidx.room.Query(value = "SELECT * FROM motivation_content WHERE isFavorite = 1 ORDER BY createdAt DESC")
    @org.jetbrains.annotations.NotNull
    public abstract androidx.lifecycle.LiveData<java.util.List<com.habittracker.app.data.model.MotivationContent>> getFavoriteContent();
    
    @androidx.room.Query(value = "SELECT * FROM motivation_content ORDER BY RANDOM() LIMIT 1")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getRandomContent(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.habittracker.app.data.model.MotivationContent> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM motivation_content WHERE isFavorite = 1 ORDER BY RANDOM() LIMIT 1")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getRandomFavoriteContent(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.habittracker.app.data.model.MotivationContent> $completion);
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object insertContent(@org.jetbrains.annotations.NotNull
    com.habittracker.app.data.model.MotivationContent content, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.lang.Long> $completion);
    
    @androidx.room.Update
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object updateContent(@org.jetbrains.annotations.NotNull
    com.habittracker.app.data.model.MotivationContent content, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Delete
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object deleteContent(@org.jetbrains.annotations.NotNull
    com.habittracker.app.data.model.MotivationContent content, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "UPDATE motivation_content SET isFavorite = :isFavorite WHERE id = :id")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object updateFavoriteStatus(long id, boolean isFavorite, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "DELETE FROM motivation_content WHERE isFromNetwork = 1 AND isFavorite = 0")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object clearNonFavoriteNetworkContent(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "SELECT COUNT(*) FROM motivation_content")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getContentCount(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.lang.Integer> $completion);
}