package com.blues.plugin

/**
 * File: com.blues.plugin.Depts.kt
 * Description: xxx
 *
 * @author: lanhuajian
 * @time: 2021/8/2
 **/
object BaseConfig {

    const val compileSdkVersion = 30
    const val buildToolsVersion = "30.0.3"
    const val minSdkVersion = 24
    const val targetSdkVersion = 30
    const val versionCode = 103
    const val versionName = "1.0.3"
    const val applicationId = "com.blues.app"
}

object AndroidX {

    const val appcompat = "androidx.appcompat:appcompat:${Versions.appcompat}"
    const val ktx = "androidx.core:core-ktx:${Versions.ktx}"
    const val constraintlayout = "androidx.constraintlayout:constraintlayout:${Versions.constraintlayout}"
    const val viewmodel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.viewmodel}"
    const val livedata = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.livedata}"
    const val annotation = "androidx.annotation:annotation:${Versions.annotation}"
}

object Room {

    const val runtime = "androidx.room:room-runtime:${Versions.room}"
    const val compiler = "androidx.room:room-compiler:${Versions.roomCompiler}"
}

object Kotlin {

    const val stdlibJdk7 = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}"
    const val stdlibJdk8 = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:${Versions.kotlin}"
    const val plugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"

    const val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}"
}

object Koin {

    const val core = "io.insert-koin:koin-android:${Versions.koin}"
}

object Network {

    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val convertor = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"

    const val okhttp3 = "com.squareup.okhttp3:okhttp:${Versions.okhttp}"
    const val okhttp3Interceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.okhttp}"

    const val fastJson = "com.alibaba:fastjson:${Versions.fastJson}"

}

object Coil {

    const val core = "io.coil-kt:coil:${Versions.coil}"
    const val gif = "io.coil-kt:coil-gif:${Versions.coil}"
}

object UiComponent {

    const val easyrecyclerview = "com.jude:easyrecyclerview:${Versions.recyclerview}"
    const val viewpager2 = "androidx.viewpager2:viewpager2:${Versions.viewpager2}"

    const val smartRefresh = "com.scwang.smartrefresh:SmartRefreshLayout:${Versions.smartRefresh}"
    const val smartRefreshHeader = "com.scwang.smartrefresh:SmartRefreshHeader:${Versions.smartRefresh}"

    const val baseRecyclerViewAdapter = "com.github.CymChad:BaseRecyclerViewAdapterHelper:${Versions.adapter}"

    const val markdown4j = "org.commonjava.googlecode.markdown4j:markdown4j:${Versions.markdown4j}"

    const val material = "com.google.android.material:material:${Versions.material}"
}

object Video {

    const val ijkplayerJava = "tv.danmaku.ijk.media:ijkplayer-java:${Versions.ijkplayer}"
    const val ijkplayerArmv7a = "tv.danmaku.ijk.media:ijkplayer-armv7a:${Versions.ijkplayer}"
    const val ijkplayerArm64 = "tv.danmaku.ijk.media:ijkplayer-arm64:${Versions.ijkplayer}"
    const val ijkplayerExo = "tv.danmaku.ijk.media:ijkplayer-exo:${Versions.ijkplayer}"
}

object Others {

    const val multidex = "androidx.multidex:multidex:${Versions.multidex}"
}

object Glide{
    const val glide  = "com.github.bumptech.glide:glide:${Versions.glide}"
    const val compiler = "com.github.bumptech.glide:compiler:${Versions.glide}"
}

object MMKV{
    const val mmkv = "com.tencent:mmkv-static:${Versions.mmkv}"
}

