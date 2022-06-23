package com.stockbit.home.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.stockbit.common.base.BaseFragment
import com.stockbit.common.base.BaseViewModel
import com.stockbit.common.extension.gone
import com.stockbit.common.extension.onLoadMoreListener
import com.stockbit.common.extension.visible
import com.stockbit.home.databinding.FragmentHomeBinding
import com.stockbit.repository.utils.Resource
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : BaseFragment(){

    private lateinit var binding: FragmentHomeBinding

    private val homeViewModel: HomeViewModel by viewModel()

    override fun getViewModel(): BaseViewModel = homeViewModel

    private val cryptoAdapter : CryptoAdapter by lazy {
        CryptoAdapter()
    }

    private var currentPage: Int = 1
    private val limit: Int = 20
    private var lastLoadedItem: Int = 0

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
        initialBinding()
        getCryptoData(true)
    }

    private fun initialBinding() = with(binding){
        rvCrypto.adapter = cryptoAdapter
        nvCrypto.onLoadMoreListener { getCryptoData(false) }
        srlCrypto.setOnRefreshListener { getCryptoData(true) }
    }

    private fun getCryptoData(isLoading: Boolean) = with(binding){
        when {
            isLoading -> {
                cryptoAdapter.clear()
                currentPage = 1
            }
            lastLoadedItem == limit -> currentPage++
            else -> return
        }

        homeViewModel.getListCrypto(currentPage, limit).observe(viewLifecycleOwner) {
            when(it.status){
                Resource.Status.LOADING -> {
                    showLoading(isLoading)
                }
                Resource.Status.SUCCESS -> {
                    hideLoading(isLoading)
                    val result = it.data ?: emptyList()
                    if(result.isEmpty()){
                        showEmptyMessage()
                    }
                    lastLoadedItem = result.size
                    cryptoAdapter.addItems(result)
                }
                Resource.Status.ERROR -> {
                    hideLoading(isLoading)
                    showErrorMessage(it.error?.message)
                }
            }
        }
    }

    private fun FragmentHomeBinding.showLoading(isLoading: Boolean) {
        if(!isLoading) {
            moreProgress.visible()
            return
        }
        srlCrypto.gone()
        contentProgress.visible()
    }

    private fun FragmentHomeBinding.hideLoading(isLoading: Boolean) {
        if(!isLoading) {
            moreProgress.gone()
            return
        }
        contentProgress.gone()
        srlCrypto.visible()
    }

    private fun FragmentHomeBinding.showEmptyMessage() {
        contentMessage.visible()
        btnTry.gone()
        tvMessage.text = "Data tidak ditemukan"
    }

    private fun FragmentHomeBinding.showErrorMessage(error: String?) {
        contentMessage.visible()
        btnTry.visible()
        tvMessage.text = error ?: "Terjadi gangguan. Silahkan coba lagi"
        btnTry.setOnClickListener { getCryptoData(true) }
    }
}