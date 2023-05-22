package com.example.pos_open_payment_client

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class ClientActivity : AppCompatActivity() {

    private lateinit var edt_message : EditText
    private lateinit var btn_send: Button

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_client)

        edt_message = findViewById(R.id.edt_result)
        btn_send = findViewById(R.id.bt_send)

        btn_send.setOnClickListener {
            val intent = Intent()
            intent.putExtra("result", edt_message.text.toString())
            setResult(78, intent)

            super.onBackPressed()
        }
    }
}