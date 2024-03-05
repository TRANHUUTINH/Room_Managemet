package service;

import data.UserData;
import entity.User;

import java.util.ArrayList;
import java.util.List;

public class HostLoginService {
    private static List<User> userList = new ArrayList<>();
    private static Host currentHost;

    public static Host getCurrentHost() {
        return currentHost;
    }

    public static void setCurrentHost(Host currentHost) {
        HostLoginService.currentHost = currentHost;
    }

    static {
        userList.addAll(UserData.ReadUserFromFile());
        UserData.saveAllUsers(userList);
    }

    public static void registerHost(String username, String password) {
        User newUser = new User(username, password,"HOST");
        userList.add(newUser);
        UserData.saveAllUsers(userList);
        System.out.println("Đăng ký CHU NHA thành công");
    }


    public static boolean loginHost(String username, String password) {
        for (User user : userList) {
            if (user.getUserType().equals("HOST") && user.getUsername().equals(username) && user.getPassword().equals(password)) {
                System.out.println("Đăng nhập thành công");
              currentHost = HostLoginService.getCurrentHost();
                return true;
            }
        }
        System.out.println("Đăng nhập không thành công");
        return false;
    }

    public void logoutHost() {
       HostLoginService.setCurrentHost(null);
        System.out.println("Đăng xuất thành công");
    }


}
