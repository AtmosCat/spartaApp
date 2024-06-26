package com.example.spartacodingapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SignUpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_signup)

        val signUpName = findViewById<EditText>(R.id.et_signUpName)
        val signUpId = findViewById<EditText>(R.id.et_signUpId)
        val signUpPw = findViewById<EditText>(R.id.et_signUpPw)

        val btn_signUp = findViewById<Button>(R.id.btn_signUp)

        btn_signUp.setOnClickListener{
            if (signUpName.text.isEmpty() == true || signUpId.text.isEmpty() == true || signUpPw.text.isEmpty() == true){
                Toast.makeText(this, "입력되지 않은 정보가 있습니다.", Toast.LENGTH_SHORT).show()
            } else {
                val intent = Intent(this, SignInActivity::class.java)
                intent.putExtra("id", signUpId.text.toString())
                intent.putExtra("pw", signUpPw.text.toString())
                setResult(RESULT_OK, intent)
                finish()
            }
        }


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}