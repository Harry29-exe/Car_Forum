package com.harry.Audio_Forum.mapping;

import com.harry.Audio_Forum.pojo.Post;
import com.harry.Audio_Forum.pojo.PostRepository;
import com.harry.Audio_Forum.pojo.PostResource;
import com.harry.Audio_Forum.pojo.PostResourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class Forum {

    PostRepository postRepository;
    PostResourceRepository postResourceRepository;

    @Autowired
    public Forum(PostRepository postRepository, PostResourceRepository postResourceRepository) {
        this.postRepository = postRepository;
        this.postResourceRepository = postResourceRepository;
    }

    @GetMapping("/api/post")
    public Post getPost(@RequestParam long id) {
        Optional<Post> post;
        if((post = postRepository.findById(id)).isPresent()) {
            return post.get();
        } else {
            return null;
        }
    }

    @PostMapping("/api/post")
    public boolean addPost(@RequestBody Post post) {
        long id = postRepository.save(post).getId();
        return postRepository.findById(id).isPresent();
    }

    @PostMapping("/api/postResources")
    public boolean addResourceToPost(@RequestBody PostResource postResource) {
        long id = postResourceRepository.save(postResource).getId();
        return postResourceRepository.existsById(id);
    }

    @DeleteMapping("/api/post")
    public boolean deletePost(@RequestParam long id) {
        if(postRepository.findById(id).isPresent()) {
            postRepository.delete(postRepository.findById(id).get());
            return true;
        } else {
            return false;
        }
    }
}