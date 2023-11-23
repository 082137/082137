package com.f7dec8.iam.repository;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.f7dec8.iam.account.AccountRepository;
import com.f7dec8.iam.support.SpringBootTestSupport;
import com.f7dec8.shared.model.Account;

public class AccountRepositoryTest extends SpringBootTestSupport {

    @Autowired
    private AccountRepository account;

    @Test
    public void testFindById() {
        String username = "admin";
        Optional<Account> one = account.findById(username);
        if (one.isPresent()) {
            debug(one.get());
        }
    }

}
