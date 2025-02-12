package exercise.controller;

import exercise.repository.CommentRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.http.HttpStatus;
import java.util.List;

import exercise.model.Post;
import exercise.repository.PostRepository;
import exercise.exception.ResourceNotFoundException;

// BEGIN
@RestController
@AllArgsConstructor
@RequestMapping("/posts")
public class PostsController {

    PostRepository postRepository;
    CommentRepository commentRepository;

    @GetMapping
    public List<Post> getAll(){
        return postRepository.findAll();
    }

    @GetMapping("/{id}")
    public Post findById(@PathVariable Long id){
        return postRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Post with id " + id + " not found"));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Post create(@RequestBody Post post){
        return postRepository.save(post);
    }

    @PutMapping("/{id}")
    public Post update(@RequestBody Post post, @PathVariable Long id){
        var oldPost = postRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Post with id " + id + " not found"));

        oldPost.setBody(post.getBody());
        oldPost.setTitle(post.getTitle());

        postRepository.save(oldPost);

        return oldPost;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        commentRepository.deleteByPostId(id);
        postRepository.deleteById(id);
    }
}
// END
