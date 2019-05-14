package dog.snow.androidrecruittest.ui.list


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import androidx.lifecycle.ViewModelProviders
import dog.snow.androidrecruittest.R
import dog.snow.androidrecruittest.data_repository.SnowDogViewModel
import dog.snow.androidrecruittest.models.Item
import kotlinx.android.synthetic.main.fragment_list.*

class ListFragment : Fragment(), ListContract.View {

    private lateinit var viewModel: SnowDogViewModel
    private lateinit var listAdapter: SDListAdapter
    lateinit var presenter: ListPresenter
    lateinit var recycler: RecyclerView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        viewModel = ViewModelProviders.of(this).get(SnowDogViewModel::class.java)
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter = ListPresenter()
        presenter.attach(this)
        initView()
    }

    private fun initView() {
        recycler = conteiner_item
        listAdapter = SDListAdapter(context!!)
        recycler.adapter = listAdapter
        viewModel.itemList.observe(this,Observer<List<Item>>{
            listAdapter.setItemList(it as ArrayList<Item>)
        })

//        swipe_to_refresh.visibility = View.INVISIBLE


    }


}
