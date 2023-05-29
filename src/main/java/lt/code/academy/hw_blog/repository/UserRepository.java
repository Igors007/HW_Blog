package lt.code.academy.hw_blog.repository;

import lt.code.academy.hw_blog.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, UUID> {
    @Override
    Optional<UserEntity> findById(UUID uuid);
}
