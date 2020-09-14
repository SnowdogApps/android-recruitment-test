package dog.snow.androidrecruittest.di.module.base

import androidx.appcompat.app.AppCompatActivity
import dagger.Binds
import dagger.Module

@Module
abstract class BaseActivityModule<A : AppCompatActivity> {
    @Binds
    abstract fun bindActivity(activity: A): AppCompatActivity
}