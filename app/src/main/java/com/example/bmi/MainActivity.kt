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
    //lateinit = late initialize, not yet assign value
    private lateinit var editTextWeight:EditText
    private lateinit var editTextHeight:EditText
    private lateinit var textViewBMI:TextView
    private lateinit var imageViewBMI: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Display UI
        setContentView(R.layout.activity_main)
        //Link UI to program code
        val editTextWeight: EditText = findViewById(R.id.editTextWeight)
        val editTextHeight: EditText = findViewById(R.id.editTextHeight)
        val buttonCalculate: Button = findViewById(R.id.buttonCalculate)
        val textViewBMI: TextView = findViewById(R.id.textViewBMI)
        imageViewBMI = findViewById(R.id.imageViewBMI)
        val buttonReset:Button = findViewById(R.id.buttonReset)
        buttonReset.setOnClickListener{
            editTextWeight.text = null
            editTextHeight.text.clear()
            textViewBMI.text = null
        }

        buttonCalculate.setOnClickListener {
            //To retrieve value from a View
            //retrieve string and convert to double store to var
            val weight: Double = editTextWeight.text.toString().toDouble()
            val height: Double = editTextHeight.text.toString().toDouble()
            val bmi = weight/(height/100).pow(2)
            var status : String

            if (bmi<=18.5) {
                imageViewBMI.setImageResource(R.drawable.under)
                status = getString(R.string.underweight)
            } else if (bmi<25) {
                imageViewBMI.setImageResource(R.drawable.normal)
                status = getString(R.string.normal)
            } else {
                imageViewBMI.setImageResource(R.drawable.over)
                status = getString(R.string.overweight)
            }

            //Underweight = <18.5
            //Normal weight = 18.5–24.9
            //Overweight = >= 25
            //textViewBMI.text = "BMI:" + round(bmi).toString() + ", Status:" + status
            textViewBMI.text = String.format("%s %1.2f %s %s", "BMI:", bmi, ", Status:", status)
        }//end of onClickListener


    }//end of func
}//end of class