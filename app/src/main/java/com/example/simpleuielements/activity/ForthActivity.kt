package com.example.simpleuielements.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import com.example.simpleuielements.R
import com.example.simpleuielements.util.toast

class ForthActivity : AppCompatActivity() {

    private val languages = arrayOf(
        "Java",
        "Kotlin",
        "Dart",
        "JavaScript",
        "C++",
        "C",
        "Python",
        "HTML",
        "CSS",
        "Angular",
        "Android",
        "Flutter",
        "Swift",
        "iOS",
        "KMM",
        "Jetpack Compose"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forth)

        initViews()

    }

    private fun initViews() {
        val listView: ListView = findViewById(R.id.listView)
        val arrAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, languages)
        listView.adapter = arrAdapter
        listView.setOnItemClickListener { parent, view, position, id ->
            toast("Clicked ${position.plus(1)}")
        }
    }
}