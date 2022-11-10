package com.example.activity_kotin

import androidx.appcompat.app.AppCompatActivity
import android.widget.EditText
import android.widget.RadioGroup
import android.os.Bundle
import com.example.activity_kotin.R
import android.content.Intent
import android.view.View
import android.widget.Button

class MainActivity2 : AppCompatActivity() {
    private lateinit var sendbtn: Button
    private lateinit var setdrink: EditText
    private lateinit var rg1: RadioGroup
    private lateinit var rg2: RadioGroup
    private var sugar = "無糖"
    private var iceopt = "去冰"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        rg1 = findViewById(R.id.radioGroup)
        rg1.setOnCheckedChangeListener(RadioGroup.OnCheckedChangeListener { radioGroup, i ->
            when (i) {
                R.id.radioButton1 -> sugar = "無糖"
                R.id.radioButton2 -> sugar = "少糖"
                R.id.radioButton3 -> sugar = "半糖"
                R.id.radioButton4 -> sugar = "全糖"
            }
        })
        rg2 = findViewById(R.id.radioGroup2)
        rg2.setOnCheckedChangeListener(RadioGroup.OnCheckedChangeListener { radioGroup, i ->
            when (i) {
                R.id.radioButton5 -> iceopt = "去冰"
                R.id.radioButton6 -> iceopt = "微冰"
                R.id.radioButton7 -> iceopt = "少冰"
                R.id.radioButton8 -> iceopt = "正常冰"
            }
        })
        sendbtn = findViewById(R.id.btn_send)
        sendbtn.setOnClickListener(View.OnClickListener {
            setdrink = findViewById(R.id.ed_drink)
            val drink = setdrink.getText().toString()
            val i = Intent()
            val b = Bundle()
            b.putString("sugar", sugar)
            b.putString("drink", drink)
            b.putString("ice", iceopt)
            i.putExtras(b)
            setResult(101, i)
            finish()
        })
    }
}