package ffs.repository.member;

import ffs.domain.Member;

public interface CreateMemberRepository {

    Long save(Member member);
}
