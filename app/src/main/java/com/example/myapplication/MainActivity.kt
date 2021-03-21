package com.example.myapplication

import android.annotation.SuppressLint
import android.content.DialogInterface
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private var add = false
    private var sub:Boolean = false
    private var multiply:Boolean = false
    private var divide:Boolean = false
    private var remainder:Boolean = false
    private var deci:Boolean = false
    private var in1: Double = 0.0
    private var i2 = 0.0

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val b1 = findViewById<Button>(R.id.one)
        val b2 = findViewById<Button>(R.id.two)
        val b3 = findViewById<Button>(R.id.three)
        val b4 = findViewById<Button>(R.id.four)
        val b5 = findViewById<Button>(R.id.five)
        val b6 = findViewById<Button>(R.id.six)
        val b7 = findViewById<Button>(R.id.seven)
        val b8 = findViewById<Button>(R.id.eight)
        val b9 = findViewById<Button>(R.id.nine)
        val b0 = findViewById<Button>(R.id.zero)
        val equal = findViewById<Button>(R.id.equal)
        val plus = findViewById<Button>(R.id.plus)
        val minus = findViewById<Button>(R.id.minus)
        val multiplyBtn = findViewById<Button>(R.id.multiply)
        val divideBtn = findViewById<Button>(R.id.divide)
        val remainderBtn = findViewById<Button>(R.id.percent)
        val cancel = findViewById<Button>(R.id.cancel)
        val delete = findViewById<Button>(R.id.delete)
        val point = findViewById<Button>(R.id.point)

        val textView = findViewById<TextView>(R.id.textView)
        val editText = findViewById<EditText>(R.id.editText)
        b1.setOnClickListener(object : DialogInterface.OnClickListener, View.OnClickListener {
            override fun onClick(dialog: DialogInterface?, which: Int) {
            }

            @SuppressLint("SetTextI18n")
            override fun onClick(v: View?) {
                editText.setText(editText.text.toString() + "1")

            }
        })
        b2.setOnClickListener {
            editText.setText(editText.text.toString() + "2")
        }

        b3.setOnClickListener {
            editText.setText(editText.text.toString() + "3")
        }

        b4.setOnClickListener {
            editText.setText(editText.text.toString() + "4")
        }
        b5.setOnClickListener {
            editText.setText(editText.text.toString() + "5")
        }
        b6.setOnClickListener {
            editText.setText(editText.text.toString() + "6")
        }
        b7.setOnClickListener {
            editText.setText(editText.text.toString() + "7")
        }
        b8.setOnClickListener {
            editText.setText(editText.text.toString() + "8")
        }
        b9.setOnClickListener {
            editText.setText(editText.text.toString() + "9")
        }
        b0.setOnClickListener {
            editText.setText(editText.text.toString() + "0")
        }
        plus.setOnClickListener {
            if (editText.text.isNotEmpty()) {
                in1 = (editText.text.toString() + "").toDouble()
                add = true
                deci = false
                textView.text = "$in1 "
                editText.text = null
            }
        }
        minus.setOnClickListener {
            if (editText.text.isNotEmpty()) {
                in1 = (editText.text.toString() + "").toDouble()
                sub = true
                deci = false
                textView.text = "$in1 "
                editText.text = null
            }
        }
        multiplyBtn.setOnClickListener {
            if (editText.text.isNotEmpty()) {
                in1 = (editText.text.toString() + "").toDouble()
                multiply = true
                deci = false
                textView.text = "$in1 "
                editText.text = null
            }
        }
        divideBtn.setOnClickListener {
            if (editText.text.isNotEmpty()) {
                in1 = (editText.text.toString() + "").toDouble()
                divide = true
                deci = false
                textView.text = "$in1 "
                editText.text = null
            }
        }
        remainderBtn.setOnClickListener {
            if (editText.text.isNotEmpty()) {
                in1 = (editText.text.toString() + "").toDouble()
                remainder = true
                deci = false
                textView.text = "$in1 "
                editText.text = null
            }
        }
        equal.setOnClickListener {
            if (add || sub || multiply || divide || remainder){
                i2 = (editText.text.toString() + "").toDouble()
            }
            if (add){
                editText.setText("${in1+i2}" )
                editText.setText(editText.text.toString() + "0")
                textView.text = "${textView.text}\n+ $i2 \n= ${in1+i2} "
                in1+= i2
                add = false
            }
            if (sub){
                editText.setText("${in1-i2}" )
                editText.setText(editText.text.toString() + "0")
                textView.text = "${textView.text}\n- $i2 \n= ${(in1-i2).toDouble()} "
                in1 -= i2
                sub = false
            }
            if (multiply){
                editText.setText("${in1*i2}" )
                editText.setText(editText.text.toString() + "0")
                textView.text = "${textView.text}\nx $i2 \n= ${in1*i2} "
                in1 *= i2
                multiply = false
            }
            if (divide){
                editText.setText("${in1/i2}" )
                editText.setText(editText.text.toString() + "0")
                textView.text = "${textView.text}\n/ $i2 \n= ${in1/i2} "
                in1 /= i2
                divide = false
            }
            if (remainder){
                editText.setText("${in1%i2}" )
                editText.setText(editText.text.toString() + "0")
                textView.text = "${textView.text}\n% $i2 \n= ${in1%i2}"
                in1 %= i2
                remainder = false
            }
        }
        cancel.setOnClickListener {
            editText.setText("")
            textView.text = ""
            in1 = 0.0
            i2 = 0.0
        }
        point.setOnClickListener {
            if (deci) {
                //Error
            } else {
                editText.setText(editText.text.toString() + ".")
                deci = true
            }
        }
        delete.setOnClickListener {
            var str = editText.text.toString()
            if(str.length > 1){
                str = str.substring(0, str.length - 1)
                editText.setText(str)
            }
            else
                editText.setText("0")
        }
    }
}