package register.memorial.domain;

import jakarta.persistence.*;

@Entity
public class Memorial {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String todoText;

    @Lob
    private byte[] todoImage;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTodoText() {
        return todoText;
    }

    public void setTodoText(String todoText) {
        this.todoText = todoText;
    }

    public byte[] getTodoImage() {
        return todoImage;
    }

    public void setTodoImage(byte[] todoImage) {
        this.todoImage = todoImage;
    }
}

