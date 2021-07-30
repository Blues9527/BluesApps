package com.blues.kaiyan.list.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.blues.framework.base.BaseViewModel
import com.blues.framework.base.catch
import com.blues.framework.base.next
import com.blues.framework.utils.HelperUtil
import com.blues.kaiyan.list.model.OpenEyeEntity
import com.blues.kaiyan.list.service.KaiyanRepository
import kotlinx.coroutines.launch

/**
 * File: com.blues.module_kaiyan.main.vm.KaiyanViewModel
 * Description: xxx
 *
 * @author: lanhuajian
 * @time: 2021-07-30
 **/

class KaiyanViewModel(private val kaiyanRepo: KaiyanRepository) : BaseViewModel() {

    private val _ranList = MutableLiveData<OpenEyeEntity>()
    val rankList: LiveData<OpenEyeEntity> = _ranList

    private val _videos = MutableLiveData<OpenEyeEntity>()
    val videos: LiveData<OpenEyeEntity> = _videos

    private val _searchResult = MutableLiveData<OpenEyeEntity>()
    val searchResult: LiveData<OpenEyeEntity> = _searchResult

    private val _hotSearch = MutableLiveData<List<String?>>()
    val hotSearch: LiveData<List<String?>> = _hotSearch

    fun getRankList() {
        viewModelScope.launch {
            requestByFlow {
                kaiyanRepo.getRankList()
            }.catch {
                HelperUtil.showSimpleLog(this.message)
            }.next {
                this.data?.let {
                    _ranList.value = it
                }
            }
        }
    }

    fun getRankListVideos(category: String) {
        viewModelScope.launch {
            requestByFlow {
                kaiyanRepo.getRankListVideos(category)
            }.catch {
                HelperUtil.showSimpleLog(this.message)
            }.next {
                this.data?.let {
                    _videos.value = it
                }
            }
        }
    }

    fun getSearchResult(query: String) {
        viewModelScope.launch {
            requestByFlow {
                kaiyanRepo.getSearchResult(query)
            }.catch {
                HelperUtil.showSimpleLog(this.message)
            }.next {
                this.data?.let {
                    _searchResult.value = it
                }
            }
        }
    }

    fun getHotSearch() {
        viewModelScope.launch {
            requestByFlow {
                kaiyanRepo.getHotSearch()
            }.catch {
                HelperUtil.showSimpleLog(this.message)
            }.next {
                this.data?.let {
                    _hotSearch.value = it
                }
            }
        }
    }
}