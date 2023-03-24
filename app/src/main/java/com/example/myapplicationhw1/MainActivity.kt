package com.example.myapplicationhw1

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editText = findViewById<EditText>(R.id.editText)
        val editText2 = findViewById<EditText>(R.id.editText2)
        val send = findViewById<Button>(R.id.button)

        send.setOnClickListener {
            val bundle = Bundle()
            val name = editText.text.toString()
            val sex = editText2.text.toString()
            bundle.putString("Key1", name)
            bundle.putString("Key2", sex)

            val intent = Intent(this,MainActivity2::class.java)
            intent.putExtras(bundle)
            startActivityForResult(intent,1)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        data?.extras?.let{
            if(resultCode == Activity.RESULT_OK){
                val editText = findViewById<EditText>(R.id.editText)
                val editText2 = findViewById<EditText>(R.id.editText2)
                editText.setVisibility(View.GONE)
                editText2.setVisibility(View.GONE)

                findViewById<TextView>(R.id.textView).text=
                    "名字： ${it.getString("Key1")}\n\n" +
                    "性別： ${it.getString("Key2")}\n\n"
                findViewById<TextView>(R.id.textView2).text=
                    "尺寸： ${it.getString("Key3")}\n\n" +
                            "顏色： ${it.getString("Key4")}\n\n"
            }
        }
    }
}