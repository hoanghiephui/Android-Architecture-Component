package com.library.sample.ui.func

import androidx.lifecycle.ViewModel
import com.library.base.di.ViewModelKey
import com.library.billing.BillingViewModel
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

@Module
abstract class BillingModule {
    @ContributesAndroidInjector
    internal abstract fun contributeBillingFragment(): BillingFragment


    @Binds
    @IntoMap
    @ViewModelKey(BillingViewModel::class)
    internal abstract fun bindViewModel(viewModel: BillingViewModel): ViewModel
}