package com.f7dec8.playground.entity;

import org.hibernate.annotations.GenericGenerator;

import com.f7dec8.shared.jpa.TsidGenerator;
import com.f7dec8.shared.model.Audit;

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
@GenericGenerator(name = "tsid", type = TsidGenerator.class)
public class Tsid extends Audit {

    @Id
    @GeneratedValue(generator = "tsid")
    private Long id;

}
