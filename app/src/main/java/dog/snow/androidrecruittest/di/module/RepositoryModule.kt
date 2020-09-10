package dog.snow.androidrecruittest.di.module

import dagger.Module
import dagger.Provides
import dog.snow.androidrecruittest.data.repository.RemoteRepository
import dog.snow.androidrecruittest.data.repository.RemoteSource
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Provides
    @Singleton
    fun provideRemoteRepository(remoteSource: RemoteSource): RemoteRepository = remoteSource
}