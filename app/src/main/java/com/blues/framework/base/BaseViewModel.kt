package com.blues.framework.base

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
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

    val loadingEvent = MutableLiveData<Boolean>()

    suspend fun <T> requestByFlow(showLoading: Boolean = true,
        request: suspend () -> Response<T>?): Flow<Response<T>> {

        if (showLoading) {
            showLoading()
        }

        return flow {
            val response = request() ?: throw IllegalArgumentException("数据非法，获取响应数据为空")
            Log.e("requestFow", "==result==>$response")
            emit(response)
        }.flowOn(Dispatchers.IO)
            .onCompletion { cause ->
                run {
                    closeLoading()
                    Log.e("requestFow", "==onCompletion==cause==>${cause}")
                    cause?.let {
                        HelperUtil.showToast(it.message ?: "")
                    }
                }
            }
    }

    private fun showLoading() {
        loadingEvent.value = true
    }

    private fun closeLoading() {
        loadingEvent.value = false
    }
}

fun <T> Flow<T>.catch(bloc: Throwable.() -> Unit) = catch { cause ->
    bloc(cause)

}

suspend fun <T> Flow<T>.next(bloc: suspend T.() -> Unit): Unit = catch { }.collect {
    bloc(it)
}