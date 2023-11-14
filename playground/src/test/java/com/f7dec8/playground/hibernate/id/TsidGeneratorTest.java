package com.f7dec8.playground.hibernate.id;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.f7dec8.playground.entity.Tsid;
import com.f7dec8.playground.repository.TsidRepository;
import com.f7dec8.playground.support.SpringBootTestSupport;

public class TsidGeneratorTest extends SpringBootTestSupport {

    @Autowired
    private TsidRepository repo;

    @Test
    public void test() {
        Tsid one = Tsid.builder().build();
        one = repo.save(one);
        debug(one);
    }

}
