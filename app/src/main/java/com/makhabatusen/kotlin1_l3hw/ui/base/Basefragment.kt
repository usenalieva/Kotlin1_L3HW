package com.makhabatusen.kotlin1_l3hw.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.viewbinding.ViewBinding
import com.makhabatusen.kotlin1_l3hw.models.FragmentViewModel

abstract class BaseFragment<VB : ViewBinding> : Fragment() {
    protected lateinit var ui: VB
    protected abstract fun bind(): VB
    protected lateinit var viewModel: FragmentViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(requireActivity()).get(FragmentViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        ui = bind()
        return ui.root
    }
}
