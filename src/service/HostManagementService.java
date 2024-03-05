package service;

import entity.User;

import java.util.List;

public class HostManagementService {
    private final List<User> userList;

    public HostManagementService(List<User> userList) {
        this.userList = userList;
    }

    public void registerHost(String username, String password) {
        User newUser = new Host(username, password);
        userList.add(newUser);
        System.out.println("Đăng ký Host thành công");
    }

    public boolean changePassword(String currentPassword, String newPassword) {
        HostLoginService hostLoginService = null;
        Host currentHost = hostLoginService.getCurrentHost();

        if (currentHost.getPassword().equals(currentPassword)) {
            currentHost.setPassword(newPassword);
            System.out.println("Mật khẩu đã được thay đổi.");
            return true;
        } else {
            System.out.println("Mật khẩu hiện tại không chính xác.");
            return false;
        }
    }

}
