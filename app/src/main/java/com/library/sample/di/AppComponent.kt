package com.library.sample.di

import android.app.Application
import com.library.base.di.ViewModelModule
import com.library.base.di.modules.CoreNetworkModule
import com.library.sample.SampleApplication
import com.library.sample.di.modules.ActivityBindingModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import dagger.android.support.DaggerApplication
import javax.inject.Singleton

/**
 * Main component of the app, created and persisted in the Application class.
 *
 * Whenever a new module is created, it should be added to the list of modules.
 * [AndroidSupportInjectionModule] is the module from Dagger.Android that helps with the
 * generation and location of subcomponents.
 */
@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        ViewModelModule::class,
        CoreNetworkModule::class,
        NetworkModule::class,
        ActivityBindingModule::class
    ]
)
interface AppComponent : AndroidInjector<DaggerApplication> {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

    //fun daggerWorkerFactory(): DaggerWorkerFactory

    //fun workerSubComponentBuilder(): WorkerSubComponent.Builder

    override fun inject(instance: DaggerApplication)

    companion object {
        fun getComponent(app: SampleApplication): AppComponent = DaggerAppComponent.builder()
            .application(app)
            .build()
    }
}