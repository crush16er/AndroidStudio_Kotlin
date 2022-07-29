package com.example.lab2_1_kotlin

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import com.example.lab2_1_kotlin.databinding.ActivityThreeOnThreeBinding
import kotlin.random.Random
import kotlinx.coroutines.*

class ThreeOnThree : AppCompatActivity() {

    private lateinit var binding: ActivityThreeOnThreeBinding
    private var playerTurn = 0;
    private var board = Array(3) {Array(3) {-1} }
    private var rowX = Array(3) {0}
    private var colX = Array(3) {0}
    private var diagX = Array(1) {0}
    private var adiagX = Array(1) {0}
    private var rowY = Array(3) {0}
    private var colY = Array(3) {0}
    private var diagY = Array(1) {0}
    private var adiagY = Array(1) {0}
    private var moves = 0
    private var resultState = "No games played before..."





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityThreeOnThreeBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        turn()
    }



    private fun turn() {
        playerTurn = Random.nextInt(2)

        when (playerTurn) {
            1 -> {
                binding.textView2.setText("X - player's turn")
            }
            else -> {
                binding.textView2.setText("O - player's turn")
            }
        }

    }


    private fun checkXwon(r: Int, c: Int): Boolean {
        rowX[r]++
        colX[c]++
        if (r == c){
            diagX[0]++
        }
        if (r + c == 2){
            adiagX[0]++
        }

        if (rowX[r] == 3)
        {
            if(r == 0)
            {
                binding.button1.setBackgroundColor(Color.parseColor("#33cc33"))
                binding.button2.setBackgroundColor(Color.parseColor("#33cc33"))
                binding.button3.setBackgroundColor(Color.parseColor("#33cc33"))
            }
            else if(r == 1)
            {
                binding.button4.setBackgroundColor(Color.parseColor("#33cc33"))
                binding.button5.setBackgroundColor(Color.parseColor("#33cc33"))
                binding.button6.setBackgroundColor(Color.parseColor("#33cc33"))
            }
            else if(r == 2)
            {
                binding.button7.setBackgroundColor(Color.parseColor("#33cc33"))
                binding.button8.setBackgroundColor(Color.parseColor("#33cc33"))
                binding.button9.setBackgroundColor(Color.parseColor("#33cc33"))
            }

            return true
        }
        else if (colX[c] == 3)
        {
            if(c == 0)
            {
                binding.button1.setBackgroundColor(Color.parseColor("#33cc33"))
                binding.button4.setBackgroundColor(Color.parseColor("#33cc33"))
                binding.button7.setBackgroundColor(Color.parseColor("#33cc33"))
            }
            else if(c == 1)
            {
                binding.button2.setBackgroundColor(Color.parseColor("#33cc33"))
                binding.button5.setBackgroundColor(Color.parseColor("#33cc33"))
                binding.button8.setBackgroundColor(Color.parseColor("#33cc33"))
            }
            else if(c == 2)
            {
                binding.button3.setBackgroundColor(Color.parseColor("#33cc33"))
                binding.button6.setBackgroundColor(Color.parseColor("#33cc33"))
                binding.button9.setBackgroundColor(Color.parseColor("#33cc33"))
            }

            return true
        }
        else if (diagX[0] == 3)
        {
            binding.button1.setBackgroundColor(Color.parseColor("#33cc33"))
            binding.button5.setBackgroundColor(Color.parseColor("#33cc33"))
            binding.button9.setBackgroundColor(Color.parseColor("#33cc33"))

            return true
        }
        else if (adiagX[0] == 3)
        {
            binding.button3.setBackgroundColor(Color.parseColor("#33cc33"))
            binding.button5.setBackgroundColor(Color.parseColor("#33cc33"))
            binding.button7.setBackgroundColor(Color.parseColor("#33cc33"))

            return true
        }
        else
        {
            return false
        }

    }

    private fun checkYwon(r: Int, c: Int): Boolean {
        rowY[r]++
        colY[c]++
        if (r == c){
            diagY[0]++
        }
        if (r + c == 2){
            adiagY[0]++
        }

        if (rowY[r] == 3)
        {
            if(r == 0)
            {
                binding.button1.setBackgroundColor(Color.parseColor("#33cc33"))
                binding.button2.setBackgroundColor(Color.parseColor("#33cc33"))
                binding.button3.setBackgroundColor(Color.parseColor("#33cc33"))
            }
            else if(r == 1)
            {
                binding.button4.setBackgroundColor(Color.parseColor("#33cc33"))
                binding.button5.setBackgroundColor(Color.parseColor("#33cc33"))
                binding.button6.setBackgroundColor(Color.parseColor("#33cc33"))
            }
            else if(r == 2)
            {
                binding.button7.setBackgroundColor(Color.parseColor("#33cc33"))
                binding.button8.setBackgroundColor(Color.parseColor("#33cc33"))
                binding.button9.setBackgroundColor(Color.parseColor("#33cc33"))
            }

            return true
        }
        else if (colY[c] == 3)
        {
            if(c == 0)
            {
                binding.button1.setBackgroundColor(Color.parseColor("#33cc33"))
                binding.button4.setBackgroundColor(Color.parseColor("#33cc33"))
                binding.button7.setBackgroundColor(Color.parseColor("#33cc33"))
            }
            else if(c == 1)
            {
                binding.button2.setBackgroundColor(Color.parseColor("#33cc33"))
                binding.button5.setBackgroundColor(Color.parseColor("#33cc33"))
                binding.button8.setBackgroundColor(Color.parseColor("#33cc33"))
            }
            else if(c == 2)
            {
                binding.button3.setBackgroundColor(Color.parseColor("#33cc33"))
                binding.button6.setBackgroundColor(Color.parseColor("#33cc33"))
                binding.button9.setBackgroundColor(Color.parseColor("#33cc33"))
            }

            return true
        }
        else if (diagY[0] == 3)
        {
            binding.button1.setBackgroundColor(Color.parseColor("#33cc33"))
            binding.button5.setBackgroundColor(Color.parseColor("#33cc33"))
            binding.button9.setBackgroundColor(Color.parseColor("#33cc33"))

            return true
        }
        else if (adiagY[0] == 3)
        {
            binding.button3.setBackgroundColor(Color.parseColor("#33cc33"))
            binding.button5.setBackgroundColor(Color.parseColor("#33cc33"))
            binding.button7.setBackgroundColor(Color.parseColor("#33cc33"))

            return true
        }
        else
        {
            return false
        }

    }

    private fun blockBoard()
    {
        board = Array(3) {Array(3) {-2} }
    }


    fun button1(View: View)
    {
        if(board[0][0] == -1)
        {
            board[0][0] = playerTurn
            moves++

            if(playerTurn == 1)
            {
                binding.button1.setText("X")
                playerTurn = 0
                if(checkXwon(0, 0))
                {
                    blockBoard()
                    binding.textView2.setText("X is a winner!")
                    resultState = "X won the game 3x3!"
                    val game3x3 = Intent()
                    game3x3.putExtra("result", resultState)
                    setResult(RESULT_OK, game3x3)
                }
                else if(moves == 9)
                {
                    binding.textView2.setText("Draw!")
                    resultState = "Draw in the game 3x3!"
                    val game3x3 = Intent()
                    game3x3.putExtra("result", resultState)
                    setResult(RESULT_OK, game3x3)                }
                else
                {
                    binding.textView2.setText("O - player's turn")
                }
            }
            else
            {
                binding.button1.setText("O")
                playerTurn = 1
                if(checkYwon(0, 0))
                {
                    blockBoard()
                    binding.textView2.setText("O is a winner!")
                    resultState = "O won the game 3x3!"
                    val game3x3 = Intent()
                    game3x3.putExtra("result", resultState)
                    setResult(RESULT_OK, game3x3)
                }
                else if(moves == 9)
                {
                    binding.textView2.setText("Draw!")
                    resultState = "Draw in the game 3x3!"
                    val game3x3 = Intent()
                    game3x3.putExtra("result", resultState)
                    setResult(RESULT_OK, game3x3)                }
                else
                {
                    binding.textView2.setText("X - player's turn")
                }
            }

        }
    }



    fun button2(View: View)
    {
        if(board[0][1] == -1)
        {
            board[0][1] = playerTurn
            moves++

            if(playerTurn == 1)
            {
                binding.button2.setText("X")
                playerTurn = 0
                if(checkXwon(0, 1))
                {
                    blockBoard()
                    binding.textView2.setText("X is a winner!")
                    resultState = "X won the game 3x3!"
                    val game3x3 = Intent()
                    game3x3.putExtra("result", resultState)
                    setResult(RESULT_OK, game3x3)
                }
                else if(moves == 9)
                {
                    binding.textView2.setText("Draw!")
                    resultState = "Draw in the game 3x3!"
                    val game3x3 = Intent()
                    game3x3.putExtra("result", resultState)
                    setResult(RESULT_OK, game3x3)                }
                else
                {
                    binding.textView2.setText("O - player's turn")
                }
            }
            else
            {
                binding.button2.setText("O")
                playerTurn = 1
                if(checkYwon(0, 1))
                {
                    blockBoard()
                    binding.textView2.setText("O is a winner!")
                    resultState = "O won the game 3x3!"
                    val game3x3 = Intent()
                    game3x3.putExtra("result", resultState)
                    setResult(RESULT_OK, game3x3)
                }
                else if(moves == 9)
                {
                    binding.textView2.setText("Draw!")
                    resultState = "Draw in the game 3x3!"
                    val game3x3 = Intent()
                    game3x3.putExtra("result", resultState)
                    setResult(RESULT_OK, game3x3)                }
                else
                {
                    binding.textView2.setText("X - player's turn")
                }
            }
        }
    }

    fun button3(View: View)
    {
        if(board[0][2] == -1)
        {
            board[0][2] = playerTurn
            moves++

            if(playerTurn == 1)
            {
                binding.button3.setText("X")
                playerTurn = 0
                if(checkXwon(0, 2))
                {
                    blockBoard()
                    binding.textView2.setText("X is a winner!")
                    resultState = "X won the game 3x3!"
                    val game3x3 = Intent()
                    game3x3.putExtra("result", resultState)
                    setResult(RESULT_OK, game3x3)
                }
                else if(moves == 9)
                {
                    binding.textView2.setText("Draw!")
                    resultState = "Draw in the game 3x3!"
                    val game3x3 = Intent()
                    game3x3.putExtra("result", resultState)
                    setResult(RESULT_OK, game3x3)                }
                else
                {
                    binding.textView2.setText("O - player's turn")
                }
            }
            else
            {
                binding.button3.setText("O")
                playerTurn = 1
                if(checkYwon(0, 2))
                {
                    blockBoard()
                    binding.textView2.setText("O is a winner!")
                    resultState = "O won the game 3x3!"
                    val game3x3 = Intent()
                    game3x3.putExtra("result", resultState)
                    setResult(RESULT_OK, game3x3)
                }
                else if(moves == 9)
                {
                    binding.textView2.setText("Draw!")
                    resultState = "Draw in the game 3x3!"
                    val game3x3 = Intent()
                    game3x3.putExtra("result", resultState)
                    setResult(RESULT_OK, game3x3)                }
                else
                {
                    binding.textView2.setText("X - player's turn")
                }
            }
        }
    }

    fun button4(View: View)
    {
        if(board[1][0] == -1)
        {
            board[1][0] = playerTurn
            moves++

            if(playerTurn == 1)
            {
                binding.button4.setText("X")
                playerTurn = 0
                if(checkXwon(1, 0))
                {
                    blockBoard()
                    binding.textView2.setText("X is a winner!")
                    resultState = "X won the game 3x3!"
                    val game3x3 = Intent()
                    game3x3.putExtra("result", resultState)
                    setResult(RESULT_OK, game3x3)
                }
                else if(moves == 9)
                {
                    binding.textView2.setText("Draw!")
                    resultState = "Draw in the game 3x3!"
                    val game3x3 = Intent()
                    game3x3.putExtra("result", resultState)
                    setResult(RESULT_OK, game3x3)
                }
                else
                {
                    binding.textView2.setText("O is a winner!")
                    resultState = "O won the game 3x3!"
                    val game3x3 = Intent()
                    game3x3.putExtra("result", resultState)
                    setResult(RESULT_OK, game3x3)
                }
            }
            else
            {
                binding.button4.setText("O")
                playerTurn = 1
                if(checkYwon(1, 0))
                {
                    blockBoard()
                    binding.textView2.setText("O is a winner!")
                }
                else if(moves == 9)
                {
                    binding.textView2.setText("Draw!")
                    resultState = "Draw in the game 3x3!"
                    val game3x3 = Intent()
                    game3x3.putExtra("result", resultState)
                    setResult(RESULT_OK, game3x3)
                }
                else
                {
                    binding.textView2.setText("X - player's turn")
                }
            }
        }
    }

    fun button5(View: View)
    {
        var field = 1
        if(board[1][1] == -1)
        {
            board[1][1] = playerTurn
            moves++

            if(playerTurn == 1)
            {
                binding.button5.setText("X")
                playerTurn = 0
                if(checkXwon(1, 1))
                {
                    blockBoard()
                    binding.textView2.setText("X is a winner!")
                    resultState = "X won the game 3x3!"
                    val game3x3 = Intent()
                    game3x3.putExtra("result", resultState)
                    setResult(RESULT_OK, game3x3)
                }
                else if(moves == 9)
                {
                    binding.textView2.setText("Draw!")
                    resultState = "Draw in the game 3x3!"
                    val game3x3 = Intent()
                    game3x3.putExtra("result", resultState)
                    setResult(RESULT_OK, game3x3)
                }
                else
                {
                    binding.textView2.setText("O - player's turn")
                }
            }
            else
            {
                binding.button5.setText("O")
                playerTurn = 1
                if(checkYwon(1, 1))
                {
                    blockBoard()
                    binding.textView2.setText("O is a winner!")
                    resultState = "O won the game 3x3!"
                    val game3x3 = Intent()
                    game3x3.putExtra("result", resultState)
                    setResult(RESULT_OK, game3x3)
                }
                else if(moves == 9)
                {
                    binding.textView2.setText("Draw!")
                    resultState = "Draw in the game 3x3!"
                    val game3x3 = Intent()
                    game3x3.putExtra("result", resultState)
                    setResult(RESULT_OK, game3x3)
                }
                else
                {
                    binding.textView2.setText("X - player's turn")
                }
            }
        }
    }

    fun button6(View: View)
    {
        var field = 1
        if(board[1][2] == -1)
        {
            board[1][2] = playerTurn
            moves++

            if(playerTurn == 1)
            {
                binding.button6.setText("X")
                playerTurn = 0
                if(checkXwon(1, 2))
                {
                    blockBoard()
                    binding.textView2.setText("X is a winner!")
                    resultState = "X won the game 3x3!"
                    val game3x3 = Intent()
                    game3x3.putExtra("result", resultState)
                    setResult(RESULT_OK, game3x3)
                }
                else if(moves == 9)
                {
                    binding.textView2.setText("Draw!")
                    resultState = "Draw in the game 3x3!"
                    val game3x3 = Intent()
                    game3x3.putExtra("result", resultState)
                    setResult(RESULT_OK, game3x3)
                }
                else
                {
                    binding.textView2.setText("O - player's turn")
                }
            }
            else
            {
                binding.button6.setText("O")
                playerTurn = 1
                if(checkYwon(1, 2))
                {
                    blockBoard()
                    binding.textView2.setText("O is a winner!")
                    resultState = "O won the game 3x3!"
                    val game3x3 = Intent()
                    game3x3.putExtra("result", resultState)
                    setResult(RESULT_OK, game3x3)
                }
                else if(moves == 9)
                {
                    binding.textView2.setText("Draw!")
                    resultState = "Draw in the game 3x3!"
                    val game3x3 = Intent()
                    game3x3.putExtra("result", resultState)
                    setResult(RESULT_OK, game3x3)
                }
                else
                {
                    binding.textView2.setText("X - player's turn")
                }
            }
        }
    }

    fun button7(View: View)
    {
        var field = 1
        if(board[2][0] == -1)
        {
            board[2][0] = playerTurn
            moves++

            if(playerTurn == 1)
            {
                binding.button7.setText("X")
                playerTurn = 0
                if(checkXwon(2, 0))
                {
                    blockBoard()
                    binding.textView2.setText("X is a winner!")
                    resultState = "X won the game 3x3!"
                    val game3x3 = Intent()
                    game3x3.putExtra("result", resultState)
                    setResult(RESULT_OK, game3x3)
                }
                else if(moves == 9)
                {
                    binding.textView2.setText("Draw!")
                    resultState = "Draw in the game 3x3!"
                    val game3x3 = Intent()
                    game3x3.putExtra("result", resultState)
                    setResult(RESULT_OK, game3x3)
                }
                else
                {
                    binding.textView2.setText("O - player's turn")
                }
            }
            else
            {
                binding.button7.setText("O")
                playerTurn = 1
                if(checkYwon(2, 0))
                {
                    blockBoard()
                    binding.textView2.setText("O is a winner!")
                    resultState = "O won the game 3x3!"
                    val game3x3 = Intent()
                    game3x3.putExtra("result", resultState)
                    setResult(RESULT_OK, game3x3)
                }
                else if(moves == 9)
                {
                    binding.textView2.setText("Draw!")
                    resultState = "Draw in the game 3x3!"
                    val game3x3 = Intent()
                    game3x3.putExtra("result", resultState)
                    setResult(RESULT_OK, game3x3)
                }
                else
                {
                    binding.textView2.setText("X - player's turn")
                }
            }
        }
    }

    fun button8(View: View)
    {
        var field = 1
        if(board[2][1] == -1)
        {
            board[2][1] = playerTurn
            moves++

            if(playerTurn == 1)
            {
                binding.button8.setText("X")
                playerTurn = 0
                if(checkXwon(2, 1))
                {
                    blockBoard()
                    binding.textView2.setText("X is a winner!")
                    resultState = "X won the game 3x3!"
                    val game3x3 = Intent()
                    game3x3.putExtra("result", resultState)
                    setResult(RESULT_OK, game3x3)
                }
                else if(moves == 9)
                {
                    binding.textView2.setText("Draw!")
                    resultState = "Draw in the game 3x3!"
                    val game3x3 = Intent()
                    game3x3.putExtra("result", resultState)
                    setResult(RESULT_OK, game3x3)
                }
                else
                {
                    binding.textView2.setText("O - player's turn")
                }
            }
            else
            {
                binding.button8.setText("O")
                playerTurn = 1
                if(checkYwon(2,1))
                {
                    blockBoard()
                    binding.textView2.setText("O is a winner!")
                    resultState = "O won the game 3x3!"
                    val game3x3 = Intent()
                    game3x3.putExtra("result", resultState)
                    setResult(RESULT_OK, game3x3)
                }
                else if(moves == 9)
                {
                    binding.textView2.setText("Draw!")
                    resultState = "Draw in the game 3x3!"
                    val game3x3 = Intent()
                    game3x3.putExtra("result", resultState)
                    setResult(RESULT_OK, game3x3)                }
                else
                {
                    binding.textView2.setText("X - player's turn")
                }
            }
        }
    }

    fun button9(View: View)
    {
        var field = 1
        if(board[2][2] == -1)
        {
            board[2][2] = playerTurn
            moves++

            if(playerTurn == 1)
            {
                binding.button9.setText("X")
                playerTurn = 0
                if(checkXwon(2, 2))
                {
                    blockBoard()
                    binding.textView2.setText("X is a winner!")
                    resultState = "X won the game 3x3!"
                    val game3x3 = Intent()
                    game3x3.putExtra("result", resultState)
                    setResult(RESULT_OK, game3x3)
                }
                else if(moves == 9)
                {
                    binding.textView2.setText("Draw!")
                    resultState = "Draw in the game 3x3!"
                    val game3x3 = Intent()
                    game3x3.putExtra("result", resultState)
                    setResult(RESULT_OK, game3x3)
                }
                else
                {
                    binding.textView2.setText("O - player's turn")
                }
            }
            else
            {
                binding.button9.setText("O")
                playerTurn = 1

                if(checkYwon(2, 2))
                {
                    blockBoard()
                    binding.textView2.setText("O is a winner!")
                    resultState = "O won the game 3x3!"
                    val game3x3 = Intent()
                    game3x3.putExtra("result", resultState)
                    setResult(RESULT_OK, game3x3)
                }
                else if(moves == 9)
                {
                    binding.textView2.setText("Draw!")
                    resultState = "Draw in the game 3x3!"
                    val game3x3 = Intent()
                    game3x3.putExtra("result", resultState)
                    setResult(RESULT_OK, game3x3)
                }
                else
                {
                    binding.textView2.setText("X - player's turn")
                }

            }
        }
    }



}
