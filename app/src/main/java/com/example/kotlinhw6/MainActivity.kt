package com.example.kotlinhw6

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kotlinhw6.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        var view = binding.root
        setContentView(view)

        binding.q1Btn.setOnClickListener {
            val intent = Intent(this ,Information::class.java)
            startActivity(intent)
        }
        binding.q2Btn.setOnClickListener {  }
        binding.q3Btn.setOnClickListener {  }
    }
}