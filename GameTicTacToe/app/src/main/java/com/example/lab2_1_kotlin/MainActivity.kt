package com.example.lab2_1_kotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private var LastGameResultText3x3 = "No games played before..."
    private var LastGameResultText5x5 = "No games played before..."

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun button3x3(view: View) {
        val game3x3 = Intent(this, ThreeOnThree::class.java)
        startActivityForResult(game3x3, 333)
    }


    fun button5x5(view: View) {
        val game5x5 = Intent(this, FiveOnFive::class.java)
        startActivityForResult(game5x5, 555)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == 333)
        {
            LastGameResultText3x3 = data?.getStringExtra("result").toString()
        }
        else if(requestCode == 555)
        {
            LastGameResultText5x5 = data?.getStringExtra("result").toString()
        }

    }

    fun buttonLastGame(view: View) {
        Toast.makeText(this, LastGameResultText3x3, Toast.LENGTH_SHORT).show();
    }

    fun buttonLastGame5x5(view: View) {
        Toast.makeText(this, LastGameResultText5x5, Toast.LENGTH_SHORT).show();
    }

}
