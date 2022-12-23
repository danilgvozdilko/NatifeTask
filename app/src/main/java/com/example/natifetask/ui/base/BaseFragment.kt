package com.example.natifetask.ui.base

import androidx.fragment.app.Fragment


abstract class BaseFragment<VM : BaseViewModel> : Fragment() {

    protected abstract val viewModel: VM

}