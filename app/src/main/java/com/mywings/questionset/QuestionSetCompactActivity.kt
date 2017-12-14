package com.mywings.questionset

import android.content.Context
import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import com.mywings.questionset.events.OnInformativeListener

abstract class QuestionSetCompactActivity : AppCompatActivity(), OnInformativeListener {


    //region Declaration Field

    //endregion Declaration Field

    override fun <T : ViewDataBinding> inflate(id: Int): ViewDataBinding {
        return DataBindingUtil.inflate(inflate(), id, getGroup(), false)
    }

    override fun <T : ViewDataBinding> attach(id: Int): ViewDataBinding {
        return DataBindingUtil.inflate(inflate(), id, getGroup(), true)
    }

    override fun getLayoutManager(flow: Int): RecyclerView.LayoutManager {
        val linearLayoutManager = LinearLayoutManager(applicationContext)
        linearLayoutManager.orientation = flow
        return linearLayoutManager
    }

    override fun hide(view: View?) {
        inputMethodManger()!!.hideSoftInputFromInputMethod(view!!.applicationWindowToken, InputMethodManager.HIDE_IMPLICIT_ONLY)
    }

    private fun inputMethodManger(): InputMethodManager? {
        val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager?
        return inputMethodManager
    }

    override fun inflate(): LayoutInflater {
        return LayoutInflater.from(this)
    }

    override fun <T : ViewDataBinding> setContentLayout(id: Int): ViewDataBinding {
        return DataBindingUtil.setContentView(this, id)
    }

    override fun show(message: String) {
        Toast.makeText(applicationContext, message, Toast.LENGTH_LONG).show()
    }

    override fun show(message: String, view: View?) {
        Snackbar.make(view!!, message, Snackbar.LENGTH_LONG).setAction("OK", { }).show()
    }

    override fun show(view: View?) {
        inputMethodManger()!!.hideSoftInputFromInputMethod(view!!.applicationWindowToken, 1)
    }

    override fun getGroup(): ViewGroup {
        return this.findViewById(android.R.id.content)
    }

}
