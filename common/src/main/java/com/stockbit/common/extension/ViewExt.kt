package com.stockbit.common.extension

import android.opengl.Visibility
import android.view.View
import android.widget.Toast
import androidx.core.widget.NestedScrollView
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import com.google.android.material.snackbar.Snackbar
import com.stockbit.common.utils.Event

/**
 * Transforms static java function Snackbar.make() to an extension function on View.
 */
fun Fragment.showSnackbar(snackbarText: String, timeLength: Int) {
    activity?.let { Snackbar.make(it.findViewById<View>(android.R.id.content), snackbarText, timeLength).show() }
}

/**
 * Triggers a snackbar message when the value contained by snackbarTaskMessageLiveEvent is modified.
 */
fun Fragment.setupSnackbar(lifecycleOwner: LifecycleOwner, snackbarEvent: LiveData<Event<Int>>, timeLength: Int) {
    snackbarEvent.observe(lifecycleOwner, Observer { event ->
        event.getContentIfNotHandled()?.let { res ->
            context?.let { showSnackbar(it.getString(res), timeLength) }
        }
    })
}

fun View.visible() = View.VISIBLE.also { this.visibility = it }

fun View.inVisible() = View.INVISIBLE.also { this.visibility = it }

fun View.gone() = View.GONE.also { this.visibility = it }

fun NestedScrollView.onLoadMoreListener(onLoadMore: () -> Unit) {
    this.setOnScrollChangeListener { v: NestedScrollView?, _: Int, y: Int, _: Int, oldY: Int ->
        val isScrollingDown = y > oldY

        if (v?.getChildAt(v.childCount - 1) != null) {
            val lastItemPosition = v.getChildAt(v.childCount - 1).measuredHeight - v.measuredHeight
            val reachBottom = y >= lastItemPosition

            if (isScrollingDown && reachBottom) onLoadMore.invoke()
        }
    }
}