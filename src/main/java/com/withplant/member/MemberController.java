package com.withplant.member;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;
    private final SignUpFormValidator signUpFormValidator;


    @InitBinder("signUpForm") // camel case 를 따라감
    public void initBinder(WebDataBinder webDataBinder) {
        webDataBinder.addValidators(signUpFormValidator);
    }

    @GetMapping("/sign-up")
    public String signUpForm(Model model) {
        model.addAttribute(new SignUpForm());
        return "account/sign-up";
    }

    @PostMapping("/sign-up")
    public String signUpForm(@Valid SignUpForm signUpForm, Errors errors, RedirectAttributes redirectAttributes) {
        System.out.println("SignUp");

        if (errors.hasErrors()) {
            System.out.println("hasError");
            return "account/sign-up"; //에러가 있으면 다시 폼으로
        }

        memberService.registerMember(signUpForm);
        redirectAttributes.addFlashAttribute("result", "success");
        return "redirect:/";
    }
}
