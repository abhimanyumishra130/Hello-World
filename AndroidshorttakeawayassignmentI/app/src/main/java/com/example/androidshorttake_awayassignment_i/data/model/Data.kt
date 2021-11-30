package com.example.androidshorttake_awayassignment_i.data.model

data class Data(
    val addressList: List<Address>,
    val autoCompleteRequestString: String,
    val focusWord: String,
    val totalFindByRSUHits: Int,
    val totalNoRSUReturned: Int
)