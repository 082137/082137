package com.f7dec8.playground.hibernate.id;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.f7dec8.playground.entity.RandomString;
import com.f7dec8.playground.repository.RandomStringRepository;
import com.f7dec8.playground.support.SpringBootTestSupport;

public class RandomStringGeneratorTest extends SpringBootTestSupport {

    @Autowired
    private RandomStringRepository repo;

    @Test
    public void test() {
        RandomString one = RandomString.builder().build();
        one = repo.save(one);
        debug(one);
    }

}
