package com.chumbok.pos.repository;

import com.chumbok.pos.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
    public Account findByUsername(String username);
}