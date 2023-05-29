package lt.code.academy.hw_blog.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lt.code.academy.hw_blog.dto.Post;
import java.time.LocalDate;
import java.util.UUID;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "posts")
public class PostEntity {
    @Id
    @GeneratedValue
    @Column(updatable = false)
    private UUID id;
    @Column(nullable = false, length = 200)
    private String title;
    @Column(nullable = false, length = 1500)
    private String content;
    @Column(nullable = false, length = 500 )
    private String comment;


    public static PostEntity convert(Post post){
        return new PostEntity(
                post.getId(),
                post.getTitle(),
                post.getContent(),
                post.getComment()
        );
    }
}
