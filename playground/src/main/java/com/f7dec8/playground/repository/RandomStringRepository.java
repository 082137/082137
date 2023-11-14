package com.f7dec8.playground.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.f7dec8.playground.entity.RandomString;

@Repository
public interface RandomStringRepository extends JpaRepository<RandomString, String> {

}
