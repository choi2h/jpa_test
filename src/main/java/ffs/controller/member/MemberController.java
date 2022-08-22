package ffs.controller.member;

import ffs.dto.request.NewMemberInfo;
import ffs.service.member.CreateMemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private CreateMemberService memberService;

    @PostMapping("/member/new")
    public ResponseEntity<Object> joinMember(@RequestBody NewMemberInfo memberInfo) {
        Long memberId = memberService.join(memberInfo);

        return ResponseEntity.ok(memberId);
    }
}
