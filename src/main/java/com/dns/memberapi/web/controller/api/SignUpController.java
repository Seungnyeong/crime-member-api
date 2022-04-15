package com.dns.memberapi.web.controller.api;

import com.dns.memberapi.application.MemberFacade;
import com.dns.memberapi.common.response.CommonResponse;
import com.dns.memberapi.web.dto.MemberDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/v1/member/sign-up")
public class SignUpController {

    private final MemberFacade memberFacade;

    @PostMapping
    public CommonResponse registerMember(@RequestBody @Valid MemberDto.MemberRegisterRequest request) {
        var command = request.toCommand();
        var memberInfo = memberFacade.registerMember(command);
        var response = new MemberDto.MemberRegisterResponse(memberInfo);
        return CommonResponse.success(response);
    }

}
