package ru.skillbranch.devintensive.musicshop

import android.text.Editable

class Order ( quantity:Int, price: Int, instrument: Any, name: Editable ) {
    val quantity = quantity
    val price = price
    val instrument = instrument
    val name = name
}