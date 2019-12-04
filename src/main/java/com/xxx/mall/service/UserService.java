package com.xxx.mall.service;

import com.xxx.mall.bean.po.User;
import com.xxx.mall.bean.po.UserExample;
import com.xxx.mall.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserService {

    @Autowired
    UserMapper userMapper;


    public List<User> selectByExample(UserExample example) {
        List<User> selectByExample = userMapper.selectByExample(example);
        return selectByExample;
    }

    public User getUserByUsernameAndPassWord(User user) {
        UserExample example = new UserExample();
        UserExample.Criteria createCriteria = example.createCriteria();
        createCriteria.andUserUsernameEqualTo(user.getUserUsername());
        createCriteria.andUserPasswordEqualTo(user.getUserPassword());

        List<User> selectByExample = userMapper.selectByExample(example);
        return selectByExample.isEmpty() ? null : selectByExample.get(0);
    }

    public void insert(User user) {
        userMapper.insert(user);
    }

    public User login(User user) {

        UserExample example = new UserExample();
        UserExample.Criteria createCriteria = example.createCriteria();
        createCriteria.andUserUsernameEqualTo(user.getUserUsername());
        createCriteria.andUserPasswordEqualTo(user.getUserPassword());
        List<User> selectByExample = userMapper.selectByExample(example);
        return selectByExample.isEmpty() ? null : selectByExample.get(0);
    }

    public User getUserByUsername(String username) {
        UserExample example = new UserExample();
        UserExample.Criteria createCriteria = example.createCriteria();
        createCriteria.andUserUsernameEqualTo(username);

        List<User> selectByExample = userMapper.selectByExample(example);

        return selectByExample.isEmpty() ? null : selectByExample.get(0);
    }

    public void updateByPrimaryKeySelective(User record) {
        userMapper.updateByPrimaryKeySelective(record);
    }

    public boolean addMoney(Double money, Integer uid) {
        User record = userMapper.selectByPrimaryKey(uid);
        Double newMoney = record.getUserMoney() + money;
        if (newMoney < 0) {
            return false;
        }

        record.setUserMoney(newMoney);
        userMapper.updateByPrimaryKeySelective(record);
        return true;
    }

    public User selectByPrimaryKey(Integer userId) {
        return userMapper.selectByPrimaryKey(userId);
    }

}
