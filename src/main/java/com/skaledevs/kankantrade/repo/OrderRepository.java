package com.skaledevs.kankantrade.repo;

import com.skaledevs.kankantrade.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Integer> {
    // No need to write any code
}
