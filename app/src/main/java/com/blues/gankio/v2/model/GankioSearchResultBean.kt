package com.blues.gankio.v2.model

import com.alibaba.fastjson.annotation.JSONField
import java.io.Serializable

class GankioSearchResultBean : Serializable {

    /**
     * count : 10
     * data : [{"_id":"5e51fb2545daba871ab7b607","author":"李金山","category":"GanHuo","createdAt":"2018-12-28 07:28:21","desc":"适用于Android的粒子动画库。","images":["http://gank.io/images/2a72ffd3a23e4d6b9075af5b0cd84fd5"],"likeCount":0,"likeCounts":0,"markdown":"适用于Android的粒子动画库。\nParticle animation library for Android\n\n# Example\n\n![](https://gank.io/images/23676e32cf1b4abc93ce2c4e125e42b3)\n\n# Setup\n\n``` gradle\nallprojects {\n    repositories {\n        ...\n        maven { url 'https://jitpack.io' }\n    }\n}\ndependencies {\n      implementation 'com.github.ibrahimsn98:android-particles:1.7'\n}\n```\n\n# Attributions\n\n``` xml\n<me.ibrahimsn.particle.particleview android:id=\"@+id/particleView\" android:layout_width=\"match_parent\" android:layout_height=\"match_parent\" app:particlecount=\"20\" app:minparticleradius=\"5\" app:maxparticleradius=\"12\" app:particlecolor=\"@android:color/white\" app:backgroundcolor=\"@android:color/holo_red_light\"><\/me.ibrahimsn.particle.particleview>\n```\n\n# Usage\n\n``` kotlin\nclass MainActivity : AppCompatActivity() {\n\n    private lateinit var particleView: ParticleView\n\n    override fun onCreate(savedInstanceState: Bundle) {\n        super.onCreate(savedInstanceState)\n        setContentView(R.layout.activity_main)\n\n        particleView = findViewById(R.id.particleView)\n    }\n\n    override fun onResume() {\n        super.onResume()\n        particleView.resume()\n    }\n\n    override fun onPause() {\n        super.onPause()\n        particleView.pause()\n    }\n}\n```\n\n# Inspired From\n\nThanks to [VincentGarreau](https://github.com/VincentGarreau) for sharing that awesome [javascript library](https://github.com/VincentGarreau/particles.js)","publishedAt":"2018-12-28 00:00:00","stars":3,"status":1,"title":"android-particles","type":"Android","updatedAt":"2020-03-30 22:50:44","url":"https://github.com/ibrahimsn98/android-particles","views":44},{"_id":"5e72265b907078dcbfe95aa5","author":"AndWang","category":"GanHuo","createdAt":"2016-03-31 10:07:42","desc":"Android Architecture_googlesamples","images":[],"likeCounts":0,"publishedAt":"2016-03-31 11:44:55","stars":1,"status":1,"title":"android-architecture","type":"Android","updatedAt":"2016-03-31 11:44:55","url":"https://github.com/googlesamples/android-architecture","views":2},{"_id":"5e72267b907078dcbfe95ba2","author":"wuzheng","category":"GanHuo","createdAt":"2015-12-04 05:47:41","desc":"FinestWebView-Android","images":[],"likeCounts":0,"publishedAt":"2015-12-09 04:24:10","stars":1,"status":1,"title":"FinestWebView-Android","type":"Android","updatedAt":"2015-12-09 04:24:10","url":"https://github.com/TheFinestArtist/FinestWebView-Android","views":3},{"_id":"5e7226b9907078dcbfe95d96","author":"mthli","category":"GanHuo","createdAt":"2015-06-09 09:46:31","desc":"Android示例大全，简直不能更赞！","images":[],"likeCounts":0,"publishedAt":"2015-06-16 05:56:26","stars":1,"status":1,"title":"Android","type":"Android","updatedAt":"2015-06-16 05:56:26","url":"https://github.com/hmkcode/Android","views":3},{"_id":"5e51fb6245daba871ab7b627","author":"李金山","category":"GanHuo","createdAt":"2018-12-13 08:39:21","desc":"在Android中登录用户界面，具有创新，美观和创意背景.","images":["http://gank.io/images/9353921b61124121959f5d92643b7468","http://gank.io/images/00e89c305a104c0996df9ead7bdae1f3"],"likeCount":0,"likeCounts":0,"markdown":"在Android中登录用户界面，具有创新，美观和创意背景.\nLogin User Interface in android with innovative, beautiful and creative background 😊😊😉\n\n## 📸 Screenshots\n\n<img src=\"https://gank.io/images/3e39ff95c0594b2e8ab207e67a614f0e\" height=\"600\" width=\"300\" hspace=\"40\"></img><img src=\"https://gank.io/images/50f045d9ed434250a2dbc09a82722a99\" height=\"600\" width=\"300\" hspace=\"40\"></img>\n\n<img src=\"https://gank.io/images/e17ef6355c3f4a25ad89a13172ffa476\" height=\"600\" width=\"300\" hspace=\"40\"></img><img src=\"https://gank.io/images/1c578d0d361442abb832a79b60f9e141\" height=\"600\" width=\"300\" hspace=\"40\"></img>\n\n## Contributing\n\nPlease fork this repository and contribute back using\n[pull requests](https://github.com/Shashank02051997/LoginUI-Android/pulls).\n\nAny contributions, large or small, major features, bug fixes, are welcomed and appreciated\nbut will be thoroughly reviewed .\n","publishedAt":"2018-12-13 00:00:00","stars":3,"status":1,"title":"LoginUI-Android","type":"Android","updatedAt":"2020-03-31 16:19:46","url":"https://github.com/Shashank02051997/LoginUI-Android","views":142},{"_id":"5e72262a907078dcbfe95925","author":"andyiac","category":"GanHuo","createdAt":"2016-08-15 16:45:27","desc":"Simplenote for Android 支持 Android Wear 还有 iOS 版","images":[],"likeCounts":0,"publishedAt":"2016-08-16 11:22:38","stars":1,"status":1,"title":"simplenote-android","type":"Android","updatedAt":"2016-08-16 11:22:38","url":"https://github.com/Automattic/simplenote-android","views":1},{"_id":"5e72263a907078dcbfe9599a","author":"joker","category":"GanHuo","createdAt":"2016-06-27 19:02:30","desc":"Narrate is a beautiful and functional open source journal for Android https://timothymiko.github.io/narrate-android","images":[],"likeCounts":0,"publishedAt":"2016-06-28 11:33:25","stars":1,"status":1,"title":"narrate-android","type":"Android","updatedAt":"2016-06-28 11:33:25","url":"https://github.com/timothymiko/narrate-android","views":1},{"_id":"5e722664907078dcbfe95ae9","author":"__weak_Point","category":"GanHuo","createdAt":"2015-10-27 03:18:12","desc":"Android徽章控件","images":[],"likeCounts":0,"publishedAt":"2016-03-02 12:06:37","stars":1,"status":1,"title":"BGABadgeView-Android","type":"Android","updatedAt":"2016-03-02 12:06:37","url":"https://github.com/bingoogolapple/BGABadgeView-Android","views":2},{"_id":"5e7225fd907078dcbfe957bf","author":"蒋朋","category":"GanHuo","createdAt":"2017-01-24 09:38:46","desc":"Execute shell commands on Android","images":[],"likeCounts":0,"publishedAt":"2017-02-04 11:47:42","stars":1,"status":1,"title":"android-shell","type":"Android","updatedAt":"2017-02-04 11:47:42","url":"https://github.com/jrummyapps/android-shell","views":2},{"_id":"5e722683907078dcbfe95be1","author":"AllenJuns","category":"GanHuo","createdAt":"2015-11-16 02:06:00","desc":"Android工具类库","images":[],"likeCounts":0,"publishedAt":"2015-11-16 03:55:17","stars":1,"status":1,"title":"android-utils","type":"Android","updatedAt":"2015-11-16 03:55:17","url":"https://github.com/jingle1267/android-utils","views":3}]
     * page : 1
     * page_count : 456
     * status : 100
     * total_counts : 4560
     */

    @JSONField(name = "count")
    var count = 0

    @JSONField(name = "page")
    var page = 0

    @JSONField(name = "page_count")
    var pageCount = 0

    @JSONField(name = "status")
    var status = 0

    @JSONField(name = "total_counts")
    var totalCounts = 0

    @JSONField(name = "data")
    var data: List<DataBean> = mutableListOf()

    class DataBean : Serializable {

        /**
         * _id : 5e51fb2545daba871ab7b607
         * author : 李金山
         * category : GanHuo
         * createdAt : 2018-12-28 07:28:21
         * desc : 适用于Android的粒子动画库。
         * images : ["http://gank.io/images/2a72ffd3a23e4d6b9075af5b0cd84fd5"]
         * likeCount : 0
         * likeCounts : 0
         * markdown : 适用于Android的粒子动画库。
         * publishedAt : 2018-12-28 00:00:00
         * stars : 3
         * status : 1
         * title : android-particles
         * type : Android
         * updatedAt : 2020-03-30 22:50:44
         * url : https://github.com/ibrahimsn98/android-particles
         * views : 44
         */
        @JSONField(name = "_id")
        var id: String = ""

        @JSONField(name = "author")
        var author: String = ""

        @JSONField(name = "category")
        var category: String = ""

        @JSONField(name = "createdAt")
        var createdAt: String = ""

        @JSONField(name = "desc")
        var desc: String = ""

        @JSONField(name = "likeCount")
        var likeCount = 0

        @JSONField(name = "likeCounts")
        var likeCounts = 0

        @JSONField(name = "markdown")
        var markdown: String = ""

        @JSONField(name = "publishedAt")
        var publishedAt: String = ""

        @JSONField(name = "stars")
        var stars = 0

        @JSONField(name = "status")
        var status = 0

        @JSONField(name = "title")
        var title: String = ""

        @JSONField(name = "type")
        var type: String = ""

        @JSONField(name = "updatedAt")
        var updatedAt: String = ""

        @JSONField(name = "url")
        var url: String = ""

        @JSONField(name = "views")
        var views = 0

        @JSONField(name = "images")
        var images: List<String> = mutableListOf()
    }
}