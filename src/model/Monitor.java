package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class Monitor {
    private String name;

    private final List<Role> roleList = new ArrayList<>();

    public Monitor(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Role> getRoleList() {
        return new ArrayList<>(roleList);
    }

    public void addRole(Role role){
        roleList.add(role);
    }

    public boolean removeRole(Role role){
        return roleList.remove(role);
    }

    public boolean canAccess(User user, Action action, Resource resource){
        Optional<Role> role = roleList.stream().filter(r -> r.isUserInRole(user)).findFirst();
        return role.map(value -> value.isAccess(action, resource)).orElse(false);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Monitor monitor = (Monitor) o;
        return Objects.equals(name, monitor.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
