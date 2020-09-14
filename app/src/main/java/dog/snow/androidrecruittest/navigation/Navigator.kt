package dog.snow.androidrecruittest.navigation

import android.widget.ImageView
import androidx.fragment.app.FragmentManager
import androidx.transition.TransitionInflater
import dog.snow.androidrecruittest.ui.activities.BaseActivity
import dog.snow.androidrecruittest.R
import dog.snow.androidrecruittest.db.dao.FragmentUtil
import dog.snow.androidrecruittest.repository.service.ListItem
import dog.snow.androidrecruittest.ui.fragments.DetailsFragment
import dog.snow.androidrecruittest.ui.fragments.ListFragment


class Navigator
constructor(
    private val activity: BaseActivity,
    private val fragmentUtil: FragmentUtil
) {

    companion object {
        private const val FRAGMENT_CONTAINER = R.id.container
    }

    private val fragmentManager: FragmentManager by lazy { activity.supportFragmentManager }

    fun showDataListFragment() {
        if (isFragmentAlreadyShown<ListFragment>()) return

        fragmentUtil.replaceFragmentAllowingStateLoss(
            fragmentManager = fragmentManager,
            fragment = ListFragment.newInstance(),
            containerViewId = FRAGMENT_CONTAINER,
            addToBackStack = false,
            animate = false
        )
    }

    fun showDetailsFragment(listItem: ListItem, imageView: ImageView) {
        if (isFragmentAlreadyShown<DetailsFragment>()) return

        val fragment = DetailsFragment.newInstance(
            listItem = listItem,
            transitionName = imageView.transitionName
        ).also {
            it.sharedElementEnterTransition =
                TransitionInflater.from(activity).inflateTransition(R.transition.default_transition)
        }

        fragmentUtil.replaceFragmentAllowingStateLoss(
            imageView = imageView,
            fragmentManager = fragmentManager,
            fragment = fragment,
            containerViewId = FRAGMENT_CONTAINER,
            addToBackStack = true,
            animate = true
        )
    }

    private inline fun <reified T> isFragmentAlreadyShown() =
        fragmentUtil.findFragment(fragmentManager, FRAGMENT_CONTAINER) is T
}