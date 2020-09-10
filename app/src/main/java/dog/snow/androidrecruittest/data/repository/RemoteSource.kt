package dog.snow.androidrecruittest.data.repository

import dog.snow.androidrecruittest.data.source.remote.service.PhotoService
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RemoteSource @Inject constructor(
    private val photoService: PhotoService
) : RemoteRepository {


}