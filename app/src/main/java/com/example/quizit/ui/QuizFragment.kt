package com.example.quizit.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.quizit.QuizViewModel
import com.example.quizit.databinding.FragmentQuizBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class QuizFragment : Fragment() {

    private lateinit var binding: FragmentQuizBinding

    private val viewModel: QuizViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentQuizBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        viewModel.score.observe(viewLifecycleOwner){
            binding.scoreText.text = it.toString()
        }
        viewModel.currentQuestion.observe(viewLifecycleOwner) {
            binding.questionText.text = it.name
        }
        viewModel.gameEnd.observe(viewLifecycleOwner) {
            if (it) {
                findNavController()
                    .navigate(QuizFragmentDirections.actionQuizFragmentToResultFragment())
            }
        }

        binding.musicianButton.setOnClickListener {
            viewModel.checkAnswer(true)

        }
        binding.footballButton.setOnClickListener {
            viewModel.checkAnswer(false)

        }
    }
}
