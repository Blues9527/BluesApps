package com.blues.home.vm

import androidx.lifecycle.viewModelScope
import com.blues.framework.base.BaseViewModel
import com.blues.framework.base.catch
import com.blues.framework.base.next
import com.blues.framework.utils.HelperUtil
import com.blues.home.model.WanAndroidBannerEntity
import com.blues.home.service.WanAndroidBannerRepository
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.launch

/**
 * File: com.blues.module_main.vm.WanAndroidBannerViewModel
 * Description: xxx
 *
 * @author: lanhuajian
 * @time: 2021-07-16
 **/

class WanAndroidBannerViewModel(private val wanAndroidRepo: WanAndroidBannerRepository) :
    BaseViewModel() {

    private val _wanAndroidBanner = MutableSharedFlow<WanAndroidBannerEntity>(replay = 1)
    val wanAndroidBanner: SharedFlow<WanAndroidBannerEntity> = _wanAndroidBanner

    fun getBanner() {
        viewModelScope.launch {
            requestByFlow {
                wanAndroidRepo.getBanner()
            }.catch {
                HelperUtil.showSimpleLog(this.message)
            }.next {
                data?.let {
                    _wanAndroidBanner.tryEmit(it)
                }
            }
        }
    }
}