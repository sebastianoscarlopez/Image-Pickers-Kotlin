package ar.com.sebas.imagepickerskotlin

import android.content.Context
import android.content.Intent

/**
 * Created by sebas on 7/11/2017.
 */

class ImagePickers(var context: Context) {

    fun showActivityResult(){
        val intent = Intent(context, PickerActivity::class.java)
        context.startActivity(intent)
    }
}