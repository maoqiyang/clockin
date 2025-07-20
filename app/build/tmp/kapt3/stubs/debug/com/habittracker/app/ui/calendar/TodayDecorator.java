package com.habittracker.app.ui.calendar;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\n"}, d2 = {"Lcom/habittracker/app/ui/calendar/TodayDecorator;", "Lcom/habittracker/app/ui/calendar/CalendarDecorator;", "()V", "today", "Lcom/habittracker/app/ui/calendar/CalendarDay;", "getBackgroundColor", "", "shouldDecorate", "", "day", "app_debug"})
public final class TodayDecorator implements com.habittracker.app.ui.calendar.CalendarDecorator {
    @org.jetbrains.annotations.NotNull
    private final com.habittracker.app.ui.calendar.CalendarDay today = null;
    
    public TodayDecorator() {
        super();
    }
    
    @java.lang.Override
    public boolean shouldDecorate(@org.jetbrains.annotations.NotNull
    com.habittracker.app.ui.calendar.CalendarDay day) {
        return false;
    }
    
    @java.lang.Override
    public int getBackgroundColor() {
        return 0;
    }
}