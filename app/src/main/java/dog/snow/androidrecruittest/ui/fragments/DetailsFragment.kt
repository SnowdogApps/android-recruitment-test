package dog.snow.androidrecruittest.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import dog.snow.androidrecruittest.R
import dog.snow.androidrecruittest.databinding.DetailsFragmentBinding
import dog.snow.androidrecruittest.extensions.arg
import dog.snow.androidrecruittest.extensions.argNotNull
import dog.snow.androidrecruittest.repository.service.DbConstans
import dog.snow.androidrecruittest.repository.service.ListItem
import kotlinx.android.synthetic.main.details_fragment.*


class DetailsFragment : Fragment(R.layout.details_fragment) {

    companion object {
        fun newInstance(listItem: ListItem, transitionName: String): DetailsFragment {
            val fragment = DetailsFragment()
            val args = Bundle().apply {
                putParcelable(DbConstans.BundleArgs.LIST_ITEM, listItem)
                putString(DbConstans.BundleArgs.TRANSITION, transitionName)
            }
            return fragment.apply { arguments = args }
        }
    }

    private lateinit var binding: DetailsFragmentBinding

    private val listItem: ListItem by argNotNull(DbConstans.BundleArgs.LIST_ITEM)

    private val transitionName: String? by arg(DbConstans.BundleArgs.TRANSITION)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DetailsFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bindData()
    }

    private fun bindData() {
        binding.photoDetail = listItem
        transitionName?.also { ivPhoto.transitionName = it }
    }
}
