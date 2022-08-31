package com.example.myapplication.service

import com.example.myapplication.model.CardResponse
import retrofit2.Call
import retrofit2.http.GET

interface CardsService {

    //metodos de requisiçao

    @GET ("v1/cards")
    suspend fun getCards(): CardResponse

//    @GET suspend fun getCards(): Call<CardResponse>

}