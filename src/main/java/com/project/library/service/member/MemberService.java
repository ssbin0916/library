package com.project.library.service.member;

import com.project.library.domain.member.Member;
import com.project.library.mapper.member.MemberMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberMapper memberMapper;

    @Transactional(readOnly = true)
    public Optional<Member> findByLoginId(String loginId) {
        return memberMapper.findByLoginId(loginId);
    }

    @Transactional(readOnly = true)
    public List<Member> findAll() {
        return memberMapper.findAll();
    }

    @Transactional
    public int save(Member member) {
        return memberMapper.insert(member);
    }

    @Transactional
    public int update(Member member) {
        return memberMapper.update(member);
    }

    @Transactional
    public int delete(Long id) {
        return memberMapper.delete(id);
    }
}
