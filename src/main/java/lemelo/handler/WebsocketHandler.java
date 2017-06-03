package lemelo.handler;

import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

public class WebsocketHandler extends TextWebSocketHandler {

	public static Map<String, WebSocketSession> sessions = new HashMap<String, WebSocketSession>();

	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {

		Principal p = session.getPrincipal();

		sessions.remove(p.getName());

	}

	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {

		Principal p = session.getPrincipal();

		sessions.put(p.getName(), session);

	}

	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {

		String payload = message.getPayload();

		JSONObject mensagem = new JSONObject(payload);

		String destino = (String) mensagem.get("destino");
		String texto = (String) mensagem.get("texto");

		sessions.get(destino).sendMessage(new TextMessage(texto));

	}

	// public static void main(String[] args) throws JSONException {
	//
	// String teste = "{\"destino\" : \"jose\",\"texto\" : \"Ola\"}";
	//
	// JSONObject mensagem = new JSONObject(teste);
	//
	// System.out.println(mensagem);
	//
	// }

}