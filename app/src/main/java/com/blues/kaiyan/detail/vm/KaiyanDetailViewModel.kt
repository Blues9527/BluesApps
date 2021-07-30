package com.blues.kaiyan.detail.vm

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.blues.framework.base.BaseViewModel
import com.blues.framework.base.catch
import com.blues.framework.base.next
import com.blues.framework.utils.HelperUtil
import com.blues.kaiyan.detail.api.KaiyanDetailApi
import com.blues.kaiyan.detail.model.OEDetailRelatedEntity
import com.blues.kaiyan.detail.service.KaiyanDetailRepository
import com.blues.wanandroid.model.WanAndroidEntity
import kotlinx.coroutines.launch

/**
 * File: com.blues.kaiyan.detail.vm.KaiyanDetailViewModel
 * Description: xxx
 *
 * @author: lanhuajian
 * @time: 2021-07-30 15:58
 **/

class KaiyanDetailViewModel(private val kaiyanDetailRepository: KaiyanDetailRepository) :
    BaseViewModel() {

    private val _detail = MutableLiveData<OEDetailRelatedEntity>()
    val detail: LiveData<OEDetailRelatedEntity> = _detail

    fun getDetail(id: String) {
        viewModelScope.launch {
            requestByFlow {
                kaiyanDetailRepository.getRelatedVideos(id)
            }.catch {
                HelperUtil.showSimpleLog(this.message)
            }.next {
                this.data?.let {
                    _detail.value = it
                }
            }
        }
    }

}