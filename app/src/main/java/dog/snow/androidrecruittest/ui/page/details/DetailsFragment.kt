package dog.snow.androidrecruittest.ui.page.details

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.transition.TransitionInflater
import dagger.android.support.AndroidSupportInjection
import dog.snow.androidrecruittest.R
import dog.snow.androidrecruittest.databinding.FragmentDetailsBinding
import dog.snow.androidrecruittest.utils.subscribe
import javax.inject.Inject

class DetailsFragment : Fragment(R.layout.fragment_details) {

    @Inject
    lateinit var detailsViewModel: DetailsViewModel
    private lateinit var binding: FragmentDetailsBinding

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupObservers()
        setUpView()
        detailsViewModel.getDetails(DetailsFragmentArgs.fromBundle(requireArguments()).photoUId)
    }

    /** Utils. */

    private fun setUpView() {
        sharedElementEnterTransition = TransitionInflater.from(context).inflateTransition(android.R.transition.move)
        binding.ivPhoto.apply {
            startPostponedEnterTransition()
        }
    }

    private fun setupObservers() {
        detailsViewModel.details.subscribe(this) { binding.detail = it }
    }
}