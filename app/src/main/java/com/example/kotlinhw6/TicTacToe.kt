package com.example.kotlinhw6

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.kotlinhw6.databinding.ActivityTicTacToeBinding
import kotlin.properties.Delegates

class TicTacToe : AppCompatActivity() {
    lateinit var binding: ActivityTicTacToeBinding
    var turnX = false
    var turnO = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTicTacToeBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        turnO = true
        startGame()
        binding.resetBtn.setOnClickListener {
            reset()
            startGame()
        }


    }

    private fun startGame() {


        binding.box1.setOnClickListener {
            clickPlayer(binding.box1)
            checkWinner()
        }
        binding.box2.setOnClickListener {
            clickPlayer(binding.box2)
            checkWinner()
        }
        binding.box3.setOnClickListener {
            clickPlayer(binding.box3)
            checkWinner()
        }
        binding.box4.setOnClickListener {
            clickPlayer(binding.box4)
            checkWinner()
        }
        binding.box5.setOnClickListener {
            clickPlayer(binding.box5)
            checkWinner()
        }
        binding.box6.setOnClickListener {
            clickPlayer(binding.box6)
            checkWinner()
        }
        binding.box7.setOnClickListener {
            clickPlayer(binding.box7)
            checkWinner()
        }
        binding.box8.setOnClickListener {
            clickPlayer(binding.box8)
            checkWinner()
        }
        binding.box9.setOnClickListener {
            clickPlayer(binding.box9)
            checkWinner()
        }


    }

    private fun reset() {
        binding.box1.text = ""
        binding.box2.text = ""
        binding.box3.text = ""
        binding.box4.text = ""
        binding.box5.text = ""
        binding.box6.text = ""
        binding.box7.text = ""
        binding.box8.text = ""
        binding.box9.text = ""


    }

    private fun checkWinner() {
        if (binding.box1.text.isNotBlank() &&
            binding.box2.text.isNotBlank() &&
            binding.box3.text.isNotBlank() &&
            binding.box1.text == binding.box2.text &&
            binding.box1.text == binding.box3.text
        ) {
            enableEmptyBlocksAfterWin()
            binding.drawTxv.text = " winner is ${binding.box1.text}"
        } else if (binding.box4.text.isNotBlank() &&
            binding.box5.text.isNotBlank() &&
            binding.box6.text.isNotBlank() &&
            binding.box4.text == binding.box5.text &&
            binding.box5.text == binding.box6.text
        ) {
            enableEmptyBlocksAfterWin()
            binding.drawTxv.text = " winner is ${binding.box4.text}"
        } else if (binding.box9.text.isNotBlank() &&
            binding.box7.text.isNotBlank() &&
            binding.box8.text.isNotBlank() &&
            binding.box7.text == binding.box8.text &&
            binding.box8.text == binding.box9.text
        ) {
            enableEmptyBlocksAfterWin()
            binding.drawTxv.text = " winner is ${binding.box8.text}"
        } else if (binding.box1.text.isNotBlank() &&
            binding.box4.text.isNotBlank() &&
            binding.box7.text.isNotBlank() &&
            binding.box1.text == binding.box4.text &&
            binding.box1.text == binding.box7.text
        ) {
            enableEmptyBlocksAfterWin()
            binding.drawTxv.text = " winner is ${binding.box4.text}"
        } else if (binding.box2.text.isNotBlank() &&
            binding.box5.text.isNotBlank() &&
            binding.box8.text.isNotBlank() &&
            binding.box2.text == binding.box5.text &&
            binding.box5.text == binding.box8.text
        ) {
            enableEmptyBlocksAfterWin()
            binding.drawTxv.text = " winner is ${binding.box5.text}"
        } else if (binding.box3.text.isNotBlank() &&
            binding.box6.text.isNotBlank() &&
            binding.box9.text.isNotBlank() &&
            binding.box3.text == binding.box6.text &&
            binding.box9.text == binding.box6.text
        ) {
            enableEmptyBlocksAfterWin()
            binding.drawTxv.text = " winner is ${binding.box6.text}"
        } else if (binding.box3.text.isNotBlank() &&
            binding.box5.text.isNotBlank() &&
            binding.box7.text.isNotBlank() &&
            binding.box3.text == binding.box5.text &&
            binding.box5.text == binding.box7.text
        ) {
            enableEmptyBlocksAfterWin()
            binding.drawTxv.text = " winner is ${binding.box5.text}"
        } else if (binding.box1.text.isNotBlank() &&
            binding.box5.text.isNotBlank() &&
            binding.box9.text.isNotBlank() &&
            binding.box1.text == binding.box5.text &&
            binding.box5.text == binding.box9.text
        ) {
            enableEmptyBlocksAfterWin()
            binding.drawTxv.text = " winner is ${binding.box5.text}"
        }
    }

    private fun clickPlayer(box: TextView) {
        if (turnX) {
            box.text = "X"
            box.isCursorVisible = false
            turnX = false
            binding.drawTxv.text = "draw O player"
        } else if (!turnX) {
            box.text = "O"
            box.isClickable = false
            turnX = true
            binding.drawTxv.text = "draw X player"
        }
    }

    fun enableEmptyBlocksAfterWin() {
        binding.box1.isClickable = false
        binding.box2.isClickable = false
        binding.box3.isClickable = false
        binding.box4.isClickable = false
        binding.box5.isClickable = false
        binding.box6.isClickable = false
        binding.box7.isClickable = false
        binding.box8.isClickable = false
        binding.box9.isClickable = false
    }
}