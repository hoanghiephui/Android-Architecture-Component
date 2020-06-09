package com.library.sample.di.modules

import android.content.Context
import com.library.base.di.modules.BaseAppModule
import com.library.billing.db.BillingDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule : BaseAppModule() {
    @Singleton
    @Provides
    fun providesAppDatabase(context: Context): BillingDatabase =
        BillingDatabase.buildDatabase(context)
}