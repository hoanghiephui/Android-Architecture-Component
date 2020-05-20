package com.library.sample.ui.main

import android.os.Bundle
import android.view.View
import com.library.base.extensions.viewModelProvider
import com.library.base.ui.BaseFragment
import com.library.sample.R

class MainFragment : BaseFragment() {
    private lateinit var viewModel: MainFragmentViewModel

    override fun getLayout() = R.layout.fragment_main

    override fun initViewModel() {
        viewModel = viewModelProvider(viewModelFactory)
    }

    override fun viewCreated(view: View, savedInstanceState: Bundle?) {

    }
}