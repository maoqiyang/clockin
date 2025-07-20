package com.habittracker.app.ui.settings

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.habittracker.app.data.model.Habit
import com.habittracker.app.databinding.ItemHabitEditBinding
import java.util.*

class HabitEditAdapter(
    private val onEditClick: (Habit) -> Unit,
    private val onDeleteClick: (Habit) -> Unit
) : ListAdapter<Habit, HabitEditAdapter.HabitEditViewHolder>(HabitEditDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HabitEditViewHolder {
        val binding = ItemHabitEditBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return HabitEditViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HabitEditViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    fun moveItem(fromPosition: Int, toPosition: Int) {
        val list = currentList.toMutableList()
        Collections.swap(list, fromPosition, toPosition)
        submitList(list)
    }

    inner class HabitEditViewHolder(
        private val binding: ItemHabitEditBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(habit: Habit) {
            binding.textHabitName.text = habit.name
            
            if (habit.description.isNotEmpty()) {
                binding.textHabitDescription.text = habit.description
                binding.textHabitDescription.visibility = android.view.View.VISIBLE
            } else {
                binding.textHabitDescription.visibility = android.view.View.GONE
            }
            
            binding.buttonEdit.setOnClickListener {
                onEditClick(habit)
            }
            
            binding.buttonDelete.setOnClickListener {
                onDeleteClick(habit)
            }
        }
    }

    class HabitEditDiffCallback : DiffUtil.ItemCallback<Habit>() {
        override fun areItemsTheSame(oldItem: Habit, newItem: Habit): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Habit, newItem: Habit): Boolean {
            return oldItem == newItem
        }
    }
}
