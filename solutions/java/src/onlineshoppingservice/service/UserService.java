package onlineshoppingservice.service;

import onlineshoppingservice.User;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class UserService {
    public Map<String, User> users;
    private static UserService service;

    private UserService() {
        users = new ConcurrentHashMap<>();
    }

    public static synchronized UserService  getInstance() {
        if (service == null) {
            service = new UserService();
        }
        return service;
    }

    public User registerUser(String name, String email, String password) {
        User user = new User(name, email, password);
        users.put(user.getId(), user);
        return user;
    }

    public User getUser(String userId) {
        return users.get(userId);
    }

}
