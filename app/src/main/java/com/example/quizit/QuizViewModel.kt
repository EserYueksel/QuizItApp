package com.example.quizit

import androidx.lifecycle.ViewModel
import com.example.quizit.data.QuizRepository
import com.example.quizit.data.model.Question

class QuizViewModel: ViewModel() {
    private val repository = QuizRepository()
    private val questions = repository.loadQuestions()

    private var _score = 0
    val score: Int
        get() = _score

    private var _currentQuestion = questions.random()
    val currentQuestion: Question
        get() = _currentQuestion

    fun checkAnswer(isMusician: Boolean) {
        if (isMusician == currentQuestion.isMusician) {
            _score ++
            getNextQuestion()
        }
    }

    private fun getNextQuestion() {
        val nextQuestion = questions.random()

        if(nextQuestion == currentQuestion) {
            getNextQuestion()
        } else {
            _currentQuestion = nextQuestion
        }
    }
    fun restartGame() {
        _score = 0
        getNextQuestion()
    }
}