package com.example.myapplication.model

class CardResponse (
    val cards: List<Card>? = null ) {

}

class Card(

    val nome: String? = null,
    val manaCost: String? = null,
    val imageUrl: String? = null
){}