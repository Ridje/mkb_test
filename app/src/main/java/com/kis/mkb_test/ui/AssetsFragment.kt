package com.kis.mkb_test.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.kis.mkb_test.R
import com.kis.mkb_test.databinding.AssetsFragmentBinding
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

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = AssetsFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.ratesLiveData.observe(viewLifecycleOwner) {
            renderState(it)
        }
        viewModel.getRates()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    fun renderState(fragmentState : AssetsState) {
        when (fragmentState) {
            is AssetsState.Error -> {
                binding.progressBar.visibility = View.GONE
                binding.root.showSnackBar(getString(R.string.Error), getString(R.string.Reload)) { viewModel.getRates() }
            }
            is AssetsState.Loading -> {
                binding.assetsFragmentRates.visibility = View.GONE
                binding.progressBar.visibility = View.VISIBLE
            }
            is AssetsState.Success -> {
                binding.progressBar.visibility = View.GONE
                binding.assetsFragmentRates.adapter = AssetsAdapter(fragmentState.rates)
                binding.assetsFragmentRates.visibility = View.VISIBLE
            }
        }
    }
}
