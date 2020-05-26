package com.library.sample.ui

import com.library.base.extensions.viewModelProvider
import com.library.base.ui.BaseActivity
import com.library.sample.R

class MainActivity : BaseActivity() {
    private lateinit var viewModel: MainActivityViewModel

    override fun getLayout(): Int {
        return R.layout.activity_main
    }

    override fun initView() {

    }

    override fun initViewModel() {
        viewModel = viewModelProvider(viewModelFactory)
    }

    override fun initLogic() {

    }
}
