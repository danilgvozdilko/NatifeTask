package com.example.natifetask.ui.registration

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Patterns
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.viewModels
import com.example.natifetask.R
import com.example.natifetask.databinding.FragmentRegistrationBinding
import com.example.natifetask.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RegistrationFragment : BaseFragment<RegistrationViewModel>() {

    override val viewModel: RegistrationViewModel by viewModels()
    private lateinit var binding: FragmentRegistrationBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRegistrationBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.email.doOnTextChanged { text, start, before, count ->
            validateData()
        }

        binding.password.doOnTextChanged { text, start, before, count ->
            validateData()
        }
        binding.toLogin.setOnClickListener {
            viewModel.navigateToLogin()
        }
        binding.btnRegistrate.setOnClickListener {
            validateAccount()
        }

    }

    private fun validateData() {
        binding.btnRegistrate.isEnabled = (binding.email.text?.toString()?.length!! > 0
                && Patterns.EMAIL_ADDRESS.matcher(binding.email.text)
            .matches() && binding.password.text?.length!! > 0)
    }

    private fun validateAccount() {
        val sharedPreferences =
            context?.getSharedPreferences(getString(R.string.user_status), Context.MODE_PRIVATE)
        val email = sharedPreferences?.getString(getString(R.string.email), "")
        val password = sharedPreferences?.getString(getString(R.string.password), "")
        if (binding.email.text.toString() == email && binding.password.text.toString() == password) {
            Toast.makeText(
                requireContext(),
                getText(R.string.acc_already_use),
                Toast.LENGTH_SHORT
            ).show()
        } else {
            val editor: SharedPreferences.Editor? = sharedPreferences?.edit()
            editor?.putString(getString(R.string.email), binding.email.text.toString())
            editor?.putString(getString(R.string.password), binding.password.text.toString())
            editor?.putBoolean(getString(R.string.logedIn), true)
            editor?.commit()
            viewModel.navigateToMain()
        }
    }

}