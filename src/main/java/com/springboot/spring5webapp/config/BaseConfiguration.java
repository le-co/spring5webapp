package com.springboot.spring5webapp.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories("com.springboot.spring5webapp.repository")
public class BaseConfiguration {
}
