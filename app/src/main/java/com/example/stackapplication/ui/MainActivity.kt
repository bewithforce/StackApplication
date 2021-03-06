package com.example.stackapplication.ui

import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.*
import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import com.example.stackapplication.R

import com.example.stackapplication.logic.Stack

import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private lateinit var linearLayoutManager: LinearLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val stack = Stack<String>()

        linearLayoutManager = LinearLayoutManager(this)
        button_push.setOnClickListener {
            val editable = textInputLayout!!.editText!!.text
            if (editable.isNotEmpty()) {
                stack.push(editable.toString())
                textInputLayout.editText!!.setText("")
                textView.text = stack.toString()
            } else
                textInputLayout.error = "bad input"
        }

        textInputLayout.editText!!.setOnClickListener{ textInputLayout.error = ""}
        textInputLayout.editText!!.setOnKeyListener(View.OnKeyListener { _, keyCode, event ->
            if (keyCode == KeyEvent.KEYCODE_ENTER && event.action == KeyEvent.ACTION_UP) {
                button_push.performClick()
                return@OnKeyListener true
            }
            false
        })

        button_top.setOnClickListener { textInputLayout.editText?.setText(stack.top()) }
        button_pop.setOnClickListener {
            textInputLayout.editText?.setText(stack.pop())
            textView.text = stack.toString()
        }

    }

}
