package dog.snow.androidrecruittest.di.module.details

import dagger.Module
import dog.snow.androidrecruittest.di.module.base.BaseFragmentModule
import dog.snow.androidrecruittest.ui.page.details.DetailsFragment

@Module(includes = [DetailsFragmentInjectionModule::class])
abstract class DetailsFragmentModule : BaseFragmentModule<DetailsFragment>() {}