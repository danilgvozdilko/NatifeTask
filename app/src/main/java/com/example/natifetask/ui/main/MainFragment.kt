package com.example.natifetask.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import com.example.natifetask.databinding.FragmentMainBinding
import com.example.natifetask.ui.base.BaseFragment
import com.example.natifetask.util.HideKeyboard
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment : BaseFragment<MainViewModel>() {

    override val viewModel: MainViewModel by viewModels()
    private lateinit var binding: FragmentMainBinding

    private val mainFragmentAdapter =
        MainFragmentAdapter(onClickProductListener = { selectedGif ->
            viewModel.navigateToSelected(selectedGif)
        })

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recyclerMain.adapter = mainFragmentAdapter
        HideKeyboard.hideKeyboard(requireContext(), binding.layout)
        loadGif()
    }

    private fun loadAdapter() {
        viewModel.listImage.observe(viewLifecycleOwner) {
            if (it != null) {
                mainFragmentAdapter.submitList(it.data)
            } else {
                Toast.makeText(requireContext(), "Oops...Something went wrong", Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }

    private fun loadGif() {
        binding.txtLoad.setOnClickListener {
            val limit = binding.editCount.text.toString()
            viewModel.getGifs(limit)
            binding.editCount.clearFocus()
            loadAdapter()
        }
    }

}