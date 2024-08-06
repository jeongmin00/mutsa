package register.register.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import register.register.domain.Member;
import register.register.service.MemberService;

@Controller
public class LoginController {

    private final MemberService memberService;

    public LoginController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/login")
    public String showLoginForm() {
        return "login";  // login.html
    }

    @PostMapping("/api/login")
    @ResponseBody
    public ResponseEntity<String> login(@RequestBody Member member) {
        Member loggedInMember = memberService.login(member.getEmail(), member.getPassword());
        if (loggedInMember != null) {
            return ResponseEntity.ok("로그인이 성공적으로 완료되었습니다.");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("로그인에 실패했습니다.");
        }
    }
}
