package ar.com.sebas.imagepickerskotlinsamples

import android.app.Activity
import android.os.Bundle
import android.view.View
import ar.com.sebas.imagepickerskotlin.ImagePickers

class MainActivity : Activity() {

    var picker = ImagePickers(this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun startPicker(view: View)
    {
        picker.showActivityResult()
    }
}
