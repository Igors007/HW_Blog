package lt.code.academy.hw_blog.service;

import lt.code.academy.hw_blog.dto.Post;
import lt.code.academy.hw_blog.entity.PostEntity;
import lt.code.academy.hw_blog.exception.PostNonExistRuntimeException;
import lt.code.academy.hw_blog.repository.PostRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class PostService {
    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {

        this.postRepository = postRepository;
    }
    public void createPost(Post post){

        postRepository.save(PostEntity.convert(post));
    }
    public List<Post> getPosts() {
        return postRepository.findAll()
                .stream()
                .map(Post :: convert)
                .toList();
    }
    public Post getPost(UUID id){
        return  postRepository.findById(id)
                .map(Post::convert)
                .orElseThrow(() -> new PostNonExistRuntimeException(id));
    }

    public void updatePost(Post post){
        postRepository.save(PostEntity.convert(post));
    }
    public void deletePost(UUID id) {
        postRepository.deleteById(id);
    }
    public List<Post> getPostByTitle(String title){
        return postRepository.getProductsByTitle(title)
                .stream()
                .map(Post::convert)
                .toList();
    }
    public List<Post> getPosts(String title) {
        if(title != null && title.isBlank()) {
            return getPostByTitle(title);
        }
        return getPosts();
    }
}
