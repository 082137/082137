package com.f7dec8.playground.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.f7dec8.playground.support.SpringBootTestSupport;
import com.f7dec8.shared.entity.Company;

public class CompanyRepositoryTest extends SpringBootTestSupport {

    @Autowired
    private CompanyRepository repo;
    
    @Test
    public void testSave() {
        Company one = Company
                .builder()
                .name("f7dec8")
                .build();
        one = repo.save(one);
        debug(one);
    }
    
}
