package dog.snow.androidrecruittest.di.module.list

import android.util.Log
import androidx.lifecycle.ViewModelProvider
import dagger.Module
import dagger.Provides
import dog.snow.androidrecruittest.ui.common.view_model.ViewModelFactory
import dog.snow.androidrecruittest.ui.page.list.ListAdapter
import dog.snow.androidrecruittest.ui.page.list.ListFragment
import dog.snow.androidrecruittest.ui.page.list.ListViewModel

@Module
class ListFragmentInjectionModule {

    @Provides
    fun provideListViewModel(fragment: ListFragment, factory: ViewModelFactory): ListViewModel {
        Log.i(TAG, "Provide ListViewModel.")
        return ViewModelProvider(fragment.viewModelStore, factory)[ListViewModel::class.java]
    }

    @Provides
    fun provideListAdapter(): ListAdapter = ListAdapter {item, position, view ->
        //TODO: navigate to details activity
    }

    companion object {
        private val TAG = ListFragmentInjectionModule::class.simpleName
    }
}