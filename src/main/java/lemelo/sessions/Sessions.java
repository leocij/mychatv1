package lemelo.sessions;

import java.util.ArrayList;
import java.util.List;

public class Sessions {

	private int total;

	private List<Session> sessions = new ArrayList<Session>();

	public void addSession(Session session) {
		sessions.add(session);
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public List<Session> getSessions() {
		return sessions;
	}

}