package com.blues.framework.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.blues.LoadingDialog
import com.blues.framework.http.Response
import com.blues.framework.utils.HelperUtil
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*

/**
 * File: com.blues.framework.base.BaseViewModel
 * Description: xxx
 *
 * @author: lanhuajian
 * @time: 2021-07-16
 **/

open class BaseViewModel : ViewModel() {

    private val _loadingEvent = MutableLiveData<Boolean>()
    val loadingEvent: LiveData<Boolean> = _loadingEvent

    suspend fun <T> requestByFlow(showLoading: Boolean = true,
        request: suspend () -> Response<T>?): Flow<Response<T>> {

        if (showLoading) showLoading()

        return flow {
            val response = request() ?: throw IllegalArgumentException("数据非法，获取响应数据为空")
            emit(response)
        }.flowOn(Dispatchers.IO).onCompletion { cause ->
            run {
                closeLoading()
                cause?.let {
                    HelperUtil.showToast(it.message ?: "")
                }
            }
        }
    }

    private fun showLoading() {
        _loadingEvent.value = true
    }

    private fun closeLoading() {
        _loadingEvent.value = false
    }
}

fun <T> Flow<T>.catch(bloc: Throwable.() -> Unit) = catch { cause ->
    bloc(cause)

}

suspend fun <T> Flow<T>.next(bloc: suspend T.() -> Unit): Unit = catch { }.collect {
    bloc(it)
}