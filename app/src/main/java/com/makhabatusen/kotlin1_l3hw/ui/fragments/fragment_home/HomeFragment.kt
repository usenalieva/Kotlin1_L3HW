package com.makhabatusen.kotlin1_l3hw.ui.fragments.fragment_home

import android.os.Bundle
import android.view.View
import com.makhabatusen.kotlin1_l3hw.databinding.FragmentHomeBinding
import com.makhabatusen.kotlin1_l3hw.ui.base.BaseFragment

class HomeFragment : BaseFragment<FragmentHomeBinding>() {
    override fun bind(): FragmentHomeBinding {
        return FragmentHomeBinding.inflate(layoutInflater)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        ui.btnIncrease.setOnClickListener {
            viewModel.onIncrementClick()
        }

        ui.btnDecrease.setOnClickListener {
            viewModel.onDecrementClick()
        }
    }

}