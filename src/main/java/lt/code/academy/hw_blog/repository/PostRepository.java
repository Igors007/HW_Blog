package lt.code.academy.hw_blog.repository;

import lt.code.academy.hw_blog.entity.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface PostRepository extends JpaRepository<PostEntity, UUID> {
    List<PostEntity> findAllBytitleContains(String title);
    @Query("SELECT p FROM PostEntity p WHERE p.title = :title AND p.comment = : comment")
    List<PostEntity> getProductsByTitle(@Param("title") String title);
}
