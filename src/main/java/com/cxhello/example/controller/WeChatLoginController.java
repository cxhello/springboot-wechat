package com.cxhello.example.controller;

import com.alibaba.fastjson.JSON;
import com.cxhello.example.entity.User;
import com.cxhello.example.entity.WeChatAccessToken;
import com.cxhello.example.entity.WeChatUserInfo;
import com.cxhello.example.service.UserService;
import com.cxhello.example.util.WeChatUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

/**
 * @author cxhello
 * @date 2021/4/25
 */
@Controller
@RequestMapping("/api/ucenter/wx")
public class WeChatLoginController {

    private static final Logger logger = LoggerFactory.getLogger(WeChatLoginController.class);

    @Autowired
    private UserService userService;

    @GetMapping("/generateWxQRCode")
    public String generateWxQrCode() {
        return "redirect:" + WeChatUtil.generateWxQrCode();
    }

    @GetMapping("callback")
    public String callBack(String code, String state) {
        WeChatAccessToken weChatAccessToken = WeChatUtil.getAccessToken(code);
        User user = userService.getUserByOpenId(weChatAccessToken.getOpenId());
        if (user == null) {
            WeChatUserInfo weChatUserInfo = WeChatUtil.getUserInfo(weChatAccessToken);
            logger.info("微信用户个人信息: {}", JSON.toJSONString(weChatUserInfo));
            user = new User();
            user.setOpenId(weChatUserInfo.getOpenId());
            user.setNickName(weChatUserInfo.getNickName());
            user.setHeadImgUrl(weChatUserInfo.getHeadImgUrl());
            user.setUnionId(weChatUserInfo.getUnionId());
            user.setCreateTime(new Date());
            user.setCreateUser("system");
            userService.insert(user);
        }
        return "redirect:http://localhost:8150/index";
    }

}
