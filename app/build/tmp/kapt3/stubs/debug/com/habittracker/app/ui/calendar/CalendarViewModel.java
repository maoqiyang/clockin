package com.habittracker.app.ui.calendar;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0002)*B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J,\u0010\u001b\u001a\u00020\n2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001d0\u00072\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001f0\u00072\u0006\u0010 \u001a\u00020\fH\u0002J4\u0010!\u001a\u00020\n2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001d0\u00072\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001f0\u00072\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020#H\u0002J*\u0010%\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001d0\u00072\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001f0\u0007H\u0002J\u000e\u0010&\u001a\u00020\'2\u0006\u0010 \u001a\u00020\fJ\u000e\u0010(\u001a\u00020\'2\u0006\u0010 \u001a\u00020\fR\u001a\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\n0\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\f0\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0012R\u001d\u0010\u0019\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u00070\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0012\u00a8\u0006+"}, d2 = {"Lcom/habittracker/app/ui/calendar/CalendarViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "application", "Landroid/app/Application;", "(Landroid/app/Application;)V", "_calendarDecorators", "Landroidx/lifecycle/MutableLiveData;", "", "Lcom/habittracker/app/ui/calendar/CalendarDecorator;", "_monthlyStats", "Lcom/habittracker/app/ui/calendar/CalendarViewModel$MonthlyStats;", "_selectedDate", "Lcom/habittracker/app/ui/calendar/CalendarDay;", "_selectedDayDetails", "Lcom/habittracker/app/ui/calendar/CalendarViewModel$DayDetailItem;", "calendarDecorators", "Landroidx/lifecycle/LiveData;", "getCalendarDecorators", "()Landroidx/lifecycle/LiveData;", "monthlyStats", "getMonthlyStats", "repository", "Lcom/habittracker/app/data/repository/HabitRepository;", "selectedDate", "getSelectedDate", "selectedDayDetails", "getSelectedDayDetails", "calculateDailyStats", "records", "Lcom/habittracker/app/data/model/HabitRecord;", "habits", "Lcom/habittracker/app/data/model/Habit;", "date", "calculateMonthlyStats", "firstDay", "Ljava/util/Date;", "lastDay", "createCalendarDecorators", "loadMonthData", "", "selectDate", "DayDetailItem", "MonthlyStats", "app_debug"})
public final class CalendarViewModel extends androidx.lifecycle.AndroidViewModel {
    @org.jetbrains.annotations.NotNull
    private final com.habittracker.app.data.repository.HabitRepository repository = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.MutableLiveData<com.habittracker.app.ui.calendar.CalendarViewModel.MonthlyStats> _monthlyStats = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.LiveData<com.habittracker.app.ui.calendar.CalendarViewModel.MonthlyStats> monthlyStats = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.MutableLiveData<java.util.List<com.habittracker.app.ui.calendar.CalendarDecorator>> _calendarDecorators = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.LiveData<java.util.List<com.habittracker.app.ui.calendar.CalendarDecorator>> calendarDecorators = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.MutableLiveData<com.habittracker.app.ui.calendar.CalendarDay> _selectedDate = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.LiveData<com.habittracker.app.ui.calendar.CalendarDay> selectedDate = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.MutableLiveData<java.util.List<com.habittracker.app.ui.calendar.CalendarViewModel.DayDetailItem>> _selectedDayDetails = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.LiveData<java.util.List<com.habittracker.app.ui.calendar.CalendarViewModel.DayDetailItem>> selectedDayDetails = null;
    
    public CalendarViewModel(@org.jetbrains.annotations.NotNull
    android.app.Application application) {
        super(null);
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<com.habittracker.app.ui.calendar.CalendarViewModel.MonthlyStats> getMonthlyStats() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<java.util.List<com.habittracker.app.ui.calendar.CalendarDecorator>> getCalendarDecorators() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<com.habittracker.app.ui.calendar.CalendarDay> getSelectedDate() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<java.util.List<com.habittracker.app.ui.calendar.CalendarViewModel.DayDetailItem>> getSelectedDayDetails() {
        return null;
    }
    
    public final void loadMonthData(@org.jetbrains.annotations.NotNull
    com.habittracker.app.ui.calendar.CalendarDay date) {
    }
    
    public final void selectDate(@org.jetbrains.annotations.NotNull
    com.habittracker.app.ui.calendar.CalendarDay date) {
    }
    
    private final com.habittracker.app.ui.calendar.CalendarViewModel.MonthlyStats calculateMonthlyStats(java.util.List<com.habittracker.app.data.model.HabitRecord> records, java.util.List<com.habittracker.app.data.model.Habit> habits, java.util.Date firstDay, java.util.Date lastDay) {
        return null;
    }
    
    private final com.habittracker.app.ui.calendar.CalendarViewModel.MonthlyStats calculateDailyStats(java.util.List<com.habittracker.app.data.model.HabitRecord> records, java.util.List<com.habittracker.app.data.model.Habit> habits, com.habittracker.app.ui.calendar.CalendarDay date) {
        return null;
    }
    
    private final java.util.List<com.habittracker.app.ui.calendar.CalendarDecorator> createCalendarDecorators(java.util.List<com.habittracker.app.data.model.HabitRecord> records, java.util.List<com.habittracker.app.data.model.Habit> habits) {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0007J\t\u0010\f\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\r\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u000e\u001a\u00020\u0003H\u00c6\u0003J\'\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\u0010\u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0012\u001a\u00020\u0013H\u00d6\u0001J\t\u0010\u0014\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u000b\u00a8\u0006\u0015"}, d2 = {"Lcom/habittracker/app/ui/calendar/CalendarViewModel$DayDetailItem;", "", "habitName", "", "isCompleted", "", "description", "(Ljava/lang/String;ZLjava/lang/String;)V", "getDescription", "()Ljava/lang/String;", "getHabitName", "()Z", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "app_debug"})
    public static final class DayDetailItem {
        @org.jetbrains.annotations.NotNull
        private final java.lang.String habitName = null;
        private final boolean isCompleted = false;
        @org.jetbrains.annotations.NotNull
        private final java.lang.String description = null;
        
        public DayDetailItem(@org.jetbrains.annotations.NotNull
        java.lang.String habitName, boolean isCompleted, @org.jetbrains.annotations.NotNull
        java.lang.String description) {
            super();
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String getHabitName() {
            return null;
        }
        
        public final boolean isCompleted() {
            return false;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String getDescription() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String component1() {
            return null;
        }
        
        public final boolean component2() {
            return false;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String component3() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.habittracker.app.ui.calendar.CalendarViewModel.DayDetailItem copy(@org.jetbrains.annotations.NotNull
        java.lang.String habitName, boolean isCompleted, @org.jetbrains.annotations.NotNull
        java.lang.String description) {
            return null;
        }
        
        @java.lang.Override
        public boolean equals(@org.jetbrains.annotations.Nullable
        java.lang.Object other) {
            return false;
        }
        
        @java.lang.Override
        public int hashCode() {
            return 0;
        }
        
        @java.lang.Override
        @org.jetbrains.annotations.NotNull
        public java.lang.String toString() {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0013\b\u0086\b\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0013\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0014\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0015\u001a\u00020\u0007H\u00c6\u0003J\t\u0010\u0016\u001a\u00020\tH\u00c6\u0003J;\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tH\u00c6\u0001J\u0013\u0010\u0018\u001a\u00020\u00072\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u001a\u001a\u00020\u0003H\u00d6\u0001J\t\u0010\u001b\u001a\u00020\tH\u00d6\u0001R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u000eR\u0011\u0010\b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\f\u00a8\u0006\u001c"}, d2 = {"Lcom/habittracker/app/ui/calendar/CalendarViewModel$MonthlyStats;", "", "totalHabits", "", "completedHabits", "completionRate", "isDaily", "", "selectedDate", "", "(IIIZLjava/lang/String;)V", "getCompletedHabits", "()I", "getCompletionRate", "()Z", "getSelectedDate", "()Ljava/lang/String;", "getTotalHabits", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "toString", "app_debug"})
    public static final class MonthlyStats {
        private final int totalHabits = 0;
        private final int completedHabits = 0;
        private final int completionRate = 0;
        private final boolean isDaily = false;
        @org.jetbrains.annotations.NotNull
        private final java.lang.String selectedDate = null;
        
        public MonthlyStats(int totalHabits, int completedHabits, int completionRate, boolean isDaily, @org.jetbrains.annotations.NotNull
        java.lang.String selectedDate) {
            super();
        }
        
        public final int getTotalHabits() {
            return 0;
        }
        
        public final int getCompletedHabits() {
            return 0;
        }
        
        public final int getCompletionRate() {
            return 0;
        }
        
        public final boolean isDaily() {
            return false;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String getSelectedDate() {
            return null;
        }
        
        public final int component1() {
            return 0;
        }
        
        public final int component2() {
            return 0;
        }
        
        public final int component3() {
            return 0;
        }
        
        public final boolean component4() {
            return false;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String component5() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.habittracker.app.ui.calendar.CalendarViewModel.MonthlyStats copy(int totalHabits, int completedHabits, int completionRate, boolean isDaily, @org.jetbrains.annotations.NotNull
        java.lang.String selectedDate) {
            return null;
        }
        
        @java.lang.Override
        public boolean equals(@org.jetbrains.annotations.Nullable
        java.lang.Object other) {
            return false;
        }
        
        @java.lang.Override
        public int hashCode() {
            return 0;
        }
        
        @java.lang.Override
        @org.jetbrains.annotations.NotNull
        public java.lang.String toString() {
            return null;
        }
    }
}