package com.example.quizit.data

import com.example.quizit.data.model.Question

class QuizRepository {

    fun loadQuestions(): List<Question> {
        val questionList = listOf(
            Question("Andrea Bocelli", true),
            Question("Adriano Celentano", true),
            Question("Eros Ramazotti", true),
            Question("Antonio Vivaldi", true),
            Question("Francesco Guccini", true),
            Question("Franco Battiato", true),
            Question("Lucio Battisti", true),
            Question("Gino Paoli", true),
            Question("Francesco Acerbi", false),
            Question("Mario Balotelli", false),
            Question("Andrea Belotti", false),
            Question("Roberto Baggio", false),
            Question("Alessandro Del Piero", false),
            Question("Andrea Pirlo", false),
            Question("Marco Materazzi", false),
            Question("Gianluigi Buffon", false)
        )

        return questionList.shuffled()

    }
}
