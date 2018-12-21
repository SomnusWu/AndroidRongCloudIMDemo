package com.yx.povertyanalysis.utils

import android.content.Context
import android.view.View

/**
 * Created by Somnus on 2018/7/16.
 */

/**
 *-------------------------------------------------------------
 * 给控件添加点击事件 ，
 * listener : 传入this
 * views : 传入需要添加点击事件的控件
 *-------------------------------------------------------------
 */
fun Context.setViewClick(listener: View.OnClickListener, vararg views: View) {
    for (it in views) {
        it.setOnClickListener(listener)
    }
}