package entity.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.ZoneId;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    public String type;
    public Double value;
    public LocalDateTime createdDate;

    @ManyToOne
    public Account from;

    @ManyToOne
    public Account to;

    @PrePersist
    public void prePersist() {
        setCreatedDate(LocalDateTime
                .now()
                .atZone(ZoneId
                        .of("America/Sao_Paulo"))
                .toLocalDateTime());
    }
}