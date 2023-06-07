package com.example.quoteapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.quoteapp.databinding.ActivityTravelquoteactivityBinding
import com.example.quoteapp.travelRepository.TravelViewModel

class travelquoteactivity : AppCompatActivity() {
    lateinit var mainviewmodel: TravelViewModel
    lateinit var binding: ActivityTravelquoteactivityBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityTravelquoteactivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.sharebtn.setOnClickListener{
            val quote=binding.tvtextquote.text.toString()
            val intent= Intent()
            intent.action= Intent.ACTION_SEND
            intent.type="text/plane"
            intent.putExtra(Intent.EXTRA_TEXT,quote)
            startActivity(Intent.createChooser(intent,"Share To-"))
        }
        mainviewmodel= ViewModelProvider(this).get(TravelViewModel::class.java)

        binding.nextbtn.setOnClickListener{
            mainviewmodel.getNextQuote()
            displayCurrentQuote()
        }
        binding.previousbtn.setOnClickListener {
            mainviewmodel.getPreviousQuote()
            displayCurrentQuote()
        }
        displayCurrentQuote()

    }

    private fun displayCurrentQuote() {
        val currentquote=mainviewmodel.getCurrentQuotes()
        binding.tvtextquote.text=currentquote.travelquote
    }
}