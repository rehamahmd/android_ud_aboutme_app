package com.example.aboutme

import android.content.Context
import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.example.aboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var editText : TextView;
    private lateinit var nicknameText : TextView;
    private lateinit var doneButton : TextView;
    private lateinit var binding : ActivityMainBinding;
    private val myName : MyName = MyName("Reham Ahmed");
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        binding.myName = myName
        nicknameText = binding.nicknameText;
        editText = binding.nicknameEdit;
        doneButton = binding.doneButton;
        doneButton.setOnClickListener {
            addNickname(it)
        }
        nicknameText.setOnClickListener {
            editNickname(it)
        }
    }

   private fun addNickname(view: View){
       binding.apply {
           nicknameText.text = editText.text;
           invalidateAll();
           view.visibility = View.GONE;
           editText.visibility = View.GONE;
           nicknameText.visibility = View.VISIBLE;
           myName?.nickName = editText.text.toString();
       }
       val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
       imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
    private fun editNickname(view: View){
        binding.apply {
            nicknameText.text = "";
            editText.text = "";
            invalidateAll();
            view.visibility = View.VISIBLE;
            editText.visibility = View.VISIBLE;
            doneButton.visibility = View.VISIBLE;
            nicknameText.visibility = View.GONE;
            myName?.nickName = "";
        }
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
}