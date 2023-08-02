package com.example.demo.Repository;

import com.example.demo.Entities.Post;
import com.example.demo.dto.PostResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PostRepo extends JpaRepository<Post, Long> {

    @Query("SELECT NEW com.example.demo.dto.PostResponse(p.user.id, p.id, p.title, p.body) " +
            "FROM Post p")
    List<PostResponse> getAllPosts();

    @Query("SELECT NEW com.example.demo.dto.PostResponse(p.user.id, p.id, p.title, p.body) " +
            "FROM Post p WHERE p.id = :postId")
    Optional<PostResponse> getPostById(@Param("postId") long postId);
}
