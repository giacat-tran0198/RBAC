package model;

import java.util.ArrayList;
import java.util.List;

public class Role {
    private final String name;

    private final List<User> permittedUsersList = new ArrayList<>();

    private final List<Authorization> permittedAuthList = new ArrayList<>();

    public Role(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<User> getPermittedUsersList() {
        return new ArrayList<>(permittedUsersList);
    }

    public List<Authorization> getPermittedAuthList() {
        return new ArrayList<>(permittedAuthList);
    }

    public void addUser(User user) {
        if (user.isBlocked()) return;
        permittedUsersList.add(user);
    }

    public boolean removeUser(User user) {
        return permittedUsersList.remove(user);
    }

    public boolean isUserInRole(User user) {
        return permittedUsersList.contains(user);
    }

    public void addAuth(Authorization auth) {
        permittedAuthList.add(auth);
    }

    public boolean removeAuth(Authorization auth) {
        return permittedAuthList.remove(auth);
    }

    public boolean isAccess(Action action, Resource resource) {
        return permittedAuthList
                .stream()
                .anyMatch(auth -> auth.getAction().equals(action) && auth.getResource().equals(resource));
    }

    public void update() {
        permittedUsersList.removeIf(User::isBlocked);
    }
}
