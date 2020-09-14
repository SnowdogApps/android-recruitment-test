package dog.snow.androidrecruittest.di.component

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import dog.snow.androidrecruittest.di.ApplicationController
import dog.snow.androidrecruittest.di.module.main.*
import javax.inject.Singleton

@Component(
    modules = [
        AndroidInjectionModule::class,
        ActivityModule::class,
        FragmentModule::class,
        NetworkModule::class,
        StorageModule::class,
        ViewModelModule::class,
        RepositoryModule::class
    ]
)
@Singleton
interface ApplicationComponent : AndroidInjector<ApplicationController> {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance application: Application): ApplicationComponent
    }
}