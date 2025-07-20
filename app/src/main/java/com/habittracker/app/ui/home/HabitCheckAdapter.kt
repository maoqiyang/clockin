package com.habittracker.app.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.habittracker.app.data.model.Habit
import com.habittracker.app.data.model.HabitRecord
import com.habittracker.app.databinding.ItemHabitCheckBinding

class HabitCheckAdapter(
    private val onHabitChecked: (Habit, Boolean) -> Unit
) : ListAdapter<Habit, HabitCheckAdapter.HabitViewHolder>(HabitDiffCallback()) {

    private var records: List<HabitRecord> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HabitViewHolder {
        val binding = ItemHabitCheckBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return HabitViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HabitViewHolder, position: Int) {
        val habit = getItem(position)
        val record = records.find { it.habitId == habit.id }
        holder.bind(habit, record?.isCompleted ?: false)
    }

    fun updateRecords(newRecords: List<HabitRecord>) {
        records = newRecords
        notifyDataSetChanged()
    }

    inner class HabitViewHolder(
        private val binding: ItemHabitCheckBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(habit: Habit, isChecked: Boolean) {
            binding.checkboxHabit.text = habit.name
            binding.checkboxHabit.isChecked = isChecked
            
            binding.checkboxHabit.setOnCheckedChangeListener { _, checked ->
                onHabitChecked(habit, checked)
            }
            
            if (habit.description.isNotEmpty()) {
                binding.textDescription.text = habit.description
                binding.textDescription.visibility = android.view.View.VISIBLE
            } else {
                binding.textDescription.visibility = android.view.View.GONE
            }
        }
    }

    class HabitDiffCallback : DiffUtil.ItemCallback<Habit>() {
        override fun areItemsTheSame(oldItem: Habit, newItem: Habit): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Habit, newItem: Habit): Boolean {
            return oldItem == newItem
        }
    }
}
