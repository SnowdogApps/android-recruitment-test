package dog.snow.androidrecruittest.di.module

import dagger.Module
import dagger.android.ContributesAndroidInjector
import dog.snow.androidrecruittest.ui.splash.SplashActivity
import dog.snow.androidrecruittest.ui.main.MainActivity

@Module
interface ActivityModule {

    @ContributesAndroidInjector
    fun provideMainActivity(): MainActivity

    @ContributesAndroidInjector
    fun provideSplashActivity(): SplashActivity
}