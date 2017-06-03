package lemelo.controller;

import java.util.Set;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lemelo.handler.WebsocketHandler;
import lemelo.sessions.Session;
import lemelo.sessions.Sessions;

@RestController
@RequestMapping(value = "sessions")
public class SessionsController {

	@RequestMapping(value = "/index", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
	public Sessions listaVideos(@RequestParam(required = false) String nome) {

		Sessions sessions = new Sessions();

		sessions.setTotal(WebsocketHandler.sessions.size());

		Set<String> sessionsIds = WebsocketHandler.sessions.keySet();

		for (String id : sessionsIds) {

			Session s = new Session();
			s.setId(id);

			sessions.addSession(s);

		}

		return sessions;

	}

}