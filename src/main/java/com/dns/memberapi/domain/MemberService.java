package com.dns.memberapi.domain;

public interface MemberService {
    MemberInfo registerMember(MemberCommand.Register memberRequest);
    boolean duplicateEmail(String email);
}
