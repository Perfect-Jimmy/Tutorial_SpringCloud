package com.cloud.configurer;

import org.springframework.context.annotation.Configuration;

/**
 * Created by Jimmy. 2018/6/4  21:50
 */


@Configuration
public class GatewayConfigurer {

   /* @Bean
    public RouteLocator customerRouteLocator(RouteLocatorBuilder builder) {*/
      /*  return builder.routes()
                .route(r -> r.path("/test/prefix/**")
                        .filters(f -> f.stripPrefix(2)
                                .filter(new CustomFilter())
                                .addResponseHeader("X-Response-test", "test"))
                        .uri("lb://SC-CONSUMER")
                        .order(0)
                        .id("test_consumer_service")
                )
                .build();*/

       /* return builder.routes()
                .route(t -> t.path("/hello")
                        .and()
                        .uri("http://localhost:8080"))
                .build();*/
   // }

/*
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        Function<PredicateSpec, Route.Builder> fn = new Function<PredicateSpec, Route.Builder>() {

            public Route.Builder apply(PredicateSpec t) {
                t.path("/hello");
                return t.uri("http://localhost:8080");
            }
        };
        return builder.routes().route(fn).build();
    }*/

   /* @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(t -> t.path("/hello")
                        .and()
                        .uri("http://localhost:8080"))
                .build();
    }*/
}
