package com.library.billing.db

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.android.billingclient.api.SkuDetails


@Entity
data class AugmentedSkuDetails(
    val canPurchase: Boolean, /* Not in SkuDetails; it's the augmentation */
    @PrimaryKey val sku: String,
    val type: String?,
    val price: String?,
    val title: String?,
    val description: String?,
    val originalJson: String?
)