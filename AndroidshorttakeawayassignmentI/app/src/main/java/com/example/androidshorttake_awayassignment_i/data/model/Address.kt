package com.example.androidshorttake_awayassignment_i.data.model

data class Address(
    val addressString: String,
    val addressType: String,
    val city: String,
    val cityBoundaryBreached: Boolean,
    val errorMargin: Int,
    val id: String,
    val label: String,
    val latitude: Double,
    val longitude: Double,
    val pinCode: String,
    val pinCodeBoundaryBreached: Boolean,
    val priority: Int,
    val source: String
)