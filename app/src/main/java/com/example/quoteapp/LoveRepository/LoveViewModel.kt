package com.example.quoteapp.LoveRepository

import androidx.lifecycle.ViewModel
import com.example.quoteapp.GymRepository.GymRepo
import com.example.quoteapp.GymRepository.GymquotesData

class LoveViewModel:ViewModel() {
    private var currentIndex=0
    private val quotes= LoveRepo().setLoveData()

    fun getCurrentQuotes(): LovequotesData {
        return quotes[currentIndex]
    }
    fun getNextQuote() {
        currentIndex = (currentIndex + 1) % quotes.size
    }

    fun getPreviousQuote() {
        currentIndex = (currentIndex - 1 + quotes.size) % quotes.size
    }
}