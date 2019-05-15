package dog.snow.androidrecruittest.ui.list

import androidx.lifecycle.AndroidViewModel
import dog.snow.androidrecruittest.data_repository.SnowDogViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class SnowDogListPresenter : SnowDogListContract.Presenter {

    lateinit var view: SnowDogListContract.View
    private lateinit var viewModel: SnowDogViewModel

    fun attach(view: SnowDogListContract.View, viewModel: SnowDogViewModel) {
        this.viewModel = viewModel
        attach(view)
    }

    override fun attach(view: SnowDogListContract.View) {
        this.view = view
    }

    override fun loadData() {
        viewModel.loadData()
    }

    fun searchDB(search: String) {
        CoroutineScope(Dispatchers.IO).launch {
            viewModel.searchDB(search)
            withContext(Dispatchers.Main) {
                view.searchUpdate()
            }
        }
//        view.updateView()

    }

    fun getViewModel(): SnowDogViewModel {
        return viewModel
    }

}