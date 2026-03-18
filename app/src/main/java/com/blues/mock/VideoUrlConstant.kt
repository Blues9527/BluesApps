package com.blues.mock

import com.blues.gankio.v1.model.VideoInfoBean
import java.util.ArrayList

/**
 * User : Blues
 * Date : 2019/7/30
 * Time : 11:28
 */
object VideoUrlConstant {

    private val urls = arrayOf("http://jdvodluwytr3t.vod.126.net/jdvodluwytr3t/nos/hls/2019/07/08/1214841813_1bd740ad3a0d4e6ca7f14d7b55f7d3c0_sd.m3u8?ak=7909bff134372bffca53cdc2c17adc27a4c38c6336120510aea1ae1790819de8f994d2cf80c6a7781230b8b55d4a04635d43566db00e3f882776739c58542d4322117d840132767793f969aceceae3796fd1d305a8fca05072f45e15f4db45ebab1751379953e9446561f60f0e4ab9c0",  //EventBus原理解析及手写框架
            "http://jdvodluwytr3t.vod.126.net/jdvodluwytr3t/nos/hls/2019/07/09/1214846004_04fb8dcc33784733a10f73a105ca4f48_sd.m3u8?ak=7909bff134372bffca53cdc2c17adc27a4c38c6336120510aea1ae1790819de8f994d2cf80c6a7781230b8b55d4a04630bf53d7ea480b5965923476124098acd22117d840132767793f969aceceae3797b91e7852e20cf0d9e123d607c272f0db8ae77e29788836745b7125f174b3914",  //安卓人工智能——快速图文识别
            "http://jdvodluwytr3t.vod.126.net/jdvodluwytr3t/nos/hls/2019/07/10/1214848950_f2e1ccd0fa8843ccb298458e9d4aec00_sd.m3u8?ak=7909bff134372bffca53cdc2c17adc27a4c38c6336120510aea1ae1790819de8f994d2cf80c6a7781230b8b55d4a04634a6f76e1c31b6fb9b055524abf88837022117d840132767793f969aceceae379d32b9ecc5c4e68e6b4573ea51b4adc52df69454fe54d63664bd5297860cdfa3d",  //面试三部曲，叫你如何从容应对即将到来的金九银十
            "http://jdvodluwytr3t.vod.126.net/jdvodluwytr3t/nos/hls/2019/07/12/1214852578_19b4f13cfe864322a95e8244cf9a5e84_sd.m3u8?ak=7909bff134372bffca53cdc2c17adc27a4c38c6336120510aea1ae1790819de8f994d2cf80c6a7781230b8b55d4a0463e510ac052905c889d6b6f2c1d702c3a322117d840132767793f969aceceae379784394334b952e779a31fe81d594a407a9f9f7a47c7d084cef6fcf98b39bf4de",  //组件化路由框架阿里ARouter的原理及手写实现
            "http://jdvodluwytr3t.vod.126.net/jdvodluwytr3t/nos/hls/2019/07/12/1214853536_f91d90b67f894061bd64fb068737abb3_sd.m3u8?ak=7909bff134372bffca53cdc2c17adc27a4c38c6336120510aea1ae1790819de8f994d2cf80c6a7781230b8b55d4a0463857eb543f5857a3c30c41fc576e5cf5022117d840132767793f969aceceae37935d7e2ff650ad6f9750f267acc398c2b4cca709eeec35724f15d3e6a182e04cb",  //从贝塞尔曲线的使用初窥高级UI的境界
            "http://jdvodluwytr3t.vod.126.net/jdvodluwytr3t/nos/hls/2019/07/13/1214858379_d2195da6705241bda89f6ae9a79468f5_sd.m3u8?ak=7909bff134372bffca53cdc2c17adc27a4c38c6336120510aea1ae1790819de8f994d2cf80c6a7781230b8b55d4a04634c90a055d379bcd8903b76f9a1da6d3922117d840132767793f969aceceae379328273cdc1bd99e1c30cad17f5212dfcb108680c195ae7aedbefcbd824e55924",  //手写安卓高级动画——粒子爆炸特效
            "http://jdvodluwytr3t.vod.126.net/jdvodluwytr3t/nos/hls/2019/07/14/1214858707_4d60904a706349799f235480bff28f25_sd.m3u8?ak=7909bff134372bffca53cdc2c17adc27a4c38c6336120510aea1ae1790819de8f994d2cf80c6a7781230b8b55d4a0463a132fa99f5f093901c6aa5c647c84d4322117d840132767793f969aceceae37955092c2f2b4ef19496de7de44cba77489bb0a5ea14ff29775bd482caa79ccf8b",  //LiveDataBus组件通信框架的原理解析以及手写实现
            "http://jdvodluwytr3t.vod.126.net/jdvodluwytr3t/nos/hls/2019/07/15/1214864352_72afcfd060244f9bbd7b9073864cd7b4_sd.m3u8?ak=7909bff134372bffca53cdc2c17adc27a4c38c6336120510aea1ae1790819de8f994d2cf80c6a7781230b8b55d4a0463c86cb0b0bd671b345c5ff1c3b5281bbf22117d840132767793f969aceceae379f42c180c646547aeaf95a2b00348d33e4426afeac364f76a817da3b2623cd41e",  //架构师之旅——代码重构
            "http://jdvodluwytr3t.vod.126.net/jdvodluwytr3t/nos/hls/2019/07/16/1214869384_835f77a217104a21a1282e2c2870e524_sd.m3u8?ak=7909bff134372bffca53cdc2c17adc27a4c38c6336120510aea1ae1790819de8f994d2cf80c6a7781230b8b55d4a046333e785fae253a26da2b47ede3c892b8b22117d840132767793f969aceceae3795de2b5e9193f7447595abb35dfb50c2bb8ae77e29788836745b7125f174b3914",  //安卓NDK高效加载GIF——NDK开发实战
            "http://jdvodluwytr3t.vod.126.net/jdvodluwytr3t/nos/hls/2019/07/17/1214875076_21941e753e1f44a78160049b098c9476_sd.m3u8?ak=7909bff134372bffca53cdc2c17adc27a4c38c6336120510aea1ae1790819de8f994d2cf80c6a7781230b8b55d4a04639736a6331834c3cba448d6a30f815f3b22117d840132767793f969aceceae379c0526ae2b88e36db7603783efac3a34c4cca709eeec35724f15d3e6a182e04cb",  //一堂课搞定图片加载框架原理及选型
            "http://jdvodluwytr3t.vod.126.net/jdvodluwytr3t/nos/hls/2019/07/22/1214884650_87845855e2e74284b9c5bf3e0f949a00_sd.m3u8?ak=7909bff134372bffca53cdc2c17adc27a4c38c6336120510aea1ae1790819de8f994d2cf80c6a7781230b8b55d4a04633196d06a32bf73b057d40eeb9faf08fd22117d840132767793f969aceceae37913fb91e4ae6f5d7ad9e00155d0d1d4b9df69454fe54d63664bd5297860cdfa3d",  //一节课看懂网易核心项目是如何使用插件化加载海量应用
            "http://jdvodluwytr3t.vod.126.net/jdvodluwytr3t/nos/hls/2019/07/19/1214880513_0000e44a7a08439faa0c35b3a4ae421a_sd.m3u8?ak=7909bff134372bffca53cdc2c17adc27a4c38c6336120510aea1ae1790819de8f994d2cf80c6a7781230b8b55d4a0463b8b3397cfafe072727ccca20471e4a5c22117d840132767793f969aceceae379b375f67e4609614b6931a439577af430ab1751379953e9446561f60f0e4ab9c0",  //动态代理实现AOP打造性能检测和网易云音乐式权限验证
            "http://jdvodluwytr3t.vod.126.net/jdvodluwytr3t/nos/hls/2019/07/20/1214884994_c2994d3dd2474aa390caba93ad5f5fb8_sd.m3u8?ak=7909bff134372bffca53cdc2c17adc27a4c38c6336120510aea1ae1790819de8f994d2cf80c6a7781230b8b55d4a0463a0138af814b557a589ca1a56e8f1de5d22117d840132767793f969aceceae3793b239fde6059f903dc577a52f44b0548b8ae77e29788836745b7125f174b3914",  //挣脱矩形束缚——实现不规则控件点击
            "http://jdvodluwytr3t.vod.126.net/jdvodluwytr3t/nos/hls/2019/07/21/1214884481_ed82e1a2ef294ae0afb5f25a9d22ffe8_sd.m3u8?ak=7909bff134372bffca53cdc2c17adc27a4c38c6336120510aea1ae1790819de8f994d2cf80c6a7781230b8b55d4a0463a1cc149c16b009082ab675f29ef2dfe622117d840132767793f969aceceae379f00e3a43f1b505dff49b44cf1b55f365623591d5e74d0640a136e4a4f0e4eb71")

    private val titles = arrayOf("EventBus原理解析及手写框架", "安卓人工智能——快速图文识别", "面试三部曲，叫你如何从容应对即将到来的金九银十", "组件化路由框架阿里ARouter的原理及手写实现", "从贝塞尔曲线的使用初窥高级UI的境界", "手写安卓高级动画——粒子爆炸特效", "LiveDataBus组件通信框架的原理解析以及手写实现", "架构师之旅——代码重构", "安卓NDK高效加载GIF——NDK开发实战", "一堂课搞定图片加载框架原理及选型", "一节课看懂网易核心项目是如何使用插件化加载海量应用", "动态代理实现AOP打造性能检测和网易云音乐式权限验证", "挣脱矩形束缚——实现不规则控件点击", "90分钟解决界面卡顿，UI布局渲染流程详解")

    val videos: List<VideoInfoBean>
        get() {
            val videos: MutableList<VideoInfoBean> = ArrayList()
            for (i in urls.indices) {
                videos.add(VideoInfoBean(urls[i], titles[i]))
            }
            return videos
        }
}