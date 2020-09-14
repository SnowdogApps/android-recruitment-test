package dog.snow.androidrecruittest.di.module.base

import androidx.fragment.app.Fragment
import dagger.Binds
import dagger.Module

@Module
abstract class BaseFragmentModule<F : Fragment> {
    @Binds
    abstract fun bindFragment(fragment: F): Fragment
}