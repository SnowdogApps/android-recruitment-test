package dog.snow.androidrecruittest.di.component

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import dog.snow.androidrecruittest.di.ApplicationController
import dog.snow.androidrecruittest.di.module.*
import javax.inject.Singleton

@Component(
    modules = [
        AndroidInjectionModule::class,
        ActivityModule::class,
        FragmentModule::class,
        NetworkModule::class,
        ViewModelModule::class,
        RepositoryModule::class
    ]
)
@Singleton
interface ApplicationComponent : AndroidInjector<ApplicationController> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder
        fun build(): ApplicationComponent
    }
}