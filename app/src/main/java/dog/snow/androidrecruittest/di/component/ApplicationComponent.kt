package dog.snow.androidrecruittest.di.component

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dog.snow.androidrecruittest.di.ApplicationController
import javax.inject.Singleton

@Component(
    modules = [
        
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