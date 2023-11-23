package com.f7dec8.iam.account;

import java.util.Optional;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.f7dec8.shared.model.Account;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class AccountService implements UserDetailsService {

    private final AccountRepository account;
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Account> one = account.findByUsername(username);
        if (one.isEmpty()) {
            throw new UsernameNotFoundException("아이디 또는 비밀번호를 잘못 입력했습니다.");
        }
        log.debug("#### 사용자 불러옴");
        return one.map(this::toUserDetails).get();
    }
    
    private UserDetails toUserDetails(Account account) {
        return User.builder()
                .username(account.getId())
                .password(account.getPassword())
                .authorities("ROLE_SUPER_ADMIN")
                .build();
    }
//
//    public static void main(String[] args) {
//        PasswordEncoder pe = new BCryptPasswordEncoder();
//        System.out.println(pe.encode("1q2w3e4r#"));
//        // $2a$10$lSyiY/v52VOpc6FOWe5bn.fVKVMvddjeAU24GIWD82s5pBXsy4jYG
//    }
    
}
