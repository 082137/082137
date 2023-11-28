package com.f7dec8.iam.security;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.f7dec8.iam.account.AccountService;
import com.f7dec8.shared.model.Account;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserDetailsFacade implements UserDetailsService {

    private final AccountService account;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account one = account.getByUsername(username);
        if (one == null) {
            throw new UsernameNotFoundException("아이디 또는 비밀번호를 잘못 입력했습니다.");
        }
        return toUserDetails(one);
    }
    
    private UserDetails toUserDetails(Account account) {
        return User.builder()
                .username(account.getUsername())
                .password(account.getPassword())
                .authorities("ROLE_USER")
                .build();
    }
    
}
