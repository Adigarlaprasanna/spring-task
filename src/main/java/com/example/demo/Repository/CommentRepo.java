package com.example.demo.Repository;

import com.example.demo.Entities.Comment;
import com.example.demo.dto.CommentsResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CommentRepo extends JpaRepository<Comment, Long> {

    @Query("SELECT NEW com.example.demo.dto.CommentsResponse(c.id, c.post.id, c.post.user.id, c.body) " +
            "FROM Comment c")
    List<CommentsResponse> getAllComments();

    @Query("SELECT NEW com.example.demo.dto.CommentsResponse(c.id, c.post.id, c.post.user.id, c.body) " +
            "FROM Comment c WHERE c.id = :commentId")
    Optional<CommentsResponse> getCommentById(@Param("commentId") long commentId);

}