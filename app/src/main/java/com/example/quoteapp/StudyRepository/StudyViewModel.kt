package com.example.quoteapp.StudyRepository

import androidx.lifecycle.ViewModel
import com.example.quoteapp.GymRepository.GymRepo
import com.example.quoteapp.GymRepository.GymquotesData

class StudyViewModel:ViewModel() {
    private var currentIndex=0
    private val quotes= StudyRepo().setStudyData()

    fun getCurrentQuotes(): StudyquotesData {
        return quotes[currentIndex]
    }
    fun getNextQuote() {
        currentIndex = (currentIndex + 1) % quotes.size
    }

    fun getPreviousQuote() {
        currentIndex = (currentIndex - 1 + quotes.size) % quotes.size
    }
}