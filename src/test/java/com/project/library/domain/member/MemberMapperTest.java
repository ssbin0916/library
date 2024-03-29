package com.project.library.domain.member;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class MemberMapperTest {

    @Mock
    private MemberMapper memberMapper;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void insert() {
        Member member = Member.builder()
                .id(1L)
                .loginId("testId")
                .password("testPass")
                .confirmPassword("testPass")
                .name("testName")
                .build();

        memberMapper.insert(member);

        verify(memberMapper, times(1)).insert(member);
    }

    @Test
    void findAll() {
        List<Member> members = List.of(
                new Member(1L, "testId1", "testPass1", "testPass1", "testName1"),
                new Member(2L, "testId2", "testPass2", "testPass2", "testName2")
        );
        when(memberMapper.findAll()).thenReturn(members);

        List<Member> foundMembers = memberMapper.findAll();

        assertEquals(2, foundMembers.size());
        assertEquals("testId1", foundMembers.get(0).getLoginId());
        assertEquals("testId2", foundMembers.get(1).getLoginId());
    }

    @Test
    void findById() {
        Long id = 1L;
        Member member = Member.builder()
                .id(id)
                .loginId("testId")
                .password("testPass")
                .confirmPassword("testPass")
                .name("testName")
                .build();
        when(memberMapper.findById(id)).thenReturn(member);

        Member foundMember = memberMapper.findById(id);

        assertEquals(id, foundMember.getId());
        assertEquals("testId", foundMember.getLoginId());
    }

    @Test
    void findByLoginId() {
        String loginId = "testId";
        Member member = Member.builder()
                .id(1L)
                .loginId(loginId)
                .password("testPass")
                .confirmPassword("testPass")
                .name("testName")
                .build();
        when(memberMapper.findByLoginId(loginId)).thenReturn(Optional.of(member));

        Optional<Member> foundMember = memberMapper.findByLoginId(loginId);

        assertEquals(loginId, foundMember.get().getLoginId());
    }

    @Test
    void update() {
        Member member = Member.builder()
                .id(1L)
                .loginId("loginId")
                .password("testPass")
                .confirmPassword("testPass")
                .name("testName")
                .build();

        memberMapper.update(member);

        verify(memberMapper, times(1)).update(member);
    }

    @Test
    void delete() {
        Long id = 1L;

        memberMapper.delete(id);

        verify(memberMapper, times(1)).delete(id);
    }
}