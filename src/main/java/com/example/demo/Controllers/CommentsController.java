package com.example.demo.Controllers;

import com.example.demo.Entities.Comment;
import com.example.demo.Services.CommentService;
import com.example.demo.dto.CommentsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comments")
public class CommentsController {
    @Autowired
    CommentService commentService;

    @PostMapping
    public Comment insertComment(@RequestBody Comment comment) {
        return commentService.saveComment(comment);
    }

    @PostMapping("/all")
    public List<Comment> addAllComments(@RequestBody List<Comment> comments) {
        return commentService.saveAllComments(comments);
    }

    @GetMapping
    public List<CommentsResponse> getAllComments() {
        return commentService.getAllComments();
    }

    @GetMapping("/{id}")
    public CommentsResponse findPostsById(@PathVariable long id) {
        return commentService.getCommentById(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteUserById(@PathVariable long id) {
        commentService.deleteComments(id);
    }

    @PutMapping("/update/{id}")
    public Comment updateThePost(@RequestBody Comment comment) {
        return commentService.updateComments(comment);
    }

}
