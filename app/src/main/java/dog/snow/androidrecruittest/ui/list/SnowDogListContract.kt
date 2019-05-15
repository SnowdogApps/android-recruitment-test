package dog.snow.androidrecruittest.ui.list

import dog.snow.androidrecruittest.ui.base.BaseContract

interface SnowDogListContract :BaseContract{
    interface View:BaseContract.View{
        fun updateView()
        fun searchUpdate()
    }
    interface Presenter:BaseContract.Presenter<View>{
        fun loadData()
    }

}