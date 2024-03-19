package com.project.library.web.member;

import com.project.library.domain.member.Member;
import com.project.library.domain.member.MemberMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberController {

    private final MemberMapper memberMapper;

    @GetMapping("/add")
    public String addForm(@ModelAttribute("member") Member member) {
        return "member/join";
    }

    @PostMapping("/add")
    public String save(@Valid @ModelAttribute("member") Member member, BindingResult bindingResult) throws Exception {
        if (bindingResult.hasErrors()) {
            return "member/join";
        }

        memberMapper.insert(member);
        return "redirect:/";
    }
}
