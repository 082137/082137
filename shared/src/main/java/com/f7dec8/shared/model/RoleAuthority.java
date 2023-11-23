package com.f7dec8.shared.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum RoleAuthority {

    SUPER_ADMIN("ROLE_SUPER_ADMIN", "슈퍼관리자");

    private final String authority;
    private final String authorityName;

}
