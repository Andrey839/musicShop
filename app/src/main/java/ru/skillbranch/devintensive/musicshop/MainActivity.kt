package ru.skillbranch.devintensive.musicshop

import android.content.res.ColorStateList
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var one = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var one = 0
        val goodInstrument = listOf("guitars","drum","keyboard","violin")
        val spinnerAdapter =ArrayAdapter(this,android.R.layout.simple_spinner_item,goodInstrument)
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner2.adapter = spinnerAdapter
    }

    fun increaseQuantity(view: View) {
        val pluss = textView5
        pluss.text = (one++).toString()
    }

    fun decreaseQuantity(view: View) {
        val minus = textView5
        if (one > 0) minus.text = (one--).toString()
        else minus.text = "0"
    }

}
