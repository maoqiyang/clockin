package com.habittracker.app.ui.calendar;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u0012\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u00060\u0003R\u00020\u00000\u0001:\u0002\u0019\u001aB\u0019\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\u0002\u0010\u0007J\u000e\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\nJ\u0006\u0010\u000e\u001a\u00020\u0006J\u001c\u0010\u000f\u001a\u00020\u00062\n\u0010\u0010\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u001c\u0010\u0013\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0012H\u0016J\u000e\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u0002R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0002X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001b"}, d2 = {"Lcom/habittracker/app/ui/calendar/CalendarAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/habittracker/app/ui/calendar/CalendarDay;", "Lcom/habittracker/app/ui/calendar/CalendarAdapter$CalendarDayViewHolder;", "onDayClick", "Lkotlin/Function1;", "", "(Lkotlin/jvm/functions/Function1;)V", "decorators", "", "Lcom/habittracker/app/ui/calendar/CalendarDecorator;", "selectedDate", "addDecorator", "decorator", "clearDecorators", "onBindViewHolder", "holder", "position", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setSelectedDate", "date", "CalendarDayDiffCallback", "CalendarDayViewHolder", "app_debug"})
public final class CalendarAdapter extends androidx.recyclerview.widget.ListAdapter<com.habittracker.app.ui.calendar.CalendarDay, com.habittracker.app.ui.calendar.CalendarAdapter.CalendarDayViewHolder> {
    @org.jetbrains.annotations.NotNull
    private final kotlin.jvm.functions.Function1<com.habittracker.app.ui.calendar.CalendarDay, kotlin.Unit> onDayClick = null;
    @org.jetbrains.annotations.Nullable
    private com.habittracker.app.ui.calendar.CalendarDay selectedDate;
    @org.jetbrains.annotations.NotNull
    private final java.util.List<com.habittracker.app.ui.calendar.CalendarDecorator> decorators = null;
    
    public CalendarAdapter(@org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super com.habittracker.app.ui.calendar.CalendarDay, kotlin.Unit> onDayClick) {
        super(null);
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.NotNull
    public com.habittracker.app.ui.calendar.CalendarAdapter.CalendarDayViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull
    com.habittracker.app.ui.calendar.CalendarAdapter.CalendarDayViewHolder holder, int position) {
    }
    
    public final void setSelectedDate(@org.jetbrains.annotations.NotNull
    com.habittracker.app.ui.calendar.CalendarDay date) {
    }
    
    public final void addDecorator(@org.jetbrains.annotations.NotNull
    com.habittracker.app.ui.calendar.CalendarDecorator decorator) {
    }
    
    public final void clearDecorators() {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016\u00a8\u0006\t"}, d2 = {"Lcom/habittracker/app/ui/calendar/CalendarAdapter$CalendarDayDiffCallback;", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lcom/habittracker/app/ui/calendar/CalendarDay;", "()V", "areContentsTheSame", "", "oldItem", "newItem", "areItemsTheSame", "app_debug"})
    public static final class CalendarDayDiffCallback extends androidx.recyclerview.widget.DiffUtil.ItemCallback<com.habittracker.app.ui.calendar.CalendarDay> {
        
        public CalendarDayDiffCallback() {
            super();
        }
        
        @java.lang.Override
        public boolean areItemsTheSame(@org.jetbrains.annotations.NotNull
        com.habittracker.app.ui.calendar.CalendarDay oldItem, @org.jetbrains.annotations.NotNull
        com.habittracker.app.ui.calendar.CalendarDay newItem) {
            return false;
        }
        
        @java.lang.Override
        public boolean areContentsTheSame(@org.jetbrains.annotations.NotNull
        com.habittracker.app.ui.calendar.CalendarDay oldItem, @org.jetbrains.annotations.NotNull
        com.habittracker.app.ui.calendar.CalendarDay newItem) {
            return false;
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"Lcom/habittracker/app/ui/calendar/CalendarAdapter$CalendarDayViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/habittracker/app/databinding/ItemCalendarDayBinding;", "(Lcom/habittracker/app/ui/calendar/CalendarAdapter;Lcom/habittracker/app/databinding/ItemCalendarDayBinding;)V", "bind", "", "day", "Lcom/habittracker/app/ui/calendar/CalendarDay;", "app_debug"})
    public final class CalendarDayViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull
        private final com.habittracker.app.databinding.ItemCalendarDayBinding binding = null;
        
        public CalendarDayViewHolder(@org.jetbrains.annotations.NotNull
        com.habittracker.app.databinding.ItemCalendarDayBinding binding) {
            super(null);
        }
        
        public final void bind(@org.jetbrains.annotations.NotNull
        com.habittracker.app.ui.calendar.CalendarDay day) {
        }
    }
}