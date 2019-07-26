package org.gerry.test;

import org.gerry.mapper.UserMapper;
import org.gerry.model.User;
import org.gerry.services.UserService;

public class Child extends Parent<UserMapper,User,UserService> {

}
