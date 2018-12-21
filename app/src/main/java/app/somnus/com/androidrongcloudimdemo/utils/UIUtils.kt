package com.yx.povertyanalysis.utils

import android.content.Context
import android.content.pm.PackageInfo
import android.content.pm.PackageManager
import android.content.res.Resources
import android.util.DisplayMetrics

/**
 * Created by Somnus on 2018/7/16.
 */


fun dpToPx(context: Context, dp: Float): Float {
    return dp * (context.resources.displayMetrics.densityDpi / 160f)
}

fun pxToDp(context: Context, px: Float): Float {
    return px / (context.resources.displayMetrics.densityDpi / 160f)
}

fun spToPx(context: Context, sp: Float): Float {
    return sp * context.resources.displayMetrics.scaledDensity
}

fun pxToSp(context: Context, px: Float): Float {
    return px / context.resources.displayMetrics.scaledDensity
}

fun dpToPx(dp: Float): Float {
    return dp * (Resources.getSystem().displayMetrics.densityDpi / 160f)
}

fun pxToDp(px: Float): Float {
    return px / (Resources.getSystem().displayMetrics.densityDpi / 160f)
}

fun spToPx(sp: Float): Float {
    return sp * Resources.getSystem().displayMetrics.scaledDensity
}

fun pxToSp(px: Float): Float {
    return px / Resources.getSystem().displayMetrics.scaledDensity
}

fun getDisplayMetrics(context: Context): DisplayMetrics {
    return context.resources.displayMetrics
}

fun getDisplayScreenWidth(context: Context): Int {
    return getDisplayMetrics(context).widthPixels
}

fun getDisplayScreenHeight(context: Context): Int {
    return getDisplayMetrics(context).heightPixels
}

/**
 *
 * @param context
 * @param name
 * @return
 * @Description:根据图片名称获取图片资源id
 */
fun getImageResourceId(context: Context, name: String): Int {
    return context.resources.getIdentifier(name, "drawable", context.packageName)
}


/**
 * 获取App版本名称
 *
 * @param context
 * @return
 */
fun getAppVersionName(context: Context): String {
    // 获取packagemanager的实例
    val packageManager = context.packageManager
    // getPackageName()是你当前类的包名，0代表是获取版本信息
    var packInfo: PackageInfo? = null
    try {
        packInfo = packageManager.getPackageInfo(context.packageName, 0)
    } catch (e: PackageManager.NameNotFoundException) {
        e.printStackTrace()
    }

    return packInfo!!.versionName
}


/**
 * 获取当前手机系统版本号
 * "7.1.2",
 * @return  系统版本号
 */
fun getSystemVersion(): String {
    return android.os.Build.VERSION.RELEASE
}

/**
 * 获取手机型号
 * "Redmi 5",
 * @return  手机型号
 */
fun getSystemModel(): String {
    return android.os.Build.MODEL
}

/**
 * 获取手机厂商
 * Xiaomi
 * @return  手机厂商
 */
fun getDeviceBrand(): String {
    return android.os.Build.BRAND
}
