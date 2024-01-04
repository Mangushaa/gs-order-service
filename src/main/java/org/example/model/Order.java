package org.example.model;

import org.example.model.enums.OrderStatus;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.Version;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import java.time.Instant;
import java.util.UUID;

@Table("gorders")
public record Order(
        @Id Long id,
        @Column("orderUuid") String uuid,
        int total,
        @Column("orderStatus") OrderStatus orderStatus,
        @Column("createdAt") @CreatedDate Instant createdAt,
        @Column("modifiedAt") @LastModifiedDate Instant modifiedAt,
        @Version int version
) {

    public static Order of(int total, OrderStatus orderStatus) {
        return new Order(null, UUID.randomUUID().toString(), total, orderStatus, null, null, 0);
    }
}
