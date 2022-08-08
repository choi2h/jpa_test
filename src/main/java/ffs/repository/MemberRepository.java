package ffs.repository;

import ffs.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
@RequiredArgsConstructor
public class MemberRepository {

    private final EntityManager em;

    public Long save(Member member) {
        em.persist(member);

        return member.getId();
    }

    public Member getOne(Long id) {
        return em.find(Member.class, id);
    }


}
