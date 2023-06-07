package com.example.quoteapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.quoteapp.FunnyRepository.FunnyViewModel
import com.example.quoteapp.LoveRepository.LoveViewModel
import com.example.quoteapp.databinding.ActivityFunnyquoteactivityBinding
import com.example.quoteapp.databinding.ActivityLovequoteactivityBinding

class lovequoteactivity : AppCompatActivity() {
    lateinit var mainviewmodel: LoveViewModel
    lateinit var binding: ActivityLovequoteactivityBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityLovequoteactivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mainviewmodel=ViewModelProvider(this).get(LoveViewModel::class.java)

        binding.sharebtn.setOnClickListener{
            val quote=binding.tvtextquote.text.toString()
            val intent= Intent()
            intent.action= Intent.ACTION_SEND
            intent.type="text/plane"
            intent.putExtra(Intent.EXTRA_TEXT,quote)
            startActivity(Intent.createChooser(intent,"Share To-"))
        }

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
        binding.tvtextquote.text=currentquote.lovequote
    }
}

