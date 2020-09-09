package dog.snow.androidrecruittest.repository.service

import dog.snow.androidrecruittest.repository.model.ItemsLocalRepository
import io.reactivex.Single

class ListItems constructor(
    private val listItemsLocalRepository: ItemsLocalRepository
) : SingleCase<List<ListItem>, Unit>() {

    override fun getAllLocalItems(params: Unit?): Single<List<ListItem>> =
        listItemsLocalRepository.getAllItems()

}
