package com.f7dec8.playground.hibernate.id;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.f7dec8.playground.entity.Tsid;
import com.f7dec8.playground.repository.TsidRepository;
import com.f7dec8.playground.support.SpringBootTestSupport;
import com.github.f4b6a3.tsid.TsidCreator;

public class TsidGeneratorTest extends SpringBootTestSupport {

    @Autowired
    @SuppressWarnings("unused")
    private TsidRepository repo;

    @Test
    public void test() {
        Tsid one = Tsid.builder().build();
//        one = repo.save(one);
        debug(one);
    }

    public static void main(String[] args) {
        com.github.f4b6a3.tsid.Tsid tsid = TsidCreator.getTsid();
        System.out.println(tsid.toString());
        System.out.println(tsid.toLong());
        Long a = tsid.toLong();
        String b = tsid.toLowerCase();
        com.github.f4b6a3.tsid.Tsid tsid2 = com.github.f4b6a3.tsid.Tsid.from(a);
        System.out.println(tsid2.toString());
        System.out.println(tsid2.toLong());
        com.github.f4b6a3.tsid.Tsid tsid3 = com.github.f4b6a3.tsid.Tsid.from(b);
        System.out.println(tsid3.toString());
        System.out.println(tsid3.toLong());

    }

}
