package service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import entity.model.User;
import repository.UserRepository;

import java.util.List;

@ApplicationScoped
public class UserService {
    @Inject
    private UserRepository repository;

    public List<User> getUsersByName(String name) {
        List<User> usersFound = repository.findByName(name);

        return usersFound;
    }

    public User findByCPF(String cpf) {
        User userFound = repository.findByCPF(cpf);

        return userFound;
    }
}