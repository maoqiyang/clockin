package com.habittracker.app.ui.calendar

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.RotateAnimation
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.habittracker.app.R
import com.habittracker.app.databinding.FragmentCalendarBinding

import java.text.SimpleDateFormat
import java.util.*

class CalendarFragment : Fragment() {

    private var _binding: FragmentCalendarBinding? = null
    private val binding get() = _binding!!

    private lateinit var calendarViewModel: CalendarViewModel
    private lateinit var dayDetailAdapter: DayDetailAdapter
    private lateinit var bottomSheetBehavior: BottomSheetBehavior<View>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        calendarViewModel = ViewModelProvider(this)[CalendarViewModel::class.java]

        _binding = FragmentCalendarBinding.inflate(inflater, container, false)
        val root: View = binding.root

        setupCalendarView()
        setupRecyclerView()
        setupBottomSheet()
        observeViewModel()

        return root
    }

    private fun setupCalendarView() {
        binding.calendarView.setOnDateSelectedListener { date ->
            calendarViewModel.selectDate(date)
        }

        val today = CalendarDay.today()
        binding.calendarView.setSelectedDate(today)

        // Load current month data
        calendarViewModel.loadMonthData(today)
        // Also select today's date in the view model
        calendarViewModel.selectDate(today)
    }

    private fun setupRecyclerView() {
        dayDetailAdapter = DayDetailAdapter()
        binding.recyclerViewDayDetail.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = dayDetailAdapter
        }
    }

    private fun setupBottomSheet() {
        bottomSheetBehavior = BottomSheetBehavior.from(binding.bottomSheet)

        // 设置底部面板的初始状态
        bottomSheetBehavior.state = BottomSheetBehavior.STATE_COLLAPSED
        bottomSheetBehavior.peekHeight = 80.dpToPx()
        bottomSheetBehavior.isHideable = false

        // 设置底部面板状态变化监听器
        bottomSheetBehavior.addBottomSheetCallback(object : BottomSheetBehavior.BottomSheetCallback() {
            override fun onStateChanged(bottomSheet: View, newState: Int) {
                updateExpandIcon(newState)
            }

            override fun onSlide(bottomSheet: View, slideOffset: Float) {
                // 可以在这里添加滑动动画效果
                val rotation = slideOffset * 180f
                binding.iconExpand.rotation = rotation
            }
        })

        // 设置点击事件来切换底部面板状态
        binding.peekContent.setOnClickListener {
            if (bottomSheetBehavior.state == BottomSheetBehavior.STATE_COLLAPSED) {
                bottomSheetBehavior.state = BottomSheetBehavior.STATE_EXPANDED
            } else {
                bottomSheetBehavior.state = BottomSheetBehavior.STATE_COLLAPSED
            }
        }
    }

    private fun updateExpandIcon(state: Int) {
        val iconRes = when (state) {
            BottomSheetBehavior.STATE_EXPANDED -> R.drawable.ic_expand_less
            else -> R.drawable.ic_expand_more
        }
        binding.iconExpand.setImageResource(iconRes)
    }

    // 扩展函数：dp转px
    private fun Int.dpToPx(): Int {
        return (this * resources.displayMetrics.density).toInt()
    }

    private fun observeViewModel() {
        calendarViewModel.monthlyStats.observe(viewLifecycleOwner) { stats ->
            updateStatsDisplay(stats)
        }
        
        calendarViewModel.calendarDecorators.observe(viewLifecycleOwner) { decorators ->
            binding.calendarView.removeDecorators()
            decorators.forEach { decorator ->
                binding.calendarView.addDecorator(decorator)
            }
            binding.calendarView.invalidateCalendar()
        }
        
        calendarViewModel.selectedDayDetails.observe(viewLifecycleOwner) { details ->
            dayDetailAdapter.submitList(details)
            updateSelectedDateDisplay(calendarViewModel.selectedDate.value)

            // 显示或隐藏空状态
            if (details.isEmpty()) {
                binding.recyclerViewDayDetail.visibility = View.GONE
                binding.emptyState.visibility = View.VISIBLE
            } else {
                binding.recyclerViewDayDetail.visibility = View.VISIBLE
                binding.emptyState.visibility = View.GONE

                // 如果有详情数据且底部面板是收起状态，可以轻微展开提示用户
                if (bottomSheetBehavior.state == BottomSheetBehavior.STATE_COLLAPSED) {
                    animateBottomSheetHint()
                }
            }
        }
    }

    private fun updateStatsDisplay(stats: CalendarViewModel.MonthlyStats) {
        if (stats.isDaily) {
            // Display daily statistics for selected date
            binding.textCompletionRate.text = "完成率: ${stats.completionRate}%"
            binding.textTotalDays.text = "总习惯: ${stats.totalHabits}个"
            binding.textCompletedDays.text = "已完成: ${stats.completedHabits}个"

            // Update the stats card title to reflect daily stats
            updateStatsTitle("当日统计")
        } else {
            // Display monthly statistics (fallback)
            binding.textCompletionRate.text = getString(R.string.completion_rate, stats.completionRate)
            binding.textTotalDays.text = getString(R.string.total_days, stats.totalHabits)
            binding.textCompletedDays.text = getString(R.string.completed_days, stats.completedHabits)

            // Update the stats card title to reflect monthly stats
            updateStatsTitle("本月统计")
        }
    }

    private fun updateStatsTitle(title: String) {
        // Find the stats title TextView and update it
        val statsTitle = binding.root.findViewById<TextView>(R.id.text_stats_title)
        statsTitle?.text = title
    }

    private fun updateSelectedDateDisplay(date: CalendarDay?) {
        date?.let {
            val formatter = SimpleDateFormat("yyyy年MM月dd日", Locale.CHINESE)
            val calendar = Calendar.getInstance()
            calendar.set(it.year, it.month - 1, it.day)
            val dateText = formatter.format(calendar.time)
            binding.textSelectedDate.text = dateText

            // 检查是否是今天
            val today = CalendarDay.today()
            if (it.year == today.year && it.month == today.month && it.day == today.day) {
                binding.textSelectedDate.text = "$dateText (今天)"
            }
        } ?: run {
            binding.textSelectedDate.text = "选择日期查看详情"
        }
    }

    private fun animateBottomSheetHint() {
        // 创建一个轻微的弹跳动画来提示用户
        val originalPeekHeight = bottomSheetBehavior.peekHeight
        val expandedPeekHeight = originalPeekHeight + 20.dpToPx()

        // 先展开一点
        bottomSheetBehavior.peekHeight = expandedPeekHeight

        // 延迟后恢复原状
        binding.bottomSheet.postDelayed({
            bottomSheetBehavior.peekHeight = originalPeekHeight
        }, 300)
    }



    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
