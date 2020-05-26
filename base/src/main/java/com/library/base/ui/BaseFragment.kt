package com.library.base.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.library.base.R
import com.library.base.extensions.inflate
import dagger.android.support.DaggerFragment
import javax.inject.Inject

abstract class BaseFragment : DaggerFragment() {
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = container?.inflate(getLayout())

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViewModel()
        viewCreated(view, savedInstanceState)
    }

    @LayoutRes
    abstract fun getLayout(): Int

    abstract fun initViewModel()

    abstract fun viewCreated(view: View, savedInstanceState: Bundle?)

    val toolbar by lazy {
        view?.findViewById<Toolbar>(R.id.toolbar)
            ?: throw IllegalAccessError("You have not added a Toolbar")
    }

    val recyclerView by lazy {
        view?.findViewById<RecyclerView>(R.id.recyclerView)
            ?: throw IllegalAccessError("You have not added a RecyclerView")
    }
    val swipeRefresh by lazy {
        view?.findViewById<SwipeRefreshLayout>(R.id.swipeRefresh)
            ?: throw IllegalAccessError("You have not added a SwipeRefresh")
    }
}