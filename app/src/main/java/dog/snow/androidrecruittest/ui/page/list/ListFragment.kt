package dog.snow.androidrecruittest.ui.page.list

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.android.support.AndroidSupportInjection
import dog.snow.androidrecruittest.databinding.FragmentListBinding

import dog.snow.androidrecruittest.utils.subscribe
import javax.inject.Inject

class ListFragment : Fragment() {
    @Inject
    lateinit var listViewModel: ListViewModel
    @Inject
    lateinit var listAdapter: ListAdapter
    private lateinit var binding: FragmentListBinding


    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViews()
        setupObservers()
    }

    /** Utils. */

    private fun setupViews() {
        binding.rvItems.apply { adapter = listAdapter }
    }

    private fun setupObservers() {
        listViewModel.listItems.subscribe(viewLifecycleOwner) { listAdapter.submitList(it) }
    }
}