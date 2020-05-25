package com.library.base.ui

import android.content.Intent
import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.lifecycle.ViewModelProvider
import com.google.android.play.core.appupdate.AppUpdateManager
import com.google.android.play.core.appupdate.AppUpdateManagerFactory
import com.google.android.play.core.install.model.AppUpdateType
import com.google.android.play.core.install.model.InstallStatus
import com.google.android.play.core.install.model.UpdateAvailability
import dagger.android.support.DaggerAppCompatActivity
import timber.log.Timber
import javax.inject.Inject

abstract class BaseActivity : DaggerAppCompatActivity() {
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private var appUpdateManager: AppUpdateManager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayout())
        initViewModel()
        if (initCheckUpdateApp()) {
            appUpdateManager = AppUpdateManagerFactory.create(this)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == REQUEST_CODE_UPDATE && initCheckUpdateApp()) {
            if (resultCode != RESULT_OK) {
                Timber.e("Update flow failed! Result code: $resultCode")
                onShowSnackbarUpdateFail()
                // If the update is cancelled or fails,
                // you can request to start the update again.
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data)
            for (fragment in supportFragmentManager.fragments) {
                fragment.onActivityResult(requestCode, resultCode, data)
            }
        }
    }

    @LayoutRes
    abstract fun getLayout(): Int

    abstract fun initViewModel()

    open fun initCheckUpdateApp(): Boolean = false
    open fun onShowSnackbarUpdateFail() {}
    open fun checkAndUpdateApp() {
        // Returns an intent object that you use to check for an update.
        val appUpdateInfoTask = appUpdateManager?.appUpdateInfo

        // Checks that the platform will allow the specified type of update.
        appUpdateInfoTask?.addOnSuccessListener { appUpdateInfo ->
            if (appUpdateInfo.updateAvailability() == UpdateAvailability.UPDATE_AVAILABLE
                // For a flexible update, use AppUpdateType.FLEXIBLE
                && appUpdateInfo.isUpdateTypeAllowed(AppUpdateType.IMMEDIATE)
                && (appUpdateInfo.installStatus() != InstallStatus.CANCELED
                        || appUpdateInfo.installStatus() != InstallStatus.FAILED)
            ) {
                try {
                    // Request the update.
                    appUpdateManager?.startUpdateFlowForResult(
                        appUpdateInfo,
                        AppUpdateType.IMMEDIATE,
                        this,
                        REQUEST_CODE_UPDATE
                    )
                } catch (ex: Exception) {
                    Timber.e(ex)
                }
            }
        }
        appUpdateInfoTask?.addOnFailureListener {
            Timber.e(it)
        }
    }

    companion object {
        private const val REQUEST_CODE_UPDATE = 1102
    }
}