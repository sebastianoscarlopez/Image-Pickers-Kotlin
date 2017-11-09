package ar.com.sebas.imagepickerskotlin

import android.content.Context
import android.os.Bundle
import android.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import ar.com.sebas.imagepickerskotlin.dummy.DummyContent
import ar.com.sebas.imagepickerskotlin.dummy.DummyContent.DummyItem

/**
 * A fragment representing a list of Items.
 *
 *
 * Activities containing this fragment MUST implement the [ImagePickersListener]
 * interface.
 */
/**
 * Mandatory empty constructor for the fragment manager to instantiate the
 * fragment (e.g. upon screen orientation changes).
 */
class ImagePickersFragment : Fragment() {

    // TODO: Customize parameters
    private val mColumnCount = 3

    private var mListener: ImagePickersListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater!!.inflate(R.layout.fragment_image_list, container, false)

        // Set the adapter
        if (view is RecyclerView) {
            val context = view.getContext()
            val recyclerView = view as RecyclerView
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(LinearLayoutManager(context))
            } else {
                recyclerView.setLayoutManager(GridLayoutManager(context, mColumnCount))
            }
            recyclerView.setAdapter(MyImageRecyclerViewAdapter(DummyContent.ITEMS, mListener))
        }
        return view
    }


    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if (context is ImagePickersListener) {
            mListener = context
        } else {
            throw RuntimeException(context!!.toString() + " must implement ImagePickersListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        mListener = null
    }
}
