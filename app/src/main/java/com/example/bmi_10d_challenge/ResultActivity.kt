package com.example.bmi_10d_challenge

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.a10dchallange_imc.R


class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val result = intent.getFloatExtra(KEY_RESULT, 0f)

        val tvResult = findViewById<TextView>(R.id.tv_result)
        val tvClassifier = findViewById<TextView>(R.id.tv_classifier)

        tvResult.text = result.toString()

        val classifier: String = if(result <= 18.5f){
            THINNESS
        } else if (result <= 18.5f && result <= 24.9f){
            NORMAL
        }else if (result <= 25f && result <= 29.9f){
            OVERWEIGHT
        }else if (result <= 30f && result <= 39.9f){
            OBESITY
        } else{
            SEVERE_OBESITY
        }

        tvClassifier.text = classifier

    }
}

const val KEY_RESULT = "ResultActivity.KEY_BMI"
const val THINNESS = "Thinness"
const val NORMAL = "Normal"
const val OVERWEIGHT = "Overweight"
const val OBESITY = "Obesity"
const val SEVERE_OBESITY = "Severe obesity"


