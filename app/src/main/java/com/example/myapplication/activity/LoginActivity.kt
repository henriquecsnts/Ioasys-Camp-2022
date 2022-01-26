package com.example.myapplication.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatTextView
import com.example.myapplication.R

class LoginActivity : AppCompatActivity() {

    private val txtError: AppCompatTextView by lazy {
        findViewById(R.id.txt_error)
    }
    private val enterButton: AppCompatButton by lazy {
        findViewById(R.id.enter_button)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        enterButton.setOnClickListener {
            val intent = Intent(this, BookListActivity::class.java)
            startActivity(intent)
        }
    }
}