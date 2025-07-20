package com.habittracker.app.ui.calendar;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\u0002\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0004H\u0016R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2 = {"Lcom/habittracker/app/ui/calendar/PartialDayDecorator;", "Lcom/habittracker/app/ui/calendar/CalendarDecorator;", "dates", "", "Lcom/habittracker/app/ui/calendar/CalendarDay;", "(Ljava/util/Collection;)V", "getBackgroundColor", "", "shouldDecorate", "", "day", "app_debug"})
public final class PartialDayDecorator implements com.habittracker.app.ui.calendar.CalendarDecorator {
    @org.jetbrains.annotations.NotNull
    private final java.util.Collection<com.habittracker.app.ui.calendar.CalendarDay> dates = null;
    
    public PartialDayDecorator(@org.jetbrains.annotations.NotNull
    java.util.Collection<com.habittracker.app.ui.calendar.CalendarDay> dates) {
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