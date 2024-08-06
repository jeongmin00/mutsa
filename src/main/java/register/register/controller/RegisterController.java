package register.register.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import register.register.domain.Member;
import register.register.service.MemberService;

@Controller
public class RegisterController {

    private final MemberService memberService;

    public RegisterController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/members/new")
    public String showRegisterForm() {
        return "register";
    }

    @PostMapping("/api/members/register")
    @ResponseBody
    public ResponseEntity<String> register(@RequestBody Member member) {
        try {
            memberService.join(member);
            return ResponseEntity.ok("회원가입이 성공적으로 완료되었습니다.");
        } catch (IllegalStateException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
