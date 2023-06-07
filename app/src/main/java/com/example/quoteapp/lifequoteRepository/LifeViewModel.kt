package com.example.quoteapp.lifequoteRepository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.quoteapp.LoveRepository.LoveRepo
import com.example.quoteapp.LoveRepository.LovequotesData

class LifeViewModel() :ViewModel() {
    private var currentIndex=0
    private val quotes=LifeRepo().setLifeData()

   fun getCurrentQuote():LifequotesData{
       return quotes[currentIndex]
   }
    fun getNextQuote(){
        currentIndex=(currentIndex +1)%quotes.size
    }
    fun getPreviousQuote(){
        currentIndex=(currentIndex -1 + quotes.size)%quotes.size
    }

}