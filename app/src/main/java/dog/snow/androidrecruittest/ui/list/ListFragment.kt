package dog.snow.androidrecruittest.ui.list


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView

import dog.snow.androidrecruittest.R

class ListFragment : Fragment(), ListContract.View {


    lateinit var presenter: ListPresenter
    lateinit var recycler:RecyclerView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter = ListPresenter()
        presenter.attach(this)
        initView()
    }

    private fun initView() {
//        recycler = findView

    }


}
