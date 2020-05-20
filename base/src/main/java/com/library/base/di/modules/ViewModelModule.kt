package com.library.base.di.modules

import androidx.lifecycle.ViewModelProvider
import com.library.base.di.BaseViewModelFactory
import dagger.Binds
import dagger.Module

/**
 * Module used to define the connection between the framework's [ViewModelProvider.Factory] and
 * our own implementation: [BaseViewModelFactory].
 */
@Module
@Suppress("UNUSED")
abstract class ViewModelModule {

    @Binds
    internal abstract fun bindViewModelFactory(factory: BaseViewModelFactory):
            ViewModelProvider.Factory
}
