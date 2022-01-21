
# 目的
> 本项目用于个人学习练手App，使用到栏一些第三方数据源和一些开源框架，如有侵权请联删。

## 编写语言 
> 版本初期开发使用的是 `Java-MVP` 模式开发，后续在工作过程中逐渐往`Kotlin-MVVM`开发模式迁移，使用了`ViewModel+Flow`的方式替代了`DataBinding`

## 采用Composing Build方式管理依赖
> 思路就是使用kotlin语言开发一个gradle plugin，然后使用这个plugin去管理依赖

## 使用到的开源框架
- 网络请求:`OkHttp3+Retrofit+Coroutines`
- 图片加载:`Coil`
- 视频播放:`NiceVideoPlayer`
- UI框架:`EasyRecyclerView/SmartRefreshLayout`
- 数据库框架:`Room`
- 依赖注入库:`Koin`

## 主要实现功能
- 开眼视频播放
- 开眼搜索视频
- 个人文章展示(目前有道云笔记在维护更新，暂时无法查看分享的文章)
- 干货（开源api数据接口）文章（干货接口已经请求不通了）
- wanAndroid的文章

## 鸣谢
- 干货
- wanAndroid
- 开眼
