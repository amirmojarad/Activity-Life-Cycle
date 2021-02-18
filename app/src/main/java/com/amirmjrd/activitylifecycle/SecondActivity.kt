package com.amirmjrd.activitylifecycle

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView

class SecondActivity : AppCompatActivity() {

    var linearLayout: LinearLayout? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        linearLayout = findViewById(R.id.second_layout)
        changeColor()
    }

    fun changeColor() {
        var color = intent.extras?.get("BACKGROUND_COLOR")
        linearLayout?.setBackgroundColor(color as Int)
    }

    fun back(view: View) {
        var intent = Intent(
            this, MainActivity::class.java
        )
        startActivity(intent)
    }
}