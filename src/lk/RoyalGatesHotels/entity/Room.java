package lk.RoyalGatesHotels.entity;

public class Room implements SuperEntity{
    private String roomNumber;
    private String roomType;
    private String status;
    private double price;

    public Room(String roomNumber, String roomType, String status, double price) {
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.status = status;
        this.price = price;
    }

    public Room(){
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    @Override
    public String toString() {
        return "Room{" +
                "roomNumber='" + roomNumber + '\'' +
                ", roomType='" + roomType + '\'' +
                ", status='" + status + '\'' +
                ", price='" + price + '\'' +
                '}';
    }
}
