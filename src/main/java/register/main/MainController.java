package register.main;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/main")
    public String showMainPage() {
        return "main/main";  // 실제 템플릿 파일의 경로에 맞춰 설정
    }
}
