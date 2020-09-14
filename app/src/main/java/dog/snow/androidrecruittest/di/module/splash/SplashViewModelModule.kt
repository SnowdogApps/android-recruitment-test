package dog.snow.androidrecruittest.di.module.splash

import android.util.Log
import androidx.lifecycle.ViewModelProvider
import dagger.Module
import dagger.Provides
import dog.snow.androidrecruittest.ui.common.view_model.ViewModelFactory
import dog.snow.androidrecruittest.ui.page.splash.SplashActivity
import dog.snow.androidrecruittest.ui.page.splash.SplashViewModel

@Module
class SplashViewModelModule {
    @Provides
    fun provideSplashViewModel(activity: SplashActivity, factory: ViewModelFactory): SplashViewModel {
        Log.i(TAG, "Provide SplashViewModel.")
        return ViewModelProvider(activity, factory)[SplashViewModel::class.java]
    }

    companion object {
        private val TAG = SplashViewModelModule::class.simpleName
    }
}