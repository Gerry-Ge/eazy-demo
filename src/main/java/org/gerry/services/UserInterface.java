package org.gerry.services;

import org.gerry.model.User;

public interface UserInterface {
    public int insert(User user);
    public User search(int id);
}
