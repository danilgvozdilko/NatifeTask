package com.example.natifetask.ui.selectedGif

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.bumptech.glide.Glide
import com.example.natifetask.data.GifDTO
import com.example.natifetask.databinding.FragmentSelectedBinding
import com.example.natifetask.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SelectedFragment : BaseFragment<SelectedViewModel>() {

    override val viewModel: SelectedViewModel by viewModels()
    lateinit var binding: FragmentSelectedBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSelectedBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val selected = SelectedFragmentArgs.fromBundle(requireArguments()).selected
        setUI(selected)
    }

    private fun setUI(selected: GifDTO?) {
        binding.name.text = selected?.username
        activity?.let {
            Glide.with(it).load(selected?.images?.original?.url).into(binding.imageView)
        }
    }

}