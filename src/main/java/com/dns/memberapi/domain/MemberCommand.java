package com.dns.memberapi.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.security.InvalidParameterException;

@Getter
@ToString
@Builder

public class MemberCommand {
    private final String username;
    private final String phone;
    private final String email;
    private final String password1;
    private final String password2;

    public MemberEntity toEntity() {

        return MemberEntity.builder()
                .email(email)
                .password(password1)
                .phone(phone)
                .username(username)
                .build();
    }
}
