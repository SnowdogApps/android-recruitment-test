package dog.snow.androidrecruittest.repository.service

import dog.snow.androidrecruittest.repository.service.ListItem
import io.reactivex.Single

interface ItemsLocalRepository {

    fun getAllItems(): Single<List<ListItem>>

}