package org.gerry.services;

import org.apache.dubbo.config.annotation.Service;
import org.gerry.Utils.applicationAware;
import org.gerry.mapper.UserMapper;
import org.gerry.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;

import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.UUID;

@Service
@org.springframework.stereotype.Service
@ComponentScan({"org.gerry.mapper"})
@Transactional
public class UserService implements UserInterface {

    @Autowired
    UserMapper userMapper;

    @Override
    public int insert(User user) {
        int i=userMapper.insert(user);
        System.out.println(i);
        return i;
    }

    @Override
    public User search(int id) {
        User user=userMapper.search(id);
        return user;
    }

}
