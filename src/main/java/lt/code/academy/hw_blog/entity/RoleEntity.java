package lt.code.academy.hw_blog.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
//@Table(name = "roles")
public class RoleEntity {
    @Id
    @GeneratedValue
    private UUID id;
    private String name;
}
