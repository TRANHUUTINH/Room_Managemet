package entity;

public class Booking {
    private int bookingId;
    private String userNameCustomer;
    private String userNameHost;
    private int roomId;

    public Booking(int bookingId, String userNameCustomer, String userNameHost, int roomId) {
        this.bookingId = bookingId;
        this.userNameCustomer = userNameCustomer;
        this.userNameHost = userNameHost;
        this.roomId = roomId;
    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public String getUserNameCustomer() {
        return userNameCustomer;
    }

    public void setUserNameCustomer(String userNameCustomer) {
        this.userNameCustomer = userNameCustomer;
    }

    public String getUserNameHost() {
        return userNameHost;
    }

    public void setUserNameHost(String userNameHost) {
        this.userNameHost = userNameHost;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "bookingId=" + bookingId +
                ", userNameCustomer='" + userNameCustomer + '\'' +
                ", userNameHost='" + userNameHost + '\'' +
                ", roomId=" + roomId +
                '}';
    }
}
