package com.cxhello.example.service;

import com.cxhello.example.entity.User;

/**
 * @author cxhello
 * @date 2021/4/26
 */
public interface UserService {

    /**
     * 新增用户
     * @param user
     */
    void insert(User user);

    /**
     * 根据openId查询用户
     * @param openId
     * @return
     */
    User getUserByOpenId(String openId);

}
