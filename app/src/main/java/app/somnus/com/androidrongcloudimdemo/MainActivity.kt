package app.somnus.com.androidrongcloudimdemo

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import app.somnus.com.androidrongcloudimdemo.utils.toast
import io.rong.imkit.RongIM
import io.rong.imlib.RongIMClient
import io.rong.imlib.model.Conversation
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*


class MainActivity : AppCompatActivity() {


    val USER_TOKEN_01 = "X1rlfrendDBMUOQ2vWKeypdGvUhp/toaiOXGTGXbzjsxaUmIImojtcNX0Juio3Vga7JlDM1dBNBLQwVg57A1TA=="
    val USER_TOKEN_02 = "LYhNnWVPiW3HmFVeW5cycA2LrJLpJ/hGV8PDLuTU00I5zPLQr2fW6tfl5E3Ba59gDeMn581sMPxG1QD2XA6CIg=="

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }

        btn_connect_01.setOnClickListener {
            connect(USER_TOKEN_01)
        }
        btn_connect_02.setOnClickListener {
            connect(USER_TOKEN_02)
        }
        btn_send_msg_list.setOnClickListener {

            /* 启动会话列表界面。
            * @param context 应用上下文。
            * @param supportedConversation 定义会话列表支持显示的会话类型，及对应的会话类型是否聚合显示。
            */
            var supMap = HashMap<String, Boolean>()
            supMap.put(Conversation.ConversationType.PRIVATE.name, false)

            RongIM.getInstance().startConversationList(this, supMap)

        }
        btn_send_msg_01.setOnClickListener {
            RongIM.getInstance().startConversation(this, Conversation.ConversationType.PRIVATE, "10086", "移动")
        }

        btn_send_msg_02.setOnClickListener {
            RongIM.getInstance().startConversation(this, Conversation.ConversationType.PRIVATE, "10011", "联通")
        }


    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }


    private fun connect(token: String) {

//        if (applicationInfo.packageName == App.getCurProcessName(applicationContext)) {

        RongIM.connect(token, object : RongIMClient.ConnectCallback() {

            /**
             * Token 错误。可以从下面两点检查 1.  Token 是否过期，如果过期您需要向 App Server 重新请求一个新的 Token
             * 2.  token 对应的 appKey 和工程里设置的 appKey 是否一致
             */
            override fun onTokenIncorrect() {
                Log.d("tag","token error")
            }

            /**
             * 连接融云成功
             * @param userid 当前 token 对应的用户 id
             */
            override fun onSuccess(userid: String) {
                Log.d("LoginActivity", "--onSuccess" + userid)
//                    startActivity(Intent(this@MainActivity, MainActivity::class.java))
//                    finish()


                toast("账户" + userid + "连接成功")
                if (userid.equals("10011")){
                    btn_connect_02.isEnabled = false
                    btn_connect_01.text = "用户1连接成功"
                }else{
                    btn_connect_01.isEnabled = false
                    btn_connect_02.text = "用户2连接成功"
                }



            }

            /**
             * 连接融云失败
             * @param errorCode 错误码，可到官网 查看错误码对应的注释
             */
            override fun onError(errorCode: RongIMClient.ErrorCode) {
                Log.d("tag",errorCode.toString())
            }
        })
    }
//    }
}
