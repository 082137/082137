package com.f7dec8.shared.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum AccountStatus {

    WAITING("대기"),

    ACTIVE("활성"),

    INACTIVE("비활성");

    private final String name;

}
