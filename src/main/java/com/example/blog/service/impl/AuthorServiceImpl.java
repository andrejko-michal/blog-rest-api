package com.example.blog.service.impl;

import com.example.blog.domain.Author;
import com.example.blog.repository.AuthorRepository;
import com.example.blog.service.AuthorService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }


    @Override
    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    @Override
    public Optional<Author> getAuthorById(Long id) {
        return authorRepository.findById(id);
    }

    @Override
    public Author createAuthor(Author author) {
        return authorRepository.save(author);
    }

    @Override
    public Author updateAuthor(Long id, Author author) {
        return authorRepository.findById(id)
                .map(existing -> {
                    existing.setName(author.getName());
                    existing.setEmail(author.getEmail());
                    return authorRepository.save(existing);
                })
                .orElseThrow(() -> new RuntimeException("Author not found"));
    }

    @Override
    public void deleteAuthor(Long id) {
        authorRepository.deleteById(id);
    }


}
