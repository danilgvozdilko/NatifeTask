package com.example.natifetask.util

import android.annotation.SuppressLint
import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager

class HideKeyboard {
    companion object {
        @SuppressLint("ClickableViewAccessibility")
        fun hideKeyboard(context: Context, view: View) {
            view.setOnTouchListener { view, motionEvent ->
                val imm: InputMethodManager? =
                    context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager?
                imm?.hideSoftInputFromWindow(view.windowToken, 0)
                false
            }
        }
    }

}