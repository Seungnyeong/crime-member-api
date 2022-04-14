package com.dns.memberapi.domain;

import lombok.Getter;

import java.time.ZonedDateTime;

@Getter
public class MemberInfo {
    private final Long id;
    private final String username;
    private final String password;
    private final String email;
    private final String phone;
    private final MemberEntity.Role role;
    private final MemberEntity.Status status;
    private final ZonedDateTime createdAt;
    private final ZonedDateTime updatedAt;

    public MemberInfo(MemberEntity memberEntity) {
        this.id = memberEntity.getId();
        this.username = memberEntity.getUsername();
        this.password = memberEntity.getPassword();
        this.email = memberEntity.getEmail();
        this.phone = memberEntity.getPhone();
        this.role = memberEntity.getRole();
        this.status =  memberEntity.getStatus();
        this.createdAt = memberEntity.getCreatedAt();
        this.updatedAt = memberEntity.getUpdatedAt();
    }
}
