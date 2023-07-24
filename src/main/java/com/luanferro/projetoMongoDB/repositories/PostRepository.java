package com.luanferro.projetoMongoDB.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.luanferro.projetoMongoDB.domain.entities.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String>{

    List<Post> findByTitleContainingIgnoreCase(String text);
    
}
