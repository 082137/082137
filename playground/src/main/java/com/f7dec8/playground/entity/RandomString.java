package com.f7dec8.playground.entity;

import org.hibernate.annotations.GenericGenerator;

import com.f7dec8.core.hibernate.id.RsidGenerator;
import com.f7dec8.shared.entity.Audit;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table
@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@GenericGenerator(name = "rsid", type = RsidGenerator.class)
public class RandomString extends Audit {

    @Id
    @GeneratedValue(generator = "rsid")
    private String id;

}
