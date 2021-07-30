package com.blues.di

import com.blues.constant.KAIYAN
import com.blues.constant.WANANDROID
import com.blues.framework.http.networkModule
import com.blues.wanandroid.vm.WanAndroidViewModel
import com.blues.wanandroid.service.WanAndroidRepository
import com.blues.wanandroid.service.provideWanAndroidPostApi
import com.blues.kaiyan.list.service.KaiyanRepository
import com.blues.kaiyan.list.service.provideKaiyanApi
import com.blues.login.service.LoginRepository
import com.blues.login.service.provideLoginApi
import com.blues.login.vm.LoginViewModel
import com.blues.home.vm.WanAndroidBannerViewModel
import com.blues.home.service.WanAndroidBannerRepository
import com.blues.home.service.provideBannerApi
import com.blues.kaiyan.list.vm.KaiyanViewModel
import com.blues.register.service.RegisterRepository
import com.blues.register.service.provideRegisterApi
import com.blues.register.vm.RegisterViewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module

/**
 * File: com.blues.di.inject
 * Description: xxx
 *
 * @author: lanhuajian
 * @time: 2021-07-17
 **/

val wanAndroidVmModule = module {
    factory { WanAndroidBannerViewModel(get()) }
    single { WanAndroidBannerRepository(get(), get()) }
    factory { provideBannerApi(get(named(WANANDROID))) }

    factory { WanAndroidViewModel(get()) }
    single { WanAndroidRepository(get(), get()) }
    factory { provideWanAndroidPostApi(get(named(WANANDROID))) }

}

val registerModule = module {
    factory {
        provideRegisterApi(get(named(WANANDROID)))
    }

    single {
        RegisterRepository(get(), get())
    }

    factory {
        RegisterViewModel(get())
    }
}

val loginModule = module {
    factory {
        provideLoginApi(get(named(WANANDROID)))
    }

    single {
        LoginRepository(get(), get())
    }
    factory {
        LoginViewModel(get())
    }
}

val kaiyanModule = module {
    factory {
        provideKaiyanApi(get(named(KAIYAN)))
    }

    single {
        KaiyanRepository(get(), get())
    }

    factory {
        KaiyanViewModel(get())
    }
}

val allModules = (networkModule + wanAndroidVmModule + registerModule + loginModule + kaiyanModule)



