import android.app.Activity
import android.content.Intent
import com.blues.framework.utils.putExtras

/**
 * Created by xiaojianjun on 2019-10-17.
 */
object ActivityUtil {

    val activities = mutableListOf<Activity>()

    /**
     * 启动一个在activity栈里的activity
     */
    @JvmStatic
    @JvmOverloads
    fun start(clazz: Class<out Activity>, params: Map<String, Any> = emptyMap()) {
        val currentActivity = activities[activities.lastIndex]
        val intent = Intent(currentActivity, clazz)
        params.forEach {
            intent.putExtras(it.key to it.value)
        }
        currentActivity.startActivity(intent)
    }


    /**
     * 获取栈顶activity
     */
    @JvmStatic
    fun topActivity() = activities[activities.lastIndex]

    /**
     * finish指定的一个或多个Activity
     */
    @JvmStatic
    fun finish(vararg clazz: Class<out Activity>) {
        activities.forEach { activity ->
            if (clazz.contains(activity::class.java)) {
                activity.finish()
            }
        }
    }

}