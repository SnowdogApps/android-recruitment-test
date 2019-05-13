package dog.snow.androidrecruittest.ui.list

import dog.snow.androidrecruittest.ui.base.BaseContract

interface ListContract :BaseContract{
    interface View:BaseContract.View
    interface Presenter:BaseContract.Presenter<View
            >

}