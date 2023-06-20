package com.blues.article

import androidx.lifecycle.viewModelScope
import com.blues.framework.base.BaseViewModel
import com.blues.framework.base.catch
import com.blues.framework.base.next
import com.blues.framework.utils.HelperUtil
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.launch

/**
 * 每日一文 view model
 */
class EverydayArticleViewModel(private val everydayArticleRepository: EverydayArticleRepository) :
    BaseViewModel() {

    private val _everydayArticleEntity = MutableSharedFlow<EverydayArticleBean>(replay = 1)
    val everydayArticleFlow: SharedFlow<EverydayArticleBean> = _everydayArticleEntity

     fun getTodayArticle() {
        viewModelScope.launch {
            requestByFlow {
                everydayArticleRepository.getTodayArticle()
            }.catch {
                HelperUtil.showSimpleLog(this.message)
            }.next {
                this.data?.let {
                    _everydayArticleEntity.tryEmit(it)
                }
            }
        }
    }
}