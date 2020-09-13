package dog.snow.androidrecruittest.di.module

import android.app.Application
import dagger.Module
import dagger.Provides
import dog.snow.androidrecruittest.data.model.photo.MyObjectBox
import dog.snow.androidrecruittest.data.model.photo.RawPhoto
import io.objectbox.Box
import io.objectbox.BoxStore
import io.objectbox.kotlin.boxFor
import javax.inject.Singleton

@Module
class StorageModule {

    @Provides
    @Singleton
    fun provideDatabase(application: Application): BoxStore = MyObjectBox.builder()
        .androidContext(application.applicationContext)
        .build()

    @Provides
    @Singleton
    fun providePhotoBox(boxStore: BoxStore): Box<RawPhoto> = boxStore.boxFor()

}