package com.skaledevs.kankantrade.repo;

import com.skaledevs.kankantrade.model.Stock;
import org.springframework.data.jpa.repository.JpaRepository;


public interface StockRepository extends JpaRepository<Stock, Integer> {
    // No need to write any code
}
