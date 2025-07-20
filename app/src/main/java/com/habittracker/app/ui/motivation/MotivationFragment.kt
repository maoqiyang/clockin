package com.habittracker.app.ui.motivation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.habittracker.app.R
import com.habittracker.app.databinding.FragmentMotivationBinding

class MotivationFragment : Fragment() {

    private var _binding: FragmentMotivationBinding? = null
    private val binding get() = _binding!!
    
    private lateinit var motivationViewModel: MotivationViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        motivationViewModel = ViewModelProvider(this)[MotivationViewModel::class.java]

        _binding = FragmentMotivationBinding.inflate(inflater, container, false)
        val root: View = binding.root

        setupUI()
        observeViewModel()
        
        // Load initial content
        motivationViewModel.loadDailyMotivation()

        return root
    }

    private fun setupUI() {
        binding.buttonRefresh.setOnClickListener {
            motivationViewModel.loadDailyMotivation()
        }
        
        binding.buttonFavorite.setOnClickListener {
            motivationViewModel.toggleFavorite()
        }
    }

    private fun observeViewModel() {
        motivationViewModel.motivationContent.observe(viewLifecycleOwner) { content ->
            content?.let {
                binding.textQuote.text = it.quote
                binding.textAuthor.text = it.author ?: "佚名"
                
                // Load image
                if (it.imageUrl.isNotEmpty()) {
                    loadImage(it.imageUrl)
                } else {
                    binding.imageMotivation.setImageResource(R.drawable.placeholder_motivation)
                }
                
                // Update favorite button
                updateFavoriteButton(it.isFavorite)
            }
        }
        
        motivationViewModel.isLoading.observe(viewLifecycleOwner) { isLoading ->
            binding.progressBar.visibility = if (isLoading) View.VISIBLE else View.GONE
            binding.buttonRefresh.isEnabled = !isLoading
        }
        
        motivationViewModel.errorMessage.observe(viewLifecycleOwner) { message ->
            message?.let {
                Toast.makeText(context, it, Toast.LENGTH_SHORT).show()
            }
        }
        
        motivationViewModel.favoriteToggled.observe(viewLifecycleOwner) { isFavorite ->
            updateFavoriteButton(isFavorite)
            val message = if (isFavorite) "已添加到收藏" else "已取消收藏"
            Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
        }
    }

    private fun loadImage(imageUrl: String) {
        Glide.with(this)
            .load(imageUrl)
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .placeholder(R.drawable.placeholder_motivation)
            .error(R.drawable.placeholder_motivation)
            .into(binding.imageMotivation)
    }

    private fun updateFavoriteButton(isFavorite: Boolean) {
        if (isFavorite) {
            binding.buttonFavorite.setIconResource(R.drawable.ic_favorite_filled)
            binding.buttonFavorite.text = getString(R.string.unfavorite)
        } else {
            binding.buttonFavorite.setIconResource(R.drawable.ic_favorite_border)
            binding.buttonFavorite.text = getString(R.string.favorite)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
