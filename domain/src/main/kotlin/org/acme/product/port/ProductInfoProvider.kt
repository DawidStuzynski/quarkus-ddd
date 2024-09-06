package org.acme.product.port

//@Port
interface ProductInfoProvider {
    fun findProductInfo(productName: String): List<String>
}
