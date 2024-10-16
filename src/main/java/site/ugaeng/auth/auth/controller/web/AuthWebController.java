package site.ugaeng.auth.auth.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import site.ugaeng.auth.auth.controller.web.dto.SignInRequest;
import site.ugaeng.auth.auth.controller.web.dto.SignUpRequest;

@Controller
public class AuthWebController {

    @GetMapping("/signup")
    public String signUpForm(final Model model) {
        model.addAttribute("signUpRequest", new SignUpRequest());
        return "signUpForm";
    }

    @GetMapping("/signin")
    public String signInForm(final Model model) {
        model.addAttribute("signInRequest", new SignInRequest());
        return "signInForm";
    }

}
