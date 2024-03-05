package main;

import entity.Room;
import entity.User;
import service.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<User> userList = new ArrayList<>();
        User user1 = new User("Tên người dùng 1");
        userList.add(user1);
        RoomSearchService roomSearchService = new RoomSearchService();
        RoomBookingService roomBookingService = new RoomBookingService();
        RoomManagementService roomManagementService = new RoomManagementService();
        ChatService chatService = new ChatService();

        boolean isRunning = true;
        while (isRunning) {
            System.out.println("===== Quản lý tìm nhà trọ =====");
            System.out.println("1. Đăng ký");
            System.out.println("2. Đăng nhập");
            System.out.println("3. Kết thúc");
            System.out.println("Vui lòng chọn:  ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("1. Đăng ký khách hàng");
                    System.out.println("2. Đăng ký chủ nhà");
                    System.out.println("Vui lòng chọn:   ");
                    int registerChoice = scanner.nextInt();
                    scanner.nextLine();

                    if (registerChoice == 1) {
                        System.out.println("Nhập tên đăng nhập KH: ");
                        String customerUsername = scanner.nextLine();
                        System.out.println("Nhập mật khẩu cua ban: ");
                        String customerPassword = scanner.nextLine();
                        CustomerLoginService.registerCustomer(customerUsername, customerPassword);
                    } else if (registerChoice == 2) {
                        System.out.println("Nhập tên đăng nhập CN: ");
                        String hostUsername = scanner.nextLine();
                        System.out.println("Nhập mật khẩu CN: ");
                        String hostPassword = scanner.nextLine();
                        HostLoginService.registerHost(hostUsername, hostPassword);
                    } else {
                        System.out.println("Lựa chọn không hợp lệ");
                    }
                    break;

                case 2:
                    System.out.println("1. Đăng nhập khách hàng");
                    System.out.println("2. Đăng nhập chủ nhà");
                    System.out.print("Vui lòng chọn:    ");
                    int loginChoice = scanner.nextInt();
                    scanner.nextLine();

                    if (loginChoice == 1) {
                        System.out.print("Nhập tên đăng nhập: ");
                        String customerUsername = scanner.nextLine();
                        System.out.print("Nhập mật khẩu: ");
                        String customerPassword = scanner.nextLine();
                        boolean isCustomerLoggedIn = CustomerLoginService.loginCustomer(customerUsername, customerPassword);

                        if (isCustomerLoggedIn) {
                            boolean isCustomerMenuRunning = true;
                            while (isCustomerMenuRunning) {
                                System.out.println("1. Tìm phòng theo khu vực");
                                System.out.println("2. Đăng ký phòng");
                                System.out.println("3. Trở lại");
                                System.out.print(" chọn: ");
                                int customerMenuChoice = scanner.nextInt();
                                scanner.nextLine();

                                switch (customerMenuChoice) {
                                    case 1:
                                        System.out.print("Nhập khu vực: ");
                                        String area = scanner.nextLine();
                                        RoomManagementService.searchRoomsByDistrict(area);
                                        break;

                                    case 2:
                                        System.out.print("Nhập ID phòng muốn đăng ký: ");
                                        int roomId = scanner.nextInt();
                                        scanner.nextLine();
                                        System.out.println("Nhap booking id");
                                        int id = scanner.nextInt();
                                        scanner.nextLine();
                                        String userCus = CustomerLoginService.getCurentCustomer().getUsername();
                                        RoomManagementService.booking(id,userCus,"CHUNHA",roomId);
                                        break;

                                    case 3:
                                        isCustomerMenuRunning = false;
                                        break;

                                    default:
                                        System.out.println("Lựa chọn không hợp lệ     .");
                                        break;
                                }
                            }
                        } else {
                            System.out.println("Đăng nhập không thành công.");
                        }
                    } else if (loginChoice == 2) {
                        System.out.print("Nhập tên đăng nhập: ");
                        String hostUsername = scanner.nextLine();
                        System.out.print("Nhập mật khẩu: ");
                        String hostPassword = scanner.nextLine();
                        boolean isHostLoggedIn = HostLoginService.loginHost(hostUsername, hostPassword);

                        if (isHostLoggedIn) {
                            boolean isHostMenuRunning = true;
                            while (isHostMenuRunning) {
                                System.out.println("1. Quản lý phòng");
                                System.out.println("2. Quản lý danh sach");
                                System.out.println("3. Trở lại");
                                System.out.print("Vui lòng chọn: ");
                                int hostMenuChoice = scanner.nextInt();
                                scanner.nextLine();

                                switch (hostMenuChoice) {
                                    case 1:
                                        System.out.println("1. Thêm phòng");
                                        System.out.println("2. Sửa phòng");
                                        System.out.println("3. Xóa phòng");
                                        System.out.print("Vui lòng chọn: ");
                                        int roomManagementChoice = scanner.nextInt();
                                        scanner.nextLine();

                                        if (roomManagementChoice == 1) {
                                            System.out.print("Nhập thông tin phòng: ");
                                            System.out.println("Nhap id");
                                            int id = scanner.nextInt();
                                            scanner.nextLine();
                                            System.out.println("Quan");
                                            String quan = scanner.nextLine();
                                            System.out.println("Duong");
                                            String duong = scanner.nextLine();
                                            System.out.println("Loai phong");
                                            String type = scanner.nextLine();
                                            System.out.println("Gia");
                                            double gia = scanner.nextDouble();
                                            scanner.nextLine();
                                            String bookby = scanner.nextLine();
                                            Room newRoom = new Room(id,quan,duong,type,gia,bookby);
                                            roomManagementService.addRoom(newRoom);
                                        } else if (roomManagementChoice == 2) {
                                            System.out.print("Nhập ID phòng muốn sửa: ");
                                            int roomId = scanner.nextInt();
                                            scanner.nextLine();
                                            System.out.print("Nhập thông tin phòng mới: ");
                                            String roomInfo = scanner.nextLine();
                                            roomManagementService.updateRoom(roomId, roomInfo);
                                        } else if (roomManagementChoice == 3) {
                                            System.out.print("Nhập ID phòng muốn xóa: ");
                                            int roomId = scanner.nextInt();
                                            scanner.nextLine();
                                            roomManagementService.deleteRoom(roomId);
                                        } else {
                                            System.out.println("Lựa chọn không hợp lệ .");
                                        }
                                        break;

                                    case 2:
                                        RoomManagementService.viewBooking();
                                        RoomManagementService.message();

                                        System.out.println("Hay nhan tin qua so dien thoai");
                                        break;

                                    case 3:
                                        isHostMenuRunning = false;
                                        break;

                                    default:
                                        System.out.println("Lựa chọn không hợp lệ.");
                                        break;
                                }
                            }
                        } else {
                            System.out.println("Đăng nhập không thành công.");
                        }
                    } else {
                        System.out.println("Lựa chọn không hợp lệ.");
                    }
                    break;

                case 3:
                    System.out.println("Đăng ký");
                    break;

                default:
                    System.out.println("Lựa chọn không hợp lệ.");
                    break;
            }
        }

        System.out.println("Chương trình kết thúc.");
    }
}

