package entity.dto.group;

import entity.model.Group;

import java.time.LocalDate;

public record OutGroupDTO(
        Long id,
        String name,
        LocalDate createdDate
) {
    public OutGroupDTO(Group g) {
        this(g.getId(), g.getName(), g.getCreatedDate());
    }
}