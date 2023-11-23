package com.f7dec8.iam.repository;

import org.springframework.beans.factory.annotation.Autowired;

import com.f7dec8.iam.authority.AuthorityRepository;
import com.f7dec8.iam.support.SpringBootTestSupport;

public class RoleRepositoryTest extends SpringBootTestSupport {

    @Autowired
    @SuppressWarnings("unused")
    private AuthorityRepository role;

}
