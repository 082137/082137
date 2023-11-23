package com.f7dec8.iam.account;

import org.springframework.stereotype.Service;

import com.f7dec8.shared.model.Account;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final AccountRepository account;

    
    
    public Account getByUsername(String username) {
        return account.findById(username).orElse(null);
    }

}
