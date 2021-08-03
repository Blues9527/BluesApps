package com.blues.home.vm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.blues.framework.base.BaseViewModel
import com.blues.framework.base.catch
import com.blues.framework.base.next
import com.blues.framework.utils.HelperUtil
import com.blues.home.model.WanAndroidBannerEntity
import com.blues.home.service.WanAndroidBannerRepository
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

    val wanAndroidBanner = MutableLiveData<WanAndroidBannerEntity>()

    fun getBanner() {
        viewModelScope.launch {
            requestByFlow {
                wanAndroidRepo.getBanner()
            }.catch {
                HelperUtil.showSimpleLog(this.message)
            }.next {
                data?.let {
                    wanAndroidBanner.value = it
                }
            }
        }
    }
}