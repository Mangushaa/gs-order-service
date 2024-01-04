package org.example.integration.data;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ProductData(
        @JsonProperty("uuid") String uuid,
        @JsonProperty("total") int total
) {

}
