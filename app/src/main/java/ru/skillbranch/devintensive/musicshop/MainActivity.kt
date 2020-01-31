package ru.skillbranch.devintensive.musicshop

import android.content.Intent
import android.content.res.ColorStateList
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var one = 0
    val goodName = mapOf("guitars" to 1500, "drum" to 1000, "keyboard" to 500, "violin" to 2000)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val goodInstrument = listOf("guitars", "drum", "keyboard", "violin")
        val spinnerAdapter =
            ArrayAdapter(this, android.R.layout.simple_spinner_item, goodInstrument)
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner2.adapter = spinnerAdapter


        spinner2.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val price = textView3
                var position = spinner2.selectedItem
                price.text = ((one)* (goodName[position])!!.toInt()).toString()
                val picture = imageView6
                when (position){
                    "guitars" -> picture.setImageResource(R.drawable.guitar)
                    "drum" -> picture.setImageResource(R.drawable.drum)
                    "keyboard" -> picture.setImageResource(R.drawable.keyboard)
                    "violin" -> picture.setImageResource(R.drawable.violin)
                }
            }
        }

    }

    fun increaseQuantity(view: View) {
        val pluss = textView5
        one++
        pluss.text = one.toString()
        val price = textView3
        var position = spinner2.selectedItem
        price.text = ((one)* (goodName[position])!!.toInt()).toString()
    }
    fun decreaseQuantity(view: View) {
        val minus = textView5
        if (one > 0) {
            one--
            minus.text = one.toString()
        } else {minus.text = "0"}
        val price = textView3
        var position = spinner2.selectedItem
        price.text = ((one)* (goodName[position])!!.toInt()).toString()

    }

    fun addCard(view: View) {
        val order = Order(one,(one)* (goodName[spinner2.selectedItem]!!.toInt()), spinner2.selectedItem, editText2.text)

        val orderIntent = Intent(this,OrderActivity::class.java).apply {
        putExtra("keyName", order.name)
        putExtra("keyQuantity", order.quantity)
        putExtra("keyInstrument", order.instrument.toString())
        putExtra("keyPrice", order.price)}
        startActivity(orderIntent)


    }
}