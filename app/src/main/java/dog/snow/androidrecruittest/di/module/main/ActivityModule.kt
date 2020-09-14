package dog.snow.androidrecruittest.di.module.main

import dagger.Module
import dagger.android.ContributesAndroidInjector
import dog.snow.androidrecruittest.di.module.splash.SplashActivityModule
import dog.snow.androidrecruittest.ui.page.splash.SplashActivity
import dog.snow.androidrecruittest.ui.page.main.MainActivity

@Module
interface ActivityModule {

    @ContributesAndroidInjector
    fun provideMainActivity(): MainActivity

    @ContributesAndroidInjector(modules = [SplashActivityModule::class])
    fun provideSplashActivity(): SplashActivity
}