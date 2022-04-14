package com.dns.memberapi.web.controller;

import com.dns.memberapi.application.MemberFacade;
import com.dns.memberapi.common.response.CommonResponse;
import com.dns.memberapi.domain.MemberCommand;
import com.dns.memberapi.web.dto.MemberDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/v1/member")
public class SignUpController {

    private final MemberFacade memberFacade;

    @PostMapping
    public CommonResponse registerPartner(@RequestBody @Valid MemberDto.MemberRegisterRequest request) {
        var command = request.toCommand();
        var memberInfo = memberFacade.registerMember(command);
        var response = new MemberDto.MemberRegisterResponse(memberInfo);
        return CommonResponse.success(response);
    }

    // TODO 패스워드 확인

}
