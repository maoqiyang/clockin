package com.habittracker.app;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\nH\u0016R\u001b\u0010\u0003\u001a\u00020\u00048FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u000b"}, d2 = {"Lcom/habittracker/app/HabitTrackerApplication;", "Landroid/app/Application;", "()V", "database", "Lcom/habittracker/app/data/database/HabitDatabase;", "getDatabase", "()Lcom/habittracker/app/data/database/HabitDatabase;", "database$delegate", "Lkotlin/Lazy;", "onCreate", "", "app_debug"})
public final class HabitTrackerApplication extends android.app.Application {
    @org.jetbrains.annotations.NotNull
    private final kotlin.Lazy database$delegate = null;
    
    public HabitTrackerApplication() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.habittracker.app.data.database.HabitDatabase getDatabase() {
        return null;
    }
    
    @java.lang.Override
    public void onCreate() {
    }
}