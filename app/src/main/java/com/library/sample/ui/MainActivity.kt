package com.library.sample.ui

import com.library.base.extensions.viewModelProvider
import com.library.base.ui.BaseActivity
import com.library.base.ui.LayoutId
import com.library.sample.R

@LayoutId(R.layout.activity_main)
class MainActivity : BaseActivity() {
    private lateinit var viewModel: MainActivityViewModel

    override fun initView() {

    }

    override fun initViewModel() {
        viewModel = viewModelProvider(viewModelFactory)
    }

    override fun initLogic() {

    }
}
