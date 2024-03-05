package entity;

public class Room {
    private int id;
    private String district;
    private String street;
    private String type;
    private double price;
    private String bookedBy;

    public Room(int id, String district, String street, String type, double price, String bookedBy) {
        this.id = id;
        this.district = district;
        this.street = street;
        this.type = type;
        this.price = price;
        this.bookedBy = bookedBy;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getBookedBy() {
        return bookedBy;
    }

    public void setBookedBy(String bookedBy) {
        this.bookedBy = bookedBy;
    }

    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", district='" + district + '\'' +
                ", street='" + street + '\'' +
                ", type='" + type + '\'' +
                ", price=" + price +
                ", bookedBy='" + bookedBy + '\'' +
                '}';
    }

    public void setInfo(String roomInfo) {
        String[] infoArray = roomInfo.split(",");
        if (infoArray.length == 4) {
            String newStreet = infoArray[0].trim();
            String newDistrict = infoArray[1].trim();
            String newType = infoArray[2].trim();
            double newPrice = Double.parseDouble(infoArray[3].trim());
            setStreet(newStreet);
            setDistrict(newDistrict);
            setType(newType);
            setPrice(newPrice);
    }
}
}
