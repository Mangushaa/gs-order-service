package org.example.api.requets;

import java.util.List;
import jakarta.validation.constraints.NotEmpty;

public record OrderRequest(
        @NotEmpty List<OrderEntryRequest> orderRequest
) {
}
