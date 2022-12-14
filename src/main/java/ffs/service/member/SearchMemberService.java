package ffs.service.member;

import ffs.domain.Member;
import ffs.dto.response.member.SearchMemberResponse;
import ffs.repository.member.FindMemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class SearchMemberService {

    private final FindMemberRepository memberRepository;

    public List<Member> getAllMemberList() {
        List<Member> memberList = memberRepository.findAll();
        log.info("Get all member. size={}", memberList.size());

        return memberList;
    }

    public SearchMemberResponse getMemberFromNameAndLastPhoneNumber(String name, String lastPhoneNumber) {
        List<Member> memberList = memberRepository.findByName(name);
        log.debug("Get member list by name. size={}", memberList.size());

        if(memberList.isEmpty()) {
            log.error("Can not found member. memberName={}, lastNumber={}", name, lastPhoneNumber);
            return null;
        }

        Member member = getMemberOfSameLastPhoneNumber(memberList, lastPhoneNumber);

        if(member == null) {
            log.error("Can not found member. memberName={}, lastNumber={}", name, lastPhoneNumber);
            return null;
        }

        return getResponseByMember(member);
    }


    private Member getMemberOfSameLastPhoneNumber(List<Member> memberList, String lastPhoneNumber) {
        for(Member member : memberList) {
            boolean isSame = isSameLastPhoneNumber(member, lastPhoneNumber);
            if(isSame) {
                return member;
            }
        }

        return null;
    }

    private boolean isSameLastPhoneNumber(Member member, String lastPhoneNumber) {
        boolean isSame = false;
        String memberPhoneNumber = member.getPhoneNumber();


        if(memberPhoneNumber != null) {
            isSame = memberPhoneNumber.endsWith(lastPhoneNumber);
        }

        return isSame;
    }

    private SearchMemberResponse getResponseByMember(Member member) {
        SearchMemberResponse response;

        if(member.isPersonalTraining()) {
            response = getPTMembershipMember(member);
        } else {
            response = getDefaultMemberInformation(member);
        }

        return response;
    }

    private SearchMemberResponse getPTMembershipMember(Member member) {
        return SearchMemberResponse.builder()
                .name(member.getName())
                .phoneNumber(member.getPhoneNumber())
                .startDate(member.getStartDate())
                .endDate(member.getEndDate())
                .isPersonalTraining(member.isPersonalTraining())
                .trainerName(member.getTrainer().getName())
                .totalLessonCount(member.getPtMembership().getTotalLessonCount())
                .useLessonCount(member.getPtMembership().getUseLessonCount())
                .lessonList(member.getLessonList())
                .build();
    }

    private SearchMemberResponse getDefaultMemberInformation(Member member) {
        return SearchMemberResponse.builder()
                .name(member.getName())
                .phoneNumber(member.getPhoneNumber())
                .startDate(member.getStartDate())
                .endDate(member.getEndDate())
                .isPersonalTraining(member.isPersonalTraining()).build();
    }


}
