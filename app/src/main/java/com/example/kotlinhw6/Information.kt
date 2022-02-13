package com.example.kotlinhw6

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.kotlinhw6.databinding.ActivityInformationsBinding

class Information : AppCompatActivity() {
    private lateinit var binding: ActivityInformationsBinding
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

        var registered = false

        binding.registerBtn.setOnClickListener{
            if (checkFiled()){
                init()
                registered = true
            }
        }
        binding.showInfoBtn.setOnClickListener{
            if (registered) {
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
    private fun init(){
        name = binding.nameEditText.text.toString()
        username = binding.usernameEditText.text.toString()
        email = binding.emailEditText.text.toString()
        password = binding.passwordEditText.text.toString()
        gender = if (binding.genderRadioGroup.checkedRadioButtonId == binding.femaleRadioButton.id){
            Gender.Female
        }else{
            Gender.Male
        }
    }
    private fun setInformation(){
        binding.nameTxv.text = name
        binding.usernameTxv.text = username
        binding.emailTxv.text = email
        binding.passwordTxv.text = password
        binding.genderTxv.text = gender.name
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