package org.gerry.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.gerry.model.User;
import org.springframework.stereotype.Repository;


@Repository
public interface UserMapper {
    public int insert(User user);

    public User search(int id);

}
