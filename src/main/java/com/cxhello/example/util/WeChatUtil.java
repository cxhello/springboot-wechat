package com.cxhello.example.util;

import com.alibaba.fastjson.JSON;
import com.cxhello.example.WeChatAccessToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;

/**
 * @author cxhello
 * @date 2021/4/25
 */
@Component
public class WeChatUtil {

    private static final Logger logger = LoggerFactory.getLogger(WeChatUtil.class);

    private static final String CHARSET_NAME = "utf-8";

    private static final String LOGIN_URL = "https://open.weixin.qq.com/connect/qrconnect" +
            "?appid=%s" +
            "&redirect_uri=%s" +
            "&response_type=code" +
            "&scope=snsapi_login" +
            "&state=%s" +
            "#wechat_redirect";

    private static final String ACCESS_TOKEN_URL = "https://api.weixin.qq.com/sns/oauth2/access_token" +
            "?appid=%s" +
            "&secret=%s" +
            "&code=%s" +
            "&grant_type=authorization_code";

    private static final String USER_INFO_URL = "https://api.weixin.qq.com/sns/userinfo" +
            "?access_token=%s" +
            "&openid=%s";

    private static final String STATE = "cxhello";

    private static String weChatAppId;

    private static String weChatAppSecret;

    private static String weChatRedirectUrl;

    @Value("${wx.open.app_id}")
    public void setWeChatAppId(String weChatAppId) {
        WeChatUtil.weChatAppId = weChatAppId;
    }

    @Value("${wx.open.app_secret}")
    public void setWeChatAppSecret(String weChatAppSecret) {
        WeChatUtil.weChatAppSecret = weChatAppSecret;
    }

    @Value("${wx.open.redirect_url}")
    public void setWeChatRedirectUrl(String weChatRedirectUrl) {
        WeChatUtil.weChatRedirectUrl = weChatRedirectUrl;
    }

    public static String generateWxQrCode() {
        try {
            weChatRedirectUrl = URLEncoder.encode(weChatRedirectUrl, CHARSET_NAME);
        } catch (UnsupportedEncodingException e) {
            logger.error("System error", e);
        }
        return String.format(LOGIN_URL, weChatAppId, weChatRedirectUrl, STATE);
    }

    public static WeChatAccessToken getAccessToken(String code) {
        String accessTokenUrl = String.format(ACCESS_TOKEN_URL, weChatAppId, weChatAppSecret, code);
        String result = null;
        try {
            result = HttpClientUtil.get(accessTokenUrl);
        } catch (Exception e) {
            logger.error("System error", e);
        }
        HashMap map = JSON.parseObject(result, HashMap.class);
        WeChatAccessToken weChatAccessToken = new WeChatAccessToken();
        weChatAccessToken.setAccessToken(map.get("access_token").toString());
        weChatAccessToken.setOpenId(map.get("openid").toString());
        return weChatAccessToken;
    }

    public static String getUserInfo(WeChatAccessToken weChatAccessToken) {
        String userInfoUrl = String.format(USER_INFO_URL, weChatAccessToken.getAccessToken(), weChatAccessToken.getOpenId());
        String result = null;
        try {
            result = HttpClientUtil.get(userInfoUrl);
        } catch (Exception e) {
            logger.error("System error", e);
        }
        HashMap map = JSON.parseObject(result, HashMap.class);
        return null;
    }

}
