package com.example.androidshorttake_awayassignment_i.repository

import com.application.searchapi.data.Resource
import com.application.searchapi.data.ResponseHandler
import com.example.androidshorttake_awayassignment_i.data.model.Address
import com.example.androidshorttake_awayassignment_i.data.model.ResponseModel
import com.example.androidshorttake_awayassignment_i.di.hilt.SearchModule
import com.example.androidshorttake_awayassignment_i.utils.ApiClient
import com.example.androidshorttake_awayassignment_i.utils.Network
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class Repo @Inject constructor() {

     var responshandler = ResponseHandler()
//    val api = Network.getInstance().create(ApiClient::class.java)

     suspend fun getAddressList(city:String):Resource<ResponseModel>{
      return try{
          val response = SearchModule.getInstance().create(ApiClient::class.java).getAddresses(city)
          responshandler.handleSuccess(response)
      }catch (e:Exception){
          responshandler.handleException(e)
      }
    }
}