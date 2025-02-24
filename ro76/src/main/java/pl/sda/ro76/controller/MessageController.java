package pl.sda.ro76.controller;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.sda.ro76.model.Message;

@RestController
@RequestMapping("/")
public class MessageController {

    @PostMapping("api/messages")
    public void sendMessage(@Valid @RequestBody final Message message) {
        System.out.println(message.getMessage());
        // handle message sending on service layer
    }
}
