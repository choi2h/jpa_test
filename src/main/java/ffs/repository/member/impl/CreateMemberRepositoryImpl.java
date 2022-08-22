package ffs.repository.member.impl;

import ffs.domain.Member;
import ffs.repository.member.CreateMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
@RequiredArgsConstructor
public class CreateMemberRepositoryImpl implements CreateMemberRepository {

    private final EntityManager em;

    public Long save(Member member) {
        em.persist(member);

        return member.getId();
    }
}
