package com.example.itunesapp.repository

import androidx.lifecycle.LiveData
import com.example.itunesapp.data.database.MusicDao
import com.example.itunesapp.data.model.MusicTable
import com.example.itunesapp.data.model.ResponseModel
import com.example.itunesapp.data.model.Result
import com.example.itunesapp.di.MusicModule
import com.example.itunesapp.utils.ApiClient
import com.example.itunesapp.utils.Resource
import com.example.itunesapp.utils.ResponseHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject

class MusicRepo @Inject constructor(val dao: MusicDao){

    private val api = MusicModule.getInstance().create(ApiClient::class.java)
    private val responseHandler = ResponseHandler()

     fun saveAllMusics(term:String){
        CoroutineScope(Dispatchers.IO).launch {
            val response = api.getMusics(term)
            saveTODB(response.results)
        }
    }
    fun saveTODB(response:List<Result>){
        var list = ArrayList<MusicTable>()
            response.forEach {
                val musicTable = MusicTable(it.artistName,it.artworkUrl30,it.collectionName,it.trackViewUrl)
                list.add(musicTable)
            }
            dao.insertMusics(list)
    }


    fun getAllMusicsFromDB():LiveData<List<MusicTable>>{
        return dao.getMusics()
    }

    fun deleteMusics(){
        CoroutineScope(Dispatchers.IO).launch {
            dao.deleteMusic()
        }
    }
    suspend fun getMusicsFromApi(term:String):Resource<ResponseModel>{
        return try {
            val response = MusicModule.getInstance().create(ApiClient::class.java).getMusics(term)
            responseHandler.handleSuccess(response)
        }catch (e:Exception){
            responseHandler.handleException(e)
        }
    }
}