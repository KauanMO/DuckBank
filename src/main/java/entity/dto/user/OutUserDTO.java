package entity.dto.user;

import entity.dto.group.OutGroupDTO;
import entity.model.User;

import java.time.LocalDate;
import java.util.List;

public record OutUserDTO(
        Long id,
        String name,
        LocalDate birthDate,
        LocalDate createdDate,
        List<OutGroupDTO> group
) {
    public OutUserDTO(User u) {
        this(u.getId(),
                u.getFirstName() + " " + u.getLastName(),
                u.getBirthdate(),
                u.getCreatedDate(), u.getUserGroups()
                        .stream()
                        .map(ug -> new OutGroupDTO(ug.getGroup())).toList());
    }
}