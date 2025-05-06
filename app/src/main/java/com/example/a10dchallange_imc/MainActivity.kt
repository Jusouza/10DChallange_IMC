package com.example.a10dchallange_imc

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
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
                    "Preencha todos os campos",
                    Snackbar.LENGTH_LONG
                ).show()
            } else {
                val weight = weightStr.toFloat()
                val height = heightStr.toFloat()

                val heightQ2 = height * height
                val result = weight / heightQ2

                //navegar para a proxima tela
                //criar o layout da proxima tela
                //paasar os dados da proxima tela

                //intent - classe do proprio android

                val intent = Intent(this, ResultActivity::class.java)
                intent.putExtra(KEY_RESULT_IMC, result)
                startActivity(intent)
                println(result)
            }
        }

    }
}