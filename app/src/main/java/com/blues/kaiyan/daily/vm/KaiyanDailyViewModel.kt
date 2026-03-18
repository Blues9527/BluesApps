package com.blues.kaiyan.daily.vm

import androidx.lifecycle.viewModelScope
import com.blues.framework.base.BaseViewModel
import com.blues.framework.base.catch
import com.blues.framework.base.next
import com.blues.framework.utils.HelperUtil
import com.blues.kaiyan.daily.model.KaiyanDailyBean
import com.blues.kaiyan.daily.service.KaiyanDailyRepository
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.launch

/**
 * File: com.blues.kaiyan.daily.vm.KaiyanDailyViewModel.kt
 * Description: xxx
 *
 * @author lanhuajian
 * @date 2023/6/29
 **/

class KaiyanDailyViewModel(private val kaiyanDailyRepository: KaiyanDailyRepository) :
    BaseViewModel() {

    private val _dailyData = MutableSharedFlow<KaiyanDailyBean>(replay = 1)
    val dailyData: SharedFlow<KaiyanDailyBean> = _dailyData

    fun getDailyData() {
        viewModelScope.launch {
            requestByFlow {
                kaiyanDailyRepository.getDailyData()
            }.catch {
                HelperUtil.showSimpleLog(this.message)
            }.next {
                this.data?.let {
                    _dailyData.tryEmit(it)
                }
            }
        }
    }
}