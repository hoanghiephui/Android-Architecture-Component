package com.library.base

import com.google.android.play.core.missingsplits.MissingSplitsManagerFactory
import com.library.base.log.AppLogTree
import com.library.base.log.CrashlyticsTree
import dagger.android.support.DaggerApplication
import timber.log.Timber

abstract class BaseApplication: DaggerApplication() {
    override fun onCreate() {
        if (MissingSplitsManagerFactory.create(this).disableAppIfMissingRequiredSplits()) {
            // Skip app initialization when user install app not from Google Play.
            return
        }
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Timber.plant(AppLogTree())
        } else {
            Timber.plant(CrashlyticsTree())
        }
    }
}