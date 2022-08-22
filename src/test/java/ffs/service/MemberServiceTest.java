package ffs.service;

import ffs.domain.Member;
import ffs.dto.request.NewMemberInfo;
import ffs.dto.response.member.SearchMemberResponse;
import ffs.service.member.CreateMemberService;
import ffs.service.member.SearchMemberService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@Transactional
public class MemberServiceTest {

    @Autowired
    CreateMemberService createMemberService;
    @Autowired
    SearchMemberService searchMemberService;

    @Test
    void joinMemberTest() {
        LocalDate startDate = LocalDate.now();
        LocalDate endDate = LocalDate.of(2023, 8, 22);
        NewMemberInfo memberInfo = new NewMemberInfo("hwa", "01088888888", startDate, endDate, false);

        Long memberId = createMemberService.join(memberInfo);
        SearchMemberResponse member = searchMemberService.getMemberFromNameAndLastPhoneNumber(memberInfo.getName(), "8888");
        Assertions.assertEquals(memberInfo.getName(), member.getName());
    }
}
