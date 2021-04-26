package com.cxhello.example.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author cxhello
 * @date 2021/4/26
 */
@Data
public class BaseEntity {

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 创建人
     */
    private String createUser;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 更新人
     */
    private String updateUser;

    /**
     * 逻辑删除 0:未删除 1:删除
     */
    private Integer isDelete;

}
