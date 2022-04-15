package com.dns.memberapi.web.dto;

import com.dns.memberapi.annotation.Password;
import com.dns.memberapi.domain.MemberCommand;
import com.dns.memberapi.domain.MemberInfo;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

public class MemberDto {

    @Getter
    @Setter
    @ToString
    public static class MemberRegisterRequest {

        @NotEmpty(message = "username 은 필수 값 입니다.")
        private String username;

        @NotEmpty(message = "password1 은 필수 값 입니다.")
        @Password
        private String password1;

        @NotEmpty(message = "password2 은 필수 값 입니다.")
        @Password
        private String password2;

        @NotEmpty(message = "email 은 필수 값 입니다.")
        @Email(message = "이메일 형식이 맞지 않습니다.")
        private String email;

        @Pattern(regexp = "\\d{3}-\\d{4}-\\d{4}", message = "번호 형식이 맞지 않습니다.")
        private String phone;

        public MemberCommand.Register toCommand() {
            return MemberCommand.Register.builder()
                    .username(username)
                    .email(email)
                    .password1(password1)
                    .password2(password2)
                    .phone(phone)
                    .build();
        }
    }

    @Getter
    @ToString
    @Builder
    public static class MemberSignInRequest {
        private final String email;
        private final String password;
    }


    @Getter
    @ToString
    public static class MemberRegisterResponse {
        private final String username;

        public MemberRegisterResponse(MemberInfo memberInfo) {
            this.username = memberInfo.getUsername();
        }
    }

}
