package com.example.kotlinhw6

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.kotlinhw6.databinding.ActivityTicTacToeBinding
import kotlin.properties.Delegates

class TicTacToe : AppCompatActivity() {
    lateinit var binding: ActivityTicTacToeBinding
    var turnX = true
    var turnO = false
    var win = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTicTacToeBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
//        startGame()
//        binding.resetBtn.setOnClickListener { reset()
//            startGame() }



    }
    private fun startGame(){
        while (!win){
            changTurn()
            binding.box1.setOnClickListener{clickPlayer(binding.box1)}
            binding.box2.setOnClickListener{clickPlayer(binding.box2)}
            binding.box3.setOnClickListener{clickPlayer(binding.box3)}
            binding.box4.setOnClickListener{clickPlayer(binding.box4)}
            binding.box5.setOnClickListener{clickPlayer(binding.box5)}
            binding.box6.setOnClickListener{clickPlayer(binding.box6)}
            binding.box7.setOnClickListener{clickPlayer(binding.box7)}
            binding.box8.setOnClickListener{clickPlayer(binding.box8)}
            binding.box9.setOnClickListener{clickPlayer(binding.box9)}
            checkWinner()

        }
    }
    private fun changTurn(){
        if (turnO) {
            !turnO
            turnX
            binding.drawTxv.text = "draw X player"
        }else if (turnX){
            !turnX
            turnO
            binding.drawTxv.text = "draw O player"
        }
    }
    private fun reset(){
        binding.box1.text = ""
        binding.box2.text = ""
        binding.box3.text = ""
        binding.box4.text = ""
        binding.box5.text = ""
        binding.box6.text = ""
        binding.box7.text = ""
        binding.box8.text = ""
        binding.box9.text = ""
        changTurn()

    }
    private fun checkWinner(){
        if (binding.box1.text == binding.box2.text &&
            binding.box1.text == binding.box3.text){
            win
            binding.drawTxv.text = " winner is ${binding.box1.text}"
        }else if (binding.box4.text == binding.box5.text &&
                binding.box5.text == binding.box6.text){
                win
            binding.drawTxv.text = " winner is ${binding.box4.text}"
        }else if (binding.box7.text == binding.box8.text &&
            binding.box8.text == binding.box9.text){
            win
            binding.drawTxv.text = " winner is ${binding.box8.text}"
        }else if (binding.box1.text == binding.box4.text &&
            binding.box1.text == binding.box7.text){
            win
            binding.drawTxv.text = " winner is ${binding.box4.text}"
        }else if (binding.box2.text == binding.box5.text &&
            binding.box5.text == binding.box8.text){
            win
            binding.drawTxv.text = " winner is ${binding.box5.text}"
        }else if (binding.box3.text == binding.box6.text &&
            binding.box9.text == binding.box6.text){
            win
            binding.drawTxv.text = " winner is ${binding.box6.text}"
        }else if (binding.box3.text == binding.box5.text &&
            binding.box5.text == binding.box7.text){
            win
            binding.drawTxv.text = " winner is ${binding.box5.text}"
        }else if (binding.box1.text == binding.box5.text &&
            binding.box5.text == binding.box9.text){
            win
            binding.drawTxv.text = " winner is ${binding.box5.text}"
        }
    }
    private fun clickPlayer(box :TextView){
        if (turnX){
            box.text = "X"
            changTurn()
        }else if (turnO){
            box.text = "O"
            changTurn()
        }
    }
}