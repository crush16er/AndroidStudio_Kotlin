package com.example.lab2_2_kotlin

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.lab2_2_kotlin.databinding.ActivityGameHangmanBinding

class GameHangman : AppCompatActivity() {
    private lateinit var binding: ActivityGameHangmanBinding
    private var word = ""
    private var hiddenWord = ""
    private var usedLetters = IntArray(26) {0}
    private var hangmanPhotoNumber = 9
    private var correctLetters = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGameHangmanBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        randomWord()
    }

    private fun randomWord() {
        val wordsArray = resources.getStringArray(R.array.words_array)
        word = wordsArray[((Math.random() * wordsArray.size).toInt())]
        //word = "BANANAMOPEBA"
        binding.textView2.setText("Chances left: 8")
        for(i in 1..word.length-1)
        {
            hiddenWord+="_ "
        }
        hiddenWord+="_"
        //hiddenWord = "_ _ N _ N _ _ _ _ _ _ _"
        binding.textView3.setText(hiddenWord)
    }

    private fun checkWin() {
        if(correctLetters == word.length)
        {
            binding.textView2.setText("You won! :)")
            for(i in 0..25)
            {
                usedLetters[i]++
            }
        }
    }

    fun buttonA(view: View)
    {
        if(usedLetters[0] == 0)
        {
            var correct = 0
            usedLetters[0]++
            var tmpWord = hiddenWord
            hiddenWord = ""
            for(i in 0..word.length-2)
            {
                if(word[i].equals('A'))
                {
                    hiddenWord+="A "
                    correct++
                    correctLetters++
                }
                else
                {
                    hiddenWord+=tmpWord[i*2]
                    hiddenWord+=" "
                }

            }

            if(word[word.length-1].equals('A'))
            {
                hiddenWord+="A"
                correct++
                correctLetters++
            }
            else
            {
                hiddenWord+=tmpWord[(word.length-1)*2]
            }

            binding.textView3.setText(hiddenWord)
            if(correct > 0)
            {
                binding.buttonA.setBackgroundColor(Color.parseColor("#33cc33"))
                checkWin()
            }
            else
            {
                binding.buttonA.setBackgroundColor(Color.parseColor("#cc0000"))
                if(hangmanPhotoNumber > 2)
                {
                    hangmanPhotoNumber--
                    when (hangmanPhotoNumber) {
                        8 -> {binding.imageView.setBackgroundResource(R.drawable.hangman8)
                                binding.textView2.setText("Chances left: 7")}
                        7 -> {binding.imageView.setBackgroundResource(R.drawable.hangman7)
                            binding.textView2.setText("Chances left: 6")}
                        6 -> {binding.imageView.setBackgroundResource(R.drawable.hangman6)
                            binding.textView2.setText("Chances left: 5")}
                        5 -> {binding.imageView.setBackgroundResource(R.drawable.hangman5)
                            binding.textView2.setText("Chances left: 4")}
                        4 -> {binding.imageView.setBackgroundResource(R.drawable.hangman4)
                            binding.textView2.setText("Chances left: 3")}
                        3 -> {binding.imageView.setBackgroundResource(R.drawable.hangman3)
                            binding.textView2.setText("Chances left: 2")}
                        2 -> {binding.imageView.setBackgroundResource(R.drawable.hangman2)
                            binding.textView2.setText("Chances left: 1")}
                    }

                }
                else
                {
                    binding.imageView.setBackgroundResource(R.drawable.hangman1)
                    var tmpText = "You lost :( -"
                    tmpText+=word
                    tmpText+="-"
                    binding.textView2.setText(tmpText)
                    for(i in 0..25)
                    {
                        usedLetters[i]++
                    }
                }
            }
        }

    }



    fun buttonB(view: View)
    {
        if(usedLetters[1] == 0)
        {
            var correct = 0
            usedLetters[1]++
            var tmpWord = hiddenWord
            hiddenWord = ""
            for(i in 0..word.length-2)
            {
                if(word[i].equals('B'))
                {
                    hiddenWord+="B "
                    correct++
                    correctLetters++
                }
                else
                {
                    hiddenWord+=tmpWord[i*2]
                    hiddenWord+=" "
                }

            }

            if(word[word.length-1].equals('B'))
            {
                hiddenWord+="B"
                correct++
                correctLetters++
            }
            else
            {
                hiddenWord+=tmpWord[(word.length-1)*2]
            }

            binding.textView3.setText(hiddenWord)
            if(correct > 0)
            {
                binding.buttonB.setBackgroundColor(Color.parseColor("#33cc33"))
                checkWin()
            }
            else
            {
                binding.buttonB.setBackgroundColor(Color.parseColor("#cc0000"))
                if(hangmanPhotoNumber > 2)
                {
                    hangmanPhotoNumber--
                    when (hangmanPhotoNumber) {
                        8 -> {binding.imageView.setBackgroundResource(R.drawable.hangman8)
                            binding.textView2.setText("Chances left: 7")}
                        7 -> {binding.imageView.setBackgroundResource(R.drawable.hangman7)
                            binding.textView2.setText("Chances left: 6")}
                        6 -> {binding.imageView.setBackgroundResource(R.drawable.hangman6)
                            binding.textView2.setText("Chances left: 5")}
                        5 -> {binding.imageView.setBackgroundResource(R.drawable.hangman5)
                            binding.textView2.setText("Chances left: 4")}
                        4 -> {binding.imageView.setBackgroundResource(R.drawable.hangman4)
                            binding.textView2.setText("Chances left: 3")}
                        3 -> {binding.imageView.setBackgroundResource(R.drawable.hangman3)
                            binding.textView2.setText("Chances left: 2")}
                        2 -> {binding.imageView.setBackgroundResource(R.drawable.hangman2)
                            binding.textView2.setText("Chances left: 1")}
                    }

                }
                else
                {
                    binding.imageView.setBackgroundResource(R.drawable.hangman1)
                    var tmpText = "You lost :( -"
                    tmpText+=word
                    tmpText+="-"
                    binding.textView2.setText(tmpText)
                    for(i in 0..25)
                    {
                        usedLetters[i]++
                    }
                }
            }
        }

    }

    fun buttonC(view: View)
    {
        if(usedLetters[2] == 0)
        {
            var correct = 0
            usedLetters[2]++
            var tmpWord = hiddenWord
            hiddenWord = ""
            for(i in 0..word.length-2)
            {
                if(word[i].equals('C'))
                {
                    hiddenWord+="C "
                    correct++
                    correctLetters++
                }
                else
                {
                    hiddenWord+=tmpWord[i*2]
                    hiddenWord+=" "
                }

            }

            if(word[word.length-1].equals('C'))
            {
                hiddenWord+="C"
                correct++
                correctLetters++
            }
            else
            {
                hiddenWord+=tmpWord[(word.length-1)*2]
            }

            binding.textView3.setText(hiddenWord)
            if(correct > 0)
            {
                binding.buttonC.setBackgroundColor(Color.parseColor("#33cc33"))
                checkWin()
            }
            else
            {
                binding.buttonC.setBackgroundColor(Color.parseColor("#cc0000"))
                if(hangmanPhotoNumber > 2)
                {
                    hangmanPhotoNumber--
                    when (hangmanPhotoNumber) {
                        8 -> {binding.imageView.setBackgroundResource(R.drawable.hangman8)
                            binding.textView2.setText("Chances left: 7")}
                        7 -> {binding.imageView.setBackgroundResource(R.drawable.hangman7)
                            binding.textView2.setText("Chances left: 6")}
                        6 -> {binding.imageView.setBackgroundResource(R.drawable.hangman6)
                            binding.textView2.setText("Chances left: 5")}
                        5 -> {binding.imageView.setBackgroundResource(R.drawable.hangman5)
                            binding.textView2.setText("Chances left: 4")}
                        4 -> {binding.imageView.setBackgroundResource(R.drawable.hangman4)
                            binding.textView2.setText("Chances left: 3")}
                        3 -> {binding.imageView.setBackgroundResource(R.drawable.hangman3)
                            binding.textView2.setText("Chances left: 2")}
                        2 -> {binding.imageView.setBackgroundResource(R.drawable.hangman2)
                            binding.textView2.setText("Chances left: 1")}
                    }

                }
                else
                {
                    binding.imageView.setBackgroundResource(R.drawable.hangman1)
                    var tmpText = "You lost :( -"
                    tmpText+=word
                    tmpText+="-"
                    binding.textView2.setText(tmpText)
                    for(i in 0..25)
                    {
                        usedLetters[i]++
                    }
                }
            }
        }

    }

    fun buttonD(view: View)
    {
        if(usedLetters[3] == 0)
        {
            var correct = 0
            usedLetters[3]++
            var tmpWord = hiddenWord
            hiddenWord = ""
            for(i in 0..word.length-2)
            {
                if(word[i].equals('D'))
                {
                    hiddenWord+="D "
                    correct++
                    correctLetters++
                }
                else
                {
                    hiddenWord+=tmpWord[i*2]
                    hiddenWord+=" "
                }

            }

            if(word[word.length-1].equals('D'))
            {
                hiddenWord+="D"
                correct++
                correctLetters++
            }
            else
            {
                hiddenWord+=tmpWord[(word.length-1)*2]
            }

            binding.textView3.setText(hiddenWord)
            if(correct > 0)
            {
                binding.buttonD.setBackgroundColor(Color.parseColor("#33cc33"))
                checkWin()
            }
            else
            {
                binding.buttonD.setBackgroundColor(Color.parseColor("#cc0000"))
                if(hangmanPhotoNumber > 2)
                {
                    hangmanPhotoNumber--
                    when (hangmanPhotoNumber) {
                        8 -> {binding.imageView.setBackgroundResource(R.drawable.hangman8)
                            binding.textView2.setText("Chances left: 7")}
                        7 -> {binding.imageView.setBackgroundResource(R.drawable.hangman7)
                            binding.textView2.setText("Chances left: 6")}
                        6 -> {binding.imageView.setBackgroundResource(R.drawable.hangman6)
                            binding.textView2.setText("Chances left: 5")}
                        5 -> {binding.imageView.setBackgroundResource(R.drawable.hangman5)
                            binding.textView2.setText("Chances left: 4")}
                        4 -> {binding.imageView.setBackgroundResource(R.drawable.hangman4)
                            binding.textView2.setText("Chances left: 3")}
                        3 -> {binding.imageView.setBackgroundResource(R.drawable.hangman3)
                            binding.textView2.setText("Chances left: 2")}
                        2 -> {binding.imageView.setBackgroundResource(R.drawable.hangman2)
                            binding.textView2.setText("Chances left: 1")}
                    }

                }
                else
                {
                    binding.imageView.setBackgroundResource(R.drawable.hangman1)
                    var tmpText = "You lost :( -"
                    tmpText+=word
                    tmpText+="-"
                    binding.textView2.setText(tmpText)
                    for(i in 0..25)
                    {
                        usedLetters[i]++
                    }
                }
            }
        }

    }

    fun buttonE(view: View)
    {
        if(usedLetters[4] == 0)
        {
            var correct = 0
            usedLetters[4]++
            var tmpWord = hiddenWord
            hiddenWord = ""
            for(i in 0..word.length-2)
            {
                if(word[i].equals('E'))
                {
                    hiddenWord+="E "
                    correct++
                    correctLetters++
                }
                else
                {
                    hiddenWord+=tmpWord[i*2]
                    hiddenWord+=" "
                }

            }

            if(word[word.length-1].equals('E'))
            {
                hiddenWord+="E"
                correct++
                correctLetters++
            }
            else
            {
                hiddenWord+=tmpWord[(word.length-1)*2]
            }

            binding.textView3.setText(hiddenWord)
            if(correct > 0)
            {
                binding.buttonE.setBackgroundColor(Color.parseColor("#33cc33"))
                checkWin()
            }
            else
            {
                binding.buttonE.setBackgroundColor(Color.parseColor("#cc0000"))
                if(hangmanPhotoNumber > 2)
                {
                    hangmanPhotoNumber--
                    when (hangmanPhotoNumber) {
                        8 -> {binding.imageView.setBackgroundResource(R.drawable.hangman8)
                            binding.textView2.setText("Chances left: 7")}
                        7 -> {binding.imageView.setBackgroundResource(R.drawable.hangman7)
                            binding.textView2.setText("Chances left: 6")}
                        6 -> {binding.imageView.setBackgroundResource(R.drawable.hangman6)
                            binding.textView2.setText("Chances left: 5")}
                        5 -> {binding.imageView.setBackgroundResource(R.drawable.hangman5)
                            binding.textView2.setText("Chances left: 4")}
                        4 -> {binding.imageView.setBackgroundResource(R.drawable.hangman4)
                            binding.textView2.setText("Chances left: 3")}
                        3 -> {binding.imageView.setBackgroundResource(R.drawable.hangman3)
                            binding.textView2.setText("Chances left: 2")}
                        2 -> {binding.imageView.setBackgroundResource(R.drawable.hangman2)
                            binding.textView2.setText("Chances left: 1")}
                    }

                }
                else
                {
                    binding.imageView.setBackgroundResource(R.drawable.hangman1)
                    var tmpText = "You lost :( -"
                    tmpText+=word
                    tmpText+="-"
                    binding.textView2.setText(tmpText)
                    for(i in 0..25)
                    {
                        usedLetters[i]++
                    }
                }
            }
        }

    }

    fun buttonF(view: View)
    {
        if(usedLetters[5] == 0)
        {
            var correct = 0
            usedLetters[5]++
            var tmpWord = hiddenWord
            hiddenWord = ""
            for(i in 0..word.length-2)
            {
                if(word[i].equals('F'))
                {
                    hiddenWord+="F "
                    correct++
                    correctLetters++
                }
                else
                {
                    hiddenWord+=tmpWord[i*2]
                    hiddenWord+=" "
                }

            }

            if(word[word.length-1].equals('F'))
            {
                hiddenWord+="F"
                correct++
                correctLetters++
            }
            else
            {
                hiddenWord+=tmpWord[(word.length-1)*2]
            }

            binding.textView3.setText(hiddenWord)
            if(correct > 0)
            {
                binding.buttonF.setBackgroundColor(Color.parseColor("#33cc33"))
                checkWin()
            }
            else
            {
                binding.buttonF.setBackgroundColor(Color.parseColor("#cc0000"))
                if(hangmanPhotoNumber > 2)
                {
                    hangmanPhotoNumber--
                    when (hangmanPhotoNumber) {
                        8 -> {binding.imageView.setBackgroundResource(R.drawable.hangman8)
                            binding.textView2.setText("Chances left: 7")}
                        7 -> {binding.imageView.setBackgroundResource(R.drawable.hangman7)
                            binding.textView2.setText("Chances left: 6")}
                        6 -> {binding.imageView.setBackgroundResource(R.drawable.hangman6)
                            binding.textView2.setText("Chances left: 5")}
                        5 -> {binding.imageView.setBackgroundResource(R.drawable.hangman5)
                            binding.textView2.setText("Chances left: 4")}
                        4 -> {binding.imageView.setBackgroundResource(R.drawable.hangman4)
                            binding.textView2.setText("Chances left: 3")}
                        3 -> {binding.imageView.setBackgroundResource(R.drawable.hangman3)
                            binding.textView2.setText("Chances left: 2")}
                        2 -> {binding.imageView.setBackgroundResource(R.drawable.hangman2)
                            binding.textView2.setText("Chances left: 1")}
                    }

                }
                else
                {
                    binding.imageView.setBackgroundResource(R.drawable.hangman1)
                    var tmpText = "You lost :( -"
                    tmpText+=word
                    tmpText+="-"
                    binding.textView2.setText(tmpText)
                    for(i in 0..25)
                    {
                        usedLetters[i]++
                    }
                }
            }
        }

    }

    fun buttonG(view: View)
    {
        if(usedLetters[6] == 0)
        {
            var correct = 0
            usedLetters[6]++
            var tmpWord = hiddenWord
            hiddenWord = ""
            for(i in 0..word.length-2)
            {
                if(word[i].equals('G'))
                {
                    hiddenWord+="G "
                    correct++
                    correctLetters++
                }
                else
                {
                    hiddenWord+=tmpWord[i*2]
                    hiddenWord+=" "
                }

            }

            if(word[word.length-1].equals('G'))
            {
                hiddenWord+="G"
                correct++
                correctLetters++
            }
            else
            {
                hiddenWord+=tmpWord[(word.length-1)*2]
            }

            binding.textView3.setText(hiddenWord)
            if(correct > 0)
            {
                binding.buttonG.setBackgroundColor(Color.parseColor("#33cc33"))
                checkWin()
            }
            else
            {
                binding.buttonG.setBackgroundColor(Color.parseColor("#cc0000"))
                if(hangmanPhotoNumber > 2)
                {
                    hangmanPhotoNumber--
                    when (hangmanPhotoNumber) {
                        8 -> {binding.imageView.setBackgroundResource(R.drawable.hangman8)
                            binding.textView2.setText("Chances left: 7")}
                        7 -> {binding.imageView.setBackgroundResource(R.drawable.hangman7)
                            binding.textView2.setText("Chances left: 6")}
                        6 -> {binding.imageView.setBackgroundResource(R.drawable.hangman6)
                            binding.textView2.setText("Chances left: 5")}
                        5 -> {binding.imageView.setBackgroundResource(R.drawable.hangman5)
                            binding.textView2.setText("Chances left: 4")}
                        4 -> {binding.imageView.setBackgroundResource(R.drawable.hangman4)
                            binding.textView2.setText("Chances left: 3")}
                        3 -> {binding.imageView.setBackgroundResource(R.drawable.hangman3)
                            binding.textView2.setText("Chances left: 2")}
                        2 -> {binding.imageView.setBackgroundResource(R.drawable.hangman2)
                            binding.textView2.setText("Chances left: 1")}
                    }

                }
                else
                {
                    binding.imageView.setBackgroundResource(R.drawable.hangman1)
                    var tmpText = "You lost :( -"
                    tmpText+=word
                    tmpText+="-"
                    binding.textView2.setText(tmpText)
                    for(i in 0..25)
                    {
                        usedLetters[i]++
                    }
                }
            }
        }

    }

    fun buttonH(view: View)
    {
        if(usedLetters[7] == 0)
        {
            var correct = 0
            usedLetters[7]++
            var tmpWord = hiddenWord
            hiddenWord = ""
            for(i in 0..word.length-2)
            {
                if(word[i].equals('H'))
                {
                    hiddenWord+="H "
                    correct++
                    correctLetters++
                }
                else
                {
                    hiddenWord+=tmpWord[i*2]
                    hiddenWord+=" "
                }

            }

            if(word[word.length-1].equals('H'))
            {
                hiddenWord+="H"
                correct++
                correctLetters++
            }
            else
            {
                hiddenWord+=tmpWord[(word.length-1)*2]
            }

            binding.textView3.setText(hiddenWord)
            if(correct > 0)
            {
                binding.buttonH.setBackgroundColor(Color.parseColor("#33cc33"))
                checkWin()
            }
            else
            {
                binding.buttonH.setBackgroundColor(Color.parseColor("#cc0000"))
                if(hangmanPhotoNumber > 2)
                {
                    hangmanPhotoNumber--
                    when (hangmanPhotoNumber) {
                        8 -> {binding.imageView.setBackgroundResource(R.drawable.hangman8)
                            binding.textView2.setText("Chances left: 7")}
                        7 -> {binding.imageView.setBackgroundResource(R.drawable.hangman7)
                            binding.textView2.setText("Chances left: 6")}
                        6 -> {binding.imageView.setBackgroundResource(R.drawable.hangman6)
                            binding.textView2.setText("Chances left: 5")}
                        5 -> {binding.imageView.setBackgroundResource(R.drawable.hangman5)
                            binding.textView2.setText("Chances left: 4")}
                        4 -> {binding.imageView.setBackgroundResource(R.drawable.hangman4)
                            binding.textView2.setText("Chances left: 3")}
                        3 -> {binding.imageView.setBackgroundResource(R.drawable.hangman3)
                            binding.textView2.setText("Chances left: 2")}
                        2 -> {binding.imageView.setBackgroundResource(R.drawable.hangman2)
                            binding.textView2.setText("Chances left: 1")}
                    }

                }
                else
                {
                    binding.imageView.setBackgroundResource(R.drawable.hangman1)
                    var tmpText = "You lost :( -"
                    tmpText+=word
                    tmpText+="-"
                    binding.textView2.setText(tmpText)
                    for(i in 0..25)
                    {
                        usedLetters[i]++
                    }
                }
            }
        }

    }

    fun buttonI(view: View)
    {
        if(usedLetters[8] == 0)
        {
            var correct = 0
            usedLetters[8]++
            var tmpWord = hiddenWord
            hiddenWord = ""
            for(i in 0..word.length-2)
            {
                if(word[i].equals('I'))
                {
                    hiddenWord+="I "
                    correct++
                    correctLetters++
                }
                else
                {
                    hiddenWord+=tmpWord[i*2]
                    hiddenWord+=" "
                }

            }

            if(word[word.length-1].equals('I'))
            {
                hiddenWord+="I"
                correct++
                correctLetters++
            }
            else
            {
                hiddenWord+=tmpWord[(word.length-1)*2]
            }

            binding.textView3.setText(hiddenWord)
            if(correct > 0)
            {
                binding.buttonI.setBackgroundColor(Color.parseColor("#33cc33"))
                checkWin()
            }
            else
            {
                binding.buttonI.setBackgroundColor(Color.parseColor("#cc0000"))
                if(hangmanPhotoNumber > 2)
                {
                    hangmanPhotoNumber--
                    when (hangmanPhotoNumber) {
                        8 -> {binding.imageView.setBackgroundResource(R.drawable.hangman8)
                            binding.textView2.setText("Chances left: 7")}
                        7 -> {binding.imageView.setBackgroundResource(R.drawable.hangman7)
                            binding.textView2.setText("Chances left: 6")}
                        6 -> {binding.imageView.setBackgroundResource(R.drawable.hangman6)
                            binding.textView2.setText("Chances left: 5")}
                        5 -> {binding.imageView.setBackgroundResource(R.drawable.hangman5)
                            binding.textView2.setText("Chances left: 4")}
                        4 -> {binding.imageView.setBackgroundResource(R.drawable.hangman4)
                            binding.textView2.setText("Chances left: 3")}
                        3 -> {binding.imageView.setBackgroundResource(R.drawable.hangman3)
                            binding.textView2.setText("Chances left: 2")}
                        2 -> {binding.imageView.setBackgroundResource(R.drawable.hangman2)
                            binding.textView2.setText("Chances left: 1")}
                    }

                }
                else
                {
                    binding.imageView.setBackgroundResource(R.drawable.hangman1)
                    var tmpText = "You lost :( -"
                    tmpText+=word
                    tmpText+="-"
                    binding.textView2.setText(tmpText)
                    for(i in 0..25)
                    {
                        usedLetters[i]++
                    }
                }
            }
        }

    }

    fun buttonJ(view: View)
    {
        if(usedLetters[9] == 0)
        {
            var correct = 0
            usedLetters[9]++
            var tmpWord = hiddenWord
            hiddenWord = ""
            for(i in 0..word.length-2)
            {
                if(word[i].equals('J'))
                {
                    hiddenWord+="J "
                    correct++
                    correctLetters++
                }
                else
                {
                    hiddenWord+=tmpWord[i*2]
                    hiddenWord+=" "
                }

            }

            if(word[word.length-1].equals('J'))
            {
                hiddenWord+="J"
                correct++
                correctLetters++
            }
            else
            {
                hiddenWord+=tmpWord[(word.length-1)*2]
            }

            binding.textView3.setText(hiddenWord)
            if(correct > 0)
            {
                binding.buttonJ.setBackgroundColor(Color.parseColor("#33cc33"))
                checkWin()
            }
            else
            {
                binding.buttonJ.setBackgroundColor(Color.parseColor("#cc0000"))
                if(hangmanPhotoNumber > 2)
                {
                    hangmanPhotoNumber--
                    when (hangmanPhotoNumber) {
                        8 -> {binding.imageView.setBackgroundResource(R.drawable.hangman8)
                            binding.textView2.setText("Chances left: 7")}
                        7 -> {binding.imageView.setBackgroundResource(R.drawable.hangman7)
                            binding.textView2.setText("Chances left: 6")}
                        6 -> {binding.imageView.setBackgroundResource(R.drawable.hangman6)
                            binding.textView2.setText("Chances left: 5")}
                        5 -> {binding.imageView.setBackgroundResource(R.drawable.hangman5)
                            binding.textView2.setText("Chances left: 4")}
                        4 -> {binding.imageView.setBackgroundResource(R.drawable.hangman4)
                            binding.textView2.setText("Chances left: 3")}
                        3 -> {binding.imageView.setBackgroundResource(R.drawable.hangman3)
                            binding.textView2.setText("Chances left: 2")}
                        2 -> {binding.imageView.setBackgroundResource(R.drawable.hangman2)
                            binding.textView2.setText("Chances left: 1")}
                    }

                }
                else
                {
                    binding.imageView.setBackgroundResource(R.drawable.hangman1)
                    var tmpText = "You lost :( -"
                    tmpText+=word
                    tmpText+="-"
                    binding.textView2.setText(tmpText)
                    for(i in 0..25)
                    {
                        usedLetters[i]++
                    }
                }
            }
        }

    }

    fun buttonK(view: View)
    {
        if(usedLetters[10] == 0)
        {
            var correct = 0
            usedLetters[10]++
            var tmpWord = hiddenWord
            hiddenWord = ""
            for(i in 0..word.length-2)
            {
                if(word[i].equals('K'))
                {
                    hiddenWord+="K "
                    correct++
                    correctLetters++
                }
                else
                {
                    hiddenWord+=tmpWord[i*2]
                    hiddenWord+=" "
                }

            }

            if(word[word.length-1].equals('K'))
            {
                hiddenWord+="K"
                correct++
                correctLetters++
            }
            else
            {
                hiddenWord+=tmpWord[(word.length-1)*2]
            }

            binding.textView3.setText(hiddenWord)
            if(correct > 0)
            {
                binding.buttonK.setBackgroundColor(Color.parseColor("#33cc33"))
                checkWin()
            }
            else
            {
                binding.buttonK.setBackgroundColor(Color.parseColor("#cc0000"))
                if(hangmanPhotoNumber > 2)
                {
                    hangmanPhotoNumber--
                    when (hangmanPhotoNumber) {
                        8 -> {binding.imageView.setBackgroundResource(R.drawable.hangman8)
                            binding.textView2.setText("Chances left: 7")}
                        7 -> {binding.imageView.setBackgroundResource(R.drawable.hangman7)
                            binding.textView2.setText("Chances left: 6")}
                        6 -> {binding.imageView.setBackgroundResource(R.drawable.hangman6)
                            binding.textView2.setText("Chances left: 5")}
                        5 -> {binding.imageView.setBackgroundResource(R.drawable.hangman5)
                            binding.textView2.setText("Chances left: 4")}
                        4 -> {binding.imageView.setBackgroundResource(R.drawable.hangman4)
                            binding.textView2.setText("Chances left: 3")}
                        3 -> {binding.imageView.setBackgroundResource(R.drawable.hangman3)
                            binding.textView2.setText("Chances left: 2")}
                        2 -> {binding.imageView.setBackgroundResource(R.drawable.hangman2)
                            binding.textView2.setText("Chances left: 1")}
                    }

                }
                else
                {
                    binding.imageView.setBackgroundResource(R.drawable.hangman1)
                    var tmpText = "You lost :( -"
                    tmpText+=word
                    tmpText+="-"
                    binding.textView2.setText(tmpText)
                    for(i in 0..25)
                    {
                        usedLetters[i]++
                    }
                }
            }
        }

    }

    fun buttonL(view: View)
    {
        if(usedLetters[11] == 0)
        {
            var correct = 0
            usedLetters[11]++
            var tmpWord = hiddenWord
            hiddenWord = ""
            for(i in 0..word.length-2)
            {
                if(word[i].equals('L'))
                {
                    hiddenWord+="L "
                    correct++
                    correctLetters++
                }
                else
                {
                    hiddenWord+=tmpWord[i*2]
                    hiddenWord+=" "
                }

            }

            if(word[word.length-1].equals('L'))
            {
                hiddenWord+="L"
                correct++
                correctLetters++
            }
            else
            {
                hiddenWord+=tmpWord[(word.length-1)*2]
            }

            binding.textView3.setText(hiddenWord)
            if(correct > 0)
            {
                binding.buttonL.setBackgroundColor(Color.parseColor("#33cc33"))
                checkWin()
            }
            else
            {
                binding.buttonL.setBackgroundColor(Color.parseColor("#cc0000"))
                if(hangmanPhotoNumber > 2)
                {
                    hangmanPhotoNumber--
                    when (hangmanPhotoNumber) {
                        8 -> {binding.imageView.setBackgroundResource(R.drawable.hangman8)
                            binding.textView2.setText("Chances left: 7")}
                        7 -> {binding.imageView.setBackgroundResource(R.drawable.hangman7)
                            binding.textView2.setText("Chances left: 6")}
                        6 -> {binding.imageView.setBackgroundResource(R.drawable.hangman6)
                            binding.textView2.setText("Chances left: 5")}
                        5 -> {binding.imageView.setBackgroundResource(R.drawable.hangman5)
                            binding.textView2.setText("Chances left: 4")}
                        4 -> {binding.imageView.setBackgroundResource(R.drawable.hangman4)
                            binding.textView2.setText("Chances left: 3")}
                        3 -> {binding.imageView.setBackgroundResource(R.drawable.hangman3)
                            binding.textView2.setText("Chances left: 2")}
                        2 -> {binding.imageView.setBackgroundResource(R.drawable.hangman2)
                            binding.textView2.setText("Chances left: 1")}
                    }

                }
                else
                {
                    binding.imageView.setBackgroundResource(R.drawable.hangman1)
                    var tmpText = "You lost :( -"
                    tmpText+=word
                    tmpText+="-"
                    binding.textView2.setText(tmpText)
                    for(i in 0..25)
                    {
                        usedLetters[i]++
                    }
                }
            }
        }

    }


    fun buttonM(view: View)
    {
        if(usedLetters[12] == 0)
        {
            var correct = 0
            usedLetters[12]++
            var tmpWord = hiddenWord
            hiddenWord = ""
            for(i in 0..word.length-2)
            {
                if(word[i].equals('M'))
                {
                    hiddenWord+="M "
                    correct++
                    correctLetters++
                }
                else
                {
                    hiddenWord+=tmpWord[i*2]
                    hiddenWord+=" "
                }

            }

            if(word[word.length-1].equals('M'))
            {
                hiddenWord+="M"
                correct++
                correctLetters++
            }
            else
            {
                hiddenWord+=tmpWord[(word.length-1)*2]
            }

            binding.textView3.setText(hiddenWord)
            if(correct > 0)
            {
                binding.buttonM.setBackgroundColor(Color.parseColor("#33cc33"))
                checkWin()
            }
            else
            {
                binding.buttonM.setBackgroundColor(Color.parseColor("#cc0000"))
                if(hangmanPhotoNumber > 2)
                {
                    hangmanPhotoNumber--
                    when (hangmanPhotoNumber) {
                        8 -> {binding.imageView.setBackgroundResource(R.drawable.hangman8)
                            binding.textView2.setText("Chances left: 7")}
                        7 -> {binding.imageView.setBackgroundResource(R.drawable.hangman7)
                            binding.textView2.setText("Chances left: 6")}
                        6 -> {binding.imageView.setBackgroundResource(R.drawable.hangman6)
                            binding.textView2.setText("Chances left: 5")}
                        5 -> {binding.imageView.setBackgroundResource(R.drawable.hangman5)
                            binding.textView2.setText("Chances left: 4")}
                        4 -> {binding.imageView.setBackgroundResource(R.drawable.hangman4)
                            binding.textView2.setText("Chances left: 3")}
                        3 -> {binding.imageView.setBackgroundResource(R.drawable.hangman3)
                            binding.textView2.setText("Chances left: 2")}
                        2 -> {binding.imageView.setBackgroundResource(R.drawable.hangman2)
                            binding.textView2.setText("Chances left: 1")}
                    }

                }
                else
                {
                    binding.imageView.setBackgroundResource(R.drawable.hangman1)
                    var tmpText = "You lost :( -"
                    tmpText+=word
                    tmpText+="-"
                    binding.textView2.setText(tmpText)
                    for(i in 0..25)
                    {
                        usedLetters[i]++
                    }
                }
            }
        }

    }

    fun buttonN(view: View)
    {
        if(usedLetters[13] == 0)
        {
            var correct = 0
            usedLetters[13]++
            var tmpWord = hiddenWord
            hiddenWord = ""
            for(i in 0..word.length-2)
            {
                if(word[i].equals('N'))
                {
                    hiddenWord+="N "
                    correct++
                    correctLetters++
                }
                else
                {
                    hiddenWord+=tmpWord[i*2]
                    hiddenWord+=" "
                }

            }

            if(word[word.length-1].equals('N'))
            {
                hiddenWord+="N"
                correct++
                correctLetters++
            }
            else
            {
                hiddenWord+=tmpWord[(word.length-1)*2]
            }

            binding.textView3.setText(hiddenWord)
            if(correct > 0)
            {
                binding.buttonN.setBackgroundColor(Color.parseColor("#33cc33"))
                checkWin()
            }
            else
            {
                binding.buttonN.setBackgroundColor(Color.parseColor("#cc0000"))
                if(hangmanPhotoNumber > 2)
                {
                    hangmanPhotoNumber--
                    when (hangmanPhotoNumber) {
                        8 -> {binding.imageView.setBackgroundResource(R.drawable.hangman8)
                            binding.textView2.setText("Chances left: 7")}
                        7 -> {binding.imageView.setBackgroundResource(R.drawable.hangman7)
                            binding.textView2.setText("Chances left: 6")}
                        6 -> {binding.imageView.setBackgroundResource(R.drawable.hangman6)
                            binding.textView2.setText("Chances left: 5")}
                        5 -> {binding.imageView.setBackgroundResource(R.drawable.hangman5)
                            binding.textView2.setText("Chances left: 4")}
                        4 -> {binding.imageView.setBackgroundResource(R.drawable.hangman4)
                            binding.textView2.setText("Chances left: 3")}
                        3 -> {binding.imageView.setBackgroundResource(R.drawable.hangman3)
                            binding.textView2.setText("Chances left: 2")}
                        2 -> {binding.imageView.setBackgroundResource(R.drawable.hangman2)
                            binding.textView2.setText("Chances left: 1")}
                    }

                }
                else
                {
                    binding.imageView.setBackgroundResource(R.drawable.hangman1)
                    var tmpText = "You lost :( -"
                    tmpText+=word
                    tmpText+="-"
                    binding.textView2.setText(tmpText)
                    for(i in 0..25)
                    {
                        usedLetters[i]++
                    }
                }
            }
        }

    }

    fun buttonO(view: View)
    {
        if(usedLetters[14] == 0)
        {
            var correct = 0
            usedLetters[14]++
            var tmpWord = hiddenWord
            hiddenWord = ""
            for(i in 0..word.length-2)
            {
                if(word[i].equals('O'))
                {
                    hiddenWord+="O "
                    correct++
                    correctLetters++
                }
                else
                {
                    hiddenWord+=tmpWord[i*2]
                    hiddenWord+=" "
                }

            }

            if(word[word.length-1].equals('O'))
            {
                hiddenWord+="O"
                correct++
                correctLetters++
            }
            else
            {
                hiddenWord+=tmpWord[(word.length-1)*2]
            }

            binding.textView3.setText(hiddenWord)
            if(correct > 0)
            {
                binding.buttonO.setBackgroundColor(Color.parseColor("#33cc33"))
                checkWin()
            }
            else
            {
                binding.buttonO.setBackgroundColor(Color.parseColor("#cc0000"))
                if(hangmanPhotoNumber > 2)
                {
                    hangmanPhotoNumber--
                    when (hangmanPhotoNumber) {
                        8 -> {binding.imageView.setBackgroundResource(R.drawable.hangman8)
                            binding.textView2.setText("Chances left: 7")}
                        7 -> {binding.imageView.setBackgroundResource(R.drawable.hangman7)
                            binding.textView2.setText("Chances left: 6")}
                        6 -> {binding.imageView.setBackgroundResource(R.drawable.hangman6)
                            binding.textView2.setText("Chances left: 5")}
                        5 -> {binding.imageView.setBackgroundResource(R.drawable.hangman5)
                            binding.textView2.setText("Chances left: 4")}
                        4 -> {binding.imageView.setBackgroundResource(R.drawable.hangman4)
                            binding.textView2.setText("Chances left: 3")}
                        3 -> {binding.imageView.setBackgroundResource(R.drawable.hangman3)
                            binding.textView2.setText("Chances left: 2")}
                        2 -> {binding.imageView.setBackgroundResource(R.drawable.hangman2)
                            binding.textView2.setText("Chances left: 1")}
                    }

                }
                else
                {
                    binding.imageView.setBackgroundResource(R.drawable.hangman1)
                    var tmpText = "You lost :( -"
                    tmpText+=word
                    tmpText+="-"
                    binding.textView2.setText(tmpText)
                    for(i in 0..25)
                    {
                        usedLetters[i]++
                    }
                }
            }
        }

    }

    fun buttonP(view: View)
    {
        if(usedLetters[15] == 0)
        {
            var correct = 0
            usedLetters[15]++
            var tmpWord = hiddenWord
            hiddenWord = ""
            for(i in 0..word.length-2)
            {
                if(word[i].equals('P'))
                {
                    hiddenWord+="P "
                    correct++
                    correctLetters++
                }
                else
                {
                    hiddenWord+=tmpWord[i*2]
                    hiddenWord+=" "
                }

            }

            if(word[word.length-1].equals('P'))
            {
                hiddenWord+="P"
                correct++
                correctLetters++
            }
            else
            {
                hiddenWord+=tmpWord[(word.length-1)*2]
            }

            binding.textView3.setText(hiddenWord)
            if(correct > 0)
            {
                binding.buttonP.setBackgroundColor(Color.parseColor("#33cc33"))
                checkWin()
            }
            else
            {
                binding.buttonP.setBackgroundColor(Color.parseColor("#cc0000"))
                if(hangmanPhotoNumber > 2)
                {
                    hangmanPhotoNumber--
                    when (hangmanPhotoNumber) {
                        8 -> {binding.imageView.setBackgroundResource(R.drawable.hangman8)
                            binding.textView2.setText("Chances left: 7")}
                        7 -> {binding.imageView.setBackgroundResource(R.drawable.hangman7)
                            binding.textView2.setText("Chances left: 6")}
                        6 -> {binding.imageView.setBackgroundResource(R.drawable.hangman6)
                            binding.textView2.setText("Chances left: 5")}
                        5 -> {binding.imageView.setBackgroundResource(R.drawable.hangman5)
                            binding.textView2.setText("Chances left: 4")}
                        4 -> {binding.imageView.setBackgroundResource(R.drawable.hangman4)
                            binding.textView2.setText("Chances left: 3")}
                        3 -> {binding.imageView.setBackgroundResource(R.drawable.hangman3)
                            binding.textView2.setText("Chances left: 2")}
                        2 -> {binding.imageView.setBackgroundResource(R.drawable.hangman2)
                            binding.textView2.setText("Chances left: 1")}
                    }

                }
                else
                {
                    binding.imageView.setBackgroundResource(R.drawable.hangman1)
                    var tmpText = "You lost :( -"
                    tmpText+=word
                    tmpText+="-"
                    binding.textView2.setText(tmpText)
                    for(i in 0..25)
                    {
                        usedLetters[i]++
                    }
                }
            }
        }

    }

    fun buttonQ(view: View)
    {
        if(usedLetters[16] == 0)
        {
            var correct = 0
            usedLetters[16]++
            var tmpWord = hiddenWord
            hiddenWord = ""
            for(i in 0..word.length-2)
            {
                if(word[i].equals('Q'))
                {
                    hiddenWord+="Q "
                    correct++
                    correctLetters++
                }
                else
                {
                    hiddenWord+=tmpWord[i*2]
                    hiddenWord+=" "
                }

            }

            if(word[word.length-1].equals('Q'))
            {
                hiddenWord+="Q"
                correct++
                correctLetters++
            }
            else
            {
                hiddenWord+=tmpWord[(word.length-1)*2]
            }

            binding.textView3.setText(hiddenWord)
            if(correct > 0)
            {
                binding.buttonQ.setBackgroundColor(Color.parseColor("#33cc33"))
                checkWin()
            }
            else
            {
                binding.buttonQ.setBackgroundColor(Color.parseColor("#cc0000"))
                if(hangmanPhotoNumber > 2)
                {
                    hangmanPhotoNumber--
                    when (hangmanPhotoNumber) {
                        8 -> {binding.imageView.setBackgroundResource(R.drawable.hangman8)
                            binding.textView2.setText("Chances left: 7")}
                        7 -> {binding.imageView.setBackgroundResource(R.drawable.hangman7)
                            binding.textView2.setText("Chances left: 6")}
                        6 -> {binding.imageView.setBackgroundResource(R.drawable.hangman6)
                            binding.textView2.setText("Chances left: 5")}
                        5 -> {binding.imageView.setBackgroundResource(R.drawable.hangman5)
                            binding.textView2.setText("Chances left: 4")}
                        4 -> {binding.imageView.setBackgroundResource(R.drawable.hangman4)
                            binding.textView2.setText("Chances left: 3")}
                        3 -> {binding.imageView.setBackgroundResource(R.drawable.hangman3)
                            binding.textView2.setText("Chances left: 2")}
                        2 -> {binding.imageView.setBackgroundResource(R.drawable.hangman2)
                            binding.textView2.setText("Chances left: 1")}
                    }

                }
                else
                {
                    binding.imageView.setBackgroundResource(R.drawable.hangman1)
                    var tmpText = "You lost :( -"
                    tmpText+=word
                    tmpText+="-"
                    binding.textView2.setText(tmpText)
                    for(i in 0..25)
                    {
                        usedLetters[i]++
                    }
                }
            }
        }

    }

    fun buttonR(view: View)
    {
        if(usedLetters[17] == 0)
        {
            var correct = 0
            usedLetters[17]++
            var tmpWord = hiddenWord
            hiddenWord = ""
            for(i in 0..word.length-2)
            {
                if(word[i].equals('R'))
                {
                    hiddenWord+="R "
                    correct++
                    correctLetters++
                }
                else
                {
                    hiddenWord+=tmpWord[i*2]
                    hiddenWord+=" "
                }

            }

            if(word[word.length-1].equals('R'))
            {
                hiddenWord+="R"
                correct++
                correctLetters++
            }
            else
            {
                hiddenWord+=tmpWord[(word.length-1)*2]
            }

            binding.textView3.setText(hiddenWord)
            if(correct > 0)
            {
                binding.buttonR.setBackgroundColor(Color.parseColor("#33cc33"))
                checkWin()
            }
            else
            {
                binding.buttonR.setBackgroundColor(Color.parseColor("#cc0000"))
                if(hangmanPhotoNumber > 2)
                {
                    hangmanPhotoNumber--
                    when (hangmanPhotoNumber) {
                        8 -> {binding.imageView.setBackgroundResource(R.drawable.hangman8)
                            binding.textView2.setText("Chances left: 7")}
                        7 -> {binding.imageView.setBackgroundResource(R.drawable.hangman7)
                            binding.textView2.setText("Chances left: 6")}
                        6 -> {binding.imageView.setBackgroundResource(R.drawable.hangman6)
                            binding.textView2.setText("Chances left: 5")}
                        5 -> {binding.imageView.setBackgroundResource(R.drawable.hangman5)
                            binding.textView2.setText("Chances left: 4")}
                        4 -> {binding.imageView.setBackgroundResource(R.drawable.hangman4)
                            binding.textView2.setText("Chances left: 3")}
                        3 -> {binding.imageView.setBackgroundResource(R.drawable.hangman3)
                            binding.textView2.setText("Chances left: 2")}
                        2 -> {binding.imageView.setBackgroundResource(R.drawable.hangman2)
                            binding.textView2.setText("Chances left: 1")}
                    }

                }
                else
                {
                    binding.imageView.setBackgroundResource(R.drawable.hangman1)
                    var tmpText = "You lost :( -"
                    tmpText+=word
                    tmpText+="-"
                    binding.textView2.setText(tmpText)
                    for(i in 0..25)
                    {
                        usedLetters[i]++
                    }
                }
            }
        }

    }

    fun buttonS(view: View)
    {
        if(usedLetters[18] == 0)
        {
            var correct = 0
            usedLetters[18]++
            var tmpWord = hiddenWord
            hiddenWord = ""
            for(i in 0..word.length-2)
            {
                if(word[i].equals('S'))
                {
                    hiddenWord+="S "
                    correct++
                    correctLetters++
                }
                else
                {
                    hiddenWord+=tmpWord[i*2]
                    hiddenWord+=" "
                }

            }

            if(word[word.length-1].equals('S'))
            {
                hiddenWord+="S"
                correct++
                correctLetters++
            }
            else
            {
                hiddenWord+=tmpWord[(word.length-1)*2]
            }

            binding.textView3.setText(hiddenWord)
            if(correct > 0)
            {
                binding.buttonS.setBackgroundColor(Color.parseColor("#33cc33"))
                checkWin()
            }
            else
            {
                binding.buttonS.setBackgroundColor(Color.parseColor("#cc0000"))
                if(hangmanPhotoNumber > 2)
                {
                    hangmanPhotoNumber--
                    when (hangmanPhotoNumber) {
                        8 -> {binding.imageView.setBackgroundResource(R.drawable.hangman8)
                            binding.textView2.setText("Chances left: 7")}
                        7 -> {binding.imageView.setBackgroundResource(R.drawable.hangman7)
                            binding.textView2.setText("Chances left: 6")}
                        6 -> {binding.imageView.setBackgroundResource(R.drawable.hangman6)
                            binding.textView2.setText("Chances left: 5")}
                        5 -> {binding.imageView.setBackgroundResource(R.drawable.hangman5)
                            binding.textView2.setText("Chances left: 4")}
                        4 -> {binding.imageView.setBackgroundResource(R.drawable.hangman4)
                            binding.textView2.setText("Chances left: 3")}
                        3 -> {binding.imageView.setBackgroundResource(R.drawable.hangman3)
                            binding.textView2.setText("Chances left: 2")}
                        2 -> {binding.imageView.setBackgroundResource(R.drawable.hangman2)
                            binding.textView2.setText("Chances left: 1")}
                    }

                }
                else
                {
                    binding.imageView.setBackgroundResource(R.drawable.hangman1)
                    var tmpText = "You lost :( -"
                    tmpText+=word
                    tmpText+="-"
                    binding.textView2.setText(tmpText)
                    for(i in 0..25)
                    {
                        usedLetters[i]++
                    }
                }
            }
        }

    }

    fun buttonT(view: View)
    {
        if(usedLetters[19] == 0)
        {
            var correct = 0
            usedLetters[19]++
            var tmpWord = hiddenWord
            hiddenWord = ""
            for(i in 0..word.length-2)
            {
                if(word[i].equals('T'))
                {
                    hiddenWord+="T "
                    correct++
                    correctLetters++
                }
                else
                {
                    hiddenWord+=tmpWord[i*2]
                    hiddenWord+=" "
                }

            }

            if(word[word.length-1].equals('T'))
            {
                hiddenWord+="T"
                correct++
                correctLetters++
            }
            else
            {
                hiddenWord+=tmpWord[(word.length-1)*2]
            }

            binding.textView3.setText(hiddenWord)
            if(correct > 0)
            {
                binding.buttonT.setBackgroundColor(Color.parseColor("#33cc33"))
                checkWin()
            }
            else
            {
                binding.buttonT.setBackgroundColor(Color.parseColor("#cc0000"))
                if(hangmanPhotoNumber > 2)
                {
                    hangmanPhotoNumber--
                    when (hangmanPhotoNumber) {
                        8 -> {binding.imageView.setBackgroundResource(R.drawable.hangman8)
                            binding.textView2.setText("Chances left: 7")}
                        7 -> {binding.imageView.setBackgroundResource(R.drawable.hangman7)
                            binding.textView2.setText("Chances left: 6")}
                        6 -> {binding.imageView.setBackgroundResource(R.drawable.hangman6)
                            binding.textView2.setText("Chances left: 5")}
                        5 -> {binding.imageView.setBackgroundResource(R.drawable.hangman5)
                            binding.textView2.setText("Chances left: 4")}
                        4 -> {binding.imageView.setBackgroundResource(R.drawable.hangman4)
                            binding.textView2.setText("Chances left: 3")}
                        3 -> {binding.imageView.setBackgroundResource(R.drawable.hangman3)
                            binding.textView2.setText("Chances left: 2")}
                        2 -> {binding.imageView.setBackgroundResource(R.drawable.hangman2)
                            binding.textView2.setText("Chances left: 1")}
                    }

                }
                else
                {
                    binding.imageView.setBackgroundResource(R.drawable.hangman1)
                    var tmpText = "You lost :( -"
                    tmpText+=word
                    tmpText+="-"
                    binding.textView2.setText(tmpText)
                    for(i in 0..25)
                    {
                        usedLetters[i]++
                    }
                }
            }
        }

    }

    fun buttonU(view: View)
    {
        if(usedLetters[20] == 0)
        {
            var correct = 0
            usedLetters[20]++
            var tmpWord = hiddenWord
            hiddenWord = ""
            for(i in 0..word.length-2)
            {
                if(word[i].equals('U'))
                {
                    hiddenWord+="U "
                    correct++
                    correctLetters++
                }
                else
                {
                    hiddenWord+=tmpWord[i*2]
                    hiddenWord+=" "
                }

            }

            if(word[word.length-1].equals('U'))
            {
                hiddenWord+="U"
                correct++
                correctLetters++
            }
            else
            {
                hiddenWord+=tmpWord[(word.length-1)*2]
            }

            binding.textView3.setText(hiddenWord)
            if(correct > 0)
            {
                binding.buttonU.setBackgroundColor(Color.parseColor("#33cc33"))
                checkWin()
            }
            else
            {
                binding.buttonU.setBackgroundColor(Color.parseColor("#cc0000"))
                if(hangmanPhotoNumber > 2)
                {
                    hangmanPhotoNumber--
                    when (hangmanPhotoNumber) {
                        8 -> {binding.imageView.setBackgroundResource(R.drawable.hangman8)
                            binding.textView2.setText("Chances left: 7")}
                        7 -> {binding.imageView.setBackgroundResource(R.drawable.hangman7)
                            binding.textView2.setText("Chances left: 6")}
                        6 -> {binding.imageView.setBackgroundResource(R.drawable.hangman6)
                            binding.textView2.setText("Chances left: 5")}
                        5 -> {binding.imageView.setBackgroundResource(R.drawable.hangman5)
                            binding.textView2.setText("Chances left: 4")}
                        4 -> {binding.imageView.setBackgroundResource(R.drawable.hangman4)
                            binding.textView2.setText("Chances left: 3")}
                        3 -> {binding.imageView.setBackgroundResource(R.drawable.hangman3)
                            binding.textView2.setText("Chances left: 2")}
                        2 -> {binding.imageView.setBackgroundResource(R.drawable.hangman2)
                            binding.textView2.setText("Chances left: 1")}
                    }

                }
                else
                {
                    binding.imageView.setBackgroundResource(R.drawable.hangman1)
                    var tmpText = "You lost :( -"
                    tmpText+=word
                    tmpText+="-"
                    binding.textView2.setText(tmpText)
                    for(i in 0..25)
                    {
                        usedLetters[i]++
                    }
                }
            }
        }

    }

    fun buttonV(view: View)
    {
        if(usedLetters[21] == 0)
        {
            var correct = 0
            usedLetters[21]++
            var tmpWord = hiddenWord
            hiddenWord = ""
            for(i in 0..word.length-2)
            {
                if(word[i].equals('V'))
                {
                    hiddenWord+="V "
                    correct++
                    correctLetters++
                }
                else
                {
                    hiddenWord+=tmpWord[i*2]
                    hiddenWord+=" "
                }

            }

            if(word[word.length-1].equals('V'))
            {
                hiddenWord+="V"
                correct++
                correctLetters++
            }
            else
            {
                hiddenWord+=tmpWord[(word.length-1)*2]
            }

            binding.textView3.setText(hiddenWord)
            if(correct > 0)
            {
                binding.buttonV.setBackgroundColor(Color.parseColor("#33cc33"))
                checkWin()
            }
            else
            {
                binding.buttonV.setBackgroundColor(Color.parseColor("#cc0000"))
                if(hangmanPhotoNumber > 2)
                {
                    hangmanPhotoNumber--
                    when (hangmanPhotoNumber) {
                        8 -> {binding.imageView.setBackgroundResource(R.drawable.hangman8)
                            binding.textView2.setText("Chances left: 7")}
                        7 -> {binding.imageView.setBackgroundResource(R.drawable.hangman7)
                            binding.textView2.setText("Chances left: 6")}
                        6 -> {binding.imageView.setBackgroundResource(R.drawable.hangman6)
                            binding.textView2.setText("Chances left: 5")}
                        5 -> {binding.imageView.setBackgroundResource(R.drawable.hangman5)
                            binding.textView2.setText("Chances left: 4")}
                        4 -> {binding.imageView.setBackgroundResource(R.drawable.hangman4)
                            binding.textView2.setText("Chances left: 3")}
                        3 -> {binding.imageView.setBackgroundResource(R.drawable.hangman3)
                            binding.textView2.setText("Chances left: 2")}
                        2 -> {binding.imageView.setBackgroundResource(R.drawable.hangman2)
                            binding.textView2.setText("Chances left: 1")}
                    }

                }
                else
                {
                    binding.imageView.setBackgroundResource(R.drawable.hangman1)
                    var tmpText = "You lost :( -"
                    tmpText+=word
                    tmpText+="-"
                    binding.textView2.setText(tmpText)
                    for(i in 0..25)
                    {
                        usedLetters[i]++
                    }
                }
            }
        }

    }

    fun buttonW(view: View)
    {
        if(usedLetters[22] == 0)
        {
            var correct = 0
            usedLetters[22]++
            var tmpWord = hiddenWord
            hiddenWord = ""
            for(i in 0..word.length-2)
            {
                if(word[i].equals('W'))
                {
                    hiddenWord+="W "
                    correct++
                    correctLetters++
                }
                else
                {
                    hiddenWord+=tmpWord[i*2]
                    hiddenWord+=" "
                }

            }

            if(word[word.length-1].equals('W'))
            {
                hiddenWord+="W"
                correct++
                correctLetters++
            }
            else
            {
                hiddenWord+=tmpWord[(word.length-1)*2]
            }

            binding.textView3.setText(hiddenWord)
            if(correct > 0)
            {
                binding.buttonW.setBackgroundColor(Color.parseColor("#33cc33"))
                checkWin()
            }
            else
            {
                binding.buttonW.setBackgroundColor(Color.parseColor("#cc0000"))
                if(hangmanPhotoNumber > 2)
                {
                    hangmanPhotoNumber--
                    when (hangmanPhotoNumber) {
                        8 -> {binding.imageView.setBackgroundResource(R.drawable.hangman8)
                            binding.textView2.setText("Chances left: 7")}
                        7 -> {binding.imageView.setBackgroundResource(R.drawable.hangman7)
                            binding.textView2.setText("Chances left: 6")}
                        6 -> {binding.imageView.setBackgroundResource(R.drawable.hangman6)
                            binding.textView2.setText("Chances left: 5")}
                        5 -> {binding.imageView.setBackgroundResource(R.drawable.hangman5)
                            binding.textView2.setText("Chances left: 4")}
                        4 -> {binding.imageView.setBackgroundResource(R.drawable.hangman4)
                            binding.textView2.setText("Chances left: 3")}
                        3 -> {binding.imageView.setBackgroundResource(R.drawable.hangman3)
                            binding.textView2.setText("Chances left: 2")}
                        2 -> {binding.imageView.setBackgroundResource(R.drawable.hangman2)
                            binding.textView2.setText("Chances left: 1")}
                    }

                }
                else
                {
                    binding.imageView.setBackgroundResource(R.drawable.hangman1)
                    var tmpText = "You lost :( -"
                    tmpText+=word
                    tmpText+="-"
                    binding.textView2.setText(tmpText)
                    for(i in 0..25)
                    {
                        usedLetters[i]++
                    }
                }
            }
        }

    }

    fun buttonX(view: View)
    {
        if(usedLetters[23] == 0)
        {
            var correct = 0
            usedLetters[23]++
            var tmpWord = hiddenWord
            hiddenWord = ""
            for(i in 0..word.length-2)
            {
                if(word[i].equals('X'))
                {
                    hiddenWord+="X "
                    correct++
                    correctLetters++
                }
                else
                {
                    hiddenWord+=tmpWord[i*2]
                    hiddenWord+=" "
                }

            }

            if(word[word.length-1].equals('X'))
            {
                hiddenWord+="X"
                correct++
                correctLetters++
            }
            else
            {
                hiddenWord+=tmpWord[(word.length-1)*2]
            }

            binding.textView3.setText(hiddenWord)
            if(correct > 0)
            {
                binding.buttonX.setBackgroundColor(Color.parseColor("#33cc33"))
                checkWin()
            }
            else
            {
                binding.buttonX.setBackgroundColor(Color.parseColor("#cc0000"))
                if(hangmanPhotoNumber > 2)
                {
                    hangmanPhotoNumber--
                    when (hangmanPhotoNumber) {
                        8 -> {binding.imageView.setBackgroundResource(R.drawable.hangman8)
                            binding.textView2.setText("Chances left: 7")}
                        7 -> {binding.imageView.setBackgroundResource(R.drawable.hangman7)
                            binding.textView2.setText("Chances left: 6")}
                        6 -> {binding.imageView.setBackgroundResource(R.drawable.hangman6)
                            binding.textView2.setText("Chances left: 5")}
                        5 -> {binding.imageView.setBackgroundResource(R.drawable.hangman5)
                            binding.textView2.setText("Chances left: 4")}
                        4 -> {binding.imageView.setBackgroundResource(R.drawable.hangman4)
                            binding.textView2.setText("Chances left: 3")}
                        3 -> {binding.imageView.setBackgroundResource(R.drawable.hangman3)
                            binding.textView2.setText("Chances left: 2")}
                        2 -> {binding.imageView.setBackgroundResource(R.drawable.hangman2)
                            binding.textView2.setText("Chances left: 1")}
                    }

                }
                else
                {
                    binding.imageView.setBackgroundResource(R.drawable.hangman1)
                    var tmpText = "You lost :( -"
                    tmpText+=word
                    tmpText+="-"
                    binding.textView2.setText(tmpText)
                    for(i in 0..25)
                    {
                        usedLetters[i]++
                    }
                }
            }
        }

    }

    fun buttonY(view: View)
    {
        if(usedLetters[24] == 0)
        {
            var correct = 0
            usedLetters[24]++
            var tmpWord = hiddenWord
            hiddenWord = ""
            for(i in 0..word.length-2)
            {
                if(word[i].equals('Y'))
                {
                    hiddenWord+="Y "
                    correct++
                    correctLetters++
                }
                else
                {
                    hiddenWord+=tmpWord[i*2]
                    hiddenWord+=" "
                }

            }

            if(word[word.length-1].equals('Y'))
            {
                hiddenWord+="Y"
                correct++
                correctLetters++
            }
            else
            {
                hiddenWord+=tmpWord[(word.length-1)*2]
            }

            binding.textView3.setText(hiddenWord)
            if(correct > 0)
            {
                binding.buttonY.setBackgroundColor(Color.parseColor("#33cc33"))
                checkWin()
            }
            else
            {
                binding.buttonY.setBackgroundColor(Color.parseColor("#cc0000"))
                if(hangmanPhotoNumber > 2)
                {
                    hangmanPhotoNumber--
                    when (hangmanPhotoNumber) {
                        8 -> {binding.imageView.setBackgroundResource(R.drawable.hangman8)
                            binding.textView2.setText("Chances left: 7")}
                        7 -> {binding.imageView.setBackgroundResource(R.drawable.hangman7)
                            binding.textView2.setText("Chances left: 6")}
                        6 -> {binding.imageView.setBackgroundResource(R.drawable.hangman6)
                            binding.textView2.setText("Chances left: 5")}
                        5 -> {binding.imageView.setBackgroundResource(R.drawable.hangman5)
                            binding.textView2.setText("Chances left: 4")}
                        4 -> {binding.imageView.setBackgroundResource(R.drawable.hangman4)
                            binding.textView2.setText("Chances left: 3")}
                        3 -> {binding.imageView.setBackgroundResource(R.drawable.hangman3)
                            binding.textView2.setText("Chances left: 2")}
                        2 -> {binding.imageView.setBackgroundResource(R.drawable.hangman2)
                            binding.textView2.setText("Chances left: 1")}
                    }

                }
                else
                {
                    binding.imageView.setBackgroundResource(R.drawable.hangman1)
                    var tmpText = "You lost :( -"
                    tmpText+=word
                    tmpText+="-"
                    binding.textView2.setText(tmpText)
                    for(i in 0..25)
                    {
                        usedLetters[i]++
                    }
                }
            }
        }

    }

    fun buttonZ(view: View)
    {
        if(usedLetters[25] == 0)
        {
            var correct = 0
            usedLetters[25]++
            var tmpWord = hiddenWord
            hiddenWord = ""
            for(i in 0..word.length-2)
            {
                if(word[i].equals('Z'))
                {
                    hiddenWord+="Z "
                    correct++
                    correctLetters++
                }
                else
                {
                    hiddenWord+=tmpWord[i*2]
                    hiddenWord+=" "
                }

            }

            if(word[word.length-1].equals('Z'))
            {
                hiddenWord+="Z"
                correct++
                correctLetters++
            }
            else
            {
                hiddenWord+=tmpWord[(word.length-1)*2]
            }

            binding.textView3.setText(hiddenWord)
            if(correct > 0)
            {
                binding.buttonZ.setBackgroundColor(Color.parseColor("#33cc33"))
                checkWin()
            }
            else
            {
                binding.buttonZ.setBackgroundColor(Color.parseColor("#cc0000"))
                if(hangmanPhotoNumber > 2)
                {
                    hangmanPhotoNumber--
                    when (hangmanPhotoNumber) {
                        8 -> {binding.imageView.setBackgroundResource(R.drawable.hangman8)
                            binding.textView2.setText("Chances left: 7")}
                        7 -> {binding.imageView.setBackgroundResource(R.drawable.hangman7)
                            binding.textView2.setText("Chances left: 6")}
                        6 -> {binding.imageView.setBackgroundResource(R.drawable.hangman6)
                            binding.textView2.setText("Chances left: 5")}
                        5 -> {binding.imageView.setBackgroundResource(R.drawable.hangman5)
                            binding.textView2.setText("Chances left: 4")}
                        4 -> {binding.imageView.setBackgroundResource(R.drawable.hangman4)
                            binding.textView2.setText("Chances left: 3")}
                        3 -> {binding.imageView.setBackgroundResource(R.drawable.hangman3)
                            binding.textView2.setText("Chances left: 2")}
                        2 -> {binding.imageView.setBackgroundResource(R.drawable.hangman2)
                            binding.textView2.setText("Chances left: 1")}
                    }

                }
                else
                {
                    binding.imageView.setBackgroundResource(R.drawable.hangman1)
                    var tmpText = "You lost :( -"
                    tmpText+=word
                    tmpText+="-"
                    binding.textView2.setText(tmpText)
                    for(i in 0..25)
                    {
                        usedLetters[i]++
                    }
                }
            }
        }

    }
}