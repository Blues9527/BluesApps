package com.blues.gankio.v1.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.blues.framework.base.BaseViewModel
import com.blues.framework.base.catch
import com.blues.framework.base.next
import com.blues.framework.utils.HelperUtil
import com.blues.gankio.v1.model.GankBean
import com.blues.gankio.v1.service.GankRepository
import kotlinx.coroutines.launch

/**
 * File: com.blues.gankio.v1.vm.GankViewModel
 * Description: xxx
 *
 * @author: lanhuajian
 * @time: 2021-08-01 15:25
 **/

class GankViewModel(private val gankRepository: GankRepository) : BaseViewModel() {

    private val _listData = MutableLiveData<GankBean>()
    val listData: LiveData<GankBean> = _listData

    private var currentPage: Int = 1

    private fun getData(type: String, page: Int) {

        viewModelScope.launch {
            requestByFlow {
                gankRepository.getData(type, page, 10)
            }.catch {
                HelperUtil.showSimpleLog(this.message)
            }.next {
                data?.let {
                    _listData.value = it
                }
            }
        }
    }

    fun initData(type: String) {
        currentPage = 1
        getData(type, currentPage)
    }

    fun loadMore(type: String) {
        getData(type, ++currentPage)
    }

}