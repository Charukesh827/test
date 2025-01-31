package com.example.preexam

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editTextName = findViewById<EditText>(R.id.editTextName)
        val editTextPhone = findViewById<EditText>(R.id.editTextPhone)
        val radioGroupGender = findViewById<RadioGroup>(R.id.radioGroupGender)
        val checkboxFood1 = findViewById<CheckBox>(R.id.checkboxFood1)
        val checkboxFood2 = findViewById<CheckBox>(R.id.checkboxFood2)
        val ratingBar = findViewById<RatingBar>(R.id.ratingBar)

        findViewById<Button>(R.id.buttonSubmit).setOnClickListener {
            val name = editTextName.text.toString()
            val phone = editTextPhone.text.toString()
            val genderId = radioGroupGender.checkedRadioButtonId
            val gender = if (genderId != -1) findViewById<RadioButton>(genderId).text else "Not specified"

            if (name.isEmpty() || phone.isEmpty()) {
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val foodsOrdered = mutableListOf<String>()
            if (checkboxFood1.isChecked) foodsOrdered.add(checkboxFood1.text.toString())
            if (checkboxFood2.isChecked) foodsOrdered.add(checkboxFood2.text.toString())

            val rating = ratingBar.rating

            // Pass data to the next screen
            val intent = Intent(this, SecondActivity::class.java).apply {
                putExtra("NAME", name)
                putExtra("PHONE", phone)
                putExtra("GENDER", gender)
                putExtra("FOODS_ORDERED", foodsOrdered.toTypedArray())
                putExtra("RATING", rating)
            }
            startActivity(intent)
        }
    }
}
