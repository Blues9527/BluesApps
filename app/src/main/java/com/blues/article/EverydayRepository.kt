package com.blues.article

import com.blues.framework.http.Response
import com.blues.framework.http.ResponseHandler
import retrofit2.Retrofit
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale


/**
 * 每日一文repo
 * 使用本地模拟数据
 */
class EverydayArticleRepository(
    private val everydayArticleServiceApi: EverydayArticleServiceApi,
    private val responseHandler: ResponseHandler
) {

    // 本地模拟文章数据
    private val mockArticles = listOf(
        MockArticle(
            title = "生活的方式",
            author = "梭罗",
            content = "我步入丛林，因为我希望生活得有意义。我希望活得深刻，汲取生命中所有的精华，把非生命的一切都击溃，以免当我生命终结时，发现自己从来没有活过。\n\n这是美国作家梭罗在《瓦尔登湖》中的一段经典文字。梭罗在瓦尔登湖畔独居两年多，用心体会生活的本质。他告诉我们，真正的幸福不在于拥有多少，而在于如何去感受和珍惜当下。\n\n在这个快节奏的时代，我们常常被各种欲望和焦虑所困扰。我们追求更多的金钱、更大的房子、更好的车子，却忽略了生活中最简单的快乐。一杯清茶，一本好书，一次与朋友的闲聊，这些都是生活给予我们的珍贵礼物。\n\n让我们放慢脚步，用心去感受生活中的美好。不必等到功成名就才去享受生活，因为生活本身就是一场旅行，重要的不是目的地，而是沿途的风景和看风景的心情。",
            digest = "我步入丛林，因为我希望生活得有意义。我希望活得深刻，汲取生命中所有的精华..."
        ),
        MockArticle(
            title = "追梦的勇气",
            author = "海明威",
            content = "一个人可以被毁灭，但不能被打败。\n\n这是《老人与海》中最著名的台词，诠释了人类精神的坚韧与不屈。老人圣地亚哥在连续八十四天没有捕到鱼的情况下，依然没有放弃对大海的期待。他的坚持最终让他钓到了一条巨大的马林鱼，虽然最后鱼肉被鲨鱼吃光，但他带回了鱼的骨架，证明了他曾经战斗过。\n\n生活中，我们每个人都是那个孤独的渔夫，面对浩瀚的大海（命运），我们显得如此渺小。但正是在这种渺小中，我们展现出了人性的伟大。每一次跌倒后的爬起，每一个深夜里的坚持，都是我们对自己人生的承诺。\n\n梦想是人生的灯塔，它指引我们在黑暗中前行。即使前路艰难，即使看不到希望，我们也要保持那份追梦的勇气。因为只有勇敢追求，才能让生命绽放出应有的光彩。",
            digest = "一个人可以被毁灭，但不能被打败..."
        ),
        MockArticle(
            title = "时间的价值",
            author = "培根",
            content = "时间是最好的老师，但遗憾的是，它最终会杀死所有的学生。\n\n英国哲学家培根的这句话道出了时间的残酷与公平。每个人都会老去，每个人的生命都有尽头，这是谁也无法逃脱的法则。但正是因为生命有限，我们才更应该珍惜时间，让每一天都活得精彩。\n\n时间是这个世界上最公平的事物。它给每个人的都是二十四小时，不多也不少。成功的人之所以成功，往往不是因为他们拥有更多的时间，而是因为他们更懂得如何利用时间。\n\n我们常常在年轻的时候挥霍时间，以为未来还有大把的时光可以挥霍。直到年老体衰时才追悔莫及，却发现时间已经从指间悄然流逝。所以，从现在开始，让我们学会管理时间，珍惜生命中的每一分每一秒。",
            digest = "时间是最好的老师，但遗憾的是，它最终会杀死所有的学生..."
        ),
        MockArticle(
            title = "读书的乐趣",
            author = "毛姆",
            content = "阅读是一座随身携带的小型避难所。\n\n英国作家毛姆用这句话精准地描述了阅读的魅力。在这个纷繁复杂的世界里，我们每个人都需要一个可以栖息的港湾。而书籍，正是这样一个可以让我们暂时逃离现实烦恼的精神家园。\n\n当你翻开一本好书，你就进入了一个全新的世界。你可以跟随主人公一起冒险，一起哭泣，一起欢笑。书籍让我们的人生延长了无数倍，因为在阅读的瞬间，我们经历了别人一生的故事。\n\n读书还能让我们变得明智。通过阅读，我们可以与古往今来的伟大灵魂对话，汲取他们的智慧。每一本书都是作者思想的结晶，阅读就是与这些伟大的思想进行交流。\n\n所以，让我们养成读书的习惯，让书籍成为我们生命中不可或缺的伴侣。",
            digest = "阅读是一座随身携带的小型避难所..."
        ),
        MockArticle(
            title = "坚持的力量",
            author = "爱迪生",
            content = "天才是百分之一的灵感加百分之九十九的汗水。\n\n发明大王爱迪生的这句名言告诉我们，成功从来不是一蹴而就的，而是需要长期的坚持和努力。爱迪生一生发明了数千种物品，每一项发明都经历了无数次的失败和尝试。\n\n在寻找适合灯丝材料的过程中，爱迪生尝试了上千种材料，每一种都失败了。如果换成普通人，可能早就放弃了。但爱迪生没有，他说失败只是证明这种方法不行，然后继续尝试下一个。\n\n这就是坚持的力量。成功的道路上并没有捷径，唯有坚持才能让我们到达目的地。当我们遇到困难想要放弃时想想爱迪生的故事，也许会重新获得前进的动力。\n\n人生就像一场马拉松，不在于瞬间的爆发，而在于途中的坚持。",
            digest = "天才是百分之一的灵感加百分之九十九的汗水..."
        )
    )

    data class MockArticle(
        val title: String,
        val author: String,
        val content: String,
        val digest: String
    )

    suspend fun getTodayArticle(): Response<EverydayArticleBean> {
        return try {
            // 使用本地模拟数据
            val mockData = generateMockArticle()
            val response = EverydayArticleBean().apply {
                data = EverydayArticleBean.Data().apply {
                    this.title = mockData.title
                    this.author = mockData.author
                    this.content = mockData.content
                    this.digest = mockData.digest
                    this.date = SimpleDateFormat("yyyyMMdd", Locale.getDefault()).format(Date())
                    this.wc = mockData.content.length
                }
            }
            responseHandler.handleSuccess(response)
        } catch (e: Exception) {
            responseHandler.handleException(e)
        }
    }

    // 根据日期生成伪随机文章
    private fun generateMockArticle(): MockArticle {
        val dayOfYear = java.util.Calendar.getInstance().get(java.util.Calendar.DAY_OF_YEAR)
        val index = dayOfYear % mockArticles.size
        return mockArticles[index]
    }
}

fun provideEverydayArticleApi(
    retrofit: Retrofit
): EverydayArticleServiceApi = retrofit.create(EverydayArticleServiceApi::class.java)
