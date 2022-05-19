package com.example.simpleuielements.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.simpleuielements.R
import com.example.simpleuielements.model.Footballer
import com.google.android.material.imageview.ShapeableImageView

class ListAdapter(
    private val context: Context,
    private val footballerList: ArrayList<Footballer>
): BaseAdapter() {

    private val layoutInflater: LayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    override fun getCount(): Int {
        return footballerList.size
    }

    override fun getItem(position: Int): Any {
        return footballerList[position]
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    @SuppressLint("ViewHolder")
    override fun getView(pos: Int, p1: View?, parent: ViewGroup): View {

        val itemLayout = layoutInflater.inflate(R.layout.item_layout, parent, false)

        val textName: TextView = itemLayout.findViewById(R.id.textName)
        val textLastName: TextView = itemLayout.findViewById(R.id.textLastName)
        val imageView: ImageView = itemLayout.findViewById(R.id.imageView)
        val isOnlineView: View = itemLayout.findViewById(R.id.onlineView)
        val textMessageCounter: TextView = itemLayout.findViewById(R.id.messageCounterText)

        val footballer = footballerList[pos]

        textName.text = footballer.name
        textLastName.text = footballer.lastName
        textMessageCounter.text = footballer.messageCount.toString()
        imageView.setImageResource(footballer.image)

        if (footballer.isOnline) {
            isOnlineView.setBackgroundResource(R.drawable.is_online_shape)
        } else {
            isOnlineView.setBackgroundResource(R.drawable.is_offline)
        }

        return itemLayout
    }
}