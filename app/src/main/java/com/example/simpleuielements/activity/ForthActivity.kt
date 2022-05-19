package com.example.simpleuielements.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatDelegate
import com.example.simpleuielements.R
import com.example.simpleuielements.adapter.ListAdapter
import com.example.simpleuielements.util.ObjectList
import com.example.simpleuielements.util.ObjectList.footballerList
import com.example.simpleuielements.util.toast

class ForthActivity : AppCompatActivity() {

    private lateinit var listView: ListView
    private lateinit var listAdapter: ListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forth)

        initViews()

    }

    private fun initViews() {
        listView = findViewById(R.id.listView)
        listAdapter = ListAdapter(this, footballerList())
        listView.adapter = listAdapter
    }
}