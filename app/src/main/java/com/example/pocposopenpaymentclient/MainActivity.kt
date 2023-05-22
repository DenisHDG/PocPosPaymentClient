package com.example.pocposopenpaymentclient

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import com.example.pos_open_payment_client.ClientActivity

class MainActivity : AppCompatActivity() {

    private val TAG = "MainActivity"

    private lateinit var button: Button
    private lateinit var text: TextView

    private var resultLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            Log.d(TAG, "onActivityResult: ")
            if (result.resultCode == 78) {
                val intent = result.data

                if (intent != null) {
                    val data = intent.getStringExtra("result")
                    text.setText(data)
                }
            }
        }


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button = findViewById(R.id.bt_nav)
        text = findViewById(R.id.tv_hello)

        button.setOnClickListener {
            val intent = Intent(this, ClientActivity::class.java)
            resultLauncher.launch(intent)
        }
    }
}