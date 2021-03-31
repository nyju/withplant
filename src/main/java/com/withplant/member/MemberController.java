package com.withplant.member;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/sign-up")
    public String signUpForm(Model model) {
        model.addAttribute(new SignUpForm());
        return "account/sign-up";
    }

    @PostMapping("/sign-up")
    public String signUpForm(@Valid SignUpForm signUpForm, Errors errors) {
        System.out.println("SignUp");

        if (errors.hasErrors()) {
            System.out.println("hasError");
            return "account/sign-up"; //에러가 있으면 다시 폼으로
        }

        memberService.registerMember(signUpForm);
        return "redirect:/";
    }
}
