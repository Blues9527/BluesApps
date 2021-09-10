package com.blues.nicevideoplayer
/**
 * 清晰度
 */
data class Clarity(

    var grade: String,   // 清晰度等级
    var p: String,   // 270P、480P、720P、1080P、4K ...
    var videoUrl: String,// 视频链接地址
)