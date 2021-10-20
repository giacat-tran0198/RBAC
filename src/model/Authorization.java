package model;

import java.util.Objects;

public class Authorization {
    private final String name;

    private final Action action;

    private final Resource resource;

    public Authorization(String name, Action action, Resource resource) {
        this.name = name;
        this.action = action;
        this.resource = resource;
    }

    public String getName() {
        return name;
    }

    public Action getAction() {
        return action;
    }

    public Resource getResource() {
        return resource;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Authorization that = (Authorization) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
