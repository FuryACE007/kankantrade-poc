package com.skaledevs.kankantrade.repo;

import com.skaledevs.kankantrade.model.Portfolio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "portfolio")
public interface PortfolioRepository extends JpaRepository<Portfolio, Integer> {
    // No need to write any code
}
