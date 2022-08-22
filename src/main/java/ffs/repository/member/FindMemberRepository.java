package ffs.repository.member;

import ffs.domain.Member;

import java.util.List;

public interface FindMemberRepository {

    Member findOne(Long id);

    List<Member> findAll();

    List<Member> findByName(String name);
}
