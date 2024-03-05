package service;

import data.UserData;
import entity.User;

import java.util.ArrayList;
import java.util.List;

public class CustomerLoginService {
    private static User curentCustomer;

    public static User getCurentCustomer() {
        return curentCustomer;
    }

    public static void setCurentCustomer(User curentCustomer) {
        CustomerLoginService.curentCustomer = curentCustomer;
    }

    private static  List<User> userList = new ArrayList<>();
    static {
        userList.addAll(UserData.ReadUserFromFile());
        UserData.saveAllUsers(userList);
    }
    public static void registerCustomer(String username, String password){
        User newUser = new User(username, password,"CUSTOMER");
        userList.add(newUser);
        UserData.saveAllUsers(userList);
        System.out.println("Đăng ký khách hàng thành công");
    }

    public static boolean loginCustomer(String username, String password) {
        for (User user : userList) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)&& user.getUserType().equals("CUSTOMER") ) {
                curentCustomer = user;
                System.out.println("Đăng nhập thành công");
                return true;
            }
        }
        System.out.println("Đăng nhập không thành công");
        return false;
    }

    public void logoutCustomer() {
        System.out.println("Đăng xuất thành công");
    }
}
