package com.example.simpleuielements.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.example.simpleuielements.R
import com.example.simpleuielements.util.toast
import java.util.*

class TimeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_time)

        val timePicker: TimePicker = findViewById(R.id.timePicker)
        val textCal: TextView = findViewById(R.id.textViewCal)
        val textTime: TextView = findViewById(R.id.textViewTime)
        val calendarView: CalendarView = findViewById(R.id.calendarView)
        calendarView.setOnDateChangeListener { view, year, month, dayOfMonth ->
               textCal.text = "$year/$month/$dayOfMonth"
        }
        timePicker.setOnTimeChangedListener { view, hourOfDay, minute ->
            textTime.text = "$hourOfDay/$minute"
        }
    }
}