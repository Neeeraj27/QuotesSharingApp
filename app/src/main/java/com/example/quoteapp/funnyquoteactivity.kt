package com.example.quoteapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.quoteapp.FunnyRepository.FunnyViewModel
import com.example.quoteapp.databinding.ActivityFunnyquoteactivityBinding
import com.example.quoteapp.databinding.ActivityMainBinding
import com.example.quoteapp.lifequoteRepository.LifeViewModel

class funnyquoteactivity : AppCompatActivity() {
    lateinit var mainviewmodel:FunnyViewModel
    lateinit var binding: ActivityFunnyquoteactivityBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityFunnyquoteactivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.sharebtn.setOnClickListener{
            val quote=binding.tvtextquote.text.toString()
            val intent= Intent()
            intent.action=Intent.ACTION_SEND
            intent.type="text/plane"
            intent.putExtra(Intent.EXTRA_TEXT,quote)
            startActivity(Intent.createChooser(intent,"Share To-"))
        }
        mainviewmodel= ViewModelProvider(this).get(FunnyViewModel::class.java)

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
        binding.tvtextquote.text=currentquote.funnyquotes
    }
}