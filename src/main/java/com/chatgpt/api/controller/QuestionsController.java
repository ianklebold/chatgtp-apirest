package com.chatgpt.api.controller;

import com.fasterxml.jackson.databind.json.JsonMapper;
import io.github.flashvayne.chatgpt.dto.image.ImageFormat;
import io.github.flashvayne.chatgpt.dto.image.ImageSize;
import io.github.flashvayne.chatgpt.service.ChatgptService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Slf4j
@AllArgsConstructor
@RestController
public class QuestionsController {

    private ChatgptService chatgptService;

    private static final String CHATGPT_QUESTION_PATH = "api/v1/question";
    private static final String CHATGPT_IMAGE_PATH = "api/v1/image";

    private static final String CHATGPT_RIGTHS = "api/v1/rigths";
    private static final String CHATGPT_HELP = "api/v1/help";


    @GetMapping(value = CHATGPT_RIGTHS)
    public String sendRigthsDependecy(){
        return "CHAT GPT DEPENDENCY : https://github.com/flashvayne/chatgpt-spring-boot-starter";
    }

    @GetMapping(value = CHATGPT_HELP)
    public String sendHelp(){

        return "Como utilizar la API : \n" +
                "1. Enviar un simple mensaje por request body : \n" +
                "Pegale a este endpoint api/v1/question con metodo POST y por texto plano lo que quieras preguntar" +
                "\n\n" +
                "2. Generar imagen por request body : \n" +
                "Pegale a este endpoint /api/v1/image?size=XXX&quantity=XXX con metodo POST y por texto plano lo que quieras preguntar" +
                "En el caso de SIZE debes poner una de estas tres opciones : SMALL, MEDIUM o LARGE\n" +
                "En el caso de quantity colocar la cantidad de imagenes que queremos que genere";

    }

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
