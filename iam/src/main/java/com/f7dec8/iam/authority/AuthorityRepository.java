package com.f7dec8.iam.authority;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.f7dec8.shared.model.Role;

@Repository
public interface AuthorityRepository extends JpaRepository<Role, Long> {

}
