package com.cxhello.example.service.impl;

import com.cxhello.example.dao.UserDao;
import com.cxhello.example.entity.User;
import com.cxhello.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author cxhello
 * @date 2021/4/26
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public void insert(User user) {
        userDao.insertSelective(user);
    }

    @Override
    public User getUserByOpenId(String openId) {
        User user = new User();
        user.setIsDelete(0);
        user.setOpenId(openId);
        return userDao.selectOne(user);
    }

}
