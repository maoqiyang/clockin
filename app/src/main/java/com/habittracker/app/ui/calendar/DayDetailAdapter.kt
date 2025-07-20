package com.habittracker.app.ui.calendar

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.habittracker.app.R
import com.habittracker.app.databinding.ItemDayDetailBinding

class DayDetailAdapter : ListAdapter<CalendarViewModel.DayDetailItem, DayDetailAdapter.DayDetailViewHolder>(
    DayDetailDiffCallback()
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DayDetailViewHolder {
        val binding = ItemDayDetailBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return DayDetailViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DayDetailViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class DayDetailViewHolder(
        private val binding: ItemDayDetailBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: CalendarViewModel.DayDetailItem) {
            binding.textHabitName.text = item.habitName

            if (item.description.isNotEmpty()) {
                binding.textHabitDescription.text = item.description
                binding.textHabitDescription.visibility = android.view.View.VISIBLE
            } else {
                binding.textHabitDescription.visibility = android.view.View.GONE
            }

            // Set completion status with improved visual feedback
            if (item.isCompleted) {
                binding.iconStatus.setImageResource(R.drawable.ic_check_circle)
                binding.iconStatus.setColorFilter(
                    ContextCompat.getColor(binding.root.context, R.color.calendar_complete)
                )
                binding.textStatus.text = "✓ 已完成"
                binding.textStatus.setTextColor(
                    ContextCompat.getColor(binding.root.context, R.color.calendar_complete)
                )
                // 添加轻微的透明度变化来表示完成状态
                binding.textHabitName.alpha = 1.0f
                binding.root.alpha = 1.0f
            } else {
                binding.iconStatus.setImageResource(R.drawable.ic_cancel)
                binding.iconStatus.setColorFilter(
                    ContextCompat.getColor(binding.root.context, R.color.calendar_incomplete)
                )
                binding.textStatus.text = "✗ 未完成"
                binding.textStatus.setTextColor(
                    ContextCompat.getColor(binding.root.context, R.color.calendar_incomplete)
                )
                // 未完成的项目稍微降低透明度
                binding.textHabitName.alpha = 0.8f
                binding.root.alpha = 0.9f
            }

            // 添加轻微的进入动画
            binding.root.animate()
                .alpha(if (item.isCompleted) 1.0f else 0.9f)
                .setDuration(200)
                .start()
        }
    }

    class DayDetailDiffCallback : DiffUtil.ItemCallback<CalendarViewModel.DayDetailItem>() {
        override fun areItemsTheSame(
            oldItem: CalendarViewModel.DayDetailItem,
            newItem: CalendarViewModel.DayDetailItem
        ): Boolean {
            return oldItem.habitName == newItem.habitName
        }

        override fun areContentsTheSame(
            oldItem: CalendarViewModel.DayDetailItem,
            newItem: CalendarViewModel.DayDetailItem
        ): Boolean {
            return oldItem == newItem
        }
    }
}
