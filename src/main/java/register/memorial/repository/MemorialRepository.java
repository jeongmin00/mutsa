package register.memorial.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import register.memorial.domain.Memorial;

import java.util.List;

public interface MemorialRepository extends JpaRepository<Memorial, Long> {
}
