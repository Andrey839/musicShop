package ru.skillbranch.devintensive.musicshop

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_order.*

class OrderActivity : AppCompatActivity() {
    lateinit var keyName: String
    lateinit var keyQuantity: String
    lateinit var keyInstrument: String
    lateinit var keyPrice: String

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

    fun sendEmail(view: View) {
        val actionSend = Intent(Intent.ACTION_SEND)
        actionSend.putExtra(Intent.EXTRA_EMAIL, arrayOf("robin839168@gmail.com"))
        actionSend.putExtra(Intent.EXTRA_SUBJECT, "Order")
        actionSend.putExtra(Intent.EXTRA_TEXT, "$keyName"+"/n"+"$keyInstrument"+"/n"+"$keyQuantity"+"/n"+"$keyPrice" )

    }
}
