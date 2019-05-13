package dog.snow.androidrecruittest.ui.main

import dog.snow.androidrecruittest.ui.base.BaseContract

interface MainContract :BaseContract{
    interface View:BaseContract.View
    interface Presenter:BaseContract.Presenter<View>

}