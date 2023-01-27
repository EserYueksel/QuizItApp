package com.example.quizit.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.quizit.QuizViewModel
import com.example.quizit.databinding.FragmentResultBinding

class ResultFragment: Fragment() {
    private lateinit var binding: FragmentResultBinding
    private val viewModel: QuizViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentResultBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel.score.observe(viewLifecycleOwner) {
            binding.resultScoreText.text = "Nicely done!\nYou have $it points!"
        }
        binding.resultAgainButton.setOnClickListener {
            viewModel.restartGame()
                findNavController().navigateUp()
        }
    }
}