package com.project.library.domain.member;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class MemberService {

    private final MemberMapper memberMapper;

    public MemberService(MemberMapper memberMapper) {
        this.memberMapper = memberMapper;
    }

    @Transactional(readOnly = true)
    public List<Member> findAll() throws Exception {
        return memberMapper.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<Member> findByLoginId(String loginId) throws Exception {
        return findAll().stream()
                .filter(m -> m.getLoginId().equals(loginId))
                .findFirst();
    }

    @Transactional
   public void save(Member member) throws Exception {
        memberMapper.insert(member);
   }

   @Transactional
   public void update(Member member) throws Exception {
       memberMapper.update(member);
   }

   @Transactional
   public void delete(Long id) throws Exception {
       memberMapper.delete(id);
   }
}
