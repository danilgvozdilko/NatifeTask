package com.example.natifetask.ui.personalData

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.natifetask.R
import com.example.natifetask.databinding.FragmentPersonalDataBinding
import com.example.natifetask.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PersonalDataFragment : BaseFragment<PersonalDataViewModel>() {

    override val viewModel: PersonalDataViewModel by viewModels()
    lateinit var binding: FragmentPersonalDataBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPersonalDataBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUI()
    }

    private fun setUI() {
        val sharedPreferences =
            activity?.getSharedPreferences(getString(R.string.user_status), Context.MODE_PRIVATE)
        val email = sharedPreferences?.getString(getString(R.string.email), "")
        val password = sharedPreferences?.getString(getString(R.string.password), "")
        binding.apply {
            emailTxt.text = email
            passwordTxt.text = password
            txtBack.setOnClickListener {
                findNavController().popBackStack()
            }
        }
    }

}