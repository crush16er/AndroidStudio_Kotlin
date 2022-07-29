package com.example.lab3_1_kotlin

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView.OnItemLongClickListener
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar


class CustomAdapter(private val data: List<String>) : RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView

        init {
            textView = view.findViewById(R.id.textView)
            view.setOnClickListener {
                Toast.makeText(view.context,
                        "position" + layoutPosition + " text:" + textView.text,
                        Toast.LENGTH_SHORT).show()
            }

            view.setOnLongClickListener {
                Snackbar.make(textView, "Long click $layoutPosition", Snackbar.LENGTH_LONG).show()
                Toast.makeText(view.context,
                        "position" + layoutPosition + " text:" + textView.text,
                        Toast.LENGTH_SHORT).show()
                true
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item_view, parent, false)
        return ViewHolder(view)
    }



    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.textView.text = data[position]
    }

    override fun getItemCount(): Int {
        return data.size
    }

}