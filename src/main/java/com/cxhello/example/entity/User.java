package com.cxhello.example.entity;

import lombok.Data;

/**
 * @author cxhello
 * @date 2021/4/26
 */
@Data
public class User extends BaseEntity {

    /**
     * 自增主键
     */
    private Long id;

    /**
     * 普通用户的标识，对当前开发者帐号唯一
     */
    private String openId;

    /**
     * 昵称
     */
    private String nickName;

    /**
     * 用户头像
     */
    private String headImgUrl;

    /**
     * 用户统一标识。针对一个微信开放平台帐号下的应用，同一用户的unionid是唯一的。
     */
    private String unionId;


}
