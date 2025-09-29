package com.example.blog.service.impl;

import com.example.blog.domain.Comment;
import com.example.blog.repository.CommentRepository;
import com.example.blog.service.CommentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;

    public CommentServiceImpl(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @Override
    public List<Comment> getAllComments() {
        return commentRepository.findAll();
    }

    @Override
    public Optional<Comment> getCommentById(Long id) {
        return commentRepository.findById(id);
    }

    @Override
    public Comment createComment(Comment comment) {
        return commentRepository.save(comment);
    }

    @Override
    public Comment updateComment(Long id, Comment comment) {
        return commentRepository.findById(id)
                .map(existing -> {
                    existing.setContent(comment.getContent());
                    existing.setAuthorName(comment.getAuthorName());
                    existing.setArticle(comment.getArticle());
                    return commentRepository.save(existing);
                })
                .orElseThrow(() -> new RuntimeException("Comment not found"));
    }

    @Override
    public void deleteComment(Long id) {
        commentRepository.deleteById(id);
    }

}
