package com.stockbit.home.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.stockbit.common.base.BaseFragment
import com.stockbit.common.base.BaseViewModel
import com.stockbit.home.databinding.FragmentHomeBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : BaseFragment(){

    private lateinit var binding: FragmentHomeBinding

    private val homeViewModel: HomeViewModel by viewModel()

    override fun getViewModel(): BaseViewModel = homeViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}