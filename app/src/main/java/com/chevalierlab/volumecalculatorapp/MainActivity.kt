package com.chevalierlab.volumecalculatorapp

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_calculate.setOnClickListener { processInput() }
    }

    @SuppressLint("SetTextI18n")
    private fun processInput() {
        val input1 = edt_input1.text.toString().trim()
        val input2 = edt_input2.text.toString().trim()
        val input3 = edt_input3.text.toString().trim()

        validateInput(input1, input2, input3)

        if (input1.isNotEmpty() && input2.isNotEmpty() && input3.isNotEmpty()) {
            val blockVolume = input1.toInt() * input2.toInt() * input3.toInt()
            tv_volume_block?.text = "Volume balok adalah : $blockVolume"
        }
    }

    private fun validateInput(input1: String, input2: String, input3: String) {
        if (TextUtils.isEmpty(input1)) {
            edt_input1.error = "Input 1 harus diisi dengan angka"
            edt_input1.requestFocus()
        }
        if (TextUtils.isEmpty(input2)) {
            edt_input2.error = "Input 2 harus diisi dengan angka"
            edt_input2.requestFocus()
        }
        if (TextUtils.isEmpty(input3)) {
            edt_input3.error = "Input 3 harus diisi dengan angka"
            edt_input3.requestFocus()
        }
    }
}