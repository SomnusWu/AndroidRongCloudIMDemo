package app.somnus.com.androidrongcloudimdemo.utils

/**
 * Created by Somnus on 2018/12/20.
 */
import android.content.Context
import android.text.TextUtils
import android.view.Gravity
import android.view.View
import android.widget.Toast

/**
 * Created by Somnus on 2017/6/13.
 * @Description:
 */

/**
 * toast with custom view
 * @param resId  id of string resource to show
 * @param duration Set how long to show the view for.
 * @see android.widget.Toast.LENGTH_SHORT
 * @see android.widget.Toast.LENGTH_LONG
 */
fun Context.toast(resId: Int, duration: Int = Toast.LENGTH_SHORT) = myToast(resId, duration)

/**
 * toast with custom view
 * @param text  text to show
 * @param duration Set how long to show the view for.
 * @see android.widget.Toast.LENGTH_SHORT
 * @see android.widget.Toast.LENGTH_LONG
 */
fun Context.toast(text: String, duration: Int = Toast.LENGTH_SHORT) = myToast(text, duration)

fun Context.toastLong(text: String, duration: Int = Toast.LENGTH_LONG) = myToast(text, duration)

fun Context.toastLong(resId: Int, duration: Int = Toast.LENGTH_LONG) = myToast(resId, duration)


var lastToastTime: Long = 0
var lastToast: String = ""
val DURATION_LENGTH: Int = 2000

fun Context.myToast(message: CharSequence, duration: Int) {
    if (TextUtils.isEmpty(message))
        return
    val time: Long = System.currentTimeMillis()

    if (TextUtils.equals(message, lastToast) && Math.abs(time - lastToastTime) < DURATION_LENGTH)
        return
    Toast.makeText(this, message, duration).show()
    lastToast = message as String
    lastToastTime = System.currentTimeMillis()
}

var lastToastInt: Int = 0

fun Context.myToast(message: Int, duration: Int) {
    if (message == 0)
        return

    val time: Long = System.currentTimeMillis()

    if (message == lastToastInt && Math.abs(time - lastToastTime) < DURATION_LENGTH)
        return
    Toast.makeText(this, message, duration).show()
    lastToastInt = message
    lastToastTime = System.currentTimeMillis()

}

/**
 * toast with custom view
 * @param view  custom view to show
 * @param duration Set how long to show the view for.
 * @see android.widget.Toast.LENGTH_SHORT
 * @see android.widget.Toast.LENGTH_LONG
 */
fun Context.toastView(view: View, duration: Int = Toast.LENGTH_LONG) = Toast(this).makeView(view,
        duration = duration).show()


/**
 * make custome toast with custom view
 *
 * @param customeView  custom view to show
 * @param gravity Set the location at which the notification should appear on the screen.
 * @see android.view.Gravity
 * @param xOff the X offset in pixels to apply to the gravity's location
 * @param yOff the Y offset in pixels to apply to the gravity's location
 * @param duration Set how long to show the view for.
 * @see android.widget.Toast.LENGTH_SHORT
 * @see android.widget.Toast.LENGTH_LONG
 */
private fun Toast.makeView(customeView: View, gravity: Int = Gravity.CENTER, xOff: Int = 0,
                           yOff: Int = 0, duration: Int = Toast.LENGTH_LONG): Toast {
    this.view = customeView
    setGravity(gravity, xOff, yOff)
    setDuration(duration)
    return this
}