package lk.RoyalGatesHotels.Dto;

public class MealOdersDto implements SuperDto {
    private String OrderId;
    private String CustomerId;
    private String Date;
    private int Qty;
    private String PkgId;

    public MealOdersDto(String orderId, String customerId, String date, int qty, String pkgId) {
        OrderId = orderId;
        CustomerId = customerId;
        Date = date;
        Qty = qty;
        PkgId = pkgId;
    }

    public MealOdersDto() {
    }

    public String getOrderId() {
        return OrderId;
    }

    public void setOrderId(String orderId) {
        OrderId = orderId;
    }

    public String getCustomerId() {
        return CustomerId;
    }

    public void setCustomerId(String customerId) {
        CustomerId = customerId;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public int getQty() {
        return Qty;
    }

    public void setQty(int qty) {
        Qty = qty;
    }

    public String getPkgId() {
        return PkgId;
    }

    public void setPkgId(String pkgId) {
        PkgId = pkgId;
    }

    @Override
    public String toString() {
        return "MealOders{" +
                "OrderId='" + OrderId + '\'' +
                ", CustomerId='" + CustomerId + '\'' +
                ", Date='" + Date + '\'' +
                ", Qty='" + Qty + '\'' +
                ", PkgId='" + PkgId + '\'' +
                '}';
    }
}
