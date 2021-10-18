package com.example.unit_5sprint1.MVVM

import androidx.lifecycle.LiveData
import com.example.unit_5sprint1.RoomDatabase.ItemDao
import com.example.unit_5sprint1.RoomDatabase.Model
import com.example.unit_5sprint1.retrofit.ApiClient
import com.example.unit_5sprint1.retrofit.Network
import com.example.unit_5sprint1.retrofit.ResponseModel
import com.example.unit_5sprint1.retrofit.ResponseModelItem
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Repository(var itemDao: ItemDao) {



    fun insertData(){
        var api = Network.getRetrofit().create(ApiClient::class.java)
        var list = arrayListOf<ResponseModelItem>()
        api.getApiData(1).enqueue(object :Callback<ResponseModel>{
            override fun onResponse(call: Call<ResponseModel>, response: Response<ResponseModel>) {
                if(response.body()!=null){
                    response.body()?.forEach {
                        var response = Model(it.name,it.birthday,it.deathday,it.image.medium,it.country.name,it.country.code,it.country.timezone)
                        itemDao.insertData(response)
                    }

                }
            }

            override fun onFailure(call: Call<ResponseModel>, t: Throwable) {

            }

        })
    }

    fun getData():LiveData<ArrayList<Model>>{
        return  itemDao.getDataFromDB()
    }
}