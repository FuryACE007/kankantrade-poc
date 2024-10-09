package com.skaledevs.kankantrade.repo;

import com.skaledevs.kankantrade.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    // No need to write any code
}
