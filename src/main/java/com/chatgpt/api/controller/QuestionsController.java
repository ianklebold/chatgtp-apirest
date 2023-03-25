package com.chatgpt.api.controller;

import io.github.flashvayne.chatgpt.dto.image.ImageFormat;
import io.github.flashvayne.chatgpt.dto.image.ImageSize;
import io.github.flashvayne.chatgpt.service.ChatgptService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@Slf4j
@AllArgsConstructor
@RestController
public class QuestionsController {

    private ChatgptService chatgptService;

    private static final String CHATGPT_QUESTION_PATH = "api/v1/question";
    private static final String CHATGPT_IMAGE_PATH = "api/v1/image";

    private static final String CHATGPT_RIGTHS = "api/v1/rigths";

    @PostMapping(value = CHATGPT_QUESTION_PATH)
    public String sendSimpleMessage(@RequestBody String message){
        return chatgptService.sendMessage(message);
    }

    @PostMapping(value = CHATGPT_IMAGE_PATH)
    public List<String> sendSimpleMessageGenerateImage(@RequestBody String message,
                                                       @RequestParam(required = false,name = "size") ImageSize size,
                                                       @RequestParam(required = false,name = "quantity") int quantity){
        return  chatgptService.imageGenerate(message,quantity,size, ImageFormat.URL);
    }


}
