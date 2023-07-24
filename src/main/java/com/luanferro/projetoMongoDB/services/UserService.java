package com.luanferro.projetoMongoDB.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luanferro.projetoMongoDB.domain.dto.UserDTO;
import com.luanferro.projetoMongoDB.domain.entities.User;
import com.luanferro.projetoMongoDB.repositories.UserRepository;
import com.luanferro.projetoMongoDB.services.exceptions.ObjectNotFoundException;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll() {
        return repository.findAll();
    }

    public User findById(String id) {
        Optional<User> user = repository.findById(id);
        return user.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }
    
    public User insert(User user) {
        return repository.insert(user);
    }

    public User fromDTO(UserDTO userDTO) {
        return new User(userDTO.getId(), userDTO.getName(), userDTO.getEmail());
    }

    public void delete(String id) {
        findById(id);
        repository.deleteById(id);
    }
}
