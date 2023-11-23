package com.f7dec8.shared.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
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
public class Account extends Audit {

    @Id
    private String id;

    /**
     * {@link User}의 id
     */
    @Column(length = 6, unique = true, nullable = false)
    private String username;

    @Column(length = 60, nullable = false)
    private String password;

    @Column
    @Enumerated(EnumType.STRING)
    private AccountStatus status;

}
