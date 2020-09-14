package dog.snow.androidrecruittest.di.module.main

import android.app.Application
import dagger.Module
import dagger.Provides
import dog.snow.androidrecruittest.data.model.raw.MyObjectBox
import dog.snow.androidrecruittest.data.model.raw.RawAlbum
import dog.snow.androidrecruittest.data.model.raw.RawPhoto
import dog.snow.androidrecruittest.data.model.raw.RawUser
import io.objectbox.Box
import io.objectbox.BoxStore
import io.objectbox.DebugFlags
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

    @Provides
    @Singleton
    fun provideAlbumBox(boxStore: BoxStore): Box<RawAlbum> = boxStore.boxFor()

    @Provides
    @Singleton
    fun provideUserBox(boxStore: BoxStore): Box<RawUser> = boxStore.boxFor()

}