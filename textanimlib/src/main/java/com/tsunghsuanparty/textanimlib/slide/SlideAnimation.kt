package com.tsunghsuanparty.textanimlib.slide

import android.os.Handler
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.widget.TextView

/**
 * Author: Tsung Hsuan, Lai
 * Created on: 2019/3/6
 * Description:
 */
open class SlideAnimation {

    companion object {
        const val ANIM_SLOW = 0
        const val ANIM_NORMAL = 1
        const val ANIM_FAST = 2
    }

    var mBackColor = 0
    var mForeColor = 0

    var mAnimSpeed = 0

    fun initSettings(backColor: Int, foreColor: Int, animSpeed: Int) {
        mBackColor = backColor
        mForeColor = foreColor
        mAnimSpeed = animSpeed
    }

    fun startAnimation(msgTextView: TextView) {
        val handler = Handler()
        var startTime: Long
        var currentTime: Long
        var finishedTime: Long
        var endTime: Int

        startTime = System.currentTimeMillis()
        currentTime = startTime

        handler.postDelayed(object: Runnable {
            override fun run() {
                currentTime = System.currentTimeMillis()
                finishedTime = currentTime - startTime

                endTime = when (mAnimSpeed) {
                    ANIM_SLOW -> (finishedTime / 280).toInt()
                    ANIM_NORMAL -> (finishedTime / 140).toInt()
                    ANIM_FAST -> (finishedTime / 70).toInt()
                    else -> (finishedTime / 140).toInt()
                }
                //LOG.D(TAG, "finished time: $finishedTime, end time: $endTime")

                val spannableString = SpannableString(msgTextView.text)

                // Back to the beginning
                if (endTime > msgTextView.text.length) {
                    endTime = 0
                    startTime = currentTime
                    spannableString.setSpan(
                        ForegroundColorSpan(mBackColor), 0,
                        msgTextView.text.length,
                        Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
                } else {
                    spannableString.setSpan(
                        ForegroundColorSpan(mForeColor), 0, endTime,
                        Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
                }

                msgTextView.text = spannableString
                handler.postDelayed(this, 10)
            }
        }, 10)
    }
}