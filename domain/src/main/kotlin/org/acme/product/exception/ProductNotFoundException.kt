package org.acme.product.exception

import org.acme.common.exception.NotFoundException
import java.util.UUID

internal class ProductNotFoundException(
    id: UUID,
) : NotFoundException(
    message = "Product with id=$id not found",
)
