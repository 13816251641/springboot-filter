package com.lujieni.filter.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @version V1.0
 * @title: GlobalJWTConfigProperties
 * @description: JWT登录校验 相关配置
 * @author: xulong
 * @date 2019/6/18
 */
@ConfigurationProperties(prefix = "scorpio.filters.jwt")
public class GlobalJWTConfigProperties {

    /**
     * 是否开启登陆校验
     */
    private boolean enabled;

    /**
     * 公钥
     */
    private String publicKey;

    /**
     * 私钥
     */
    private String privateKey;

    /**
     * 需要进行拦截的地址pattern
     */
    private List<String> needFilterUrlPatterns;

    /**
     * 不需要进行拦截的地址列表，优先级高于需要拦截的配置
     */
    private List<String> noNeedFilterUrlPatterns;

    /**
     * 统一登录界面地址
     */
    private String loginPage;

    /**
     * 写cookie的key
     */
    private String cookieName;

    /**
     * 写cookie的域名
     */
    private String cookieDomain;

    /**
     * token通过header进行传递的header名称(防止CSRF攻击)
     */
    private String tokenHeaderName;

    /**
     * 认证服务登陆成功后重定向到认证服务器地址
     */
    private String loginSuccessRedirectUrl;

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getPublicKey() {
        return publicKey;
    }

    public void setPublicKey(String publicKey) {
        this.publicKey = publicKey;
    }

    public String getPrivateKey() {
        return privateKey;
    }

    public void setPrivateKey(String privateKey) {
        this.privateKey = privateKey;
    }

    public List<String> getNeedFilterUrlPatterns() {
        return needFilterUrlPatterns;
    }

    public void setNeedFilterUrlPatterns(List<String> needFilterUrlPatterns) {
        this.needFilterUrlPatterns = needFilterUrlPatterns;
    }

    public List<String> getNoNeedFilterUrlPatterns() {
        return noNeedFilterUrlPatterns;
    }

    public void setNoNeedFilterUrlPatterns(List<String> noNeedFilterUrlPatterns) {
        this.noNeedFilterUrlPatterns = noNeedFilterUrlPatterns;
    }

    public String getLoginPage() {
        return loginPage;
    }

    public void setLoginPage(String loginPage) {
        this.loginPage = loginPage;
    }

    public String getCookieName() {
        return cookieName;
    }

    public void setCookieName(String cookieName) {
        this.cookieName = cookieName;
    }

    public String getCookieDomain() {
        return cookieDomain;
    }

    public void setCookieDomain(String cookieDomain) {
        this.cookieDomain = cookieDomain;
    }

    public String getTokenHeaderName() {
        return tokenHeaderName;
    }

    public void setTokenHeaderName(String tokenHeaderName) {
        this.tokenHeaderName = tokenHeaderName;
    }

    public String getLoginSuccessRedirectUrl() {
        return loginSuccessRedirectUrl;
    }

    public void setLoginSuccessRedirectUrl(String loginSuccessRedirectUrl) {
        this.loginSuccessRedirectUrl = loginSuccessRedirectUrl;
    }
}
