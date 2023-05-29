package lt.code.academy.hw_blog.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
import lt.code.academy.hw_blog.entity.PostEntity;
import java.time.LocalDate;
import java.util.UUID;

@Setter
@Getter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Post {
    private UUID id;
    @NotBlank
    @Size(min = 5, max = 200)
    private String title;
    @NotBlank
    @Size(min = 5, max = 1500)
    private String content;
    @Size(min = 5, max = 500)
    private String comment;


    public static Post convert(PostEntity entity){
        return new Post(
                entity.getId(),
                entity.getTitle(),
                entity.getContent(),
                entity.getComment()
        );
    }
}
