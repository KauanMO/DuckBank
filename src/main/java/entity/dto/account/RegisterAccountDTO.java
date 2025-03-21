package entity.dto.account;

import java.time.LocalDate;

public record RegisterAccountDTO(
        String firstName,
        String middleName,
        String lastName,
        LocalDate birthDate
) {
}
