package service;

import model.Action;
import model.Monitor;
import model.Resource;
import model.User;

public interface AccessServiceInterface {
    public String accessResource(User user, Monitor monitor, Action action, Resource resource);
}
