package com.library.billing

interface BillingInject {
    fun getPublicKey(): String
    fun getSubscriptions(): List<String>
}