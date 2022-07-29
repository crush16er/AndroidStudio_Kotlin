package com.example.lab3_1_kotlin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.SnapHelper


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerview = findViewById<RecyclerView>(R.id.myrecyclerview)

        recyclerview.layoutManager = LinearLayoutManager(
                this,
                LinearLayoutManager.VERTICAL,
                false
        )
        recyclerview.adapter = CustomAdapter(generateData())
        //recyclerview.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.HORIZONTAL))
        val helper: SnapHelper = LinearSnapHelper()
        helper.attachToRecyclerView(recyclerview)
    }

    private fun generateData() : List<String> {
        val data : MutableList<String> = ArrayList()
        for (i in 0..100) {
            data.add(i.toString() + " - element")
        }
        return data
    }
}