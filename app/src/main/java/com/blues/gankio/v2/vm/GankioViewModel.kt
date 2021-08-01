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

    private val _banner = MutableLiveData<GankioBannerBean>()
    val banner: LiveData<GankioBannerBean> = _banner

    fun getBanner() {
        viewModelScope.launch {
            requestByFlow {
                gankioRepository.getBanner()
            }.catch {
                HelperUtil.showSimpleLog(this.message)
            }.next {
                this.data?.let {
                    _banner.value = it
                }
            }
        }
    }

    private val _category = MutableLiveData<GankioCategoryBean>()
    val category: LiveData<GankioCategoryBean> = _category

    fun getCategory(type: String) {
        viewModelScope.launch {
            requestByFlow {
                gankioRepository.getCategory(type)
            }.catch {
                HelperUtil.showSimpleLog(this.message)
            }.next {
                this.data?.let {
                    _category.value = it
                }
            }
        }
    }

    private val _list = MutableLiveData<GankioUniversalBean>()
    val list: LiveData<GankioUniversalBean> = _list

    fun getCategoryPostList(category: String = GankioConstant.GANK, type: String,
        page: Int = currentPage) {
        viewModelScope.launch {
            requestByFlow {
                gankioRepository.getCategoryPostList(category, type, page, 10)
            }.catch {
                HelperUtil.showSimpleLog(this.message)
            }.next {
                this.data?.let {
                    _list.value = it
                }
            }
        }
    }

    fun loadCategoryPostListMore(category: String, type: String) {
        getCategoryPostList(category, type, page = ++currentPage)
    }

    private val _randomList = MutableLiveData<GankioRandomBean>()
    val randomList: LiveData<GankioRandomBean> = _randomList

    fun getRandomCategoryPostList(category: String, type: String, count: Int) {
        viewModelScope.launch {
            requestByFlow {
                gankioRepository.getRandomCategoryPostList(category, type, count)
            }.catch {
                HelperUtil.showSimpleLog(this.message)
            }.next {
                this.data?.let {
                    _randomList.value = it
                }
            }
        }
    }

    private val _postDetail = MutableLiveData<GankioPostDetailBean>()
    val postDetail: LiveData<GankioPostDetailBean> = _postDetail

    fun getPostDetail(postId: String) {
        viewModelScope.launch {
            requestByFlow {
                gankioRepository.getPostDetail(postId)
            }.catch {
                HelperUtil.showSimpleLog(this.message)
            }.next {
                this.data?.let {
                    _postDetail.value = it
                }
            }
        }
    }

    private val _hotList = MutableLiveData<GankioHotBean>()
    val hotList: LiveData<GankioHotBean> = _hotList

    fun getPostHotList(type: String, category: String, count: Int) {
        viewModelScope.launch {
            requestByFlow {
                gankioRepository.getPostHotList(type, category, count)
            }.catch {
                HelperUtil.showSimpleLog(this.message)
            }.next {
                this.data?.let {
                    _hotList.value = it
                }
            }
        }
    }

    private val _postComments = MutableLiveData<GankioPostCommentsBean>()
    val postComment: LiveData<GankioPostCommentsBean> = _postComments

    fun getGankPostComments(postId: String) {
        viewModelScope.launch {
            requestByFlow {
                gankioRepository.getGankPostComments(postId)
            }.catch {
                HelperUtil.showSimpleLog(this.message)
            }.next {
                this.data?.let {
                    _postComments.value = it
                }
            }
        }
    }

    private val _search = MutableLiveData<GankioSearchResultBean>()
    val search: LiveData<GankioSearchResultBean> = _search

    fun getSearchContents(search: String, category: String, type: String, page: Int, count: Int) {
        viewModelScope.launch {
            requestByFlow {
                gankioRepository.getSearchContents(search, category, type, page, count)
            }.catch {
                HelperUtil.showSimpleLog(this.message)
            }.next {
                this.data?.let {
                    _search.value = it
                }
            }
        }
    }
}