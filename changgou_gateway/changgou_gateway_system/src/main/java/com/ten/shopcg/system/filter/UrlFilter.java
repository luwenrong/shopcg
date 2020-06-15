package com.ten.shopcg.system.filter;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
public class UrlFilter implements GlobalFilter, Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        System.out.println("经过第二个过滤器");
        ServerHttpRequest request = exchange.getRequest();
        String path = request.getURI().getPath();
        System.out.println("path:" + path);

        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return 2;
    }
}
