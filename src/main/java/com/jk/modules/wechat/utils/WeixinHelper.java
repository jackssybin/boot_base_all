package com.jk.modules.wechat.utils;

import com.alibaba.fastjson.JSONObject;
import org.apache.log4j.Logger;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;
import org.xml.sax.InputSource;

import java.io.StringReader;
import java.util.*;

/**
 * 微信授权登录  消息通知 及 支付 测试Demo
 *
 * @author makeit
 */
public class WeixinHelper {

    private static Logger logger = Logger.getLogger(WeixinHelper.class);


    /**
     * XML转排序的MAP
     *
     * @param xml
     * @return
     */
    public static Map<String, String> parseXmpToMap(String xml) {
        Map<String, String> map = new TreeMap<String, String>(
                new Comparator<String>() {
                    public int compare(String obj1, String obj2) {
                        // 降序排序
                        return obj1.compareTo(obj2);
                    }
                });
        try {
            InputSource xmlSource = new InputSource(new StringReader(xml));
            SAXBuilder builder = new SAXBuilder();
            Document doc = builder.build(xmlSource);
            Element rootElement = doc.getRootElement();
            List<Element> list = rootElement.getChildren();
            for (int i = 0; i < list.size(); i++) {
                Element e = list.get(i);
                map.put(e.getName(), e.getText());
                // log.info("----name:" + e.getName() + "-----text:" + e.getText());
            }
            return map;
        } catch (Exception e) {
            logger.info(e.getStackTrace());
            return null;
        }
    }

    /**
     * 获取网页授权凭证
     *
     * @param appId     公众账号的唯一标识
     * @param appSecret 公众账号的密钥
     * @return WeixinAouth2Token
     */
    public static String getAccessToken(String appId, String appSecret) {
        String access_token = null;

        // 拼接请求地址
        String requestUrl = "https://api.weixin.qq.com/cgi-bin/token?appid=APPID&secret=SECRET&grant_type=client_credential";
        requestUrl = requestUrl.replace("APPID", appId);
        requestUrl = requestUrl.replace("SECRET", appSecret);


        logger.info("requestUrl=" + requestUrl);

        // 获取网页授权凭证
        JSONObject jsonObject = CommonUtil.httpsRequest(requestUrl, "GET", null);
        if (null != jsonObject) {
            try {
                access_token = jsonObject.getString("access_token");
                logger.info("getToken strJson=" + access_token);
            } catch (Exception e) {
                access_token = null;
                int errorCode = jsonObject.getInteger("errcode");
                String errorMsg = jsonObject.getString("errmsg");
                logger.error("获取网页授权凭证失败 errcode:{" + errorCode + "} errmsg:{" + errorMsg + "}");
            }
        }
        return access_token;
    }

    /**
     * 获取网页授权凭证
     *
     * @param appId     公众账号的唯一标识
     * @param appSecret 公众账号的密钥
     * @param code
     * @return WeixinAouth2Token
     */
    public static WxOauth2Token getOauth2AccessToken(String appId, String appSecret, String code) {
        WxOauth2Token wat = null;
        // 拼接请求地址
        String requestUrl = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=APPID&secret=SECRET&code=CODE&grant_type=authorization_code";
        requestUrl = requestUrl.replace("APPID", appId);
        requestUrl = requestUrl.replace("SECRET", appSecret);
        requestUrl = requestUrl.replace("CODE", code);
        // 获取网页授权凭证
        JSONObject jsonObject = CommonUtil.httpsRequest(requestUrl, "GET", null);
        if (null != jsonObject) {
            try {
                wat = new WxOauth2Token();
                wat.setAccessToken(jsonObject.getString("access_token"));
                wat.setExpiresIn(jsonObject.getInteger("expires_in"));
                wat.setRefreshToken(jsonObject.getString("refresh_token"));
                wat.setOpenId(jsonObject.getString("openid"));
                wat.setScope(jsonObject.getString("scope"));
                wat.setUpdateTime(new Date());
            } catch (Exception e) {
                wat = null;
                int errorCode = jsonObject.getInteger("errcode");
                String errorMsg = jsonObject.getString("errmsg");
                logger.error("获取网页授权凭证失败 errcode:{" + errorCode + "} errmsg:{" + errorMsg + "}");
            }
        }
        return wat;
    }


    /**
     * 通过网页授权获取用户信息
     *
     * @param accessToken 网页授权接口调用凭证
     * @param openId      用户标识
     * @return SNSUserInfo
     */
    @SuppressWarnings({"deprecation", "unchecked"})
    public static SNSUserInfo getSNSUserInfo(String accessToken, String openId) {
        SNSUserInfo snsUserInfo = null;
        // 拼接请求地址
        String requestUrl = "https://api.weixin.qq.com/sns/userinfo?access_token=ACCESS_TOKEN&openid=OPENID";
        requestUrl = requestUrl.replace("ACCESS_TOKEN", accessToken).replace("OPENID", openId);
        // 通过网页授权获取用户信息
        JSONObject jsonObject = CommonUtil.httpsRequest(requestUrl, "GET", null);
        if (null != jsonObject) {
            try {
                snsUserInfo = new SNSUserInfo();
                // 用户的标识
                snsUserInfo.setOpenId(jsonObject.getString("openid"));
                // 昵称
                snsUserInfo.setNickname(jsonObject.getString("nickname"));
                // 性别（1是男性，2是女性，0是未知）
                snsUserInfo.setSex(jsonObject.getInteger("sex"));
                // 用户所在国家
                snsUserInfo.setCountry(jsonObject.getString("country"));
                // 用户所在省份
                snsUserInfo.setProvince(jsonObject.getString("province"));
                // 用户所在城市
                snsUserInfo.setCity(jsonObject.getString("city"));
                // 用户头像
                snsUserInfo.setHeadImgUrl(jsonObject.getString("headimgurl"));
                // 用户特权信息
                snsUserInfo.setPrivilegeList((List) jsonObject.get("privilege"));
            } catch (Exception e) {
                snsUserInfo = null;
                int errorCode = jsonObject.getInteger("errcode");
                String errorMsg = jsonObject.getString("errmsg");
                logger.error("获取用户信息失败 errcode:{" + errorCode + "} errmsg:{" + errorMsg + "}");
            }
        }
        return snsUserInfo;
    }

}
