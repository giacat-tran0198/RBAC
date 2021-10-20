package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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

    public boolean addRole(Role role){
        return roleList.add(role);
    }

    public boolean removeRole(Role role){
        return roleList.remove(role);
    }

    public boolean canAccess(User user, Action action, Resource resource){
        Role role = null;

        // find role
        for (Role r: roleList){
            if (r.isUserInRole(user)){
                role = r;
                break;
            }
        }

        if (role == null) return false;

        return role.isAccess(action, resource);
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
