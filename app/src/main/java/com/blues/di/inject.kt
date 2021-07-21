package com.blues.di

import com.blues.framework.http.networkModule
import com.blues.model_wanandroid.vm.WanAndroidViewModel
import com.blues.model_wanandroid.service.WanAndroidRepository
import com.blues.model_wanandroid.service.provideWanAndroidPostApi
import com.blues.module_login.service.LoginRepository
import com.blues.module_login.service.provideLoginApi
import com.blues.module_login.vm.LoginViewModel
import com.blues.module_main.vm.WanAndroidBannerViewModel
import com.blues.module_main.service.WanAndroidBannerRepository
import com.blues.module_main.service.provideBannerApi
import com.blues.module_register.service.RegisterRepository
import com.blues.module_register.service.provideRegisterApi
import com.blues.module_register.vm.RegisterViewModel
import org.koin.dsl.module

/**
 * File: com.blues.di.inject
 * Description: xxx
 *
 * @author: lanhuajian
 * @time: 2021-07-17 13:35
 **/

val wanAndroidVmModule = module {
    factory { WanAndroidBannerViewModel(get()) }
    single { WanAndroidBannerRepository(get(), get()) }
    factory { provideBannerApi(get()) }

    factory { WanAndroidViewModel(get()) }
    single { WanAndroidRepository(get(), get()) }
    factory { provideWanAndroidPostApi(get()) }

}

val registerModule = module {
    factory {
        provideRegisterApi(get())
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
        provideLoginApi(get())
    }

    single {
        LoginRepository(get(), get())
    }
    factory {
        LoginViewModel(get())
    }
}

val allModules = (networkModule + wanAndroidVmModule + registerModule + loginModule)



