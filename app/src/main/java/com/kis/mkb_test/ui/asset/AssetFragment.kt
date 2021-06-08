package com.kis.mkb_test.ui.asset

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kis.mkb_test.MainActivity
import com.kis.mkb_test.R
import com.kis.mkb_test.databinding.AssetFragmentBinding
import com.kis.mkb_test.model.pojo.AssetRate
import java.lang.RuntimeException

class AssetFragment : Fragment() {

    companion object {
        const val BUNDLE_EXTRA = "asset_rate"
        fun newInstance(bundle : Bundle) : AssetFragment {
            val fragment = AssetFragment()
            fragment.arguments = bundle
            return fragment
        }
    }

    private var _binding: AssetFragmentBinding? = null
    private val binding get() = _binding ?: throw RuntimeException("Trying to reach binding between onCreateView and OnDestroyView")

    private val assetRate : AssetRate? by lazy {
        arguments?.getParcelable(BUNDLE_EXTRA)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = AssetFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        assetRate?.let {
            bindAssetRate()
        }
    }

    fun bindAssetRate() {
        if (assetRate == null) {
            (requireActivity() as MainActivity).navigateToDefaultFragment()
        }
        assetRate?.let {
            requireActivity().title = it.currMnemTo
            with(it) {
                binding.assetsRowCurMnemTo.text = currMnemTo
                binding.assetsRowCurCodeTo.text = String.format("(%d)", to)
                binding.assetsRowBuyForValue.text = buy.toString()
                binding.assetsRowBuyDelta.text = deltaBuy.toString()
                binding.assetsRowSellForValue.text = sale.toString()
                binding.assetsRowSellDelta.text = deltaSale.toString()
                binding.assetsRowCurMnemFrom.text = currMnemFrom
                binding.assetsRowCurCodeFrom.text = String.format("(%d)", from)
                binding.assetsFragmentTp.text = tp.toString()
                binding.assetsFragmentName.text = name
                binding.assetsFragmentBasic.text = basic.toString()
            }

        }
    }
}