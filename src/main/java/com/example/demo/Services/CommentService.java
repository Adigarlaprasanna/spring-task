package com.example.demo.Services;

import com.example.demo.Entities.Comment;
import com.example.demo.Repository.CommentRepo;
import com.example.demo.dto.CommentsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class CommentService {
    @Autowired
    CommentRepo commentRepo;

    public Comment saveComment(Comment comment) {
        return commentRepo.save(comment);
    }

    public List<Comment> saveAllComments(List<Comment> comment) {
        return commentRepo.saveAll(comment);
    }

    public List<CommentsResponse> getAllComments() {
        return commentRepo.getAllComments();
    }

    public CommentsResponse getCommentById(long id) {
        return commentRepo.getCommentById(id).orElse(null);
    }

    public String deleteComments(long id) {
        commentRepo.deleteById(id);
        return "the " + id + " Post data has been deleted";
    }

    public Comment updateComments(Comment comment) {
        Comment existingComment = commentRepo.findById(comment.getId()).orElse(null);
        existingComment.setId(comment.getId());
        existingComment.setPost(comment.getPost());
        existingComment.setBody(comment.getBody());
        return commentRepo.save(existingComment);
    }
}
