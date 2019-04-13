package com.romanstetsiuk.spring_aspect.restController;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/messages")
public class MessageController {

    @GetMapping("/{text}")
    public ResponseEntity<Message> getSingle(@PathVariable("text") String s) {

        return ResponseEntity.ok().body(new Message(s));
    }

    @GetMapping
    public ResponseEntity<List<Message>> getAll() {
        List<Message> messages = new ArrayList<>();
        messages.add(new Message("dasdasddsad1"));
        messages.add(new Message("dasdasddsad2"));
        messages.add(new Message("dasdasddsad3"));

        return ResponseEntity.ok().body(messages);
    }

}
