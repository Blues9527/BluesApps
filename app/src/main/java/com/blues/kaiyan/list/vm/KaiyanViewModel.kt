package com.blues.kaiyan.list.vm

import androidx.lifecycle.viewModelScope
import com.blues.framework.base.BaseViewModel
import com.blues.framework.base.catch
import com.blues.framework.base.next
import com.blues.framework.utils.HelperUtil
import com.blues.kaiyan.list.model.KaiyanBean
import com.blues.kaiyan.list.service.KaiyanRepository
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.launch

/**
 * File: com.blues.module_kaiyan.main.vm.KaiyanViewModel
 * Description: xxx
 *
 * @author: lanhuajian
 * @time: 2021-07-30
 **/

class KaiyanViewModel(private val kaiyanRepo: KaiyanRepository) : BaseViewModel() {

    private val _ranList = MutableSharedFlow<KaiyanBean>(replay = 1)
    val rankList: SharedFlow<KaiyanBean> = _ranList

    private val _videos = MutableSharedFlow<KaiyanBean>(replay = 1)
    val videos: SharedFlow<KaiyanBean> = _videos

    private val _searchResult = MutableSharedFlow<KaiyanBean>(replay = 1)
    val searchResult: SharedFlow<KaiyanBean> = _searchResult

    private val _hotSearch = MutableSharedFlow<List<String?>>(replay = 1)
    val hotSearch: SharedFlow<List<String?>> = _hotSearch

    fun getRankList() {
        viewModelScope.launch {
            requestByFlow {
                kaiyanRepo.getRankList()
            }.catch {
                HelperUtil.showSimpleLog(this.message)
            }.next {
                this.data?.let {
                    _ranList.tryEmit(it)
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
                    _videos.tryEmit(it)
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
                    _searchResult.tryEmit(it)
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
                    _hotSearch.tryEmit(it)
                }
            }
        }
    }
}