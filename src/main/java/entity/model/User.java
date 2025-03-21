package entity.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "app_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    public String firstName;
    public String lastName;
    public String password;
    public LocalDate birthdate;
    public String cpf;
    public LocalDate createdDate;

    @OneToMany(mappedBy = "user")
    public List<UserGroup> userGroups;

    @PrePersist
    public void prePersist() {
        setCreatedDate(LocalDate.now());
    }
}