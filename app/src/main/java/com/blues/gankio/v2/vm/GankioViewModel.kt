package com.blues.gankio.v2.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.blues.framework.base.BaseViewModel
import com.blues.framework.base.catch
import com.blues.framework.base.next
import com.blues.framework.utils.HelperUtil
import com.blues.gankio.v2.model.*
import com.blues.gankio.v2.constant.GankioConstant
import com.blues.gankio.v2.service.GankioRepository
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.launch

/**
 * File: com.blues.gankio.v2.vm.GankioViewModel
 * Description: xxx
 *
 * @author: lanhuajian
 * @time: 2021-07-30 17:00
 **/

class GankioViewModel(private val gankioRepository: GankioRepository) : BaseViewModel() {

    private var currentPage: Int = 1

    fun requestData() {

        //一开始要加载banner和category
        getBanner() //干货，可能需要合并girl
        //干货，可能需要合并girl
        getCategory(GankioConstant.GANK)
    }

    private val _banner = MutableSharedFlow<GankioBannerBean>(replay = 1)
    val banner: SharedFlow<GankioBannerBean> = _banner

    fun getBanner() {
        viewModelScope.launch {
            requestByFlow {
                gankioRepository.getBanner()
            }.catch {
                HelperUtil.showSimpleLog(this.message)
            }.next {
                this.data?.let {
                    _banner.tryEmit(it)
                }
            }
        }
    }

    private val _category = MutableSharedFlow<GankioCategoryBean>(replay = 1)
    val category: SharedFlow<GankioCategoryBean> = _category

    fun getCategory(type: String) {
        viewModelScope.launch {
            requestByFlow {
                gankioRepository.getCategory(type)
            }.catch {
                HelperUtil.showSimpleLog(this.message)
            }.next {
                this.data?.let {
                    _category.tryEmit(it)
                }
            }
        }
    }

    private val _list = MutableSharedFlow<GankioUniversalBean>(replay = 1)
    val list: SharedFlow<GankioUniversalBean> = _list

    fun getCategoryPostList(
        category: String = GankioConstant.GANK, type: String,
        page: Int = currentPage
    ) {
        viewModelScope.launch {
            requestByFlow {
                gankioRepository.getCategoryPostList(category, type, page, 10)
            }.catch {
                HelperUtil.showSimpleLog(this.message)
            }.next {
                this.data?.let {
                    _list.tryEmit(it)
                }
            }
        }
    }

    fun loadCategoryPostListMore(category: String, type: String) {
        getCategoryPostList(category, type, page = ++currentPage)
    }

    private val _randomList = MutableSharedFlow<GankioRandomBean>(replay = 1)
    val randomList: SharedFlow<GankioRandomBean> = _randomList

    fun getRandomCategoryPostList(category: String, type: String, count: Int) {
        viewModelScope.launch {
            requestByFlow {
                gankioRepository.getRandomCategoryPostList(category, type, count)
            }.catch {
                HelperUtil.showSimpleLog(this.message)
            }.next {
                this.data?.let {
                    _randomList.tryEmit(it)
                }
            }
        }
    }

    private val _postDetail = MutableSharedFlow<GankioPostDetailBean>(replay = 1)
    val postDetail: SharedFlow<GankioPostDetailBean> = _postDetail

    fun getPostDetail(postId: String) {
        viewModelScope.launch {
            requestByFlow {
                gankioRepository.getPostDetail(postId)
            }.catch {
                HelperUtil.showSimpleLog(this.message)
            }.next {
                this.data?.let {
                    _postDetail.tryEmit(it)
                }
            }
        }
    }

    private val _hotList = MutableSharedFlow<GankioHotBean>()
    val hotList: SharedFlow<GankioHotBean> = _hotList

    fun getPostHotList(type: String, category: String, count: Int) {
        viewModelScope.launch {
            requestByFlow {
                gankioRepository.getPostHotList(type, category, count)
            }.catch {
                HelperUtil.showSimpleLog(this.message)
            }.next {
                this.data?.let {
                    _hotList.tryEmit(it)
                }
            }
        }
    }

    private val _postComments = MutableSharedFlow<GankioPostCommentsBean>()
    val postComment: SharedFlow<GankioPostCommentsBean> = _postComments

    fun getGankPostComments(postId: String) {
        viewModelScope.launch {
            requestByFlow {
                gankioRepository.getGankPostComments(postId)
            }.catch {
                HelperUtil.showSimpleLog(this.message)
            }.next {
                this.data?.let {
                    _postComments.tryEmit(it)
                }
            }
        }
    }

    private val _search = MutableSharedFlow<GankioSearchResultBean>()
    val search: SharedFlow<GankioSearchResultBean> = _search

    fun getSearchContents(search: String, category: String, type: String, page: Int, count: Int) {
        viewModelScope.launch {
            requestByFlow {
                gankioRepository.getSearchContents(search, category, type, page, count)
            }.catch {
                HelperUtil.showSimpleLog(this.message)
            }.next {
                this.data?.let {
                    _search.tryEmit(it)
                }
            }
        }
    }
}