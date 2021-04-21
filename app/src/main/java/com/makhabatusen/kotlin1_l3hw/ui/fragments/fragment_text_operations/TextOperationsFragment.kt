package com.makhabatusen.kotlin1_l3hw.ui.fragments.fragment_text_operations

import android.os.Bundle
import android.view.View
import com.makhabatusen.kotlin1_l3hw.databinding.FragmentOperationsTextBinding
import com.makhabatusen.kotlin1_l3hw.ui.base.BaseFragment

class TextOperationsFragment : BaseFragment<FragmentOperationsTextBinding>() {
    override fun bind(): FragmentOperationsTextBinding {
        return FragmentOperationsTextBinding.inflate(layoutInflater)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.textResult.observe(viewLifecycleOwner, {
            ui.tvOperations.text = it.toString()
        })
    }
}