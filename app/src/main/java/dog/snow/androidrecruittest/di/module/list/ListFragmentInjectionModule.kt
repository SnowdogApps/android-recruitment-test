package dog.snow.androidrecruittest.di.module.list

import android.util.Log
import android.widget.ImageView
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import dagger.Module
import dagger.Provides
import dog.snow.androidrecruittest.R
import dog.snow.androidrecruittest.ui.common.view_model.ViewModelFactory
import dog.snow.androidrecruittest.ui.page.list.ListAdapter
import dog.snow.androidrecruittest.ui.page.list.ListFragment
import dog.snow.androidrecruittest.ui.page.list.ListFragmentDirections

import dog.snow.androidrecruittest.ui.page.list.ListViewModel
import kotlinx.android.synthetic.main.item_list.view.*

@Module
class ListFragmentInjectionModule {

    @Provides
    fun provideListViewModel(fragment: ListFragment, factory: ViewModelFactory): ListViewModel {
        Log.i(TAG, "Provide ListViewModel.")
        return ViewModelProvider(fragment.viewModelStore, factory)[ListViewModel::class.java]
    }

    @Provides
    fun provideListAdapter(fragment: ListFragment): ListAdapter = ListAdapter { item, _, view ->
        val action = ListFragmentDirections.actionListFragmentToDetailsFragment(item.uId)
        val extras = FragmentNavigatorExtras(
            view.findViewById<ImageView>(R.id.iv_thumb) to item.uId.toString()
        )
        fragment.findNavController().navigate(action, extras)
    }

    companion object {
        private val TAG = ListFragmentInjectionModule::class.simpleName
    }
}