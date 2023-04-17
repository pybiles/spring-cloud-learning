package com.yjx.web.filter;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;
@Component
public class AuthFilter implements GlobalFilter {
    /**
     * 过滤器过滤时都调用该方法
     *
     * @param exchange 交换机
     * @param chain    过滤器链 用于放行
     * @return
     */
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        System.out.println("进行用户授权鉴定------");
        //获取到请求
        ServerHttpRequest request = exchange.getRequest();
        ServerHttpResponse response = exchange.getResponse();

        String token = request.getQueryParams().getFirst("token");
        //表示没有登录
        if (token == null) {
            response.setStatusCode(HttpStatus.UNAUTHORIZED);
            return response.setComplete();
        }
        //有登录就响应，存储一个userId的用户信息到请求
        ServerHttpRequest req = exchange.getRequest().mutate().header("userId", "Cause").build();
//        response.getHeaders().setContentType(MediaType.APPLICATION_JSON);
//
//        String json = "{\"code\":401,\"msg\":\"未授权\"}";
//        response.writeWith(Mono.fromSupplier(() -> {
//            return response.bufferFactory().wrap(json.getBytes());
//        }));

//        return chain.filter(exchange);
        //放行，并响应
        return chain.filter(exchange.mutate().request(req).build());
    }
}
