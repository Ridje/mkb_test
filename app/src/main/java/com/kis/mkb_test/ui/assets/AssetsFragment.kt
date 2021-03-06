package com.kis.mkb_test.ui.assets

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.kis.mkb_test.MainActivity
import com.kis.mkb_test.R
import com.kis.mkb_test.databinding.AssetsFragmentBinding
import com.kis.mkb_test.model.pojo.AssetRate
import com.kis.mkb_test.ui.asset.AssetFragment
import com.kis.mkb_test.utils.showSnackBar
import dagger.hilt.android.AndroidEntryPoint
import java.lang.RuntimeException

@AndroidEntryPoint
class AssetsFragment : Fragment() {

    companion object {
        fun newInstance() = AssetsFragment()
    }

    private val viewModel : AssetsViewModel by viewModels()

    private var _binding: AssetsFragmentBinding? = null
    private val binding get() = _binding ?: throw RuntimeException("Trying to reach binding between onCreateView and OnDestoryView")

    private var _adapter: AssetsAdapter? = null
    private val assetsAdapter get() = _adapter ?: throw RuntimeException("Trying to reach binding between onViewCreated and OnDestoryView")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = AssetsFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        requireActivity().title = resources.getString(R.string.app_name)
        initAdapter()
        initObservable()
        initSwipeRefresh()
    }

    private fun initSwipeRefresh() {
        binding.assetsFragmentSwipeRefreshLayout.setOnRefreshListener { viewModel.getRates() }
    }

    private fun initObservable() {
        viewModel.ratesLiveData.observe(viewLifecycleOwner) {
            renderState(it)
        }
    }

    private fun initAdapter() {
        val onClickListener = { position : Int -> openAssetRate(assetsAdapter.assets[position]) }
        _adapter = AssetsAdapter(listOf(), onClickListener)
        binding.assetsFragmentRates.adapter = assetsAdapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
        _adapter = null
    }

    fun renderState(fragmentState : AssetsState) {
        when (fragmentState) {
            is AssetsState.Error -> {
                binding.assetsFragmentSwipeRefreshLayout.isRefreshing = false;
                binding.root.showSnackBar(getString(R.string.Error), getString(R.string.Reload)) { viewModel.getRates() }
            }
            is AssetsState.Loading -> {
                binding.assetsFragmentSwipeRefreshLayout.isRefreshing = true;
            }
            is AssetsState.Success -> {
                binding.assetsFragmentSwipeRefreshLayout.isRefreshing = false;
                assetsAdapter.assets =  fragmentState.rates
                binding.assetsFragmentRates.visibility = View.VISIBLE
                assetsAdapter.notifyDataSetChanged()
            }
        }
    }

    fun openAssetRate(assetRate : AssetRate) {
        val bundle = Bundle()
        bundle.putParcelable(AssetFragment.BUNDLE_EXTRA, assetRate)
        (requireActivity() as MainActivity).navigateToFragment(AssetFragment.newInstance(bundle))
    }
}
