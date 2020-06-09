package com.library.sample.ui.main

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.library.base.extensions.show
import com.library.base.extensions.viewModelProvider
import com.library.base.ui.BaseFragment
import com.library.base.ui.LayoutId
import com.library.sample.R
import com.library.sample.ui.func.BillingFragment
import kotlinx.android.synthetic.main.fragment_main.*

@LayoutId(R.layout.fragment_main)
class MainFragment : BaseFragment(), BottomNavigationView.OnNavigationItemSelectedListener {
    private lateinit var viewModel: MainFragmentViewModel

    override fun initViewModel() {
        viewModel = viewModelProvider(viewModelFactory)
    }

    override fun viewCreated(view: View, savedInstanceState: Bundle?) {
        viewPager.apply {
            offscreenPageLimit = 2
        }
        bottomBar.setOnNavigationItemSelectedListener(this)
        btnBilling.setOnClickListener {
            BillingFragment().show(childFragmentManager)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.menu_home -> {
                viewPager.currentItem = 0
                true
            }
            R.id.menu_net -> {
                viewPager.currentItem = 1
                true
            }
            R.id.menu_debug -> {
                viewPager.currentItem = 2
                true
            }
            else -> {
                false
            }
        }
    }
}