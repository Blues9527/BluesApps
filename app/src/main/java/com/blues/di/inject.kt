package com.blues.di

import com.blues.constant.GANKIO
import com.blues.constant.KAIYAN
import com.blues.constant.WANANDROID
import com.blues.framework.http.networkModule
import com.blues.gankio.v1.service.GankRepository
import com.blues.gankio.v1.service.provideGankApi
import com.blues.gankio.v1.vm.GankViewModel
import com.blues.gankio.v2.service.GankioRepository
import com.blues.gankio.v2.service.provideGankioApi
import com.blues.gankio.v2.vm.GankioViewModel
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
import com.blues.kaiyan.detail.service.KaiyanDetailRepository
import com.blues.kaiyan.detail.service.provideKaiyanDetailApi
import com.blues.kaiyan.detail.vm.KaiyanDetailViewModel
import com.blues.kaiyan.list.vm.KaiyanViewModel
import com.blues.register.service.RegisterRepository
import com.blues.register.service.provideRegisterApi
import com.blues.register.vm.RegisterViewModel
import org.koin.core.qualifier.named
import org.koin.core.scope.get
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

    factory { provideKaiyanDetailApi(get(named(KAIYAN))) }

    single {
        KaiyanRepository(get(), get())
    }

    single { KaiyanDetailRepository(get(), get()) }

    factory {
        KaiyanViewModel(get())
    }

    factory { KaiyanDetailViewModel(get()) }
}

val gankioModule = module {
    factory {
        provideGankioApi(get(named(GANKIO)))

    }
    factory {
        provideGankApi(get(named(GANKIO)))
    }

    single {
        GankioRepository(get(), get())
    }

    single {
        GankRepository(get(), get())
    }

    factory {
        GankioViewModel(get())

    }
    factory {
        GankViewModel(get())
    }
}

val allModules = (networkModule + wanAndroidVmModule + registerModule + loginModule + kaiyanModule + gankioModule)



