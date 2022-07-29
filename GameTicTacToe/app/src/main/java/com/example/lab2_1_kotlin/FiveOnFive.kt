package com.example.lab2_1_kotlin

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import com.example.lab2_1_kotlin.databinding.ActivityFiveOnFiveBinding
import com.example.lab2_1_kotlin.databinding.ActivityThreeOnThreeBinding
import kotlin.random.Random
import kotlinx.coroutines.*

class FiveOnFive : AppCompatActivity() {

    private lateinit var binding: ActivityFiveOnFiveBinding
    private var playerTurn = 0
    private var board = Array(5) {Array(5) {-1} }
    private var rowX = Array(5) {0}
    private var colX = Array(5) {0}
    private var diagX = Array(3) {0}
    private var adiagX = Array(3) {0}
    private var rowY = Array(5) {0}
    private var colY = Array(5) {0}
    private var diagY = Array(3) {0}
    private var adiagY = Array(3) {0}
    private var moves = 0
    private var resultState = "No games played before..."




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFiveOnFiveBinding.inflate(layoutInflater)
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

    private fun blockBoard()
    {
        board = Array(5) {Array(5) {-2} }
    }

    private fun checkXwon(r: Int, c: Int): Boolean {
        rowX[r]++
        colX[c]++
        if (r == c)
        {
            diagX[0]++
        }
        else if(c + 1 == r)
        {
            diagX[1]++
        }
        else if(c == r + 1)
        {
            diagX[2]++
        }

        if (r + c == 4)
        {
            adiagX[0]++
        }
        else if(c + r == 3)
        {
            adiagX[1]++
        }
        else if(c + r == 5)
        {
            adiagX[2]++
        }

        if (rowX[r] >= 4)
        {
            if(r == 0)
            {
                if(board[r][0] == 1 && board[r][1] == 1 && board[r][2] == 1 && board[r][3] == 1)
                {
                    binding.button1.setBackgroundColor(Color.parseColor("#33cc33"))
                    binding.button2.setBackgroundColor(Color.parseColor("#33cc33"))
                    binding.button3.setBackgroundColor(Color.parseColor("#33cc33"))
                    binding.button4.setBackgroundColor(Color.parseColor("#33cc33"))

                    return true
                }
                else if(board[r][1] == 1 && board[r][2] == 1 && board[r][3] == 1 && board[r][4] == 1)
                {
                    binding.button5.setBackgroundColor(Color.parseColor("#33cc33"))
                    binding.button2.setBackgroundColor(Color.parseColor("#33cc33"))
                    binding.button3.setBackgroundColor(Color.parseColor("#33cc33"))
                    binding.button4.setBackgroundColor(Color.parseColor("#33cc33"))

                    return true
                }
                else
                {
                    return false
                }
            }
            else if(r == 1)
            {
                if(board[r][0] == 1 && board[r][1] == 1 && board[r][2] == 1 && board[r][3] == 1)
                {
                    binding.button6.setBackgroundColor(Color.parseColor("#33cc33"))
                    binding.button7.setBackgroundColor(Color.parseColor("#33cc33"))
                    binding.button8.setBackgroundColor(Color.parseColor("#33cc33"))
                    binding.button9.setBackgroundColor(Color.parseColor("#33cc33"))

                    return true
                }
                else if(board[r][1] == 1 && board[r][2] == 1 && board[r][3] == 1 && board[r][4] == 1)
                {
                    binding.button7.setBackgroundColor(Color.parseColor("#33cc33"))
                    binding.button8.setBackgroundColor(Color.parseColor("#33cc33"))
                    binding.button9.setBackgroundColor(Color.parseColor("#33cc33"))
                    binding.button10.setBackgroundColor(Color.parseColor("#33cc33"))

                    return true
                }
                else
                {
                    return false
                }
            }
            else if(r == 2)
            {
                if(board[r][0] == 1 && board[r][1] == 1 && board[r][2] == 1 && board[r][3] == 1)
                {
                    binding.button11.setBackgroundColor(Color.parseColor("#33cc33"))
                    binding.button12.setBackgroundColor(Color.parseColor("#33cc33"))
                    binding.button13.setBackgroundColor(Color.parseColor("#33cc33"))
                    binding.button14.setBackgroundColor(Color.parseColor("#33cc33"))

                    return true
                }
                else if(board[r][1] == 1 && board[r][2] == 1 && board[r][3] == 1 && board[r][4] == 1)
                {
                    binding.button15.setBackgroundColor(Color.parseColor("#33cc33"))
                    binding.button12.setBackgroundColor(Color.parseColor("#33cc33"))
                    binding.button13.setBackgroundColor(Color.parseColor("#33cc33"))
                    binding.button14.setBackgroundColor(Color.parseColor("#33cc33"))

                    return true
                }
                else
                {
                    return false
                }
            }
            else if(r == 3)
            {
                if(board[r][0] == 1 && board[r][1] == 1 && board[r][2] == 1 && board[r][3] == 1)
                {
                    binding.button16.setBackgroundColor(Color.parseColor("#33cc33"))
                    binding.button17.setBackgroundColor(Color.parseColor("#33cc33"))
                    binding.button18.setBackgroundColor(Color.parseColor("#33cc33"))
                    binding.button19.setBackgroundColor(Color.parseColor("#33cc33"))

                    return true
                }
                else if(board[r][1] == 1 && board[r][2] == 1 && board[r][3] == 1 && board[r][4] == 1)
                {
                    binding.button17.setBackgroundColor(Color.parseColor("#33cc33"))
                    binding.button18.setBackgroundColor(Color.parseColor("#33cc33"))
                    binding.button19.setBackgroundColor(Color.parseColor("#33cc33"))
                    binding.button20.setBackgroundColor(Color.parseColor("#33cc33"))

                    return true
                }
                else
                {
                    return false
                }
            }
            else if(r == 4)
            {
                if(board[r][0] == 1 && board[r][1] == 1 && board[r][2] == 1 && board[r][3] == 1)
                {
                    binding.button21.setBackgroundColor(Color.parseColor("#33cc33"))
                    binding.button22.setBackgroundColor(Color.parseColor("#33cc33"))
                    binding.button23.setBackgroundColor(Color.parseColor("#33cc33"))
                    binding.button24.setBackgroundColor(Color.parseColor("#33cc33"))

                    return true
                }
                else if(board[r][1] == 1 && board[r][2] == 1 && board[r][3] == 1 && board[r][4] == 1)
                {
                    binding.button25.setBackgroundColor(Color.parseColor("#33cc33"))
                    binding.button22.setBackgroundColor(Color.parseColor("#33cc33"))
                    binding.button23.setBackgroundColor(Color.parseColor("#33cc33"))
                    binding.button24.setBackgroundColor(Color.parseColor("#33cc33"))

                    return true
                }
                else
                {
                    return false
                }
            }
        }
        else if (colX[c] >= 4)
        {
            if(c == 0)
            {
                if(board[0][c] == 1 && board[1][c] == 1 && board[2][c] == 1 && board[3][c] == 1)
                {
                    binding.button1.setBackgroundColor(Color.parseColor("#33cc33"))
                    binding.button6.setBackgroundColor(Color.parseColor("#33cc33"))
                    binding.button11.setBackgroundColor(Color.parseColor("#33cc33"))
                    binding.button16.setBackgroundColor(Color.parseColor("#33cc33"))

                    return true
                }
                else if(board[4][c] == 1 && board[1][c] == 1 && board[2][c] == 1 && board[3][c] == 1)
                {
                    binding.button21.setBackgroundColor(Color.parseColor("#33cc33"))
                    binding.button6.setBackgroundColor(Color.parseColor("#33cc33"))
                    binding.button11.setBackgroundColor(Color.parseColor("#33cc33"))
                    binding.button16.setBackgroundColor(Color.parseColor("#33cc33"))

                    return true
                }
                else
                {
                    return false
                }
            }
            else if(c == 1)
            {
                if(board[0][c] == 1 && board[1][c] == 1 && board[2][c] == 1 && board[3][c] == 1)
                {
                    binding.button2.setBackgroundColor(Color.parseColor("#33cc33"))
                    binding.button7.setBackgroundColor(Color.parseColor("#33cc33"))
                    binding.button12.setBackgroundColor(Color.parseColor("#33cc33"))
                    binding.button17.setBackgroundColor(Color.parseColor("#33cc33"))

                    return true
                }
                else if(board[4][c] == 1 && board[1][c] == 1 && board[2][c] == 1 && board[3][c] == 1)
                {
                    binding.button22.setBackgroundColor(Color.parseColor("#33cc33"))
                    binding.button7.setBackgroundColor(Color.parseColor("#33cc33"))
                    binding.button12.setBackgroundColor(Color.parseColor("#33cc33"))
                    binding.button17.setBackgroundColor(Color.parseColor("#33cc33"))

                    return true
                }
                else
                {
                    return false
                }
            }
            else if(c == 2)
            {
                if(board[0][c] == 1 && board[1][c] == 1 && board[2][c] == 1 && board[3][c] == 1)
                {
                    binding.button3.setBackgroundColor(Color.parseColor("#33cc33"))
                    binding.button8.setBackgroundColor(Color.parseColor("#33cc33"))
                    binding.button13.setBackgroundColor(Color.parseColor("#33cc33"))
                    binding.button18.setBackgroundColor(Color.parseColor("#33cc33"))

                    return true
                }
                else if(board[4][c] == 1 && board[1][c] == 1 && board[2][c] == 1 && board[3][c] == 1)
                {
                    binding.button23.setBackgroundColor(Color.parseColor("#33cc33"))
                    binding.button8.setBackgroundColor(Color.parseColor("#33cc33"))
                    binding.button13.setBackgroundColor(Color.parseColor("#33cc33"))
                    binding.button18.setBackgroundColor(Color.parseColor("#33cc33"))

                    return true
                }
                else
                {
                    return false
                }
            }
            else if(c == 3)
            {
                if(board[0][c] == 1 && board[1][c] == 1 && board[2][c] == 1 && board[3][c] == 1)
                {
                    binding.button4.setBackgroundColor(Color.parseColor("#33cc33"))
                    binding.button9.setBackgroundColor(Color.parseColor("#33cc33"))
                    binding.button14.setBackgroundColor(Color.parseColor("#33cc33"))
                    binding.button19.setBackgroundColor(Color.parseColor("#33cc33"))

                    return true
                }
                else if(board[4][c] == 1 && board[1][c] == 1 && board[2][c] == 1 && board[3][c] == 1)
                {
                    binding.button24.setBackgroundColor(Color.parseColor("#33cc33"))
                    binding.button9.setBackgroundColor(Color.parseColor("#33cc33"))
                    binding.button14.setBackgroundColor(Color.parseColor("#33cc33"))
                    binding.button19.setBackgroundColor(Color.parseColor("#33cc33"))

                    return true
                }
                else
                {
                    return false
                }
            }
            else if(c == 4)
            {
                if(board[0][c] == 1 && board[1][c] == 1 && board[2][c] == 1 && board[3][c] == 1)
                {
                    binding.button5.setBackgroundColor(Color.parseColor("#33cc33"))
                    binding.button10.setBackgroundColor(Color.parseColor("#33cc33"))
                    binding.button15.setBackgroundColor(Color.parseColor("#33cc33"))
                    binding.button20.setBackgroundColor(Color.parseColor("#33cc33"))

                    return true
                }
                else if(board[4][c] == 1 && board[1][c] == 1 && board[2][c] == 1 && board[3][c] == 1)
                {
                    binding.button25.setBackgroundColor(Color.parseColor("#33cc33"))
                    binding.button10.setBackgroundColor(Color.parseColor("#33cc33"))
                    binding.button15.setBackgroundColor(Color.parseColor("#33cc33"))
                    binding.button20.setBackgroundColor(Color.parseColor("#33cc33"))

                    return true
                }
                else
                {
                    return false
                }
            }
        }

        if (diagX[0] >= 4)
        {
            if(board[0][0] == 1 && board[1][1] == 1 && board[2][2] == 1 && board[3][3] == 1)
            {
                binding.button1.setBackgroundColor(Color.parseColor("#33cc33"))
                binding.button7.setBackgroundColor(Color.parseColor("#33cc33"))
                binding.button13.setBackgroundColor(Color.parseColor("#33cc33"))
                binding.button19.setBackgroundColor(Color.parseColor("#33cc33"))

                return true
            }
            else if(board[4][4] == 1 && board[1][1] == 1 && board[2][2] == 1 && board[3][3] == 1)
            {
                binding.button25.setBackgroundColor(Color.parseColor("#33cc33"))
                binding.button7.setBackgroundColor(Color.parseColor("#33cc33"))
                binding.button13.setBackgroundColor(Color.parseColor("#33cc33"))
                binding.button19.setBackgroundColor(Color.parseColor("#33cc33"))

                return true
            }
            else
            {
                return false
            }
        }
        if (diagX[1] == 4)
        {
            if(board[1][0] == 1 && board[2][1] == 1 && board[3][2] == 1 && board[4][3] == 1)
            {
                binding.button6.setBackgroundColor(Color.parseColor("#33cc33"))
                binding.button12.setBackgroundColor(Color.parseColor("#33cc33"))
                binding.button18.setBackgroundColor(Color.parseColor("#33cc33"))
                binding.button24.setBackgroundColor(Color.parseColor("#33cc33"))

                return true
            }
            else
            {
                return false
            }
        }
        if (diagX[2] == 4)
        {
            if(board[0][1] == 1 && board[1][2] == 1 && board[2][3] == 1 && board[3][4] == 1)
            {
                binding.button2.setBackgroundColor(Color.parseColor("#33cc33"))
                binding.button8.setBackgroundColor(Color.parseColor("#33cc33"))
                binding.button14.setBackgroundColor(Color.parseColor("#33cc33"))
                binding.button20.setBackgroundColor(Color.parseColor("#33cc33"))

                return true
            }
            else
            {
                return false
            }
        }


        if (adiagX[0] >= 4)
        {
            if(board[0][4] == 1 && board[1][3] == 1 && board[2][2] == 1 && board[3][1] == 1)
            {
                binding.button5.setBackgroundColor(Color.parseColor("#33cc33"))
                binding.button9.setBackgroundColor(Color.parseColor("#33cc33"))
                binding.button13.setBackgroundColor(Color.parseColor("#33cc33"))
                binding.button17.setBackgroundColor(Color.parseColor("#33cc33"))

                return true
            }
            else if(board[4][0] == 1 && board[1][3] == 1 && board[2][2] == 1 && board[3][1] == 1)
            {
                binding.button21.setBackgroundColor(Color.parseColor("#33cc33"))
                binding.button9.setBackgroundColor(Color.parseColor("#33cc33"))
                binding.button13.setBackgroundColor(Color.parseColor("#33cc33"))
                binding.button17.setBackgroundColor(Color.parseColor("#33cc33"))

                return true
            }
            else
            {
                return false
            }
        }
        if (adiagX[1] == 4)
        {
            if(board[0][3] == 1 && board[1][2] == 1 && board[2][1] == 1 && board[3][0] == 1)
            {
                binding.button4.setBackgroundColor(Color.parseColor("#33cc33"))
                binding.button8.setBackgroundColor(Color.parseColor("#33cc33"))
                binding.button12.setBackgroundColor(Color.parseColor("#33cc33"))
                binding.button16.setBackgroundColor(Color.parseColor("#33cc33"))

                return true
            }
            else
            {
                return false
            }
        }
        if (adiagX[2] == 4)
        {
            if(board[1][4] == 1 && board[2][3] == 1 && board[3][2] == 1 && board[4][1] == 1)
            {
                binding.button10.setBackgroundColor(Color.parseColor("#33cc33"))
                binding.button14.setBackgroundColor(Color.parseColor("#33cc33"))
                binding.button18.setBackgroundColor(Color.parseColor("#33cc33"))
                binding.button22.setBackgroundColor(Color.parseColor("#33cc33"))

                return true
            }
            else
            {
                return false
            }
        }

        return false
    }

    private fun checkYwon(r: Int, c: Int): Boolean {
        rowY[r]++
        colY[c]++
        if (r == c)
        {
            diagY[0]++
        }
        else if(c + 1 == r)
        {
            diagY[1]++
        }
        else if(c == r + 1)
        {
            diagY[2]++
        }

        if (r + c == 4)
        {
            adiagY[0]++
        }
        else if(c + r == 3)
        {
            adiagY[1]++
        }
        else if(c + r == 5)
        {
            adiagY[2]++
        }

        if (rowY[r] >= 4)
        {
            if(r == 0)
            {
                if(board[r][0] == 0 && board[r][1] == 0 && board[r][2] == 0 && board[r][3] == 0)
                {
                    binding.button1.setBackgroundColor(Color.parseColor("#33cc33"))
                    binding.button2.setBackgroundColor(Color.parseColor("#33cc33"))
                    binding.button3.setBackgroundColor(Color.parseColor("#33cc33"))
                    binding.button4.setBackgroundColor(Color.parseColor("#33cc33"))

                    return true
                }
                else if(board[r][1] == 0 && board[r][2] == 0 && board[r][3] == 0 && board[r][4] == 0)
                {
                    binding.button5.setBackgroundColor(Color.parseColor("#33cc33"))
                    binding.button2.setBackgroundColor(Color.parseColor("#33cc33"))
                    binding.button3.setBackgroundColor(Color.parseColor("#33cc33"))
                    binding.button4.setBackgroundColor(Color.parseColor("#33cc33"))

                    return true
                }
                else
                {
                    return false
                }
            }
            else if(r == 1)
            {
                if(board[r][0] == 0 && board[r][1] == 0 && board[r][2] == 0 && board[r][3] == 0)
                {
                    binding.button6.setBackgroundColor(Color.parseColor("#33cc33"))
                    binding.button7.setBackgroundColor(Color.parseColor("#33cc33"))
                    binding.button8.setBackgroundColor(Color.parseColor("#33cc33"))
                    binding.button9.setBackgroundColor(Color.parseColor("#33cc33"))

                    return true
                }
                else if(board[r][1] == 0 && board[r][2] == 0 && board[r][3] == 0 && board[r][4] == 0)
                {
                    binding.button7.setBackgroundColor(Color.parseColor("#33cc33"))
                    binding.button8.setBackgroundColor(Color.parseColor("#33cc33"))
                    binding.button9.setBackgroundColor(Color.parseColor("#33cc33"))
                    binding.button10.setBackgroundColor(Color.parseColor("#33cc33"))

                    return true
                }
                else
                {
                    return false
                }
            }
            else if(r == 2)
            {
                if(board[r][0] == 0 && board[r][1] == 0 && board[r][2] == 0 && board[r][3] == 0)
                {
                    binding.button11.setBackgroundColor(Color.parseColor("#33cc33"))
                    binding.button12.setBackgroundColor(Color.parseColor("#33cc33"))
                    binding.button13.setBackgroundColor(Color.parseColor("#33cc33"))
                    binding.button14.setBackgroundColor(Color.parseColor("#33cc33"))

                    return true
                }
                else if(board[r][1] == 0 && board[r][2] == 0 && board[r][3] == 0 && board[r][4] == 0)
                {
                    binding.button15.setBackgroundColor(Color.parseColor("#33cc33"))
                    binding.button12.setBackgroundColor(Color.parseColor("#33cc33"))
                    binding.button13.setBackgroundColor(Color.parseColor("#33cc33"))
                    binding.button14.setBackgroundColor(Color.parseColor("#33cc33"))

                    return true
                }
                else
                {
                    return false
                }
            }
            else if(r == 3)
            {
                if(board[r][0] == 0 && board[r][1] == 0 && board[r][2] == 0 && board[r][3] == 0)
                {
                    binding.button16.setBackgroundColor(Color.parseColor("#33cc33"))
                    binding.button17.setBackgroundColor(Color.parseColor("#33cc33"))
                    binding.button18.setBackgroundColor(Color.parseColor("#33cc33"))
                    binding.button19.setBackgroundColor(Color.parseColor("#33cc33"))

                    return true
                }
                else if(board[r][1] == 0 && board[r][2] == 0 && board[r][3] == 0 && board[r][4] == 0)
                {
                    binding.button17.setBackgroundColor(Color.parseColor("#33cc33"))
                    binding.button18.setBackgroundColor(Color.parseColor("#33cc33"))
                    binding.button19.setBackgroundColor(Color.parseColor("#33cc33"))
                    binding.button20.setBackgroundColor(Color.parseColor("#33cc33"))

                    return true
                }
                else
                {
                    return false
                }
            }
            else if(r == 4)
            {
                if(board[r][0] == 0 && board[r][1] == 0 && board[r][2] == 0 && board[r][3] == 0)
                {
                    binding.button21.setBackgroundColor(Color.parseColor("#33cc33"))
                    binding.button22.setBackgroundColor(Color.parseColor("#33cc33"))
                    binding.button23.setBackgroundColor(Color.parseColor("#33cc33"))
                    binding.button24.setBackgroundColor(Color.parseColor("#33cc33"))

                    return true
                }
                else if(board[r][1] == 0 && board[r][2] == 0 && board[r][3] == 0 && board[r][4] == 0)
                {
                    binding.button25.setBackgroundColor(Color.parseColor("#33cc33"))
                    binding.button22.setBackgroundColor(Color.parseColor("#33cc33"))
                    binding.button23.setBackgroundColor(Color.parseColor("#33cc33"))
                    binding.button24.setBackgroundColor(Color.parseColor("#33cc33"))

                    return true
                }
                else
                {
                    return false
                }
            }
        }
        else if (colY[c] >= 4)
        {
            if(c == 0)
            {
                if(board[0][c] == 0 && board[1][c] == 0 && board[2][c] == 0 && board[3][c] == 0)
                {
                    binding.button1.setBackgroundColor(Color.parseColor("#33cc33"))
                    binding.button6.setBackgroundColor(Color.parseColor("#33cc33"))
                    binding.button11.setBackgroundColor(Color.parseColor("#33cc33"))
                    binding.button16.setBackgroundColor(Color.parseColor("#33cc33"))

                    return true
                }
                else if(board[4][c] == 0 && board[1][c] == 0 && board[2][c] == 0 && board[3][c] == 0)
                {
                    binding.button21.setBackgroundColor(Color.parseColor("#33cc33"))
                    binding.button6.setBackgroundColor(Color.parseColor("#33cc33"))
                    binding.button11.setBackgroundColor(Color.parseColor("#33cc33"))
                    binding.button16.setBackgroundColor(Color.parseColor("#33cc33"))

                    return true
                }
                else
                {
                    return false
                }
            }
            else if(c == 1)
            {
                if(board[0][c] == 0 && board[1][c] == 0 && board[2][c] == 0 && board[3][c] == 0)
                {
                    binding.button2.setBackgroundColor(Color.parseColor("#33cc33"))
                    binding.button7.setBackgroundColor(Color.parseColor("#33cc33"))
                    binding.button12.setBackgroundColor(Color.parseColor("#33cc33"))
                    binding.button17.setBackgroundColor(Color.parseColor("#33cc33"))

                    return true
                }
                else if(board[4][c] == 0 && board[1][c] == 0 && board[2][c] == 0 && board[3][c] == 0)
                {
                    binding.button22.setBackgroundColor(Color.parseColor("#33cc33"))
                    binding.button7.setBackgroundColor(Color.parseColor("#33cc33"))
                    binding.button12.setBackgroundColor(Color.parseColor("#33cc33"))
                    binding.button17.setBackgroundColor(Color.parseColor("#33cc33"))

                    return true
                }
                else
                {
                    return false
                }
            }
            else if(c == 2)
            {
                if(board[0][c] == 0 && board[1][c] == 0 && board[2][c] == 0 && board[3][c] == 0)
                {
                    binding.button3.setBackgroundColor(Color.parseColor("#33cc33"))
                    binding.button8.setBackgroundColor(Color.parseColor("#33cc33"))
                    binding.button13.setBackgroundColor(Color.parseColor("#33cc33"))
                    binding.button18.setBackgroundColor(Color.parseColor("#33cc33"))

                    return true
                }
                else if(board[4][c] == 0 && board[1][c] == 0 && board[2][c] == 0 && board[3][c] == 0)
                {
                    binding.button23.setBackgroundColor(Color.parseColor("#33cc33"))
                    binding.button8.setBackgroundColor(Color.parseColor("#33cc33"))
                    binding.button13.setBackgroundColor(Color.parseColor("#33cc33"))
                    binding.button18.setBackgroundColor(Color.parseColor("#33cc33"))

                    return true
                }
                else
                {
                    return false
                }
            }
            else if(c == 3)
            {
                if(board[0][c] == 0 && board[1][c] == 0 && board[2][c] == 0 && board[3][c] == 0)
                {
                    binding.button4.setBackgroundColor(Color.parseColor("#33cc33"))
                    binding.button9.setBackgroundColor(Color.parseColor("#33cc33"))
                    binding.button14.setBackgroundColor(Color.parseColor("#33cc33"))
                    binding.button19.setBackgroundColor(Color.parseColor("#33cc33"))

                    return true
                }
                else if(board[4][c] == 0 && board[1][c] == 0 && board[2][c] == 0 && board[3][c] == 0)
                {
                    binding.button24.setBackgroundColor(Color.parseColor("#33cc33"))
                    binding.button9.setBackgroundColor(Color.parseColor("#33cc33"))
                    binding.button14.setBackgroundColor(Color.parseColor("#33cc33"))
                    binding.button19.setBackgroundColor(Color.parseColor("#33cc33"))

                    return true
                }
                else
                {
                    return false
                }
            }
            else if(c == 4)
            {
                if(board[0][c] == 0 && board[1][c] == 0 && board[2][c] == 0 && board[3][c] == 0)
                {
                    binding.button5.setBackgroundColor(Color.parseColor("#33cc33"))
                    binding.button10.setBackgroundColor(Color.parseColor("#33cc33"))
                    binding.button15.setBackgroundColor(Color.parseColor("#33cc33"))
                    binding.button20.setBackgroundColor(Color.parseColor("#33cc33"))

                    return true
                }
                else if(board[4][c] == 0 && board[1][c] == 0 && board[2][c] == 0 && board[3][c] == 0)
                {
                    binding.button25.setBackgroundColor(Color.parseColor("#33cc33"))
                    binding.button10.setBackgroundColor(Color.parseColor("#33cc33"))
                    binding.button15.setBackgroundColor(Color.parseColor("#33cc33"))
                    binding.button20.setBackgroundColor(Color.parseColor("#33cc33"))

                    return true
                }
                else
                {
                    return false
                }
            }
        }

        if (diagY[0] >= 4)
        {
            if(board[0][0] == 0 && board[1][1] == 0 && board[2][2] == 0 && board[3][3] == 0)
            {
                binding.button1.setBackgroundColor(Color.parseColor("#33cc33"))
                binding.button7.setBackgroundColor(Color.parseColor("#33cc33"))
                binding.button13.setBackgroundColor(Color.parseColor("#33cc33"))
                binding.button19.setBackgroundColor(Color.parseColor("#33cc33"))

                return true
            }
            else if(board[4][4] == 0 && board[1][1] == 0 && board[2][2] == 0 && board[3][3] == 0)
            {
                binding.button25.setBackgroundColor(Color.parseColor("#33cc33"))
                binding.button7.setBackgroundColor(Color.parseColor("#33cc33"))
                binding.button13.setBackgroundColor(Color.parseColor("#33cc33"))
                binding.button19.setBackgroundColor(Color.parseColor("#33cc33"))

                return true
            }
            else
            {
                return false
            }
        }
        if (diagY[1] == 4)
        {
            if(board[1][0] == 0 && board[2][1] == 0 && board[3][2] == 0 && board[4][3] == 0)
            {
                binding.button6.setBackgroundColor(Color.parseColor("#33cc33"))
                binding.button12.setBackgroundColor(Color.parseColor("#33cc33"))
                binding.button18.setBackgroundColor(Color.parseColor("#33cc33"))
                binding.button24.setBackgroundColor(Color.parseColor("#33cc33"))

                return true
            }
            else
            {
                return false
            }
        }
        if (diagY[2] == 4)
        {
            if(board[0][1] == 0 && board[1][2] == 0 && board[2][3] == 0 && board[3][4] == 0)
            {
                binding.button2.setBackgroundColor(Color.parseColor("#33cc33"))
                binding.button8.setBackgroundColor(Color.parseColor("#33cc33"))
                binding.button14.setBackgroundColor(Color.parseColor("#33cc33"))
                binding.button20.setBackgroundColor(Color.parseColor("#33cc33"))

                return true
            }
            else
            {
                return false
            }
        }


        if (adiagY[0] >= 4)
        {
            if(board[0][4] == 0 && board[1][3] == 0 && board[2][2] == 0 && board[3][1] == 0)
            {
                binding.button5.setBackgroundColor(Color.parseColor("#33cc33"))
                binding.button9.setBackgroundColor(Color.parseColor("#33cc33"))
                binding.button13.setBackgroundColor(Color.parseColor("#33cc33"))
                binding.button17.setBackgroundColor(Color.parseColor("#33cc33"))

                return true
            }
            else if(board[4][0] == 0 && board[1][3] == 0 && board[2][2] == 0 && board[3][1] == 0)
            {
                binding.button21.setBackgroundColor(Color.parseColor("#33cc33"))
                binding.button9.setBackgroundColor(Color.parseColor("#33cc33"))
                binding.button13.setBackgroundColor(Color.parseColor("#33cc33"))
                binding.button17.setBackgroundColor(Color.parseColor("#33cc33"))

                return true
            }
            else
            {
                return false
            }
        }
        if (adiagY[1] == 4)
        {
            if(board[0][3] == 0 && board[1][2] == 0 && board[2][1] == 0 && board[3][0] == 0)
            {
                binding.button4.setBackgroundColor(Color.parseColor("#33cc33"))
                binding.button8.setBackgroundColor(Color.parseColor("#33cc33"))
                binding.button12.setBackgroundColor(Color.parseColor("#33cc33"))
                binding.button16.setBackgroundColor(Color.parseColor("#33cc33"))

                return true
            }
            else
            {
                return false
            }
        }
        if (adiagY[2] == 4)
        {
            if(board[1][4] == 0 && board[2][3] == 0 && board[3][2] == 0 && board[4][1] == 0)
            {
                binding.button10.setBackgroundColor(Color.parseColor("#33cc33"))
                binding.button14.setBackgroundColor(Color.parseColor("#33cc33"))
                binding.button18.setBackgroundColor(Color.parseColor("#33cc33"))
                binding.button22.setBackgroundColor(Color.parseColor("#33cc33"))

                return true
            }
            else
            {
                return false
            }
        }

        return false
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
                    resultState = "X won the game 5x5!"
                    val game5x5 = Intent()
                    game5x5.putExtra("result", resultState)
                    setResult(RESULT_OK, game5x5)
                }
                else if(moves == 25)
                {
                    binding.textView2.setText("Draw!")
                    resultState = "Draw in the game 5x5!"
                    val game5x5 = Intent()
                    game5x5.putExtra("result", resultState)
                    setResult(RESULT_OK, game5x5)
                }
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
                    resultState = "O won the game 5x5!"
                    val game5x5 = Intent()
                    game5x5.putExtra("result", resultState)
                    setResult(RESULT_OK, game5x5)
                }
                else if(moves == 25)
                {
                    binding.textView2.setText("Draw!")
                    resultState = "Draw in the game 5x5!"
                    val game5x5 = Intent()
                    game5x5.putExtra("result", resultState)
                    setResult(RESULT_OK, game5x5)
                }
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
                    resultState = "X won the game 5x5!"
                    val game5x5 = Intent()
                    game5x5.putExtra("result", resultState)
                    setResult(RESULT_OK, game5x5)
                }
                else if(moves == 25)
                {
                    binding.textView2.setText("Draw!")
                    resultState = "Draw in the game 5x5!"
                    val game5x5 = Intent()
                    game5x5.putExtra("result", resultState)
                    setResult(RESULT_OK, game5x5)
                }
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
                    resultState = "O won the game 5x5!"
                    val game5x5 = Intent()
                    game5x5.putExtra("result", resultState)
                    setResult(RESULT_OK, game5x5)
                }
                else if(moves == 25)
                {
                    binding.textView2.setText("Draw!")
                    resultState = "Draw in the game 5x5!"
                    val game5x5 = Intent()
                    game5x5.putExtra("result", resultState)
                    setResult(RESULT_OK, game5x5)
                }
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
                    resultState = "X won the game 5x5!"
                    val game5x5 = Intent()
                    game5x5.putExtra("result", resultState)
                    setResult(RESULT_OK, game5x5)
                }
                else if(moves == 25)
                {
                    binding.textView2.setText("Draw!")
                    resultState = "Draw in the game 5x5!"
                    val game5x5 = Intent()
                    game5x5.putExtra("result", resultState)
                    setResult(RESULT_OK, game5x5)
                }
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
                    resultState = "O won the game 5x5!"
                    val game5x5 = Intent()
                    game5x5.putExtra("result", resultState)
                    setResult(RESULT_OK, game5x5)
                }
                else if(moves == 25)
                {
                    binding.textView2.setText("Draw!")
                    resultState = "Draw in the game 5x5!"
                    val game5x5 = Intent()
                    game5x5.putExtra("result", resultState)
                    setResult(RESULT_OK, game5x5)
                }
                else
                {
                    binding.textView2.setText("X - player's turn")
                }
            }

        }
    }

    fun button4(View: View)
    {
        if(board[0][3] == -1)
        {
            board[0][3] = playerTurn
            moves++

            if(playerTurn == 1)
            {
                binding.button4.setText("X")
                playerTurn = 0
                if(checkXwon(0, 3))
                {
                    blockBoard()
                    binding.textView2.setText("X is a winner!")
                    resultState = "X won the game 5x5!"
                    val game5x5 = Intent()
                    game5x5.putExtra("result", resultState)
                    setResult(RESULT_OK, game5x5)
                }
                else if(moves == 25)
                {
                    binding.textView2.setText("Draw!")
                    resultState = "Draw in the game 5x5!"
                    val game5x5 = Intent()
                    game5x5.putExtra("result", resultState)
                    setResult(RESULT_OK, game5x5)
                }
                else
                {
                    binding.textView2.setText("O - player's turn")
                }
            }
            else
            {
                binding.button4.setText("O")
                playerTurn = 1
                if(checkYwon(0, 3))
                {
                    blockBoard()
                    binding.textView2.setText("O is a winner!")
                    resultState = "O won the game 5x5!"
                    val game5x5 = Intent()
                    game5x5.putExtra("result", resultState)
                    setResult(RESULT_OK, game5x5)
                }
                else if(moves == 25)
                {
                    binding.textView2.setText("Draw!")
                    resultState = "Draw in the game 5x5!"
                    val game5x5 = Intent()
                    game5x5.putExtra("result", resultState)
                    setResult(RESULT_OK, game5x5)
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
        if(board[0][4] == -1)
        {
            board[0][4] = playerTurn
            moves++

            if(playerTurn == 1)
            {
                binding.button5.setText("X")
                playerTurn = 0
                if(checkXwon(0, 4))
                {
                    blockBoard()
                    binding.textView2.setText("X is a winner!")
                    resultState = "X won the game 5x5!"
                    val game5x5 = Intent()
                    game5x5.putExtra("result", resultState)
                    setResult(RESULT_OK, game5x5)
                }
                else if(moves == 25)
                {
                    binding.textView2.setText("Draw!")
                    resultState = "Draw in the game 5x5!"
                    val game5x5 = Intent()
                    game5x5.putExtra("result", resultState)
                    setResult(RESULT_OK, game5x5)
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
                if(checkYwon(0, 4))
                {
                    blockBoard()
                    binding.textView2.setText("O is a winner!")
                    resultState = "O won the game 5x5!"
                    val game5x5 = Intent()
                    game5x5.putExtra("result", resultState)
                    setResult(RESULT_OK, game5x5)
                }
                else if(moves == 25)
                {
                    binding.textView2.setText("Draw!")
                    resultState = "Draw in the game 5x5!"
                    val game5x5 = Intent()
                    game5x5.putExtra("result", resultState)
                    setResult(RESULT_OK, game5x5)
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
        if(board[1][0] == -1)
        {
            board[1][0] = playerTurn
            moves++

            if(playerTurn == 1)
            {
                binding.button6.setText("X")
                playerTurn = 0
                if(checkXwon(1, 0))
                {
                    blockBoard()
                    binding.textView2.setText("X is a winner!")
                    resultState = "X won the game 5x5!"
                    val game5x5 = Intent()
                    game5x5.putExtra("result", resultState)
                    setResult(RESULT_OK, game5x5)
                }
                else if(moves == 25)
                {
                    binding.textView2.setText("Draw!")
                    resultState = "Draw in the game 5x5!"
                    val game5x5 = Intent()
                    game5x5.putExtra("result", resultState)
                    setResult(RESULT_OK, game5x5)
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
                if(checkYwon(1, 0))
                {
                    blockBoard()
                    binding.textView2.setText("O is a winner!")
                    resultState = "O won the game 5x5!"
                    val game5x5 = Intent()
                    game5x5.putExtra("result", resultState)
                    setResult(RESULT_OK, game5x5)
                }
                else if(moves == 25)
                {
                    binding.textView2.setText("Draw!")
                    resultState = "Draw in the game 5x5!"
                    val game5x5 = Intent()
                    game5x5.putExtra("result", resultState)
                    setResult(RESULT_OK, game5x5)
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
        if(board[1][1] == -1)
        {
            board[1][1] = playerTurn
            moves++

            if(playerTurn == 1)
            {
                binding.button7.setText("X")
                playerTurn = 0
                if(checkXwon(1, 1))
                {
                    blockBoard()
                    binding.textView2.setText("X is a winner!")
                    resultState = "X won the game 5x5!"
                    val game5x5 = Intent()
                    game5x5.putExtra("result", resultState)
                    setResult(RESULT_OK, game5x5)
                }
                else if(moves == 25)
                {
                    binding.textView2.setText("Draw!")
                    resultState = "Draw in the game 5x5!"
                    val game5x5 = Intent()
                    game5x5.putExtra("result", resultState)
                    setResult(RESULT_OK, game5x5)
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
                if(checkYwon(1, 1))
                {
                    blockBoard()
                    binding.textView2.setText("O is a winner!")
                    resultState = "O won the game 5x5!"
                    val game5x5 = Intent()
                    game5x5.putExtra("result", resultState)
                    setResult(RESULT_OK, game5x5)
                }
                else if(moves == 25)
                {
                    binding.textView2.setText("Draw!")
                    resultState = "Draw in the game 5x5!"
                    val game5x5 = Intent()
                    game5x5.putExtra("result", resultState)
                    setResult(RESULT_OK, game5x5)
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
        if(board[1][2] == -1)
        {
            board[1][2] = playerTurn
            moves++

            if(playerTurn == 1)
            {
                binding.button8.setText("X")
                playerTurn = 0
                if(checkXwon(1, 2))
                {
                    blockBoard()
                    binding.textView2.setText("X is a winner!")
                    resultState = "X won the game 5x5!"
                    val game5x5 = Intent()
                    game5x5.putExtra("result", resultState)
                    setResult(RESULT_OK, game5x5)
                }
                else if(moves == 25)
                {
                    binding.textView2.setText("Draw!")
                    resultState = "Draw in the game 5x5!"
                    val game5x5 = Intent()
                    game5x5.putExtra("result", resultState)
                    setResult(RESULT_OK, game5x5)
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
                if(checkYwon(1, 2))
                {
                    blockBoard()
                    binding.textView2.setText("O is a winner!")
                    resultState = "O won the game 5x5!"
                    val game5x5 = Intent()
                    game5x5.putExtra("result", resultState)
                    setResult(RESULT_OK, game5x5)
                }
                else if(moves == 25)
                {
                    binding.textView2.setText("Draw!")
                    resultState = "Draw in the game 5x5!"
                    val game5x5 = Intent()
                    game5x5.putExtra("result", resultState)
                    setResult(RESULT_OK, game5x5)
                }
                else
                {
                    binding.textView2.setText("X - player's turn")
                }
            }

        }
    }

    fun button9(View: View)
    {
        if(board[1][3] == -1)
        {
            board[1][3] = playerTurn
            moves++

            if(playerTurn == 1)
            {
                binding.button9.setText("X")
                playerTurn = 0
                if(checkXwon(1, 3))
                {
                    blockBoard()
                    binding.textView2.setText("X is a winner!")
                    resultState = "X won the game 5x5!"
                    val game5x5 = Intent()
                    game5x5.putExtra("result", resultState)
                    setResult(RESULT_OK, game5x5)
                }
                else if(moves == 25)
                {
                    binding.textView2.setText("Draw!")
                    resultState = "Draw in the game 5x5!"
                    val game5x5 = Intent()
                    game5x5.putExtra("result", resultState)
                    setResult(RESULT_OK, game5x5)
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
                if(checkYwon(1, 3))
                {
                    blockBoard()
                    binding.textView2.setText("O is a winner!")
                    resultState = "O won the game 5x5!"
                    val game5x5 = Intent()
                    game5x5.putExtra("result", resultState)
                    setResult(RESULT_OK, game5x5)
                }
                else if(moves == 25)
                {
                    binding.textView2.setText("Draw!")
                    resultState = "Draw in the game 5x5!"
                    val game5x5 = Intent()
                    game5x5.putExtra("result", resultState)
                    setResult(RESULT_OK, game5x5)
                }
                else
                {
                    binding.textView2.setText("X - player's turn")
                }
            }

        }
    }

    fun button10(View: View)
    {
        if(board[1][4] == -1)
        {
            board[1][4] = playerTurn
            moves++

            if(playerTurn == 1)
            {
                binding.button10.setText("X")
                playerTurn = 0
                if(checkXwon(1, 4))
                {
                    blockBoard()
                    binding.textView2.setText("X is a winner!")
                    resultState = "X won the game 5x5!"
                    val game5x5 = Intent()
                    game5x5.putExtra("result", resultState)
                    setResult(RESULT_OK, game5x5)
                }
                else if(moves == 25)
                {
                    binding.textView2.setText("Draw!")
                    resultState = "Draw in the game 5x5!"
                    val game5x5 = Intent()
                    game5x5.putExtra("result", resultState)
                    setResult(RESULT_OK, game5x5)
                }
                else
                {
                    binding.textView2.setText("O - player's turn")
                }
            }
            else
            {
                binding.button10.setText("O")
                playerTurn = 1
                if(checkYwon(1, 4))
                {
                    blockBoard()
                    binding.textView2.setText("O is a winner!")
                    resultState = "O won the game 5x5!"
                    val game5x5 = Intent()
                    game5x5.putExtra("result", resultState)
                    setResult(RESULT_OK, game5x5)
                }
                else if(moves == 25)
                {
                    binding.textView2.setText("Draw!")
                    resultState = "Draw in the game 5x5!"
                    val game5x5 = Intent()
                    game5x5.putExtra("result", resultState)
                    setResult(RESULT_OK, game5x5)
                }
                else
                {
                    binding.textView2.setText("X - player's turn")
                }
            }

        }
    }

    fun button11(View: View)
    {
        if(board[2][0] == -1)
        {
            board[2][0] = playerTurn
            moves++

            if(playerTurn == 1)
            {
                binding.button11.setText("X")
                playerTurn = 0
                if(checkXwon(2, 0))
                {
                    blockBoard()
                    binding.textView2.setText("X is a winner!")
                    resultState = "X won the game 5x5!"
                    val game5x5 = Intent()
                    game5x5.putExtra("result", resultState)
                    setResult(RESULT_OK, game5x5)
                }
                else if(moves == 25)
                {
                    binding.textView2.setText("Draw!")
                    resultState = "Draw in the game 5x5!"
                    val game5x5 = Intent()
                    game5x5.putExtra("result", resultState)
                    setResult(RESULT_OK, game5x5)
                }
                else
                {
                    binding.textView2.setText("O - player's turn")
                }
            }
            else
            {
                binding.button11.setText("O")
                playerTurn = 1
                if(checkYwon(2, 0))
                {
                    blockBoard()
                    binding.textView2.setText("O is a winner!")
                    resultState = "O won the game 5x5!"
                    val game5x5 = Intent()
                    game5x5.putExtra("result", resultState)
                    setResult(RESULT_OK, game5x5)
                }
                else if(moves == 25)
                {
                    binding.textView2.setText("Draw!")
                    resultState = "Draw in the game 5x5!"
                    val game5x5 = Intent()
                    game5x5.putExtra("result", resultState)
                    setResult(RESULT_OK, game5x5)
                }
                else
                {
                    binding.textView2.setText("X - player's turn")
                }
            }

        }
    }

    fun button12(View: View)
    {
        if(board[2][1] == -1)
        {
            board[2][1] = playerTurn
            moves++

            if(playerTurn == 1)
            {
                binding.button12.setText("X")
                playerTurn = 0
                if(checkXwon(2, 1))
                {
                    blockBoard()
                    binding.textView2.setText("X is a winner!")
                    resultState = "X won the game 5x5!"
                    val game5x5 = Intent()
                    game5x5.putExtra("result", resultState)
                    setResult(RESULT_OK, game5x5)
                }
                else if(moves == 25)
                {
                    binding.textView2.setText("Draw!")
                    resultState = "Draw in the game 5x5!"
                    val game5x5 = Intent()
                    game5x5.putExtra("result", resultState)
                    setResult(RESULT_OK, game5x5)
                }
                else
                {
                    binding.textView2.setText("O - player's turn")
                }
            }
            else
            {
                binding.button12.setText("O")
                playerTurn = 1
                if(checkYwon(2, 1))
                {
                    blockBoard()
                    binding.textView2.setText("O is a winner!")
                    resultState = "O won the game 5x5!"
                    val game5x5 = Intent()
                    game5x5.putExtra("result", resultState)
                    setResult(RESULT_OK, game5x5)
                }
                else if(moves == 25)
                {
                    binding.textView2.setText("Draw!")
                    resultState = "Draw in the game 5x5!"
                    val game5x5 = Intent()
                    game5x5.putExtra("result", resultState)
                    setResult(RESULT_OK, game5x5)
                }
                else
                {
                    binding.textView2.setText("X - player's turn")
                }
            }

        }
    }


    fun button13(View: View)
    {
        if(board[2][2] == -1)
        {
            board[2][2] = playerTurn
            moves++

            if(playerTurn == 1)
            {
                binding.button13.setText("X")
                playerTurn = 0
                if(checkXwon(2, 2))
                {
                    blockBoard()
                    binding.textView2.setText("X is a winner!")
                    resultState = "X won the game 5x5!"
                    val game5x5 = Intent()
                    game5x5.putExtra("result", resultState)
                    setResult(RESULT_OK, game5x5)
                }
                else if(moves == 25)
                {
                    binding.textView2.setText("Draw!")
                    resultState = "Draw in the game 5x5!"
                    val game5x5 = Intent()
                    game5x5.putExtra("result", resultState)
                    setResult(RESULT_OK, game5x5)
                }
                else
                {
                    binding.textView2.setText("O - player's turn")
                }
            }
            else
            {
                binding.button13.setText("O")
                playerTurn = 1
                if(checkYwon(2, 2))
                {
                    blockBoard()
                    binding.textView2.setText("O is a winner!")
                    resultState = "O won the game 5x5!"
                    val game5x5 = Intent()
                    game5x5.putExtra("result", resultState)
                    setResult(RESULT_OK, game5x5)
                }
                else if(moves == 25)
                {
                    binding.textView2.setText("Draw!")
                    resultState = "Draw in the game 5x5!"
                    val game5x5 = Intent()
                    game5x5.putExtra("result", resultState)
                    setResult(RESULT_OK, game5x5)
                }
                else
                {
                    binding.textView2.setText("X - player's turn")
                }
            }

        }
    }

    fun button14(View: View)
    {
        if(board[2][3] == -1)
        {
            board[2][3] = playerTurn
            moves++

            if(playerTurn == 1)
            {
                binding.button14.setText("X")
                playerTurn = 0
                if(checkXwon(2, 3))
                {
                    blockBoard()
                    binding.textView2.setText("X is a winner!")
                    resultState = "X won the game 5x5!"
                    val game5x5 = Intent()
                    game5x5.putExtra("result", resultState)
                    setResult(RESULT_OK, game5x5)
                }
                else if(moves == 25)
                {
                    binding.textView2.setText("Draw!")
                    resultState = "Draw in the game 5x5!"
                    val game5x5 = Intent()
                    game5x5.putExtra("result", resultState)
                    setResult(RESULT_OK, game5x5)
                }
                else
                {
                    binding.textView2.setText("O - player's turn")
                }
            }
            else
            {
                binding.button14.setText("O")
                playerTurn = 1
                if(checkYwon(2, 3))
                {
                    blockBoard()
                    binding.textView2.setText("O is a winner!")
                    resultState = "O won the game 5x5!"
                    val game5x5 = Intent()
                    game5x5.putExtra("result", resultState)
                    setResult(RESULT_OK, game5x5)
                }
                else if(moves == 25)
                {
                    binding.textView2.setText("Draw!")
                    resultState = "Draw in the game 5x5!"
                    val game5x5 = Intent()
                    game5x5.putExtra("result", resultState)
                    setResult(RESULT_OK, game5x5)
                }
                else
                {
                    binding.textView2.setText("X - player's turn")
                }
            }

        }
    }

    fun button15(View: View)
    {
        if(board[2][4] == -1)
        {
            board[2][4] = playerTurn
            moves++

            if(playerTurn == 1)
            {
                binding.button15.setText("X")
                playerTurn = 0
                if(checkXwon(2, 4))
                {
                    blockBoard()
                    binding.textView2.setText("X is a winner!")
                    resultState = "X won the game 5x5!"
                    val game5x5 = Intent()
                    game5x5.putExtra("result", resultState)
                    setResult(RESULT_OK, game5x5)
                }
                else if(moves == 25)
                {
                    binding.textView2.setText("Draw!")
                    resultState = "Draw in the game 5x5!"
                    val game5x5 = Intent()
                    game5x5.putExtra("result", resultState)
                    setResult(RESULT_OK, game5x5)
                }
                else
                {
                    binding.textView2.setText("O - player's turn")
                }
            }
            else
            {
                binding.button15.setText("O")
                playerTurn = 1
                if(checkYwon(2, 4))
                {
                    blockBoard()
                    binding.textView2.setText("O is a winner!")
                    resultState = "O won the game 5x5!"
                    val game5x5 = Intent()
                    game5x5.putExtra("result", resultState)
                    setResult(RESULT_OK, game5x5)
                }
                else if(moves == 25)
                {
                    binding.textView2.setText("Draw!")
                    resultState = "Draw in the game 5x5!"
                    val game5x5 = Intent()
                    game5x5.putExtra("result", resultState)
                    setResult(RESULT_OK, game5x5)
                }
                else
                {
                    binding.textView2.setText("X - player's turn")
                }
            }

        }
    }

    fun button16(View: View)
    {
        if(board[3][0] == -1)
        {
            board[3][0] = playerTurn
            moves++

            if(playerTurn == 1)
            {
                binding.button16.setText("X")
                playerTurn = 0
                if(checkXwon(3, 0))
                {
                    blockBoard()
                    binding.textView2.setText("X is a winner!")
                    resultState = "X won the game 5x5!"
                    val game5x5 = Intent()
                    game5x5.putExtra("result", resultState)
                    setResult(RESULT_OK, game5x5)
                }
                else if(moves == 25)
                {
                    binding.textView2.setText("Draw!")
                    resultState = "Draw in the game 5x5!"
                    val game5x5 = Intent()
                    game5x5.putExtra("result", resultState)
                    setResult(RESULT_OK, game5x5)
                }
                else
                {
                    binding.textView2.setText("O - player's turn")
                }
            }
            else
            {
                binding.button16.setText("O")
                playerTurn = 1
                if(checkYwon(3, 0))
                {
                    blockBoard()
                    binding.textView2.setText("O is a winner!")
                    resultState = "O won the game 5x5!"
                    val game5x5 = Intent()
                    game5x5.putExtra("result", resultState)
                    setResult(RESULT_OK, game5x5)
                }
                else if(moves == 25)
                {
                    binding.textView2.setText("Draw!")
                    resultState = "Draw in the game 5x5!"
                    val game5x5 = Intent()
                    game5x5.putExtra("result", resultState)
                    setResult(RESULT_OK, game5x5)
                }
                else
                {
                    binding.textView2.setText("X - player's turn")
                }
            }

        }
    }

    fun button17(View: View)
    {
        if(board[3][1] == -1)
        {
            board[3][1] = playerTurn
            moves++

            if(playerTurn == 1)
            {
                binding.button17.setText("X")
                playerTurn = 0
                if(checkXwon(3, 1))
                {
                    blockBoard()
                    binding.textView2.setText("X is a winner!")
                    resultState = "X won the game 5x5!"
                    val game5x5 = Intent()
                    game5x5.putExtra("result", resultState)
                    setResult(RESULT_OK, game5x5)
                }
                else if(moves == 25)
                {
                    binding.textView2.setText("Draw!")
                    resultState = "Draw in the game 5x5!"
                    val game5x5 = Intent()
                    game5x5.putExtra("result", resultState)
                    setResult(RESULT_OK, game5x5)
                }
                else
                {
                    binding.textView2.setText("O - player's turn")
                }
            }
            else
            {
                binding.button17.setText("O")
                playerTurn = 1
                if(checkYwon(3, 1))
                {
                    blockBoard()
                    binding.textView2.setText("O is a winner!")
                    resultState = "O won the game 5x5!"
                    val game5x5 = Intent()
                    game5x5.putExtra("result", resultState)
                    setResult(RESULT_OK, game5x5)
                }
                else if(moves == 25)
                {
                    binding.textView2.setText("Draw!")
                    resultState = "Draw in the game 5x5!"
                    val game5x5 = Intent()
                    game5x5.putExtra("result", resultState)
                    setResult(RESULT_OK, game5x5)
                }
                else
                {
                    binding.textView2.setText("X - player's turn")
                }
            }

        }
    }

    fun button18(View: View)
    {
        if(board[3][2] == -1)
        {
            board[3][2] = playerTurn
            moves++

            if(playerTurn == 1)
            {
                binding.button18.setText("X")
                playerTurn = 0
                if(checkXwon(3, 2))
                {
                    blockBoard()
                    binding.textView2.setText("X is a winner!")
                    resultState = "X won the game 5x5!"
                    val game5x5 = Intent()
                    game5x5.putExtra("result", resultState)
                    setResult(RESULT_OK, game5x5)
                }
                else if(moves == 25)
                {
                    binding.textView2.setText("Draw!")
                    resultState = "Draw in the game 5x5!"
                    val game5x5 = Intent()
                    game5x5.putExtra("result", resultState)
                    setResult(RESULT_OK, game5x5)
                }
                else
                {
                    binding.textView2.setText("O - player's turn")
                }
            }
            else
            {
                binding.button18.setText("O")
                playerTurn = 1
                if(checkYwon(3, 2))
                {
                    blockBoard()
                    binding.textView2.setText("O is a winner!")
                    resultState = "O won the game 5x5!"
                    val game5x5 = Intent()
                    game5x5.putExtra("result", resultState)
                    setResult(RESULT_OK, game5x5)
                }
                else if(moves == 25)
                {
                    binding.textView2.setText("Draw!")
                    resultState = "Draw in the game 5x5!"
                    val game5x5 = Intent()
                    game5x5.putExtra("result", resultState)
                    setResult(RESULT_OK, game5x5)
                }
                else
                {
                    binding.textView2.setText("X - player's turn")
                }
            }

        }
    }

    fun button19(View: View)
    {
        if(board[3][3] == -1)
        {
            board[3][3] = playerTurn
            moves++

            if(playerTurn == 1)
            {
                binding.button19.setText("X")
                playerTurn = 0
                if(checkXwon(3, 3))
                {
                    blockBoard()
                    binding.textView2.setText("X is a winner!")
                    resultState = "X won the game 5x5!"
                    val game5x5 = Intent()
                    game5x5.putExtra("result", resultState)
                    setResult(RESULT_OK, game5x5)
                }
                else if(moves == 25)
                {
                    binding.textView2.setText("Draw!")
                    resultState = "Draw in the game 5x5!"
                    val game5x5 = Intent()
                    game5x5.putExtra("result", resultState)
                    setResult(RESULT_OK, game5x5)
                }
                else
                {
                    binding.textView2.setText("O - player's turn")
                }
            }
            else
            {
                binding.button19.setText("O")
                playerTurn = 1
                if(checkYwon(3, 3))
                {
                    blockBoard()
                    binding.textView2.setText("O is a winner!")
                    resultState = "O won the game 5x5!"
                    val game5x5 = Intent()
                    game5x5.putExtra("result", resultState)
                    setResult(RESULT_OK, game5x5)
                }
                else if(moves == 25)
                {
                    binding.textView2.setText("Draw!")
                    resultState = "Draw in the game 5x5!"
                    val game5x5 = Intent()
                    game5x5.putExtra("result", resultState)
                    setResult(RESULT_OK, game5x5)
                }
                else
                {
                    binding.textView2.setText("X - player's turn")
                }
            }

        }
    }

    fun button20(View: View)
    {
        if(board[3][4] == -1)
        {
            board[3][4] = playerTurn
            moves++

            if(playerTurn == 1)
            {
                binding.button20.setText("X")
                playerTurn = 0
                if(checkXwon(3, 4))
                {
                    blockBoard()
                    binding.textView2.setText("X is a winner!")
                    resultState = "X won the game 5x5!"
                    val game5x5 = Intent()
                    game5x5.putExtra("result", resultState)
                    setResult(RESULT_OK, game5x5)
                }
                else if(moves == 25)
                {
                    binding.textView2.setText("Draw!")
                    resultState = "Draw in the game 5x5!"
                    val game5x5 = Intent()
                    game5x5.putExtra("result", resultState)
                    setResult(RESULT_OK, game5x5)
                }
                else
                {
                    binding.textView2.setText("O - player's turn")
                }
            }
            else
            {
                binding.button20.setText("O")
                playerTurn = 1
                if(checkYwon(3, 4))
                {
                    blockBoard()
                    binding.textView2.setText("O is a winner!")
                    resultState = "O won the game 5x5!"
                    val game5x5 = Intent()
                    game5x5.putExtra("result", resultState)
                    setResult(RESULT_OK, game5x5)
                }
                else if(moves == 25)
                {
                    binding.textView2.setText("Draw!")
                    resultState = "Draw in the game 5x5!"
                    val game5x5 = Intent()
                    game5x5.putExtra("result", resultState)
                    setResult(RESULT_OK, game5x5)
                }
                else
                {
                    binding.textView2.setText("X - player's turn")
                }
            }

        }
    }

    fun button21(View: View)
    {
        if(board[4][0] == -1)
        {
            board[4][0] = playerTurn
            moves++

            if(playerTurn == 1)
            {
                binding.button21.setText("X")
                playerTurn = 0
                if(checkXwon(4, 0))
                {
                    blockBoard()
                    binding.textView2.setText("X is a winner!")
                    resultState = "X won the game 5x5!"
                    val game5x5 = Intent()
                    game5x5.putExtra("result", resultState)
                    setResult(RESULT_OK, game5x5)
                }
                else if(moves == 25)
                {
                    binding.textView2.setText("Draw!")
                    resultState = "Draw in the game 5x5!"
                    val game5x5 = Intent()
                    game5x5.putExtra("result", resultState)
                    setResult(RESULT_OK, game5x5)
                }
                else
                {
                    binding.textView2.setText("O - player's turn")
                }
            }
            else
            {
                binding.button21.setText("O")
                playerTurn = 1
                if(checkYwon(4, 0))
                {
                    blockBoard()
                    binding.textView2.setText("O is a winner!")
                    resultState = "O won the game 5x5!"
                    val game5x5 = Intent()
                    game5x5.putExtra("result", resultState)
                    setResult(RESULT_OK, game5x5)
                }
                else if(moves == 25)
                {
                    binding.textView2.setText("Draw!")
                    resultState = "Draw in the game 5x5!"
                    val game5x5 = Intent()
                    game5x5.putExtra("result", resultState)
                    setResult(RESULT_OK, game5x5)
                }
                else
                {
                    binding.textView2.setText("X - player's turn")
                }
            }

        }
    }

    fun button22(View: View)
    {
        if(board[4][1] == -1)
        {
            board[4][1] = playerTurn
            moves++

            if(playerTurn == 1)
            {
                binding.button22.setText("X")
                playerTurn = 0
                if(checkXwon(4, 1))
                {
                    blockBoard()
                    binding.textView2.setText("X is a winner!")
                    resultState = "X won the game 5x5!"
                    val game5x5 = Intent()
                    game5x5.putExtra("result", resultState)
                    setResult(RESULT_OK, game5x5)
                }
                else if(moves == 25)
                {
                    binding.textView2.setText("Draw!")
                    resultState = "Draw in the game 5x5!"
                    val game5x5 = Intent()
                    game5x5.putExtra("result", resultState)
                    setResult(RESULT_OK, game5x5)
                }
                else
                {
                    binding.textView2.setText("O - player's turn")
                }
            }
            else
            {
                binding.button22.setText("O")
                playerTurn = 1
                if(checkYwon(4, 1))
                {
                    blockBoard()
                    binding.textView2.setText("O is a winner!")
                    resultState = "O won the game 5x5!"
                    val game5x5 = Intent()
                    game5x5.putExtra("result", resultState)
                    setResult(RESULT_OK, game5x5)
                }
                else if(moves == 25)
                {
                    binding.textView2.setText("Draw!")
                    resultState = "Draw in the game 5x5!"
                    val game5x5 = Intent()
                    game5x5.putExtra("result", resultState)
                    setResult(RESULT_OK, game5x5)
                }
                else
                {
                    binding.textView2.setText("X - player's turn")
                }
            }

        }
    }

    fun button23(View: View)
    {
        if(board[4][2] == -1)
        {
            board[4][2] = playerTurn
            moves++

            if(playerTurn == 1)
            {
                binding.button23.setText("X")
                playerTurn = 0
                if(checkXwon(4, 2))
                {
                    blockBoard()
                    binding.textView2.setText("X is a winner!")
                    resultState = "X won the game 5x5!"
                    val game5x5 = Intent()
                    game5x5.putExtra("result", resultState)
                    setResult(RESULT_OK, game5x5)
                }
                else if(moves == 25)
                {
                    binding.textView2.setText("Draw!")
                    resultState = "Draw in the game 5x5!"
                    val game5x5 = Intent()
                    game5x5.putExtra("result", resultState)
                    setResult(RESULT_OK, game5x5)
                }
                else
                {
                    binding.textView2.setText("O - player's turn")
                }
            }
            else
            {
                binding.button23.setText("O")
                playerTurn = 1
                if(checkYwon(4, 2))
                {
                    blockBoard()
                    binding.textView2.setText("O is a winner!")
                    resultState = "O won the game 5x5!"
                    val game5x5 = Intent()
                    game5x5.putExtra("result", resultState)
                    setResult(RESULT_OK, game5x5)
                }
                else if(moves == 25)
                {
                    binding.textView2.setText("Draw!")
                    resultState = "Draw in the game 5x5!"
                    val game5x5 = Intent()
                    game5x5.putExtra("result", resultState)
                    setResult(RESULT_OK, game5x5)
                }
                else
                {
                    binding.textView2.setText("X - player's turn")
                }
            }

        }
    }

    fun button24(View: View)
    {
        if(board[4][3] == -1)
        {
            board[4][3] = playerTurn
            moves++

            if(playerTurn == 1)
            {
                binding.button24.setText("X")
                playerTurn = 0
                if(checkXwon(4, 3))
                {
                    blockBoard()
                    binding.textView2.setText("X is a winner!")
                    resultState = "X won the game 5x5!"
                    val game5x5 = Intent()
                    game5x5.putExtra("result", resultState)
                    setResult(RESULT_OK, game5x5)
                }
                else if(moves == 25)
                {
                    binding.textView2.setText("Draw!")
                    resultState = "Draw in the game 5x5!"
                    val game5x5 = Intent()
                    game5x5.putExtra("result", resultState)
                    setResult(RESULT_OK, game5x5)
                }
                else
                {
                    binding.textView2.setText("O - player's turn")
                }
            }
            else
            {
                binding.button24.setText("O")
                playerTurn = 1
                if(checkYwon(4, 3))
                {
                    blockBoard()
                    binding.textView2.setText("O is a winner!")
                    resultState = "O won the game 5x5!"
                    val game5x5 = Intent()
                    game5x5.putExtra("result", resultState)
                    setResult(RESULT_OK, game5x5)
                }
                else if(moves == 25)
                {
                    binding.textView2.setText("Draw!")
                    resultState = "Draw in the game 5x5!"
                    val game5x5 = Intent()
                    game5x5.putExtra("result", resultState)
                    setResult(RESULT_OK, game5x5)
                }
                else
                {
                    binding.textView2.setText("X - player's turn")
                }
            }

        }
    }

    fun button25(View: View)
    {
        if(board[4][4] == -1)
        {
            board[4][4] = playerTurn
            moves++

            if(playerTurn == 1)
            {
                binding.button25.setText("X")
                playerTurn = 0
                if(checkXwon(4, 4))
                {
                    blockBoard()
                    binding.textView2.setText("X is a winner!")
                    resultState = "X won the game 5x5!"
                    val game5x5 = Intent()
                    game5x5.putExtra("result", resultState)
                    setResult(RESULT_OK, game5x5)
                }
                else if(moves == 25)
                {
                    binding.textView2.setText("Draw!")
                    resultState = "Draw in the game 5x5!"
                    val game5x5 = Intent()
                    game5x5.putExtra("result", resultState)
                    setResult(RESULT_OK, game5x5)
                }
                else
                {
                    binding.textView2.setText("O - player's turn")
                }
            }
            else
            {
                binding.button25.setText("O")
                playerTurn = 1
                if(checkYwon(4, 4))
                {
                    blockBoard()
                    binding.textView2.setText("O is a winner!")
                    resultState = "O won the game 5x5!"
                    val game5x5 = Intent()
                    game5x5.putExtra("result", resultState)
                    setResult(RESULT_OK, game5x5)
                }
                else if(moves == 25)
                {
                    binding.textView2.setText("Draw!")
                    resultState = "Draw in the game 5x5!"
                    val game5x5 = Intent()
                    game5x5.putExtra("result", resultState)
                    setResult(RESULT_OK, game5x5)
                }
                else
                {
                    binding.textView2.setText("X - player's turn")
                }
            }

        }
    }
}