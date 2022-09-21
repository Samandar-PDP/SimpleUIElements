package com.example.simpleuielements.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.speech.RecognizerIntent
import android.speech.tts.TextToSpeech
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import androidx.appcompat.widget.AppCompatTextView
import com.example.simpleuielements.R
import com.example.simpleuielements.util.toast
import java.util.*
import kotlin.collections.ArrayList

class FiveThActivity : AppCompatActivity() {
    private var textToSpeech: TextToSpeech? = null
    private lateinit var button: Button
    private lateinit var textView: AppCompatTextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_five_th)

        speechToText()
        textToSpeech()

    }
    private fun speechToText() {
        val button1: ImageButton = findViewById(R.id.btnVoice)
        textView = findViewById(R.id.textVoice)

        button1.setOnClickListener {
            val intent = Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH)
            intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM)
            intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault())
            intent.putExtra(RecognizerIntent.EXTRA_PROMPT, "Say something..")
            try {
                startActivityForResult(intent, 100)
            } catch (e: Exception) {
                toast(e.stackTraceToString())
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 100) {
            if (resultCode == RESULT_OK || data != null) {
                val res: ArrayList<String> = data?.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS)!!
                textView.text = res[0]
            }
        }
    }

    private fun textToSpeech() {
        textToSpeech = TextToSpeech(this, listener())
        val editText: EditText = findViewById(R.id.editText)
        button = findViewById(R.id.btnSpeech)
        button.setOnClickListener {
            val speechText = editText.text.toString().trim()
            textToSpeech?.speak(speechText, TextToSpeech.QUEUE_FLUSH, null)
            toast(speechText)
        }
    }
    private fun listener() = TextToSpeech.OnInitListener { status ->
        if (status == TextToSpeech.SUCCESS) {
            val res = textToSpeech?.setLanguage(Locale.US)
            if (res == TextToSpeech.LANG_MISSING_DATA || res == TextToSpeech.LANG_NOT_SUPPORTED) {
                toast("Language not supported")
            } else {
                button.isEnabled = true
                textToSpeech()
            }
        }
    }

    override fun onDestroy() {
        if (textToSpeech != null) {
            textToSpeech?.stop()
            textToSpeech?.shutdown()
        }
        super.onDestroy()
    }
}