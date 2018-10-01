package com.jk.modules.wechat.utils;

import java.util.Date;

/**
 * 类名: WxOauth2Token </br>
 * 描述:  网页授权信息  </br>
 * 开发人员： makeit </br>
 * 创建时间：  2016-11-27 </br>
 * 发布版本：V1.0  </br>
 */
public class WxOauth2Token {

    private Long id;
    // 会员id
    private Long uid;
    // 网页授权接口调用凭证
    private String accessToken;
    // 凭证有效时长
    private int expiresIn;
    // 用于刷新凭证
    private String refreshToken;
    // 用户标识
    private String openId;
    // 用户授权作用域
    private String scope;

    private Date updateTime;   //开始日期

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public int getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(int expiresIn) {
        this.expiresIn = expiresIn;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }


    public String toString() {
        return "{\"accessToken\":\"" + accessToken
                + "\",\"openId\":\"" + openId
                + "\",\"expiresIn\":\"" + expiresIn
                + "\",\"refreshToken\":\"" + refreshToken
                + "\",\"scope\":\"" + scope
                + "\",\"updateTime\":\"" + updateTime
                + "\"}";
    }
}