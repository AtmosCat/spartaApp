package com.example.spartacodingapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.isInvisible
import androidx.lifecycle.findViewTreeViewModelStoreOwner
import kotlin.random.Random

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home)

        val cat1 = findViewById<ImageView>(R.id.iv_cat1)
        val cat2 = findViewById<ImageView>(R.id.iv_cat2)
        val cat3 = findViewById<ImageView>(R.id.iv_cat3)
        val cat4 = findViewById<ImageView>(R.id.iv_cat4)
        val cat5 = findViewById<ImageView>(R.id.iv_cat5)

        var random = (1..5).random()
        if (random == 1){
            cat1.isInvisible = false
        } else if (random == 2){
            cat2.isInvisible = false
        } else if (random == 3){
            cat3.isInvisible = false
        } else if (random == 4){
            cat4.isInvisible = false
        } else {
            cat5.isInvisible = false
        }

        val btn_finish = findViewById<Button>(R.id.btn_finish)

        val homeId = findViewById<TextView>(R.id.tv_introduceId)
        val idData = intent.getStringExtra("userId")
        println(idData)
        homeId.setText("아이디 : ${idData}")

        btn_finish.setOnClickListener{
            finish()
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}