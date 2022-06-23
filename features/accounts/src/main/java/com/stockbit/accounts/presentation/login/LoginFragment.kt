package com.stockbit.accounts.presentation.login

import android.graphics.Typeface
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.text.style.StyleSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.Fragment
import com.stockbit.accounts.R
import com.stockbit.accounts.databinding.AccountsLoginFragmentBinding
import com.stockbit.common.base.BaseFragment
import com.stockbit.common.base.BaseViewModel
import com.stockbit.common.extension.gone
import com.stockbit.common.extension.visible
import com.stockbit.repository.utils.Resource
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoginFragment : BaseFragment() {
    private lateinit var binding : AccountsLoginFragmentBinding

    private val loginViewModel: LoginViewModel by viewModel()

    override fun getViewModel(): BaseViewModel = loginViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = AccountsLoginFragmentBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onSetupAccountData()
        initBinding()
    }

    private fun onSetupAccountData() {
        loginViewModel.initAccounts()
    }

    private fun initBinding() {
        with(binding){
            val spanText = getString(R.string.account_btn_suggest_register)
            val spanColor = ContextCompat.getColor(requireContext(), R.color.colorPrimary)
            val spannable = SpannableString(spanText)
            spannable.setSpan(
                ForegroundColorSpan(spanColor),
                17, spanText.length,
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
            )
            spannable.setSpan(
                StyleSpan(Typeface.BOLD),
                17,
                spanText.length,
                Spannable.SPAN_INCLUSIVE_EXCLUSIVE
            )
            btnSuggestRegister.text = spannable

            etUsernameOrEmail.doAfterTextChanged {
                tilUsernameOrEmail.error = null
                tilUsernameOrEmail.isErrorEnabled = false
            }

            etPassword.doAfterTextChanged {
                tilPassword.error = null
                tilPassword.isErrorEnabled = false
            }

            btnLogin.setOnClickListener {
                val usernameOrEmail = etUsernameOrEmail.text.toString()
                val password = etPassword.text.toString()

                if(usernameOrEmail.isBlank()){
                    tilUsernameOrEmail.isErrorEnabled = false
                    tilUsernameOrEmail.error = "Username or Email can not be empty"
                    return@setOnClickListener
                }

                if(password.isBlank()){
                    tilPassword.isErrorEnabled = false
                    tilPassword.error = "Password can not be empty"
                    return@setOnClickListener
                }

                loginViewModel.doLogin(usernameOrEmail, password)
                    .observe(viewLifecycleOwner){
                        when(it.status){
                            Resource.Status.LOADING -> {
                                loginProgress.visible()
                                btnLogin.gone()
                            }
                            Resource.Status.SUCCESS -> {
                                loginProgress.gone()
                                btnLogin.visible()
                                moveToHome()
                            }
                            Resource.Status.ERROR -> {
                                loginProgress.gone()
                                btnLogin.visible()
                                Toast.makeText(requireContext(), it.error?.message ?: "", Toast.LENGTH_SHORT).show()
                            }
                        }
                    }

            }
        }
    }

    private fun moveToHome() {
        val directions = LoginFragmentDirections.actionToHome()
        loginViewModel.navigate(directions)
    }


}