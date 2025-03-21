package service;

import entity.dto.user.RegisterUserDTO;
import entity.model.Account;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import entity.model.User;
import jakarta.transaction.Transactional;
import repository.UserRepository;

import java.util.List;

@ApplicationScoped
public class UserService {
    @Inject
    private UserRepository repository;
    @Inject
    private AccountService accountService;
    @Inject
    private UserGroupService userGroupService;

    @Transactional
    public User registerUser(RegisterUserDTO dto) {
        Account newAccount = accountService.registerAccount(dto.account());

        User newUser = User.builder()
                .password(dto.password())
                .cpf(dto.cpf())
                .account(newAccount)
                .build();

        repository.persist(newUser);

        userGroupService.registerUserGroups(newUser, List.of("user"));

        return newUser;
    }

    public List<User> getUsersByName(String name) {
        List<User> usersFound = repository.findByName(name);

        return usersFound;
    }

    public User findByCPF(String cpf) {
        User userFound = repository.findByCPF(cpf);

        return userFound;
    }
}