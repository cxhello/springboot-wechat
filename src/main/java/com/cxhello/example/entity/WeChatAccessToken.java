package com.cxhello.example.entity;

import lombok.Data;

/**
 * @author cxhello
 * @date 2021/4/25
 */
@Data
public class WeChatAccessToken {

    /**
     * 接口调用凭证
     */
    private String accessToken;

    /**
     * 授权用户唯一标识
     */
    private String openId;

}
