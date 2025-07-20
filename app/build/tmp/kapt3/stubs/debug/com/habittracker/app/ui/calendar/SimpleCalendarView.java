package com.habittracker.app.ui.calendar;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\n\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u000e\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0016J\u000e\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00110\u0018H\u0002J\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00110\u0018J\u0006\u0010\u001a\u001a\u00020\u0012J\u0006\u0010\u001b\u001a\u00020\u0012J\u001a\u0010\u001c\u001a\u00020\u00122\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00120\u0010J\u000e\u0010\u001e\u001a\u00020\u00122\u0006\u0010\u001f\u001a\u00020\u0011J\b\u0010 \u001a\u00020\u0012H\u0002J\b\u0010!\u001a\u00020\u0012H\u0002R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0011X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\""}, d2 = {"Lcom/habittracker/app/ui/calendar/SimpleCalendarView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/habittracker/app/databinding/ViewSimpleCalendarBinding;", "calendarAdapter", "Lcom/habittracker/app/ui/calendar/CalendarAdapter;", "currentMonth", "Ljava/util/Calendar;", "onDateSelectedListener", "Lkotlin/Function1;", "Lcom/habittracker/app/ui/calendar/CalendarDay;", "", "selectedDate", "addDecorator", "decorator", "Lcom/habittracker/app/ui/calendar/CalendarDecorator;", "generateCalendarDays", "", "getCurrentCalendarDays", "invalidateCalendar", "removeDecorators", "setOnDateSelectedListener", "listener", "setSelectedDate", "date", "setupNavigation", "updateCalendar", "app_debug"})
public final class SimpleCalendarView extends android.widget.LinearLayout {
    @org.jetbrains.annotations.NotNull
    private final com.habittracker.app.databinding.ViewSimpleCalendarBinding binding = null;
    private com.habittracker.app.ui.calendar.CalendarAdapter calendarAdapter;
    @org.jetbrains.annotations.Nullable
    private kotlin.jvm.functions.Function1<? super com.habittracker.app.ui.calendar.CalendarDay, kotlin.Unit> onDateSelectedListener;
    @org.jetbrains.annotations.Nullable
    private com.habittracker.app.ui.calendar.CalendarDay selectedDate;
    @org.jetbrains.annotations.NotNull
    private java.util.Calendar currentMonth;
    
    @kotlin.jvm.JvmOverloads
    public SimpleCalendarView(@org.jetbrains.annotations.NotNull
    android.content.Context context, @org.jetbrains.annotations.Nullable
    android.util.AttributeSet attrs, int defStyleAttr) {
        super(null);
    }
    
    private final void setupNavigation() {
    }
    
    private final void updateCalendar() {
    }
    
    private final java.util.List<com.habittracker.app.ui.calendar.CalendarDay> generateCalendarDays() {
        return null;
    }
    
    public final void setOnDateSelectedListener(@org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super com.habittracker.app.ui.calendar.CalendarDay, kotlin.Unit> listener) {
    }
    
    public final void setSelectedDate(@org.jetbrains.annotations.NotNull
    com.habittracker.app.ui.calendar.CalendarDay date) {
    }
    
    public final void addDecorator(@org.jetbrains.annotations.NotNull
    com.habittracker.app.ui.calendar.CalendarDecorator decorator) {
    }
    
    public final void removeDecorators() {
    }
    
    public final void invalidateCalendar() {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<com.habittracker.app.ui.calendar.CalendarDay> getCurrentCalendarDays() {
        return null;
    }
    
    @kotlin.jvm.JvmOverloads
    public SimpleCalendarView(@org.jetbrains.annotations.NotNull
    android.content.Context context) {
        super(null);
    }
    
    @kotlin.jvm.JvmOverloads
    public SimpleCalendarView(@org.jetbrains.annotations.NotNull
    android.content.Context context, @org.jetbrains.annotations.Nullable
    android.util.AttributeSet attrs) {
        super(null);
    }
}