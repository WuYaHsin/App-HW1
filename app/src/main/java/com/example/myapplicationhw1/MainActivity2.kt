package com.example.myapplicationhw1

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        intent?.extras?.let {
            val name = it.getString("Key1")
            val sex = it.getString("Key2")

            val editText3 = findViewById<EditText>(R.id.editText3)
            val editText4 = findViewById<EditText>(R.id.editText4)
            val send2 = findViewById<Button>(R.id.button2)
            send2.setOnClickListener {
                val bundle = Bundle()
                val size = editText3.text.toString()
                val color = editText4.text.toString()
                bundle.putString("Key1", name)
                bundle.putString("Key2", sex)
                bundle.putString("Key3", size)
                bundle.putString("Key4", color)

                val intent = Intent().putExtras(bundle)
                setResult(Activity.RESULT_OK, intent.putExtras(bundle))
                finish()
            }
        }
    }
}