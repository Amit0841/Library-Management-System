package com.masai.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.masai.model.ChatGPTRequest;
import com.masai.model.ChatGptResponse;
import com.masai.model.Responce;

@RestController
@CrossOrigin(origins = "*")
public class CustomBotController {

    @Value("${openai.model}")
    private String model;

    @Value(("${openai.api.url}"))
    private String apiURL;

    @Autowired
    private RestTemplate template;
    
   // Endpoint http://localhost:8080/chat?prompt=
    @GetMapping("/chat")
    public ResponseEntity<Responce>  chat(@RequestParam("prompt") String prompt){
        ChatGPTRequest request=new ChatGPTRequest(model, "give me book's details like title, publish date, price in Rupe, and more. on this structure=  \r\n"
        		+ "\r\n"
        		+ "Title:\r\n"
        		+ "Author:\r\n"
        		+ "Description:\r\n"
        		+ "Publish Date:\r\n"
        		+ "Price:₹ \r\n"
        		+ "Genre:\r\n"
        		+ "\r\n"
        		+ "in the Price section don't give any characters only provided the number I wanted."
        		+ " I don't want this (as an example, actual prices vary based on editions and sellers) or (as an example, actual prices may vary) on price."
        		+ " if you do not find by book name then you start to find by Genre and give me A book details and if it's a Genre then provide atlits 4,5 book's."
        		+ " In the Description give only 10 to 15 word only."
        		+ " The book's name or Genre or Author is "+prompt +".Don't give any explanation like =( Im sorry, but as an AI text-based model, I dont have real-time access to specific book details or prices. However, I can recommend a few books by).");
        ChatGptResponse chatGptResponse = template.postForObject(apiURL, request, ChatGptResponse.class);
        Responce c=new Responce(chatGptResponse.getChoices().get(0).getMessage().getContent());
        return new  ResponseEntity<Responce> (c,HttpStatus.OK);
    }
}
