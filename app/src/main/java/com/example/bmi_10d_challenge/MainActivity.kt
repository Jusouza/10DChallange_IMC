package com.example.bmi_10d_challenge

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.a10dchallange_imc.R
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val edtWeight = findViewById<TextInputEditText>(R.id.edt_weight)
        val edtHeight = findViewById<TextInputEditText>(R.id.edt_height)
        val btnCalculate = findViewById<Button>(R.id.btn_calculate)

        btnCalculate.setOnClickListener {

            val weightStr : String = edtWeight.text.toString()
            val heightStr : String = edtHeight.text.toString()

            if (weightStr.isEmpty() || heightStr.isEmpty()){
                Snackbar.make(
                    edtWeight,
                    ERROR_MASSAGE,
                    Snackbar.LENGTH_LONG
                ).show()
            } else {
                val weight = weightStr.toFloat()
                val height = heightStr.toFloat()

                val heightQ2 = height * height
                val result = weight / heightQ2

                val intent = Intent(this, ResultActivity::class.java)
                intent.putExtra(KEY_RESULT, result)
                startActivity(intent)
                println(result)
            }
        }

    }
}
const val ERROR_MASSAGE = "Fill all the fields to continue"
