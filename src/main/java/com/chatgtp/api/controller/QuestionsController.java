package com.chatgtp.api.controller;

import io.github.flashvayne.chatgpt.service.ChatgptService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@AllArgsConstructor
@RestController
public class QuestionsController {

    private ChatgptService chatgptService;

    private static final String CHATGTP_PATH = "api/v1/question";

    @PostMapping(value = CHATGTP_PATH)
    public String sendSimpleMessage(@RequestBody String message){
        return chatgptService.sendMessage(message);
    }

}