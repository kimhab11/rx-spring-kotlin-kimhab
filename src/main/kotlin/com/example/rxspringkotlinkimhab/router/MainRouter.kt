package com.example.rxspringkotlinkimhab.router

import com.example.rxspringkotlinkimhab.handler.AppUserHandler
import com.example.rxspringkotlinkimhab.handler.OrderHandler
import com.example.rxspringkotlinkimhab.handler.TestHandler
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.server.RouterFunction
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.router

@Configuration
class MainRouter {
    @Bean
    fun forTesting(testHandler: TestHandler): RouterFunction<ServerResponse> =
        router {
            "api/v1/".nest {
                GET("test", testHandler::sayHello)
                GET("student", testHandler::getStudentName)
            }
        }

    @Bean
    fun forAppUser(appUserHandler: AppUserHandler): RouterFunction<ServerResponse> =
        router {
            GET("users" , appUserHandler::findAll)
            GET("user/{id}" , appUserHandler::findByid)
            POST("user" , appUserHandler::addUser)
        }

    @Bean
    fun forOrder(orderHandler: OrderHandler): RouterFunction<ServerResponse> =
        router {
            GET("orders", orderHandler::findAll)
            POST("order" , orderHandler::addOrder)
        }
}