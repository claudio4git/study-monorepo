package br.com.jccf.javaspring.order;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}
