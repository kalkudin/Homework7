package com.example.homework7

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.InputType
import android.util.TypedValue
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.Toast
import com.example.homework7.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding:ActivityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.addButton.setOnClickListener{
            val inputText:String = binding.inputField.text.toString()
            val isChecked:Boolean = binding.numericCheckbox.isChecked
            val linearLayout: LinearLayout = binding.containerForFields
            if(checkEmptyField(inputText)){
                Toast.makeText(this, "Please Fill in the Field", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            makeNewTextField(isChecked,linearLayout)
        }
    }

    private fun makeNewTextField(fieldIsNumeric:Boolean, linearLayout:LinearLayout){
        val newEditText:EditText = EditText(this)
        val params = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        )
        newEditText.maxLines = 1
        newEditText.layoutParams = params
        newEditText.setTextSize(TypedValue.COMPLEX_UNIT_SP,14f)

        if(!fieldIsNumeric){
            newEditText.inputType = InputType.TYPE_CLASS_TEXT
            newEditText.hint = "TEXT"
        }
        else{
            newEditText.inputType = InputType.TYPE_CLASS_NUMBER
            newEditText.hint = "NUMERIC"
        }
        linearLayout.addView(newEditText)
    }

    private fun checkEmptyField(input:String):Boolean{
        return input.isNullOrBlank()
    }
}

