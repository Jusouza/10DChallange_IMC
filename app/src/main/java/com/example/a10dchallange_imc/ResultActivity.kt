package com.example.a10dchallange_imc

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat



class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val result = intent.getFloatExtra(KEY_RESULT_IMC, 0f)

        val tvResult = findViewById<TextView>(R.id.tv_result)
        val tvClassifier = findViewById<TextView>(R.id.tv_classifier)

        tvResult.text = result.toString()

        val classifier: String = if(result <= 18.5f){
            MAGREZA
        } else if (result <= 18.5f && result <= 24.9f){
            NORMAL
        }else if (result <= 25f && result <= 29.9f){
            SOBREPESO
        }else if (result <= 30f && result <= 39.9f){
            OBESIDADE
        } else{
            OBESIDADE_GRAVE
        }

        tvClassifier.text = classifier

    }
}

const val KEY_RESULT_IMC = "ResultActivity.KEY_IMC"
const val MAGREZA = "Magreza"
const val NORMAL = "Normal"
const val SOBREPESO = "Sobrepeso"
const val OBESIDADE = "Obesidade"
const val OBESIDADE_GRAVE = "Obesidade grave"


