package com.mywings.questionset.events

/**
 * @author Tatyabhau Chavan
 * @created 11/12/2017
 */

interface OnInformativeListener : OnLayoutListener, OnInputManagerListener {
    fun show()
    fun show(id: Int)
}
