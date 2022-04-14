package com.dns.memberapi.infrastructure.member;

import com.dns.memberapi.domain.MemberEntity;
import com.dns.memberapi.domain.MemberStore;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class MemberStoreImpl implements MemberStore {
    private final MemberRepository memberRepository;

    @Override
    public MemberEntity store(MemberEntity memberEntity) {
        return memberRepository.save(memberEntity);
    }
}
