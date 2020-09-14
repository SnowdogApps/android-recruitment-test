package dog.snow.androidrecruittest.di.module.splash

import dagger.Module
import dog.snow.androidrecruittest.di.module.base.BaseActivityModule
import dog.snow.androidrecruittest.ui.page.splash.SplashActivity

@Module(includes = [SplashViewModelModule::class])
abstract class SplashActivityModule : BaseActivityModule<SplashActivity>()