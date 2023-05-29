package lt.code.academy.hw_blog.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lt.code.academy.hw_blog.dto.User;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
//@Table(name = "users")
public class UserEntity {
    @Id
    @GeneratedValue
    @Column(updatable = false)
    private UUID id;
    private String fullName;
    private String email;
    private String username;
    private String password;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<RoleEntity> roles;

    public static UserEntity convert(User user){
        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        return new UserEntity(
                user.getId(),
                user.getFullName(),
                user.getEmail(),
                user.getUsername(),
                encoder.encode(user.getPassword()),
                Set.of(new RoleEntity(UUID.fromString("b26cb831-9427-41ee-adcc-271f7b02d611"), "USER")));
    }
}
