package entity.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "app_group")
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    public String name;
    public LocalDate createdDate;

    @OneToMany(mappedBy = "group")
    public List<UserGroup> groupUsers;

    @PrePersist
    public void prePersist() {
        setCreatedDate(LocalDate.now());
    }
}