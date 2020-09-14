package dog.snow.androidrecruittest.di.module.main

import dagger.Binds
import dagger.Module
import dagger.Provides
import dog.snow.androidrecruittest.data.repository.SourceRepository
import dog.snow.androidrecruittest.data.repository.SourceRepositoryImpl
import javax.inject.Singleton

@Module
interface RepositoryModule {

    @Binds
    @Singleton
    fun provideSourceRepository(remoteSourceImpl: SourceRepositoryImpl): SourceRepository
}