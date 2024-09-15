package ru.pazik98.HawkingBrosTestTask.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.pazik98.HawkingBrosTestTask.model.MessageA;

import java.util.Optional;

@RestController
public class MessageController {
    @RequestMapping("api/1/adapter")
    public ResponseEntity<String> adapter(@RequestBody MessageA messageA) {
        var msg = Optional.ofNullable(messageA.getMsg()).orElse("");
        if (msg.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Field \"msg\" is empty.");
        }

        var lng = Optional.ofNullable(messageA.getLng()).orElse("");
        if (!lng.equals("ru")) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Field \"lng\" must be \"ru\".");
        }


        return ResponseEntity.ok().body(null);
    }

}
