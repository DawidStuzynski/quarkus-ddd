package org.acme.product.api

import jakarta.ws.rs.Consumes
import jakarta.ws.rs.GET
import jakarta.ws.rs.POST
import jakarta.ws.rs.Path
import jakarta.ws.rs.Produces
import jakarta.ws.rs.core.MediaType.APPLICATION_JSON
import org.acme.product.ProductFacade
import org.acme.product.api.dto.CreateProductRequest
import org.acme.product.api.dto.CreateProductResponse
import org.acme.product.usecase.dto.CreateProductInput

@Path("/api/v1")
internal class ProductEndpoint(
    private val facade: ProductFacade
) {
    @POST
    @Path("/product")
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    fun saveProduct(request: CreateProductRequest): CreateProductResponse {
        val input = CreateProductInput(
            name = request.name,
            description = request.description,
            price = request.price,
        )
        return CreateProductResponse.of(
            facade.saveProduct(input)
        )
    }

    @GET
    @Path("/products")
    fun readProducts(
    ): String {
        return facade.hello()
    }
}
