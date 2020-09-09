package dog.snow.androidrecruittest.di.module

import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dog.snow.androidrecruittest.ui.common.view_model.ViewModelFactory

@Module
interface ViewModelModule {

    @Binds
    fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}