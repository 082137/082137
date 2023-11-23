package com.f7dec8.shared.model;

import java.util.List;

import org.hibernate.annotations.GenericGenerator;

import com.f7dec8.shared.jpa.RsidGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@GenericGenerator(name = "rsid", type = RsidGenerator.class)
public class User extends Audit {

    @Id
    @GeneratedValue(generator = "rsid")
    private String id;

    @Column(length = 30)
    private String name;
    
    @OneToMany
    private List<Role> roles;

}