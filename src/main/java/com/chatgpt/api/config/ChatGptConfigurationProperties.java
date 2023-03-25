package com.chatgpt.api.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("chatgpt")
public record ChatGptConfigurationProperties(String apikey) {
}
