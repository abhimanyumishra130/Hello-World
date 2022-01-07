package com.example.moviedatabase.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.liveData
import com.example.moviedatabase.ui.paging.PagingSourceItem

class Repository {

    fun getPageList() = Pager(

        config = PagingConfig(
            pageSize = 20
        ),
        pagingSourceFactory = {PagingSourceItem()}
    ).liveData
}