package com.f7dec8.playground.entity;

import org.hibernate.annotations.GenericGenerator;

import com.f7dec8.core.persistence.RandomStringGenerator;
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
@GenericGenerator(name = RandomStringGenerator.NAME, type = RandomStringGenerator.class)
public class RandomString extends Audit {

    @Id
    @GeneratedValue(generator = RandomStringGenerator.NAME)
    private String id;

}
