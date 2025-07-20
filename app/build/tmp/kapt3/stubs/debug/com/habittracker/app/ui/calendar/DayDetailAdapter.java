package com.habittracker.app.ui.calendar;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\u000e\u000fB\u0005\u00a2\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH\u0016J\u0018\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\tH\u0016\u00a8\u0006\u0010"}, d2 = {"Lcom/habittracker/app/ui/calendar/DayDetailAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/habittracker/app/ui/calendar/CalendarViewModel$DayDetailItem;", "Lcom/habittracker/app/ui/calendar/DayDetailAdapter$DayDetailViewHolder;", "()V", "onBindViewHolder", "", "holder", "position", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "DayDetailDiffCallback", "DayDetailViewHolder", "app_debug"})
public final class DayDetailAdapter extends androidx.recyclerview.widget.ListAdapter<com.habittracker.app.ui.calendar.CalendarViewModel.DayDetailItem, com.habittracker.app.ui.calendar.DayDetailAdapter.DayDetailViewHolder> {
    
    public DayDetailAdapter() {
        super(null);
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.NotNull
    public com.habittracker.app.ui.calendar.DayDetailAdapter.DayDetailViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull
    com.habittracker.app.ui.calendar.DayDetailAdapter.DayDetailViewHolder holder, int position) {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016\u00a8\u0006\t"}, d2 = {"Lcom/habittracker/app/ui/calendar/DayDetailAdapter$DayDetailDiffCallback;", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lcom/habittracker/app/ui/calendar/CalendarViewModel$DayDetailItem;", "()V", "areContentsTheSame", "", "oldItem", "newItem", "areItemsTheSame", "app_debug"})
    public static final class DayDetailDiffCallback extends androidx.recyclerview.widget.DiffUtil.ItemCallback<com.habittracker.app.ui.calendar.CalendarViewModel.DayDetailItem> {
        
        public DayDetailDiffCallback() {
            super();
        }
        
        @java.lang.Override
        public boolean areItemsTheSame(@org.jetbrains.annotations.NotNull
        com.habittracker.app.ui.calendar.CalendarViewModel.DayDetailItem oldItem, @org.jetbrains.annotations.NotNull
        com.habittracker.app.ui.calendar.CalendarViewModel.DayDetailItem newItem) {
            return false;
        }
        
        @java.lang.Override
        public boolean areContentsTheSame(@org.jetbrains.annotations.NotNull
        com.habittracker.app.ui.calendar.CalendarViewModel.DayDetailItem oldItem, @org.jetbrains.annotations.NotNull
        com.habittracker.app.ui.calendar.CalendarViewModel.DayDetailItem newItem) {
            return false;
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"Lcom/habittracker/app/ui/calendar/DayDetailAdapter$DayDetailViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/habittracker/app/databinding/ItemDayDetailBinding;", "(Lcom/habittracker/app/databinding/ItemDayDetailBinding;)V", "bind", "", "item", "Lcom/habittracker/app/ui/calendar/CalendarViewModel$DayDetailItem;", "app_debug"})
    public static final class DayDetailViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull
        private final com.habittracker.app.databinding.ItemDayDetailBinding binding = null;
        
        public DayDetailViewHolder(@org.jetbrains.annotations.NotNull
        com.habittracker.app.databinding.ItemDayDetailBinding binding) {
            super(null);
        }
        
        public final void bind(@org.jetbrains.annotations.NotNull
        com.habittracker.app.ui.calendar.CalendarViewModel.DayDetailItem item) {
        }
    }
}