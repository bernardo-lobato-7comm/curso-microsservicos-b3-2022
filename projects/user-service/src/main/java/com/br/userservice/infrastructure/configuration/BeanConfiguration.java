package com.br.userservice.infrastructure.configuration;

import com.br.userservice.UserServiceApplication;
import com.br.userservice.application.port.inbound.UserInbound;
import com.br.userservice.application.port.outbound.UserEventPublisher;
import com.br.userservice.application.port.outbound.UserRepository;
import com.br.userservice.application.service.UserDomainService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = UserServiceApplication.class)
public class BeanConfiguration {

    @Bean
    UserInbound userService(final UserRepository userRepository, final UserEventPublisher userEventPublisher){
        return new UserDomainService(userRepository, userEventPublisher);
    }
}
