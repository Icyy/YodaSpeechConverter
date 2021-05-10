package com.example.yodaspeech

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_result.*

@Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
class resultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val rtext:String = intent.getStringExtra("result_text") //fetching text from the intent
        Log.d("resutl", rtext.toString())
        rstext.text = rtext //displaying the converted text on this activity
        copyButton.setOnClickListener {

            //copying text incase the copy button is pressed

            val clipboardManager = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
            val clipData = ClipData.newPlainText("text", rtext)
            clipboardManager.setPrimaryClip(clipData)
            Toast.makeText(this, "Copied Yoda's message", Toast.LENGTH_LONG).show()
        }

    }

    fun goBack(view: View) {

        //incase the user presses the back arrow do this, going back to the previous activity

        val int = Intent(this, MainActivity::class.java)
        startActivity(int)

    }

}
