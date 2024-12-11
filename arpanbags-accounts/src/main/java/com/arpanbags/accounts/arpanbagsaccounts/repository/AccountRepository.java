package com.arpanbags.accounts.arpanbagsaccounts.repository;

import com.arpanbags.accounts.arpanbagsaccounts.entity.Account;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account,Long> {

    Optional<Account> findByAccountName(String accountName);

    void deleteById(Long id);

}
