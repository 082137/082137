package com.f7dec8.shared.model;

import org.hibernate.annotations.GenericGenerator;

import com.f7dec8.shared.hibernate.id.RsidGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table
@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@GenericGenerator(name = "rsid", type = RsidGenerator.class)
public class Company extends Audit {

    @Id
    @GeneratedValue(generator = "rsid")
    private String id;

    @Column(length = 100)
    private String name;

}
