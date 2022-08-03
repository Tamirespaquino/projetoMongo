package com.tamiresntt.projetoMongo.services;

import com.tamiresntt.projetoMongo.domain.Post;
import com.tamiresntt.projetoMongo.repository.PostRepository;
import com.tamiresntt.projetoMongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository repo;

    public Post findById(String id) {
        Optional<Post> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto nao encontrado"));
    }

    public List<Post> findByTitle(String text) {
        return repo.searchTitle(text);
    }
}
