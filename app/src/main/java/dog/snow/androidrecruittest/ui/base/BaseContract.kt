package dog.snow.androidrecruittest.ui.base

interface BaseContract {
    interface Presenter<in T>{
        fun attach(view:T)
    }
    interface View
}