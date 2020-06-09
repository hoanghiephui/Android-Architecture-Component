package com.library.sample.ui.func

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.library.base.extensions.inflate
import com.library.base.extensions.viewModelProvider
import com.library.base.ui.DaggerBottomSheetDialogFragment
import com.library.billing.BillingInject
import com.library.billing.BillingViewModel
import com.library.sample.BuildConfig
import com.library.sample.R

class BillingFragment : DaggerBottomSheetDialogFragment(), BillingInject {
    private lateinit var viewModel: BillingViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_billing, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = viewModelProvider(viewModelFactory)
        viewModel.onStartConnectToGoogleBilling(this)
    }

    override fun getPublicKey() = BuildConfig.GOOGLE_LICENCE

    override fun getSubscriptions(): List<String> {
        return listOf(BuildConfig.SUB_ONE)
    }
}