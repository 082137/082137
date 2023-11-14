package com.f7dec8.playground.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.f7dec8.shared.entity.Company;

@Repository
public interface CompanyRepository extends JpaRepository<Company, String> {

}
