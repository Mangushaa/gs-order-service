package org.example.api.requets;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record OrderEntryRequest(@NotNull String productUuid, @Positive int count) {
}
