package com.lujieni.filter.filter;

import com.alibaba.fastjson.JSON;
import com.lujieni.filter.properties.GlobalJWTConfigProperties;
import com.lujieni.filter.response.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @version V1.0
 * @title: GlobalJWTVerifyGlobalFilter
 * @description: JWT登录校验拦截器
 * @author: XuLong
 * @date 2019/11/4
 */
public class GlobalJWTVerifyGlobalFilter extends OncePerRequestFilter {

    private final Logger logger = LoggerFactory.getLogger(GlobalJWTVerifyGlobalFilter.class);

    private GlobalJWTConfigProperties globalJWTConfigProperties;

    public void setGlobalJWTConfigProperties(GlobalJWTConfigProperties globalJWTConfigProperties) {
        this.globalJWTConfigProperties = globalJWTConfigProperties;
    }

    /**
     * 校验当前地址 是否要登录拦截
     * @param request
     * @return
     * true:不需要拦截
     * false:需要拦截
     */
    @Override
    protected boolean shouldNotFilter(HttpServletRequest request){
        String url = request.getServletPath();// /filter不会出现在url中
        logger.info("servletPath:{}",url);
        if(url.contains("123"))
            return true;
        return false;
    }

    /**
     * 在controller处理请求前拦截
     * 校验token
     * @param request
     * @param response
     * @param filterChain
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        //校验不过 登录去吧你
        String redirectUrl = globalJWTConfigProperties.getLoginPage();
        String referer = request.getHeader(HttpHeaders.REFERER);
        if (!StringUtils.isEmpty(referer)) {
            redirectUrl += "?redirectUrl=" + referer;
        }
        Response result = new Response();
        result.setSuccess(false);
        result.setErrorCode(Response.ERROR_REDIRECT);
        result.setResult(redirectUrl);
        response.setStatus(org.springframework.http.HttpStatus.OK.value());
        response.getWriter().write(JSON.toJSONString(result));

        /*
            request.setAttribute("name","lujieni520");
            直接获取request
            HttpServletRequest myRequest = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
            String name = (String)myRequest.getAttribute("name");
            System.out.println(name);
        */
        return;
    }
}
