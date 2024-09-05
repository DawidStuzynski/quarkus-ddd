package org.acme.product.port

import org.acme.product.port.ProductInfoProvider

//@PortMock
internal class ProductInfoProviderMock : ProductInfoProvider {
    private val infos: MutableMap<String, List<String>> = mutableMapOf()

    override fun findProductInfo(productName: String): List<String> = infos[productName] ?: listOf()

    fun addInfoForProduct(
        productName: String,
        urls: List<String>,
    ) {
        infos[productName] = urls
    }
}
