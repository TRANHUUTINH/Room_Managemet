package service;

import entity.User;

public class Host extends User {

    public Host(int id, String fullName, String email, String phoneNumber, String username) {
        super(id, fullName, email, phoneNumber, username);
    }

    public Host(String username, String password) {
        super(username, password);
    }

    public Host(String userType) {
        super(userType);
    }

    public Host(String username, String password, String userType) {
        super(username, password, userType);
    }
}
