package com.app.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.web.WebMvcAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @author Tomas Yussef Galicia Guzman
 *         email: tomasyussef@gmail.com
 *         date: 16/09/2016
 */
@SpringBootApplication(scanBasePackages = "com.app.example")
@EnableJpaRepositories(basePackages = "com.app.example")
@EntityScan(basePackages = "com.app.example")
@EnableWebMvc
public class WebMain extends WebMvcAutoConfiguration
{
    public static void main(String[] args)
    {
        SpringApplication.run(WebMain.class, args);
    }
}