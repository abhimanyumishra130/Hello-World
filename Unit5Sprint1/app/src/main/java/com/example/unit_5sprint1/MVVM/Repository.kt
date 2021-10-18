package com.example.unit_5sprint1.MVVM

import androidx.lifecycle.LiveData
import com.example.unit_5sprint1.RoomDatabase.ItemDao
import com.example.unit_5sprint1.RoomDatabase.Model
import com.example.unit_5sprint1.retrofit.ApiClient
import com.example.unit_5sprint1.retrofit.Network
import com.example.unit_5sprint1.retrofit.ResponseModel
import com.example.unit_5sprint1.retrofit.ResponseModelItem
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Repository(var itemDao: ItemDao) {



    fun insertData(num:Int){
        var api = Network.getRetrofit().create(ApiClient::class.java)
        var list = arrayListOf<ResponseModelItem>()
        api.getApiData(num).enqueue(object :Callback<ResponseModel>{
            override fun onResponse(call: Call<ResponseModel>, response: Response<ResponseModel>) {
                if(response.body()!=null){
                    CoroutineScope(Dispatchers.IO).launch {


                        response.body()?.forEach {

                            var name = "0"
                            if (it.name != null) name = it.name

                            var birth = "0"
                            if (it.birthday != null) birth = it.birthday

                            var death = "0"
                            if (it.deathday != null) death = it.deathday

                            var imageur = "0"
                            if (it.image != null) imageur = it.image.original

                            var cname = "0"
                            if (it.country != null) cname = it.country.name

                            var ccode = "0"
                            if (it.country != null) ccode = it.country.code

                            var time = "0"
                            if (it.country != null) time = it.country.timezone

                            var response = Model(name, birth, death, imageur, cname, ccode, time)
                            itemDao.insertData(response)
                        }
                    }
                }
            }

            override fun onFailure(call: Call<ResponseModel>, t: Throwable) {

            }

        })
    }

    fun deleteAll(){
        CoroutineScope(Dispatchers.IO).launch {
            itemDao.deleteAll()
        }
    }
    fun getData():LiveData<List<Model>>{
        return  itemDao.getDataFromDB()
    }
}