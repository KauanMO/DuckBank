package service;

import entity.model.Group;
import entity.model.User;
import entity.model.UserGroup;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import repository.UserGroupRepository;

import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class UserGroupService {
    @Inject
    private UserGroupRepository repository;
    @Inject
    private GroupService groupService;

    public List<UserGroup> registerUserGroups(User user, List<String> groupsNames) {
        List<Group> groupsFound = groupService.findByNames(groupsNames);

        List<UserGroup> userGroups = new ArrayList<>();

        for (Group group : groupsFound) {
            userGroups.add(UserGroup.builder()
                    .user(user)
                    .group(group)
                    .build());
        }

        repository.persist(userGroups);

        return userGroups;
    }
}
