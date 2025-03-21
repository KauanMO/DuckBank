package entity.dto.user;

import entity.dto.account.RegisterAccountDTO;

public record RegisterUserDTO(
        String cpf,
        Integer password,
        RegisterAccountDTO account
) {
}