package lemelo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

import lemelo.handler.WebsocketHandler;

@EnableWebSocket
@SpringBootApplication
public class Mychatv1Application {

	public static void main(String[] args) {
		SpringApplication.run(Mychatv1Application.class, args);
	}

	public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
		registry.addHandler(new WebsocketHandler(), "/chat");
	}
}
