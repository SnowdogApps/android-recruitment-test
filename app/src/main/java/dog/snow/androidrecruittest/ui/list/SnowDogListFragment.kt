package dog.snow.androidrecruittest.ui.list


import android.os.Bundle
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import dog.snow.androidrecruittest.R
import dog.snow.androidrecruittest.data_repository.SnowDogViewModel
import dog.snow.androidrecruittest.models.Item
import kotlinx.android.synthetic.main.fragment_list.*
import java.nio.file.WatchEvent
import android.view.View.INVISIBLE as INVISIBLE1

class SnowDogListFragment : Fragment(), SnowDogListContract.View, SwipeRefreshLayout.OnRefreshListener {

    private lateinit var listAdapter: SnowDogListAdapter
    lateinit var presenterSnowDog: SnowDogListPresenter
    lateinit var recycler: RecyclerView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {


        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenterSnowDog = SnowDogListPresenter()
        presenterSnowDog.attach(this, ViewModelProviders.of(this).get(SnowDogViewModel::class.java))
        initView()
    }

    private fun initView() {
        search_edit_frame.setOnEditorActionListener{ textView, keyCode, keyEvent ->
            val DONE = 6

            if (keyCode == DONE) {
                presenterSnowDog.searchDB(textView.text.toString())
            }
            false
        }
        recycler = conteiner_item
        listAdapter = SnowDogListAdapter(context!!)
        recycler.layoutManager = LinearLayoutManager(context)
        recycler.adapter = listAdapter
        presenterSnowDog.getViewModel().getItemList().observe(this, Observer<List<Item>> {
            listAdapter.setItemList(it as ArrayList<Item>)
        })

//        swipe_to_refresh.visibility = View.INVISIBLE
        swipe_to_refresh.setOnRefreshListener(this)
    }

    override fun onRefresh() {
        presenterSnowDog.loadData()
        updateView()
    }

    override fun updateView() {
        presenterSnowDog.getViewModel().getItemList().observe(this, Observer<List<Item>> {
            listAdapter.setItemList(it as ArrayList<Item>)
            swipe_to_refresh.visibility= INVISIBLE1
        })
    }

}
