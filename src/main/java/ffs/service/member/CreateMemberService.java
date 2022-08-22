package ffs.service.member;

import ffs.domain.Member;
import ffs.dto.request.NewMemberInfo;
import ffs.repository.member.CreateMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateMemberService {

    private final CreateMemberRepository memberRepository;

    public Long join(NewMemberInfo memberInfo) {
        Member member = getMemberFromMemberInfo(memberInfo);
        return memberRepository.save(member);
    }

    private Member getMemberFromMemberInfo(NewMemberInfo memberInfo) {
        Member member = new Member();
        member.setName(memberInfo.getName());
        member.setPhoneNumber(memberInfo.getPhoneNumber());
        member.setStartDate(memberInfo.getStartDate());
        member.setEndDate(memberInfo.getEndDate());
        member.setPersonalTraining(memberInfo.isPersonalTraining());

        return member;
    }

}
