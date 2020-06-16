package com.ten.shopcg.system.filter;

import com.ten.shopcg.system.util.JwtUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @author ten.lu
 * @title 接口jwt验证
 * @date 2020-06-17 0:22
 */
@Component
public class AuthorizeFilter implements GlobalFilter, Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        //1、获取请求对象
        ServerHttpRequest request = exchange.getRequest();
        //2、获取响应对象
        ServerHttpResponse response = exchange.getResponse();
        //3、判断当前的请求是否为登录请求，如果是，则直接放行
        if(request.getURI().getPath().contains("/admin/login")){
            return chain.filter(exchange);
        }
        //4、获取当前的所有请求头信息
        HttpHeaders headers = request.getHeaders();
        //5、获取jwt令牌信息
        String jwtToken = headers.getFirst("token");
        //6、判断令牌
        if(StringUtils.isEmpty(jwtToken)){
            response.setStatusCode(HttpStatus.UNAUTHORIZED);
            return response.setComplete();
        }

        try{
            JwtUtil.parseJWT(jwtToken);
        }catch (Exception e){
            e.printStackTrace();
            response.setStatusCode(HttpStatus.UNAUTHORIZED);
            return response.setComplete();
        }
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
