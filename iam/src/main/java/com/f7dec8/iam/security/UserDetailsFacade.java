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
    // private final RoleService role;

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
                .build();
    }

//  public static void main(String[] args) {
//  PasswordEncoder pe = new BCryptPasswordEncoder();
//  System.out.println(pe.encode("1q2w3e4r#"));
//  // $2a$10$lSyiY/v52VOpc6FOWe5bn.fVKVMvddjeAU24GIWD82s5pBXsy4jYG
//}
    
}
