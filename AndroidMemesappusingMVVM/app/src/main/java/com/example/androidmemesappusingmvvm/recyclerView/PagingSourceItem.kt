package com.example.androidmemesappusingmvvm.recyclerView

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.androidmemesappusingmvvm.recyclerView.model.Meme
import com.example.androidmemesappusingmvvm.remote.ApiClient
import com.example.androidmemesappusingmvvm.remote.Network
import java.lang.Exception

class PagingSourceItem:PagingSource<Int, Meme>() {

    private var api = Network.getRetrofit().create(ApiClient::class.java)
    override fun getRefreshKey(state: PagingState<Int, Meme>): Int? {
        return state.anchorPosition
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Meme> {

        val pageNumber = params.key ?: 1
        val response = api.getData()
        val list = response.data.memes

        return try {
            LoadResult.Page(
                data = list,
                prevKey = null,
                nextKey = if(list.isEmpty()) null else pageNumber+1
            )
        }catch (e:Exception){
            LoadResult.Error(e)
        }
    }
}