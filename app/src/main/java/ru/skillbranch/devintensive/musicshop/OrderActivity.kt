package ru.skillbranch.devintensive.musicshop

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_order.*

class OrderActivity : AppCompatActivity() {
    private lateinit var keyName: String
    private lateinit var keyQuantity: String
    private lateinit var keyInstrument: String
    private lateinit var keyPrice: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order)

        val keyName = intent.getStringExtra("keyName")
        val keyQuantity = intent.getStringExtra("keyQuantity")
        val keyInstrument = intent.getStringExtra("keyInstrument")
        val keyPrice = intent.getStringExtra("keyPrice")

        textViewName.apply {
            text = keyName
        }
        textViewQuantity.apply {
            text = keyQuantity
        }
        textViewPrice.apply {
            text = keyPrice
        }
        textViewInstrument.apply {
            text = keyInstrument
        }


    }

    fun sendEmail(view: View) {
        val str = "$keyName/n$keyInstrument/n$keyQuantity/n$keyPrice"
        val actionSend = Intent(Intent.ACTION_SEND).apply {
        putExtra(Intent.EXTRA_EMAIL, arrayOf("robin839168@gmail.com"))
        putExtra(Intent.EXTRA_SUBJECT, "Order")
        putExtra(Intent.EXTRA_TEXT, str)}

    }

}
