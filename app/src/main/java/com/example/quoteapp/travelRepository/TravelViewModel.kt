package com.example.quoteapp.travelRepository

import androidx.lifecycle.ViewModel
import com.example.quoteapp.GymRepository.GymRepo
import com.example.quoteapp.GymRepository.GymquotesData

class TravelViewModel:ViewModel() {
    private var currentIndex=0
    private val quotes= TravelRepo().setTravelData()

    fun getCurrentQuotes(): TravelquotesData {
        return quotes[currentIndex]
    }
    fun getNextQuote() {
        currentIndex = (currentIndex + 1) % quotes.size
    }

    fun getPreviousQuote() {
        currentIndex = (currentIndex - 1 + quotes.size) % quotes.size
    }
}