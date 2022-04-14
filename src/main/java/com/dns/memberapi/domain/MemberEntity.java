package com.dns.memberapi.domain;

import lombok.*;
import org.apache.commons.lang3.StringUtils;
import javax.persistence.*;
import java.security.InvalidParameterException;

@Entity
@NoArgsConstructor
@Table(name = "member")
@Getter
public class MemberEntity extends AbstractEntity {

    @Id //Primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 30)
    private String username; // 아이디

    @Column(nullable = false, length = 100) // -> 비밀번호를 암호화 하기위해서 해쉬를 사용해야 한다.
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    @Column(nullable = false, length = 50)
    private String email;

    @Column(nullable = true, length = 50)
    private String phone;

    @Enumerated(EnumType.STRING)
    private Status status;

    @Getter
    @RequiredArgsConstructor
    public enum Role {
        ADMIN("관리자"),
        USER(" 사용자");
        private final String description;
    }

    @Getter
    @RequiredArgsConstructor
    public enum Status {
        ACTIVATE("활성"),
        DEACTIVATE("비활성");
        private final String description;
    }

    @Builder
    public MemberEntity(String username, String password, Role role, String email, String phone) {
        if(StringUtils.isEmpty(username)) throw new InvalidParameterException("empty username");
        if(StringUtils.isEmpty(password)) throw new InvalidParameterException("empty password");
        if(StringUtils.isEmpty(email)) throw new InvalidParameterException("empty email");
        if(StringUtils.isEmpty(phone)) throw new InvalidParameterException("empty phone");

        this.username = username;
        this.password = password;
        this.role = Role.USER;
        this.email = email;
        this.phone = phone;
        this.status = Status.ACTIVATE;
    }

    public void activate() {
        this.status = Status.ACTIVATE;
    }

    public void deactivate() {
        this.status = Status.DEACTIVATE;
    }

}
