package com.amirmjrd.activitylifecycle

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import kotlin.properties.Delegates
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private var linearLayout: LinearLayout? = null
    private var close: Button? = null
    private var openAnotherActivity: Button? = null
    private var changeBackgroundColor: Button? = null
    private var color by Delegates.notNull<Int>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        linearLayout = findViewById(R.id.linearLayout)
        close = findViewById(R.id.close)
        changeBackgroundColor = findViewById(R.id.changeBackgroundColor)
        openAnotherActivity = findViewById(R.id.openAnotherActivity)
    }

    fun changeBackgroundColor(view: View) {
        color = Color.argb(
            255,
            Random.nextInt(0, 255),
            Random.nextInt(0, 255),
            Random.nextInt(0, 255)
        )
        linearLayout?.setBackgroundColor(color)
    }

    fun openAnotherActivity(view: View) {
        var intent = Intent(this, SecondActivity::class.java).apply {
            putExtra("BACKGROUND_COLOR", color)
        }
        startActivity(intent)
    }

    fun closeActivity(view: View) {
        finish()
    }
}