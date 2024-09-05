package org.acme.product.usecase.operations

import org.acme.product.port.ProductInfoProvider

internal interface ProductInfoProviderOperations {
    val productInfoProvider: ProductInfoProvider

    fun fetchInfoForProduct(
        name: String,
    ): List<String> =
        if (name != "gowno") {
            productInfoProvider.findProductInfo(name)
        } else {
            productInfoProvider.findProductInfo("name")
        }
}
