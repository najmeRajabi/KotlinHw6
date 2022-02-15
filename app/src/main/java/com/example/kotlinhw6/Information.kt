package com.example.kotlinhw6

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.kotlinhw6.databinding.ActivityInformationsBinding

class Information : AppCompatActivity() {
    private lateinit var binding :ActivityInformationsBinding
    private  var name :String=""
    lateinit var username: String
    lateinit var email :String
    lateinit var password : String
    lateinit var gender : Gender

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityInformationsBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val sharedPreference: SharedPreferences? = this.getSharedPreferences("info", Context.MODE_PRIVATE)

        var registered = false

        binding.registerBtn.setOnClickListener{
            if (checkFiled()){
                init()
                registered = true
                Toast.makeText(this,"registered successfully",Toast.LENGTH_SHORT).show()
            }
        }
        binding.showInfoBtn.setOnClickListener{
            if (sharedPreference?.getBoolean("register",false) == true) {
                setInformation()
                showInformation()
            }else{
                Toast.makeText(this,"not registered yet!",Toast.LENGTH_SHORT).show()
            }
        }
        binding.hideInfoBtn.setOnClickListener { hideInformation() }
    }



    private fun checkFiled():Boolean{
        var result =  false
        when {
            binding.nameEditText.text?.isBlank() == true -> {
                binding.nameEditText.error="Enter your name"
            }
            binding.usernameEditText.text?.isBlank() == true -> {
                binding.usernameEditText.error = " enter username"
            }
            binding.emailEditText.text?.isBlank() == true -> {
                binding.emailEditText.error = "enter email address"
            }
            binding.passwordEditText.text?.isBlank() == true -> {
                binding.passwordEditText.error = " enter a password"
            }
            binding.repeatPasswordEditText.text?.isBlank() == true -> {
                binding.repeatPasswordEditText.error = " repeat password"
            }
            binding.passwordEditText.text.toString() != binding.repeatPasswordEditText.text.toString() -> {
                binding.repeatPasswordEditText.error = " passwords not same"
            }
            else -> result = true
        }
        return result
    }
    private fun init(){
        val sharedPreference: SharedPreferences? = this.getSharedPreferences("info", Context.MODE_PRIVATE)
        name = binding.nameEditText.text.toString()
        username = binding.usernameEditText.text.toString()
        email = binding.emailEditText.text.toString()
        password = binding.passwordEditText.text.toString()
        gender = if (binding.genderRadioGroup.checkedRadioButtonId == binding.femaleRadioButton.id){
            Gender.Female
        }else{
            Gender.Male
        }

        val editor= sharedPreference?.edit()
        editor?.putString("name",name)
        editor?.putString("username",username)
        editor?.putString("email",email)
        editor?.putString("password",password)
        editor?.putString("gender",gender.name)
        editor?.putBoolean("register",true)
        editor?.apply()
        editor?.commit()

    }
    private fun setInformation(){
        val sharedPreference: SharedPreferences? = this.getSharedPreferences("info", Context.MODE_PRIVATE)
        binding.nameTxv.text = sharedPreference?.getString("name","name")
        binding.usernameTxv.text = sharedPreference?.getString("username","username")
        binding.emailTxv.text = sharedPreference?.getString("email","email")
        binding.passwordTxv.text = sharedPreference?.getString("password","password")
        binding.genderTxv.text = sharedPreference?.getString("gender","gender")
    }
    private fun showInformation(){
        val component = arrayListOf(binding.nameTxv,binding.emailTxv,
            binding.genderTxv, binding.usernameTxv,binding.passwordTxv,
            binding.hideInfoBtn)
        component.forEach{it.visibility= View.VISIBLE}
    }
    private fun hideInformation(){
        val component = arrayListOf(binding.nameTxv,binding.emailTxv,
            binding.genderTxv, binding.usernameTxv,binding.passwordTxv,
            binding.hideInfoBtn)
        component.forEach{it.visibility= View.GONE}
    }
}

enum class Gender{
    Female , Male
}