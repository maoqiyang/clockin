package com.habittracker.app.ui.home;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u0012\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u00060\u0003R\u00020\u00000\u0001:\u0002\u0016\u0017B\u001f\u0012\u0018\u0010\u0004\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005\u00a2\u0006\u0002\u0010\bJ\u001c\u0010\f\u001a\u00020\u00072\n\u0010\r\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u001c\u0010\u0010\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u000fH\u0016J\u0014\u0010\u0014\u001a\u00020\u00072\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u000b0\nR \u0010\u0004\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0018"}, d2 = {"Lcom/habittracker/app/ui/home/HabitCheckAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/habittracker/app/data/model/Habit;", "Lcom/habittracker/app/ui/home/HabitCheckAdapter$HabitViewHolder;", "onHabitChecked", "Lkotlin/Function2;", "", "", "(Lkotlin/jvm/functions/Function2;)V", "records", "", "Lcom/habittracker/app/data/model/HabitRecord;", "onBindViewHolder", "holder", "position", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "updateRecords", "newRecords", "HabitDiffCallback", "HabitViewHolder", "app_debug"})
public final class HabitCheckAdapter extends androidx.recyclerview.widget.ListAdapter<com.habittracker.app.data.model.Habit, com.habittracker.app.ui.home.HabitCheckAdapter.HabitViewHolder> {
    @org.jetbrains.annotations.NotNull
    private final kotlin.jvm.functions.Function2<com.habittracker.app.data.model.Habit, java.lang.Boolean, kotlin.Unit> onHabitChecked = null;
    @org.jetbrains.annotations.NotNull
    private java.util.List<com.habittracker.app.data.model.HabitRecord> records;
    
    public HabitCheckAdapter(@org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function2<? super com.habittracker.app.data.model.Habit, ? super java.lang.Boolean, kotlin.Unit> onHabitChecked) {
        super(null);
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.NotNull
    public com.habittracker.app.ui.home.HabitCheckAdapter.HabitViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull
    com.habittracker.app.ui.home.HabitCheckAdapter.HabitViewHolder holder, int position) {
    }
    
    public final void updateRecords(@org.jetbrains.annotations.NotNull
    java.util.List<com.habittracker.app.data.model.HabitRecord> newRecords) {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016\u00a8\u0006\t"}, d2 = {"Lcom/habittracker/app/ui/home/HabitCheckAdapter$HabitDiffCallback;", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lcom/habittracker/app/data/model/Habit;", "()V", "areContentsTheSame", "", "oldItem", "newItem", "areItemsTheSame", "app_debug"})
    public static final class HabitDiffCallback extends androidx.recyclerview.widget.DiffUtil.ItemCallback<com.habittracker.app.data.model.Habit> {
        
        public HabitDiffCallback() {
            super();
        }
        
        @java.lang.Override
        public boolean areItemsTheSame(@org.jetbrains.annotations.NotNull
        com.habittracker.app.data.model.Habit oldItem, @org.jetbrains.annotations.NotNull
        com.habittracker.app.data.model.Habit newItem) {
            return false;
        }
        
        @java.lang.Override
        public boolean areContentsTheSame(@org.jetbrains.annotations.NotNull
        com.habittracker.app.data.model.Habit oldItem, @org.jetbrains.annotations.NotNull
        com.habittracker.app.data.model.Habit newItem) {
            return false;
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0016\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2 = {"Lcom/habittracker/app/ui/home/HabitCheckAdapter$HabitViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/habittracker/app/databinding/ItemHabitCheckBinding;", "(Lcom/habittracker/app/ui/home/HabitCheckAdapter;Lcom/habittracker/app/databinding/ItemHabitCheckBinding;)V", "bind", "", "habit", "Lcom/habittracker/app/data/model/Habit;", "isChecked", "", "app_debug"})
    public final class HabitViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull
        private final com.habittracker.app.databinding.ItemHabitCheckBinding binding = null;
        
        public HabitViewHolder(@org.jetbrains.annotations.NotNull
        com.habittracker.app.databinding.ItemHabitCheckBinding binding) {
            super(null);
        }
        
        public final void bind(@org.jetbrains.annotations.NotNull
        com.habittracker.app.data.model.Habit habit, boolean isChecked) {
        }
    }
}