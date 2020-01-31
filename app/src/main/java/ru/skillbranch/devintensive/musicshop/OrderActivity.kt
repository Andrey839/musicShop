package ru.skillbranch.devintensive.musicshop

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_order.*

class OrderActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order)

        val keyName = intent.getStringExtra("keyName")
        val keyQuantity = intent.getStringExtra("keyQuantity")
        val keyInstrument= intent.getStringExtra("keyInstrument")
        val keyPrice = intent.getStringExtra("keyPrice")

        val orderActName = textViewName.apply {
            text = keyName
        }
        val orderActQuantity = textViewQuantity.apply {
            text = keyQuantity
        }
        val orderActPrice = textViewPrice.apply {
            text = keyPrice
        }
        val orderActInstrument = textViewInstrument.apply {
            text = keyInstrument
        }


    }
}
