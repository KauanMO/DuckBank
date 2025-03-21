package entity.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    public String firstName;
    public String middleName;
    public String lastName;
    public LocalDate birthDate;
    public LocalDate createdDate;

    @OneToMany(mappedBy = "from")
    public List<Transaction> sentTransactions = new ArrayList<>();

    @OneToMany(mappedBy = "to")
    public List<Transaction> receivedTransactions = new ArrayList<>();

    @PrePersist
    public void prePersist() {
        setCreatedDate(LocalDate.now());
    }
}