package com.example.yodaspeech

import MySingleton
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var itText : String? = null
    var rText : String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        submitButton.setOnClickListener {
            itText = inputText.text.toString()
            var url = "https://yoda-api.appspot.com/api/v1/yodish?text=$itText"     //getting user input to convert
//            Toast.makeText(this, "$itText", Toast.LENGTH_LONG).show()
            var jsonObjectRequest = JsonObjectRequest(Request.Method.GET, url, null, Response.Listener { response ->

                // On successful response do this->

                rText = response.getString("yodish")
//                Toast.makeText(this, "$rText", Toast.LENGTH_LONG).show()
                val intent = Intent(this, resultActivity::class.java)
                Log.d("text", rText)
                intent.putExtra("result_text", rText.toString())
                startActivity(intent)
//                Log.d("response message", rText)


            }, Response.ErrorListener { error ->
                //incase you get an error

//                Toast.makeText(this, error.toString(), Toast.LENGTH_LONG).show()
                Log.d("error message", error.toString())

            })


            MySingleton.getInstance(this).addToRequestQueue(jsonObjectRequest)  //using MySingleton class to add requests in volley queue

        }


    }
}
