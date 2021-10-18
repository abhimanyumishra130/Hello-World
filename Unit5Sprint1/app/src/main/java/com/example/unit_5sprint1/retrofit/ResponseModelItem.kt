package com.example.unit_5sprint1.retrofit

data class ResponseModelItem(
    val _links: Links,
    val birthday: String,
    val country: Country,
    val deathday: String,
    val gender: String,
    val id: Int,
    val image: Image,
    val name: String,
    val updated: Int,
    val url: String
)