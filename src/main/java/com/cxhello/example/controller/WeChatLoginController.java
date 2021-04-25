package com.cxhello.example.controller;

import com.cxhello.example.WeChatAccessToken;
import com.cxhello.example.util.WeChatUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author cxhello
 * @date 2021/4/25
 */
@Controller
@RequestMapping("/api/ucenter/wx")
public class WeChatLoginController {

    private static final Logger logger = LoggerFactory.getLogger(WeChatLoginController.class);

    @GetMapping("/generateWxQRCode")
    public String generateWxQrCode() {
        return "redirect:" + WeChatUtil.generateWxQrCode();
    }

    @GetMapping("callback")
    public String callBack(String code, String state) {
        WeChatAccessToken weChatAccessToken = WeChatUtil.getAccessToken(code);
        WeChatUtil.getUserInfo(weChatAccessToken);
        return null;
    }



}
