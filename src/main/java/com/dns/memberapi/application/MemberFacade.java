package com.dns.memberapi.application;

import com.dns.memberapi.domain.MemberCommand;
import com.dns.memberapi.domain.MemberInfo;
import com.dns.memberapi.domain.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class MemberFacade {

    // TODO 추후에 다른 서비스들과 붙혀야 할일이 있으면 붙혀야 함.
    private final MemberService memberService;

    public MemberInfo registerMember(MemberCommand command) {
        return memberService.registerMember(command);
    }
}
