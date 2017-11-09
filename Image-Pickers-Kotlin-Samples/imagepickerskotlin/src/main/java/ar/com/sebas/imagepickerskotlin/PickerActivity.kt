package ar.com.sebas.imagepickerskotlin

import android.app.Activity
import android.graphics.Color
import android.os.Bundle
import android.support.annotation.IdRes
import android.view.View
import android.R.attr.fragment
import android.util.Log
import android.widget.Toast
import ar.com.sebas.imagepickerskotlin.dummy.DummyContent


class PickerActivity : Activity(), ImagePickersListener {

    fun <T : View> Activity.bind(@IdRes idRes: Int): Lazy<T> {
        @Suppress("UNCHECKED_CAST")
        return unsafeLazy { findViewById<T>(idRes) as T }
    }

    fun <T : View> View.bind(@IdRes idRes: Int): Lazy<T> {
        @Suppress("UNCHECKED_CAST")
        return unsafeLazy { findViewById<T>(idRes) as T }
    }

    private fun <T> unsafeLazy(initializer: () -> T) = lazy(LazyThreadSafetyMode.NONE, initializer)

    private val contentPicker by bind<View>(R.id.contentPicker)
    //private val grid by bind<View>(R.id.grid)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_picker)
        val manager = fragmentManager
        val transaction = manager.beginTransaction()
        transaction.add(R.id.gridSelector, ImagePickersFragment())
        transaction.commit()
    }

    override fun onPick(item: DummyContent.DummyItem) {
        Log.d("onPick", item.toString())
    }
}
