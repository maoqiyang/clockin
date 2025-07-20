package com.habittracker.app.ui.settings;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001#B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0016\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0018J\u000e\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\u000bJ\u000e\u0010\u001c\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\u000bJ\u0014\u0010\u001d\u001a\u00020\u00162\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u000b0\nJ\u000e\u0010\u001e\u001a\u00020\u00162\u0006\u0010\u001f\u001a\u00020 J\u000e\u0010!\u001a\u00020\u00162\u0006\u0010\"\u001a\u00020\u0018R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00070\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0019\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00130\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\r\u00a8\u0006$"}, d2 = {"Lcom/habittracker/app/ui/settings/SettingsViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "application", "Landroid/app/Application;", "(Landroid/app/Application;)V", "_operationResult", "Landroidx/lifecycle/MutableLiveData;", "Lcom/habittracker/app/ui/settings/SettingsViewModel$OperationResult;", "habits", "Landroidx/lifecycle/LiveData;", "", "Lcom/habittracker/app/data/model/Habit;", "getHabits", "()Landroidx/lifecycle/LiveData;", "operationResult", "getOperationResult", "repository", "Lcom/habittracker/app/data/repository/HabitRepository;", "userSettings", "Lcom/habittracker/app/data/model/UserSettings;", "getUserSettings", "addHabit", "", "name", "", "description", "deleteHabit", "habit", "updateHabit", "updateHabitOrder", "updateReminderEnabled", "enabled", "", "updateReminderTime", "time", "OperationResult", "app_debug"})
public final class SettingsViewModel extends androidx.lifecycle.AndroidViewModel {
    @org.jetbrains.annotations.NotNull
    private final com.habittracker.app.data.repository.HabitRepository repository = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.LiveData<java.util.List<com.habittracker.app.data.model.Habit>> habits = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.LiveData<com.habittracker.app.data.model.UserSettings> userSettings = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.MutableLiveData<com.habittracker.app.ui.settings.SettingsViewModel.OperationResult> _operationResult = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.LiveData<com.habittracker.app.ui.settings.SettingsViewModel.OperationResult> operationResult = null;
    
    public SettingsViewModel(@org.jetbrains.annotations.NotNull
    android.app.Application application) {
        super(null);
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<java.util.List<com.habittracker.app.data.model.Habit>> getHabits() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<com.habittracker.app.data.model.UserSettings> getUserSettings() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<com.habittracker.app.ui.settings.SettingsViewModel.OperationResult> getOperationResult() {
        return null;
    }
    
    public final void addHabit(@org.jetbrains.annotations.NotNull
    java.lang.String name, @org.jetbrains.annotations.NotNull
    java.lang.String description) {
    }
    
    public final void updateHabit(@org.jetbrains.annotations.NotNull
    com.habittracker.app.data.model.Habit habit) {
    }
    
    public final void deleteHabit(@org.jetbrains.annotations.NotNull
    com.habittracker.app.data.model.Habit habit) {
    }
    
    public final void updateHabitOrder(@org.jetbrains.annotations.NotNull
    java.util.List<com.habittracker.app.data.model.Habit> habits) {
    }
    
    public final void updateReminderTime(@org.jetbrains.annotations.NotNull
    java.lang.String time) {
    }
    
    public final void updateReminderEnabled(boolean enabled) {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/habittracker/app/ui/settings/SettingsViewModel$OperationResult;", "", "(Ljava/lang/String;I)V", "SUCCESS", "ERROR", "MAX_HABITS_REACHED", "app_debug"})
    public static enum OperationResult {
        /*public static final*/ SUCCESS /* = new SUCCESS() */,
        /*public static final*/ ERROR /* = new ERROR() */,
        /*public static final*/ MAX_HABITS_REACHED /* = new MAX_HABITS_REACHED() */;
        
        OperationResult() {
        }
        
        @org.jetbrains.annotations.NotNull
        public static kotlin.enums.EnumEntries<com.habittracker.app.ui.settings.SettingsViewModel.OperationResult> getEntries() {
            return null;
        }
    }
}