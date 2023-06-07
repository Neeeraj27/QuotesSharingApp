package com.example.quoteapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.cardview.widget.CardView
import com.example.quoteapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.lifequote.setOnClickListener{
            startActivity(Intent(this,lifequoteactivity::class.java))
        }
        binding.gymquote.setOnClickListener{
            startActivity(Intent(this,gymquoteactivity::class.java))
        }
        binding.travelquotes.setOnClickListener{
            startActivity(Intent(this,travelquoteactivity::class.java))
        }

        binding.studyquotes.setOnClickListener{
            startActivity(Intent(this,studyquoteactivity::class.java))
        }
        binding.lovequotes.setOnClickListener{
            startActivity(Intent(this,lovequoteactivity::class.java))
        }

        binding.funnyquotes.setOnClickListener{
            startActivity(Intent(this,funnyquoteactivity::class.java))
        }

    }
}