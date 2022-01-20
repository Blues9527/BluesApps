package com.blues.wanandroid.vm

import androidx.lifecycle.viewModelScope
import com.blues.framework.base.BaseViewModel
import com.blues.framework.base.catch
import com.blues.framework.base.next
import com.blues.framework.utils.HelperUtil
import com.blues.wanandroid.model.WanAndroidEntity
import com.blues.wanandroid.service.WanAndroidRepository
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.launch

/**
 * File: com.blues.model_wanandroid.vm.WanAndroidViewModel
 * Description: xxx
 *
 * @author: lanhuajian
 * @time: 2021-07-16
 **/

class WanAndroidViewModel(private val wanAndroidRepo: WanAndroidRepository) : BaseViewModel() {

    private var startPage = 0

    private val _wanAndroidEntity = MutableSharedFlow<WanAndroidEntity>(replay = 1)
    val wanAndroidEntity: SharedFlow<WanAndroidEntity> = _wanAndroidEntity

    private fun getPostList(page: Int) {
        viewModelScope.launch {
            requestByFlow {
                wanAndroidRepo.getPostList(page)
            }.catch {
                HelperUtil.showSimpleLog(this.message)
            }
                .next {
                    this.data?.let {
                        _wanAndroidEntity.tryEmit(it)
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