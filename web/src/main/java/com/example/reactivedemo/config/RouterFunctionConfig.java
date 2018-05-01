package com.example.reactivedemo.config;

import com.example.reactivedemo.entity.User;
import com.example.reactivedemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;


/**
 * Created by jack on 2018/4/14 0014.
 */
@Configuration
public class RouterFunctionConfig {

    @Bean
    @Autowired
    public RouterFunction<ServerResponse> findAll(UserRepository userRepository){

       return RouterFunctions.route(RequestPredicates.GET("/webflux/findAll"),request -> {
            Flux<User> userFlux = Flux.fromIterable(userRepository.userConcurrentMap.values());
            return ServerResponse.ok().body(userFlux,User.class);
        });

    }
}
