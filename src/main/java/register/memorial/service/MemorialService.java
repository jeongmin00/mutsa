package register.memorial.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import register.memorial.controller.MemorialDTO;
import register.memorial.domain.Memorial;
import register.memorial.repository.MemorialRepository;

import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MemorialService {

    private final MemorialRepository memorialRepository;

    public MemorialService(MemorialRepository memorialRepository) {
        this.memorialRepository = memorialRepository;
    }

    public Memorial createMemorial(String todoText, MultipartFile todoImage) throws IOException {
        Memorial memorial = new Memorial();
        memorial.setTodoText(todoText);
        memorial.setTodoImage(todoImage.getBytes());
        return memorialRepository.save(memorial);
    }

    public List<MemorialDTO> findAll() {
        return memorialRepository.findAll().stream().map(this::toDTO).collect(Collectors.toList());
    }

    private MemorialDTO toDTO(Memorial memorial) {
        MemorialDTO dto = new MemorialDTO();
        dto.setTodoText(memorial.getTodoText());
        dto.setTodoImage(Base64.getEncoder().encodeToString(memorial.getTodoImage()));
        return dto;
    }
}
