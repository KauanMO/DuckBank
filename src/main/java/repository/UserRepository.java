package repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import entity.model.User;

import java.util.List;

@ApplicationScoped
public class UserRepository implements PanacheRepository<User> {
    public List<User> findByName(String name) {
        return this.list("firstName like ?1 or lastName like ?1", name);
    }

    public User findByCPF(String cpf) {
        return this.find("cpf = ?1", cpf).singleResult();
    }
}