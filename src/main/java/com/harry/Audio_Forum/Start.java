package com.harry.Audio_Forum;


import com.harry.Audio_Forum.pojo.Post;
import com.harry.Audio_Forum.pojo.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class Start {
    /*
    private PostRepository postRepository;

    @Autowired
    public Start(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void run() {
        Post post = new Post("to jest post", "Kowalski");
        postRepository.save(post);

    }*/
}





