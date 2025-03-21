package service;

import entity.dto.account.RegisterAccountDTO;
import entity.model.Account;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import repository.AccountRepository;

@ApplicationScoped
public class AccountService {
    @Inject
    private AccountRepository repository;

    public Account registerAccount(RegisterAccountDTO dto) {
        Account newAccount = Account.builder()
                .birthDate(dto.birthDate())
                .firstName(dto.firstName())
                .middleName(dto.middleName())
                .lastName(dto.lastName())
                .build();

        repository.persist(newAccount);

        return newAccount;
    }
}