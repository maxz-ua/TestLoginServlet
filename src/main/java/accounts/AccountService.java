package accounts;

import java.util.HashMap;
import java.util.Map;

public class AccountService {
    private final Map<String, Profile> loginToProfile;
    private final Map<String, Profile> sessionIdToProfile;

    public AccountService() {
        loginToProfile = new HashMap<>();
        sessionIdToProfile = new HashMap<>();
    }

    public void addNewUser(Profile userProfile) {
        loginToProfile.put(userProfile.getLogin(), userProfile);
    }

    public Profile getUserByLogin(String login) {
        return loginToProfile.get(login);
    }

    public Profile getUserBySessionId(String sessionId) {
        return sessionIdToProfile.get(sessionId);
    }

    public void addSession(String sessionId, Profile userProfile) {
        sessionIdToProfile.put(sessionId, userProfile);
    }

    public void deleteSession(String sessionId) {
        sessionIdToProfile.remove(sessionId);
    }
}
