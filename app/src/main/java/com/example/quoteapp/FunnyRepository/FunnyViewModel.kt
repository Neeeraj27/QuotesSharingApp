package com.example.quoteapp.FunnyRepository

import androidx.lifecycle.ViewModel
import com.example.quoteapp.lifequoteRepository.LifeRepo
import com.example.quoteapp.lifequoteRepository.LifequotesData

class FunnyViewModel:ViewModel() {
    private var currentIndex=0
    private val quotes= FunnyRepo().setFunnyData()

    fun getCurrentQuotes(): FunnyquotesData {
        return quotes[currentIndex]
    }
    fun getNextQuote() {
        currentIndex = (currentIndex + 1) % quotes.size
    }

    fun getPreviousQuote() {
        currentIndex = (currentIndex - 1 + quotes.size) % quotes.size
    }

}