package com.example.kotlinhw6

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kotlinhw6.databinding.ActivityInformationsBinding

class Information : AppCompatActivity() {
    lateinit var binding: ActivityInformationsBinding
    lateinit var name :String
    lateinit var username: String
    lateinit var email :String
    lateinit var password : String
    lateinit var gender : Gender
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityInformationsBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.registerBtn.setOnClickListener{
            if (checkFiled()){

            }
        }
    }
    fun checkFiled():Boolean{
        var result =  false
        when {
            binding.nameEditText.text?.isBlank() == true -> {
                binding.nameEditText.error="Enter your name"
            }
            binding.usernameEditText.text?.isBlank() == true -> {
                binding.usernameEditText.error = " enter username"
            }
            binding.passwordEditText.text?.isBlank() == true -> {
                binding.passwordEditText.error = " enter a password"
            }
            binding.repeatPasswordEditText.text?.isBlank() == true -> {
                binding.repeatPasswordEditText.error = " repeat password"
            }
            binding.passwordEditText.text != binding.repeatPasswordEditText.text -> {
                binding.repeatPasswordEditText.error = " passwords not same"
            }
            else -> result = true
        }
        return result
    }
    fun fillFiled(){
        name = binding.nameEditText.text.toString()
    }
}

enum class Gender{
    Female , Male
}