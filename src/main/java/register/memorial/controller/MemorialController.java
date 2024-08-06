package register.memorial.controller;

import register.memorial.service.MemorialService;
import register.memorial.domain.Memorial;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;
import java.util.List;

@Controller
public class MemorialController {

    private final MemorialService memorialService;

    public MemorialController(MemorialService memorialService) {
        this.memorialService = memorialService;
    }

    @GetMapping("/memorials/new")
    public String showMemorialPage() {
        return "memorial";
    }

    @PostMapping("/api/memorial")
    @ResponseBody
    public ResponseEntity<MemorialDTO> createMemorial(@RequestParam("todoText") String todoText,
                                                      @RequestParam("todoImage") MultipartFile todoImage) {
        try {
            Memorial memorial = memorialService.createMemorial(todoText, todoImage);
            MemorialDTO memorialDTO = new MemorialDTO();
            memorialDTO.setTodoText(memorial.getTodoText());
            memorialDTO.setTodoImage(Base64.getEncoder().encodeToString(memorial.getTodoImage()));
            return ResponseEntity.ok(memorialDTO);
        } catch (IOException e) {
            return ResponseEntity.status(500).build();
        }
    }

    @GetMapping("/api/memorials")
    @ResponseBody
    public List<MemorialDTO> getAllMemorials() {
        return memorialService.findAll();
    }
}