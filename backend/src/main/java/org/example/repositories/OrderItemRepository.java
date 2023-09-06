package org.example.repositories;

import org.example.domain.OrderItem;
import org.example.domain.utils.OrderItemPrimaryKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPrimaryKey> {
}
