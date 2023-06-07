package com.example.quoteapp.GymRepository

import androidx.lifecycle.ViewModel
import com.example.quoteapp.FunnyRepository.FunnyRepo
import com.example.quoteapp.FunnyRepository.FunnyquotesData

class GymViewModel:ViewModel() {
    private var currentIndex=0
    private val quotes= GymRepo().setGymData()

    fun getCurrentQuotes(): GymquotesData {
        return quotes[currentIndex]
    }
    fun getNextQuote() {
        currentIndex = (currentIndex + 1) % quotes.size
    }

    fun getPreviousQuote() {
        currentIndex = (currentIndex - 1 + quotes.size) % quotes.size
    }


}
