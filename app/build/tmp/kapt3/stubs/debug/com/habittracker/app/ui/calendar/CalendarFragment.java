package com.habittracker.app.ui.calendar;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u000f\u001a\u00020\u0010H\u0002J\b\u0010\u0011\u001a\u00020\u0010H\u0002J$\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u0010H\u0016J\b\u0010\u001a\u001a\u00020\u0010H\u0002J\b\u0010\u001b\u001a\u00020\u0010H\u0002J\b\u0010\u001c\u001a\u00020\u0010H\u0002J\u0010\u0010\u001d\u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\u0012\u0010 \u001a\u00020\u00102\b\u0010!\u001a\u0004\u0018\u00010\"H\u0002J\u0010\u0010#\u001a\u00020\u00102\u0006\u0010$\u001a\u00020%H\u0002J\u0010\u0010&\u001a\u00020\u00102\u0006\u0010\'\u001a\u00020(H\u0002J\f\u0010)\u001a\u00020\u001f*\u00020\u001fH\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u00048BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006*"}, d2 = {"Lcom/habittracker/app/ui/calendar/CalendarFragment;", "Landroidx/fragment/app/Fragment;", "()V", "_binding", "Lcom/habittracker/app/databinding/FragmentCalendarBinding;", "binding", "getBinding", "()Lcom/habittracker/app/databinding/FragmentCalendarBinding;", "bottomSheetBehavior", "Lcom/google/android/material/bottomsheet/BottomSheetBehavior;", "Landroid/view/View;", "calendarViewModel", "Lcom/habittracker/app/ui/calendar/CalendarViewModel;", "dayDetailAdapter", "Lcom/habittracker/app/ui/calendar/DayDetailAdapter;", "animateBottomSheetHint", "", "observeViewModel", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "setupBottomSheet", "setupCalendarView", "setupRecyclerView", "updateExpandIcon", "state", "", "updateSelectedDateDisplay", "date", "Lcom/habittracker/app/ui/calendar/CalendarDay;", "updateStatsDisplay", "stats", "Lcom/habittracker/app/ui/calendar/CalendarViewModel$MonthlyStats;", "updateStatsTitle", "title", "", "dpToPx", "app_debug"})
public final class CalendarFragment extends androidx.fragment.app.Fragment {
    @org.jetbrains.annotations.Nullable
    private com.habittracker.app.databinding.FragmentCalendarBinding _binding;
    private com.habittracker.app.ui.calendar.CalendarViewModel calendarViewModel;
    private com.habittracker.app.ui.calendar.DayDetailAdapter dayDetailAdapter;
    private com.google.android.material.bottomsheet.BottomSheetBehavior<android.view.View> bottomSheetBehavior;
    
    public CalendarFragment() {
        super();
    }
    
    private final com.habittracker.app.databinding.FragmentCalendarBinding getBinding() {
        return null;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.NotNull
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    private final void setupCalendarView() {
    }
    
    private final void setupRecyclerView() {
    }
    
    private final void setupBottomSheet() {
    }
    
    private final void updateExpandIcon(int state) {
    }
    
    private final int dpToPx(int $this$dpToPx) {
        return 0;
    }
    
    private final void observeViewModel() {
    }
    
    private final void updateStatsDisplay(com.habittracker.app.ui.calendar.CalendarViewModel.MonthlyStats stats) {
    }
    
    private final void updateStatsTitle(java.lang.String title) {
    }
    
    private final void updateSelectedDateDisplay(com.habittracker.app.ui.calendar.CalendarDay date) {
    }
    
    private final void animateBottomSheetHint() {
    }
    
    @java.lang.Override
    public void onDestroyView() {
    }
}