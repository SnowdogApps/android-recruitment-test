package dog.snow.androidrecruittest.di.module

import dagger.Module
import dagger.Provides
import dog.snow.androidrecruittest.data.repository.SourceRepository
import dog.snow.androidrecruittest.data.repository.SourceRepositoryImpl
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Provides
    @Singleton
    fun provideRemoteRepository(remoteRepositoryImpl: SourceRepositoryImpl): SourceRepository = remoteRepositoryImpl
}