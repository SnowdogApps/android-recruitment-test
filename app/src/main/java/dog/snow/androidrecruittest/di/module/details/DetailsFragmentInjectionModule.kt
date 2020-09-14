package dog.snow.androidrecruittest.di.module.details

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import dog.snow.androidrecruittest.data.model.type.common.UId
import dog.snow.androidrecruittest.di.key.ViewModelKey
import dog.snow.androidrecruittest.ui.common.view_model.ViewModelFactory
import dog.snow.androidrecruittest.ui.page.details.DetailsFragment
import dog.snow.androidrecruittest.ui.page.details.DetailsFragmentArgs
import dog.snow.androidrecruittest.ui.page.details.DetailsViewModel

@Module
class DetailsFragmentInjectionModule {

    @Provides
    fun provideListViewModel(fragment: DetailsFragment, factory: ViewModelFactory): DetailsViewModel {
        Log.i(TAG, "Provide ListViewModel.")
        return ViewModelProvider(fragment.viewModelStore, factory)[DetailsViewModel::class.java]
    }

    companion object {
        private val TAG = DetailsFragmentInjectionModule::class.simpleName
    }
}