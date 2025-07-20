package com.habittracker.app.ui.calendar

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.habittracker.app.R
import com.habittracker.app.databinding.ItemCalendarDayBinding

class CalendarAdapter(
    private val onDayClick: (CalendarDay) -> Unit
) : ListAdapter<CalendarDay, CalendarAdapter.CalendarDayViewHolder>(CalendarDayDiffCallback()) {

    private var selectedDate: CalendarDay? = null
    private val decorators = mutableListOf<CalendarDecorator>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CalendarDayViewHolder {
        val binding = ItemCalendarDayBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return CalendarDayViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CalendarDayViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    fun setSelectedDate(date: CalendarDay) {
        val oldSelected = selectedDate
        selectedDate = date
        
        // Refresh the old and new selected items
        oldSelected?.let { old ->
            val oldIndex = currentList.indexOfFirst { it.year == old.year && it.month == old.month && it.day == old.day }
            if (oldIndex != -1) notifyItemChanged(oldIndex)
        }
        
        val newIndex = currentList.indexOfFirst { it.year == date.year && it.month == date.month && it.day == date.day }
        if (newIndex != -1) notifyItemChanged(newIndex)
    }

    fun addDecorator(decorator: CalendarDecorator) {
        decorators.add(decorator)
        notifyDataSetChanged()
    }

    fun clearDecorators() {
        decorators.clear()
        notifyDataSetChanged()
    }

    inner class CalendarDayViewHolder(
        private val binding: ItemCalendarDayBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(day: CalendarDay) {
            if (day.isCurrentMonth && day.day > 0) {
                // 显示当前月份的日期
                binding.textDay.text = day.day.toString()
                binding.textDay.alpha = 1.0f
                binding.root.visibility = android.view.View.VISIBLE

                // 重置背景色
                binding.root.setBackgroundColor(Color.TRANSPARENT)

                // Check if this day should be decorated
                val decorator = decorators.find { it.shouldDecorate(day) }
                if (decorator != null) {
                    binding.root.setBackgroundColor(decorator.getBackgroundColor())
                }

                // Highlight selected date
                if (selectedDate?.let { it.year == day.year && it.month == day.month && it.day == day.day } == true) {
                    binding.root.setBackgroundColor(
                        ContextCompat.getColor(binding.root.context, R.color.calendar_today)
                    )
                }

                // Check if it's today
                val today = CalendarDay.today()
                if (day.year == today.year && day.month == today.month && day.day == today.day) {
                    binding.textDay.setTextColor(
                        ContextCompat.getColor(binding.root.context, R.color.calendar_today)
                    )
                } else {
                    binding.textDay.setTextColor(
                        ContextCompat.getColor(binding.root.context, R.color.text_primary)
                    )
                }

                binding.root.setOnClickListener {
                    onDayClick(day)
                }
            } else {
                // 空白占位符
                binding.textDay.text = ""
                binding.textDay.alpha = 0.0f
                binding.root.setBackgroundColor(Color.TRANSPARENT)
                binding.root.setOnClickListener(null)
                binding.root.visibility = android.view.View.VISIBLE
            }
        }
    }

    class CalendarDayDiffCallback : DiffUtil.ItemCallback<CalendarDay>() {
        override fun areItemsTheSame(oldItem: CalendarDay, newItem: CalendarDay): Boolean {
            return oldItem.year == newItem.year &&
                   oldItem.month == newItem.month &&
                   oldItem.day == newItem.day &&
                   oldItem.isCurrentMonth == newItem.isCurrentMonth
        }

        override fun areContentsTheSame(oldItem: CalendarDay, newItem: CalendarDay): Boolean {
            return oldItem == newItem
        }
    }
}
