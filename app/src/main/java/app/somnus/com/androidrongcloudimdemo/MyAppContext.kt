package app.somnus.com.androidrongcloudimdemo

import android.app.Application
import android.net.Uri
import io.rong.imkit.RongIM
import io.rong.imlib.model.UserInfo

/**
 * Created by Somnus on 2018/7/16.
 */
class MyAppContext : Application() {

    init {
        instance = this
    }

    override fun onCreate() {
        super.onCreate()

        RongIM.init(this)
        RongIM.setUserInfoProvider(object : RongIM.UserInfoProvider {
            override fun getUserInfo(userId: String?): UserInfo {
                return findUser(userId!!)
            }
        }, true)

    }

    private fun findUser(userId: String): UserInfo {
        return if (userId.equals("10011")) {
            UserInfo(userId, "中国联通", Uri.parse("http://img0.imgtn.bdimg.com/it/u=3516898571,1545856409&fm=26&gp=0.jpg"))
        } else {
            UserInfo(userId, "中国移动", Uri.parse("https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=3652242842,2837219905&fm=26&gp=0.jpg"))
        }

    }


    companion object {
        lateinit var instance: MyAppContext

    }
}