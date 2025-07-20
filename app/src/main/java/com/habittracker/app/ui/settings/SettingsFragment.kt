package com.habittracker.app.ui.settings

import android.app.TimePickerDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.textfield.TextInputEditText
import com.habittracker.app.R
import com.habittracker.app.data.model.Habit
import com.habittracker.app.databinding.FragmentSettingsBinding
import java.util.*

class SettingsFragment : Fragment() {

    private var _binding: FragmentSettingsBinding? = null
    private val binding get() = _binding!!
    
    private lateinit var settingsViewModel: SettingsViewModel
    private lateinit var habitEditAdapter: HabitEditAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        settingsViewModel = ViewModelProvider(this)[SettingsViewModel::class.java]

        _binding = FragmentSettingsBinding.inflate(inflater, container, false)
        val root: View = binding.root

        setupUI()
        setupRecyclerView()
        observeViewModel()

        return root
    }

    private fun setupUI() {
        binding.buttonAddHabit.setOnClickListener {
            showAddHabitDialog()
        }
        
        binding.textReminderTime.setOnClickListener {
            showTimePickerDialog()
        }
        
        binding.switchReminder.setOnCheckedChangeListener { _, isChecked ->
            settingsViewModel.updateReminderEnabled(isChecked)
        }
    }

    private fun setupRecyclerView() {
        habitEditAdapter = HabitEditAdapter(
            onEditClick = { habit -> showEditHabitDialog(habit) },
            onDeleteClick = { habit -> showDeleteConfirmDialog(habit) }
        )
        
        binding.recyclerViewHabits.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = habitEditAdapter
        }
        
        // Add drag and drop functionality
        val itemTouchHelper = ItemTouchHelper(object : ItemTouchHelper.SimpleCallback(
            ItemTouchHelper.UP or ItemTouchHelper.DOWN, 0
        ) {
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                val fromPosition = viewHolder.adapterPosition
                val toPosition = target.adapterPosition
                habitEditAdapter.moveItem(fromPosition, toPosition)
                return true
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                // Not used
            }
            
            override fun onMoved(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                fromPos: Int,
                target: RecyclerView.ViewHolder,
                toPos: Int,
                x: Int,
                y: Int
            ) {
                super.onMoved(recyclerView, viewHolder, fromPos, target, toPos, x, y)
                settingsViewModel.updateHabitOrder(habitEditAdapter.currentList)
            }
        })
        
        itemTouchHelper.attachToRecyclerView(binding.recyclerViewHabits)
    }

    private fun observeViewModel() {
        settingsViewModel.habits.observe(viewLifecycleOwner) { habits ->
            habitEditAdapter.submitList(habits.toMutableList())
        }
        
        settingsViewModel.userSettings.observe(viewLifecycleOwner) { settings ->
            settings?.let {
                binding.textReminderTime.text = it.reminderTime
                binding.switchReminder.isChecked = it.isReminderEnabled
            }
        }
        
        settingsViewModel.operationResult.observe(viewLifecycleOwner) { result ->
            val message = when (result) {
                SettingsViewModel.OperationResult.SUCCESS -> "操作成功"
                SettingsViewModel.OperationResult.ERROR -> "操作失败"
                SettingsViewModel.OperationResult.MAX_HABITS_REACHED -> getString(R.string.max_habits_reached)
            }
            Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
        }
    }

    private fun showAddHabitDialog() {
        val dialogView = LayoutInflater.from(context).inflate(R.layout.dialog_add_habit, null)
        val editTextName = dialogView.findViewById<TextInputEditText>(R.id.edit_text_habit_name)
        val editTextDescription = dialogView.findViewById<TextInputEditText>(R.id.edit_text_habit_description)
        
        MaterialAlertDialogBuilder(requireContext())
            .setTitle(R.string.add_habit)
            .setView(dialogView)
            .setPositiveButton(R.string.save) { _, _ ->
                val name = editTextName.text.toString().trim()
                val description = editTextDescription.text.toString().trim()
                if (name.isNotEmpty()) {
                    settingsViewModel.addHabit(name, description)
                }
            }
            .setNegativeButton(R.string.cancel, null)
            .show()
    }

    private fun showEditHabitDialog(habit: Habit) {
        val dialogView = LayoutInflater.from(context).inflate(R.layout.dialog_add_habit, null)
        val editTextName = dialogView.findViewById<TextInputEditText>(R.id.edit_text_habit_name)
        val editTextDescription = dialogView.findViewById<TextInputEditText>(R.id.edit_text_habit_description)
        
        editTextName.setText(habit.name)
        editTextDescription.setText(habit.description)
        
        MaterialAlertDialogBuilder(requireContext())
            .setTitle(R.string.edit)
            .setView(dialogView)
            .setPositiveButton(R.string.save) { _, _ ->
                val name = editTextName.text.toString().trim()
                val description = editTextDescription.text.toString().trim()
                if (name.isNotEmpty()) {
                    settingsViewModel.updateHabit(habit.copy(name = name, description = description))
                }
            }
            .setNegativeButton(R.string.cancel, null)
            .show()
    }

    private fun showDeleteConfirmDialog(habit: Habit) {
        MaterialAlertDialogBuilder(requireContext())
            .setTitle(R.string.delete_habit)
            .setMessage("确定要删除习惯「${habit.name}」吗？")
            .setPositiveButton(R.string.delete) { _, _ ->
                settingsViewModel.deleteHabit(habit)
            }
            .setNegativeButton(R.string.cancel, null)
            .show()
    }

    private fun showTimePickerDialog() {
        val currentTime = binding.textReminderTime.text.toString().split(":")
        val hour = currentTime.getOrNull(0)?.toIntOrNull() ?: 20
        val minute = currentTime.getOrNull(1)?.toIntOrNull() ?: 0
        
        TimePickerDialog(
            context,
            { _, selectedHour, selectedMinute ->
                val timeString = String.format("%02d:%02d", selectedHour, selectedMinute)
                settingsViewModel.updateReminderTime(timeString)
            },
            hour,
            minute,
            true
        ).show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
