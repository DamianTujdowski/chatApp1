package pl.tujdowski.czathttp;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

@Controller
public class ChatSender {

    @PostMapping("/chat")
    public String send(@RequestParam String username,
                     @RequestParam String value,
                     Model model) {
        ChatMessage chatMessage = new ChatMessage(username, value);
        HttpEntity<ChatMessage> httpEntity = new HttpEntity<>(chatMessage);
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.exchange("http://localhost:8082/handleChatMessage",
                HttpMethod.POST,
                httpEntity,
                Void.class
        );

        ChatApi.chatMessage.add(chatMessage);
        model.addAttribute("chatMessage", new ChatMessage());
        return "sendMessage";
    }


}
