package com.example.quoteapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.quoteapp.databinding.ActivityFunnyquoteactivityBinding
import com.example.quoteapp.databinding.ActivityLifequoteactivityBinding
import com.example.quoteapp.lifequoteRepository.LifeViewModel

class lifequoteactivity : AppCompatActivity() {
    lateinit var binding: ActivityLifequoteactivityBinding
    lateinit var mainviewmodel:LifeViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLifequoteactivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mainviewmodel=ViewModelProvider(this).get(LifeViewModel::class.java)

        binding.sharebtn.setOnClickListener {
            val text=binding.tvtextquote.text.toString()
            val i=Intent()
            i.action=Intent.ACTION_SEND
            i.putExtra(Intent.EXTRA_TEXT,text)
            i.type="text/plane"
            startActivity(Intent.createChooser(i,"Share To-"))
        }

        binding.nextbtn.setOnClickListener {
            mainviewmodel.getNextQuote()
            displayCurrentQuote()
        }
        binding.previousbtn.setOnClickListener {
            mainviewmodel.getPreviousQuote()
            displayCurrentQuote()
        }
        displayCurrentQuote()
    }
    fun displayCurrentQuote(){
        val currentquote=mainviewmodel.getCurrentQuote()
        binding.tvtextquote.text=currentquote.lifequote
    }
}