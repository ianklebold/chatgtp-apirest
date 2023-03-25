package com.chatgpt.api;

import com.chatgpt.api.config.ChatGptConfigurationProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(ChatGptConfigurationProperties.class)
public class ChatgptApirestApplication {

    public static void main(String[] args) {
        SpringApplication.run(ChatgptApirestApplication.class, args);
    }

}
