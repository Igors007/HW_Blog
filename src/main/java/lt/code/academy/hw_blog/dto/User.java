package lt.code.academy.hw_blog.dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lt.code.academy.hw_blog.entity.UserEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.Collection;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class User implements UserDetails {

    private UUID id;
    @NotBlank
    @Size(min = 5, max = 50)
    private String fullName;
    @Email
    private String email;
    private Set<Role> roles;
    @NotBlank
    @Size(min = 5, max = 20)
    private String username;
    @NotBlank
    @Size(min = 5, max = 20)
    private String password;

    public static User convert(UserEntity entity) {
        Set<Role> roles = entity.getRoles()
                .stream()
                .map(Role::convert)
                .collect(Collectors.toSet());
        return new User(
                entity.getId(),
                entity.getFullName(),
                entity.getEmail(),
                roles,
                entity.getUsername(),
                entity.getPassword()
        );
}

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
