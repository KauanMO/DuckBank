package service;

import entity.model.Group;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import repository.GroupRepository;

import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class GroupService {
    @Inject
    private GroupRepository repository;

    public List<Group> findByNames(List<String> names) {
        List<Group> groupsFound = new ArrayList<>();

        for(String name : names) {
            groupsFound.add(repository.findByName(name));
        }

        return groupsFound;
    }
}