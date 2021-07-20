package com.blues.module_main.vm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.blues.framework.base.BaseViewModel
import com.blues.framework.base.catch
import com.blues.framework.base.next
import com.blues.framework.utils.HelperUtil
import com.blues.module_main.model.WanAndroidBannerEntity
import com.blues.module_main.service.WanAndroidBannerRepository
import kotlinx.coroutines.launch

/**
 * File: com.blues.module_main.vm.WanAndroidBannerViewModel
 * Description: xxx
 *
 * @author: lanhuajian
 * @time: 2021-07-16 22:49
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
                    this.data?.let {
                        wanAndroidBanner.value = it
                    }
                }
        }
    }
}