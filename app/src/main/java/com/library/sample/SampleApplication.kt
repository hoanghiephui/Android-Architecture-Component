package com.library.sample

import com.library.base.BaseApplication
import com.library.sample.di.AppComponent
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication

class SampleApplication : BaseApplication() {
    private val appComponent by lazy { AppComponent.getComponent(this) }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return appComponent
    }
}