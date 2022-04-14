package com.dns.memberapi.domain;

public interface PasswordValidator {
    boolean passwordCheck(String password1, String password2);
    boolean passwordRule(String password);
}
