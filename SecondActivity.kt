package com.example.preexam

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val name = intent.getStringExtra("NAME")
        val phone = intent.getStringExtra("PHONE")
        val gender = intent.getStringExtra("GENDER")
        val foodsOrdered = intent.getStringArrayExtra("FOODS_ORDERED")?.joinToString(", ")
        val rating = intent.getFloatExtra("RATING", 0f)

        // Display the formatted data in TextViews or other UI elements as needed.

        findViewById<Button>(R.id.button2).setOnClickListener{
            findViewById<TextView>(R.id.textView2).setText(name+" - "+phone+" - "+gender)
        }
    }
}