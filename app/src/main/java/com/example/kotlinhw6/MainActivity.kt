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
        val view = binding.root
        setContentView(view)

        binding.q1Btn.setOnClickListener {
            val intent = Intent(this ,Information::class.java)
            startActivity(intent)
        }
        binding.q2Btn.setOnClickListener {
            val intent = Intent(this ,TicTacToe::class.java)
            startActivity(intent)
        }
        binding.q3Btn.setOnClickListener {
            val intent = Intent(this ,AllaedinConstraintLayout::class.java)
            startActivity(intent)
        }
    }
}