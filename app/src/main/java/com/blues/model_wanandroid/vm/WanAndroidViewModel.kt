package com.blues.model_wanandroid.vm

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.blues.framework.base.BaseViewModel
import com.blues.framework.base.catch
import com.blues.framework.base.next
import com.blues.framework.utils.HelperUtil
import com.blues.model_wanandroid.model.WanAndroidEntity
import com.blues.model_wanandroid.service.WanAndroidRepository
import kotlinx.coroutines.launch

/**
 * File: com.blues.model_wanandroid.vm.WanAndroidViewModel
 * Description: xxx
 *
 * @author: lanhuajian
 * @time: 2021-07-16 19:37
 **/

class WanAndroidViewModel(private val wanAndroidRepo: WanAndroidRepository) : BaseViewModel() {

    private var startPage = 0

    val wanAndroidEntity = MutableLiveData<WanAndroidEntity>()

    private fun getPostList(page: Int) {
        viewModelScope.launch {
            requestByFlow {
                wanAndroidRepo.getPostList(page)
            }.catch {
                HelperUtil.showSimpleLog(this.message)
            }
                .next {
                    this.data?.let {
                        Log.i("blues", "data:$it")
                        wanAndroidEntity.value = it
                    }
                }
        }
    }

    fun initData() {
        getPostList(startPage)
    }

    fun loadMore() {
        getPostList(++startPage)
    }

}