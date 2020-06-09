package com.library.billing

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.library.billing.db.AugmentedSkuDetails
import javax.inject.Inject

class BillingViewModel @Inject constructor(private val billingRepository: BillingRepository) :
    ViewModel() {
    val subsSkuDetailsListLiveData: LiveData<List<AugmentedSkuDetails>> = billingRepository.subsSkuDetailsListLiveData

    fun onStartConnectToGoogleBilling(billingInject: BillingInject) {
        billingRepository.startDataSourceConnections(billingInject)
    }

    /**
     * Not used in this sample app. But you may want to force refresh in your own app (e.g.
     * pull-to-refresh)
     */
    fun queryPurchases() = billingRepository.queryPurchasesAsync()

    override fun onCleared() {
        billingRepository.endDataSourceConnections()
        super.onCleared()
    }
}