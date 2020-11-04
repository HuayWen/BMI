package com.example.bmi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import kotlin.math.pow
import kotlin.math.round

//variable : Type(Class)
//val = value(not changed), var = variable(can change)
//E.g. val pi: Double = 3.142
//E.g. var number : Float
//fun is function

class MainActivity : AppCompatActivity() {
    //Global variable

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Display UI
        setContentView(R.layout.activity_main)
        //Link UI to program code
        val editTextWeight: EditText = findViewById(R.id.editTextWeight)
        val editTextHeight: EditText = findViewById(R.id.editTextHeight)
        val buttonCalculate: Button = findViewById(R.id.buttonCalculate)
        val textViewBMI: TextView = findViewById(R.id.textViewBMI)
        var img : ImageView = findViewById(R.id.imageViewBMI)

        buttonCalculate.setOnClickListener {
            //To retrieve value from a View
            //retrieve string and convert to double store to var
            val weight: Double = editTextWeight.text.toString().toDouble()
            val height: Double = editTextHeight.text.toString().toDouble()
            val bmi = weight/(height/100).pow(2)
            var bmiText = ""

            //TODO: Determine status of BMI and present result to the user
            if (bmi<18.5) {
                img.setImageResource(R.drawable.under)
                bmiText = "Underweight"
            } else if (bmi<25) {
                img.setImageResource(R.drawable.normal)
                bmiText = "Normal"
            } else {
                img.setImageResource(R.drawable.over)
                bmiText = "Overweight"
            }

            //Underweight = <18.5
            //Normal weight = 18.5–24.9
            //Overweight = >= 25
            textViewBMI.text = "BMI:" + round(bmi).toString() + ", Status:" + bmiText
        }//end of onClickListener


    }//end of func
}//end of class