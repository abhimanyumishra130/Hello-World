package com.example.androidmockassignment_iv.ui

import android.content.Context
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.exampCle.androidmockassignment_iv.ui.ItemClickListener
import com.example.androidmockassignment_iv.data.database.Contact
import com.example.androidmockassignment_iv.di.AppModule
import java.lang.Exception

class PagingSourceItem(val list: ArrayList<Contact>) : PagingSource<Int, Contact>() {

    override fun getRefreshKey(state: PagingState<Int, Contact>): Int? {
        return state.anchorPosition
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Contact> {

        val pageNumber =  params.key ?: 1
//        val list = AppModule.providesDao(AppModule.providesDatabase(context)).getAllContacts()
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