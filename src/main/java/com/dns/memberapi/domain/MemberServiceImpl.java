package com.dns.memberapi.domain;

import com.dns.memberapi.common.exception.BaseException;
import com.dns.memberapi.common.exception.NotEqualsException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.security.InvalidParameterException;

@Service
@Slf4j
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberStore memberStore;
    private final PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public MemberInfo registerMember(MemberCommand command) {

        if (!command.getPassword1().equals(command.getPassword2())) {
            throw new NotEqualsException("패스워드 불일치");
        }

        var initMember = MemberEntity.builder()
                .username(command.getUsername())
                .email(command.getEmail())
                .password(passwordEncoder.encode(command.getPassword1()))
                .phone(command.getPhone())
                .build();
        MemberEntity member = memberStore.store(initMember);
        return new MemberInfo(member);
    }
}
