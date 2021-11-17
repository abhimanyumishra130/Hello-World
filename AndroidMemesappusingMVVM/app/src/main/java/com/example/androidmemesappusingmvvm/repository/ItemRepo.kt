package com.example.androidmemesappusingmvvm.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.liveData
import com.example.androidmemesappusingmvvm.recyclerView.PagingSourceItem

class ItemRepo {

    fun PagerItem() = Pager(
        config = PagingConfig(
            pageSize = 20
        ),
        pagingSourceFactory = { PagingSourceItem() }
    ).liveData
}