package com.ou.mall.service;

import com.ou.mall.bean.User;
import com.ou.mall.bean.UserExample;
import com.ou.mall.dao.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户Service
 * @author: kpkym
 * date: 2018/3/1
 * time: 0:30
 */
@Service
public class UserService {
	@Autowired
	UserMapper userMapper;

    /**
     * @param user 根据username password 查询出User
     * @return null 或 user
     */
    public User login(User user) {
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        criteria.andUsernameEqualTo(user.getUsername())
                .andPasswordEqualTo(user.getPassword());
        List<User> users = userMapper.selectByExample(example);
        return users.size() == 0 ? null : users.get(0);
    }

    /**
     * @param user 需要注册的用户信息
     * @return true:注册成功 false:注册失败
     */
    public boolean register(User user) {
        return 0 != userMapper.insertSelective(user);
    }
}
