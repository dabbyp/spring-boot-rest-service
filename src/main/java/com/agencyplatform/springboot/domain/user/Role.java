package com.agencyplatform.springboot.domain.user;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Role {
    GUEST("ROLE_GUEST", "손님"),
    USER("ROLE_USER", "회원"),
    PARTNER("ROLE_PARTNER", "파트너");

    private final String key;
    private final String title;
}
