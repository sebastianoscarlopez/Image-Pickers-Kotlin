package ar.com.sebas.imagepickerskotlin

import ar.com.sebas.imagepickerskotlin.dummy.DummyContent

/**
 * Created by sebas on 7/11/2017.
 *
 * This interface must be implemented by activities that contain this
 * fragment to allow an interaction in this fragment to be communicated
 * to the activity and potentially other fragments contained in that
 * activity.
*/
interface ImagePickersListener {
    fun onPick(item: DummyContent.DummyItem)
}