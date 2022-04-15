package com.dns.memberapi.infrastructure.member;

import com.dns.memberapi.domain.MemberReader;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class MemberReaderImpl implements MemberReader {

    private final MemberRepository memberRepository;

    @Override
    public boolean getMemberByEmail(String email) {
        return false;
    }
}
