package com.example.testmatrialdesgin

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.content.res.AppCompatResources
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {

    private lateinit var textInputLayout: TextInputLayout
    private lateinit var textInputEditText: TextInputEditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textInputLayout = findViewById(R.id.textInputLayout)
        textInputEditText = findViewById(R.id.textInputEditText)

        textInputEditText.background =
            AppCompatResources.getDrawable(
                this.baseContext,
                R.drawable.custom_edittext_background
            ) // Set default background

        textInputEditText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                // Not needed in this example
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                val inputText = s.toString().trim()
                if (inputText.isEmpty()) {
                    // Set the background to show red border
                    textInputEditText.background =
                        AppCompatResources.getDrawable(
                            baseContext,
                            R.drawable.custom_edittext_error_background
                        ) // Set error background
                    textInputLayout.helperText = "safljdalskjfsajlksa"
                    textInputLayout.setHelperTextTextAppearance(R.style.HelperTextAppearance)
                } else {
                    // Reset to default background
                    textInputEditText.background =
                        AppCompatResources.getDrawable(
                            baseContext,
                            R.drawable.custom_edittext_background
                        ) // Set default background
                    textInputLayout.helperText = ""
                }
            }

            override fun afterTextChanged(s: Editable?) {
                // Not needed in this example
            }
        })
    }
}



