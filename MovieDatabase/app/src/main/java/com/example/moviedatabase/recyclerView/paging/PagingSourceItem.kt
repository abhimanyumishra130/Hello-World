package com.example.moviedatabase.recyclerView.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.moviedatabase.remote.NetworkHelper
import com.example.moviedatabase.remote.Result
import java.lang.Exception

class PagingSourceItem : PagingSource<Int, Result>() {

    private val api = NetworkHelper.getApi()
    val api_key = "c379a75cfa42f4ecf840fe6eae7cc83c"

    override fun getRefreshKey(state: PagingState<Int, Result>): Int? {
        return state.anchorPosition
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Result> {

        val pageNumber =  params.key ?: 1
        val response = api.getData(api_key)
        val list = response.results
//val list = arrayListOf<Result>()
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