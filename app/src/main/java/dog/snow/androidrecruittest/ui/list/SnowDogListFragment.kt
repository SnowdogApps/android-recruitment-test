package dog.snow.androidrecruittest.ui.list


import android.os.Bundle
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import dog.snow.androidrecruittest.data_repository.SnowDogViewModel
import dog.snow.androidrecruittest.models.Item
import kotlinx.android.synthetic.main.fragment_list.*
import android.view.View.INVISIBLE as INVISIBLE1
import android.view.animation.AnimationUtils
import dog.snow.androidrecruittest.R


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
        search_edit_frame.setOnEditorActionListener { textView, keyCode, keyEvent ->
            val DONE = 0

            if (keyEvent.action.equals(KeyEvent.ACTION_DOWN) || keyEvent.action.equals(KeyEvent.ACTION_UP)) {
                presenterSnowDog.searchDB(textView.text.toString())
                searchUpdate()
            }
            true
        }
        recycler = conteiner_item
        listAdapter = SnowDogListAdapter(context!!)
        recycler.layoutManager = LinearLayoutManager(context)
        recycler.adapter = listAdapter
        recycler.layoutAnimation = AnimationUtils.loadLayoutAnimation(context, R.anim.fall_down_animation)
        swipe_to_refresh.setOnRefreshListener(this)
        presenterSnowDog.loadData()
    }

    override fun onRefresh() {
        presenterSnowDog.loadData()
    }

    override fun updateView() {
        presenterSnowDog.getViewModel().getItemList().observe(this, object : Observer<List<Item>> {
            override fun onChanged(t: List<Item>?) {
                setUpdateInfo(t!!)
            }
        })
    }

    override fun searchUpdate() {
        presenterSnowDog.getViewModel().getSearchResult().observe(this, object : Observer<List<Item>> {
            override fun onChanged(t: List<Item>?) {
                setUpdateInfo(t!!)
            }
        })
    }

    private fun setUpdateInfo(search: List<Item>) {
        listAdapter.setItemList(search as ArrayList<Item>)
        swipe_to_refresh.isRefreshing = false
//        recycler.scheduleLayoutAnimation()
    }

}
