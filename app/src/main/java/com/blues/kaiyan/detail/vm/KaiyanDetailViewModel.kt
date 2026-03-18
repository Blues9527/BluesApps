package com.blues.kaiyan.detail.vm

import androidx.lifecycle.*
import com.blues.framework.base.BaseViewModel
import com.blues.framework.base.catch
import com.blues.framework.base.next
import com.blues.framework.utils.HelperUtil
import com.blues.kaiyan.detail.model.KaiyanDetailBean
import com.blues.kaiyan.detail.service.KaiyanDetailRepository
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

/**
 * File: com.blues.kaiyan.detail.vm.KaiyanDetailViewModel
 * Description: xxx
 *
 * @author: lanhuajian
 * @time: 2022-01-05 19:27
 **/

class KaiyanDetailViewModel(private val kaiyanDetailRepository: KaiyanDetailRepository) :
    BaseViewModel() {

    //StateFlow
    private val _detail = MutableSharedFlow<KaiyanDetailBean>(replay = 1)
    val detail: SharedFlow<KaiyanDetailBean?> = _detail

    fun getDetail(id: String) {
        viewModelScope.launch {
            requestByFlow {
                kaiyanDetailRepository.getRelatedVideos(id)
            }.catch {
                HelperUtil.showSimpleLog(this.message)
            }.next {
                this.data?.let {
                    _detail.tryEmit(it)
                }
            }
        }
    }

}