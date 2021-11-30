package com.example.androidshorttake_awayassignment_i.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.application.searchapi.data.Resource
import com.example.androidshorttake_awayassignment_i.data.model.ResponseModel
import com.example.androidshorttake_awayassignment_i.repository.Repo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers.IO
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(val repo: Repo):ViewModel() {

    fun getListAddress(city:String):LiveData<Resource<ResponseModel>>{
       return liveData(IO) {
           val data = repo.getAddressList(city)
           emit(data)
       }
    }
}