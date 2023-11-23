package com.f7dec8.iam.account;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.f7dec8.shared.model.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, String> {

}
