package com.habittracker.app.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.habittracker.app.R
import com.habittracker.app.databinding.FragmentHomeBinding
import java.text.SimpleDateFormat
import java.util.*

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    
    private lateinit var homeViewModel: HomeViewModel
    private lateinit var habitAdapter: HabitCheckAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        homeViewModel = ViewModelProvider(this)[HomeViewModel::class.java]

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        setupUI()
        setupRecyclerView()
        observeViewModel()

        return root
    }

    private fun setupUI() {
        // Display today's date
        val today = SimpleDateFormat("yyyy年MM月dd日 EEEE", Locale.CHINESE).format(Date())
        binding.textToday.text = getString(R.string.today_date, today)
    }

    private fun setupRecyclerView() {
        habitAdapter = HabitCheckAdapter { habit, isChecked ->
            homeViewModel.updateHabitRecord(habit.id, isChecked)
        }
        
        binding.recyclerViewHabits.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = habitAdapter
        }
    }

    private fun observeViewModel() {
        homeViewModel.habits.observe(viewLifecycleOwner) { habits ->
            habitAdapter.submitList(habits)
        }
        
        homeViewModel.todayRecords.observe(viewLifecycleOwner) { records ->
            habitAdapter.updateRecords(records)
        }
        
        homeViewModel.saveResult.observe(viewLifecycleOwner) { success ->
            if (success) {
                Toast.makeText(context, R.string.save_success, Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
