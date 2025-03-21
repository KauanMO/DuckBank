package repository;

import entity.model.Group;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class GroupRepository implements PanacheRepository<Group> {
    public Group findByName(String name) {
        return this.find("name = ?1", name).singleResult();
    }
}