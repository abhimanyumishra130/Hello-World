package com.example.itunesapp.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.itunesapp.data.model.MusicTable
import com.example.itunesapp.data.model.ResponseModel
import com.example.itunesapp.repository.MusicRepo
import com.example.itunesapp.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers.IO
import javax.inject.Inject

@HiltViewModel
class MusicViewModel @Inject constructor(val repo: MusicRepo):ViewModel() {

    fun getAllMusicFromApi(term:String):LiveData<Resource<ResponseModel>>{
        return liveData(IO){
           val data =  repo.getMusicsFromApi(term)
            emit(data)
        }
    }

     fun saveAllMusic(term: String){
        repo.saveAllMusics(term)
    }

    fun deleteAll(){
        repo.deleteMusics()
    }

    fun getAllMusics():LiveData<List<MusicTable>>{
        return repo.getAllMusicsFromDB()
    }
}