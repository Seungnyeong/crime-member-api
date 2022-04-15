package com.dns.memberapi.infrastructure.member;

import com.dns.memberapi.domain.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface MemberRepository extends JpaRepository<MemberEntity, Long> {
    Optional<String> findByEmailContains(String email);
}