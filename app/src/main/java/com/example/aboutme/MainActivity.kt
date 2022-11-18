package com.example.aboutme

import android.content.Context
import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var editText : TextView;
    private lateinit var nicknameText : TextView;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        nicknameText = findViewById(R.id.nickname_text);
        editText = findViewById(R.id.nickname_edit);
        findViewById<Button>(R.id.done_button).setOnClickListener {
            addNickname(it)
        }
    }

   private fun addNickname(view: View){
        nicknameText.text = editText.text;
        view.visibility = View.GONE;
        editText.visibility = View.GONE;
        nicknameText.visibility = View.VISIBLE;

       val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
       imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
}