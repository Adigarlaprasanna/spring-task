package com.example.demo.Controllers;

import com.example.demo.Entities.Post;
import com.example.demo.Services.PostService;
import com.example.demo.dto.PostResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping("/{id}")
    public PostResponse getPost(@PathVariable("id") int id) {
        return postService.getPostById(id);
    }

    @GetMapping
    public List<PostResponse> getAllPosts() {
        return this.postService.getAllPosts();
    }

    @PostMapping("/save")
    public Post createPost(@RequestBody Post post){
        return this.postService.savePost(post);
    }

    @DeleteMapping("/delete/{id}")
    public String  deletePost(@PathVariable("id") int id) {
        return this.postService.deletePost(id);
    }

    @PutMapping("/update")
    public Post updatePost(@RequestBody Post post) {
        return this.postService.updatePost(post);
    }
}
