package com.example.simpleuielements.activity

import android.app.AlertDialog
import android.app.ProgressDialog
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.Message
import android.view.LayoutInflater
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.simpleuielements.R
import com.example.simpleuielements.util.toast

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        initViews()

    }

    private fun initViews() {
        allDialog()
    }

    private fun allDialog() {
        findViewById<View>(R.id.simpleDialog).setOnClickListener { simpleDialog() }
        findViewById<View>(R.id.singleSelectionDialog).setOnClickListener { singleChoiceDialog() }
        findViewById<View>(R.id.multiSelectionDialog).setOnClickListener { multiSelectionDialog() }
        findViewById<View>(R.id.confirmDialog).setOnClickListener { confirmDialog() }
        findViewById<View>(R.id.fullScreenDialog).setOnClickListener { fullScreenDialog() }
        findViewById<View>(R.id.progressDialog).setOnClickListener { progressDialog() }
        findViewById<View>(R.id.customDialog).setOnClickListener { customAlertDialog() }
        findViewById<View>(R.id.horizontalProgressDialog).setOnClickListener { horizontalProgressDialog() }

        findViewById<View>(R.id.btnGoThird).setOnClickListener {
            val intent = Intent(this, ForthActivity::class.java)
            startActivity(intent)
        }
    }

    private fun simpleDialog() {
        val alertDialog = AlertDialog.Builder(this).create()
        alertDialog.setTitle("Simple AlertDialog")
        alertDialog.setMessage("please click this option")
        alertDialog.setButton(
            AlertDialog.BUTTON_NEUTRAL,
            "OK"
        ) { dialog: DialogInterface, _: Int ->
            dialog.dismiss()
        }
        alertDialog.show()
    }

    private fun confirmDialog() {
        val alertDialog = AlertDialog.Builder(this)
            .create()
        alertDialog.setTitle("Confirm AlertDialog")
        alertDialog.setMessage("This is Confirm Alert Dialog")
        alertDialog.setButton(
            AlertDialog.BUTTON_POSITIVE,
            "ACCEPT"
        ) { dialog: DialogInterface, _: Int -> dialog.dismiss() }
        alertDialog.setButton(
            AlertDialog.BUTTON_NEGATIVE,
            "DECLINE"
        ) { dialog: DialogInterface, _: Int -> dialog.dismiss() }
        alertDialog.show()
    }

    private fun multiSelectionDialog() {
        val choices = arrayOf<CharSequence>("Choice 1", "Choice 2", "Choice 3")
        val choicesInitial = booleanArrayOf(true, false, true)
        val alertDialog =
            AlertDialog.Builder(this).setTitle("Choice Option").setPositiveButton("Accept", null)
                .setNeutralButton("Cancel", null).setMultiChoiceItems(
                    choices,
                    choicesInitial
                ) { _: DialogInterface?, _: Int, _: Boolean -> }
        alertDialog.show()
    }

    private fun singleChoiceDialog() {
        val alertDialog =
            AlertDialog.Builder(this)
        alertDialog.setTitle("Single Choice Dialog")
        alertDialog.setPositiveButton("OK", null)
        alertDialog.setNeutralButton("Cancel", null)
        val items = arrayOf("Java", "Kotlin", "Dart")
        val checkItem = 1
        alertDialog.setSingleChoiceItems(items, checkItem) { _: DialogInterface?, which: Int ->
            when (which) {
                0 -> toast("Java")
                1 -> toast("Kotlin")
                2 -> toast("Dart")
            }
        }
        alertDialog.show()
    }

    private fun progressDialog() {
        val progressDialog = ProgressDialog(this)
        progressDialog.setTitle("Circular Progress Dialog")
        progressDialog.setMessage("Loading...")
        progressDialog.show()
    }

    private fun horizontalProgressDialog() {
        val progressDialog =
            ProgressDialog(this)
        progressDialog.max = 100
        progressDialog.setTitle("Horizontal Progress Dialog")
        progressDialog.setMessage("Loading...")
        progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL)
        progressDialog.show()
        val handler: Handler = object : Handler(Looper.getMainLooper()) {
            override fun handleMessage(
                msg: Message
            ) {
                super.handleMessage(msg)
                progressDialog.incrementProgressBy(5)
            }
        }
        Thread {
            try {
                while (progressDialog.progress <= progressDialog.max) {
                    Thread.sleep(200)
                    handler.sendMessage(handler.obtainMessage())
                    if (progressDialog.progress == progressDialog.max) {
                        progressDialog.dismiss()
                    }
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }.start()
    }

    private fun customAlertDialog() {
        val factory = LayoutInflater.from(this)
        val dialogView: View = factory.inflate(R.layout.alert_dialog_custom, null)
        val dialog = AlertDialog.Builder(this).create()
        dialog.setView(dialogView)
        dialogView.findViewById<View>(R.id.btnYes).setOnClickListener { dialog.dismiss() }
        dialogView.findViewById<View>(
            R.id.btnNo
        ).setOnClickListener { dialog.dismiss() }
        dialog.show()
    }

    private fun fullScreenDialog() {
        val alertDialog = AlertDialog.Builder(
            this,
            android.R.style.Theme_DeviceDefault_Light_NoActionBar_Fullscreen
        )
            .create()
        alertDialog.setTitle("Full Screen AlertDialog")
        alertDialog.setMessage("This is Full Screen Alert Dialog")
        alertDialog.setButton(
            AlertDialog.BUTTON_NEUTRAL,
            "OK"
        ) { dialog: DialogInterface, _: Int -> dialog.dismiss() }
        alertDialog.show()
    }
}
