package com.library.base.di.modules

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides

@Module
abstract class BaseAppModule {
    @Provides
    fun provideContext(application: Application): Context {
        return application
    }

}