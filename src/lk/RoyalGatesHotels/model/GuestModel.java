package lk.RoyalGatesHotels.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lk.RoyalGatesHotels.entity.Guest;
import lk.RoyalGatesHotels.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class GuestModel {
    public static String getLastGuestId() throws SQLException, ClassNotFoundException {
        ResultSet result = CrudUtil.execute("SELECT customer_id FROM customer ORDER BY customer_id DESC LIMIT 1");
        if(result.next()){
            return result.getString("customer_id");
        }
        return null;
    }

    public static boolean addGuest(Guest guest) throws SQLException, ClassNotFoundException {

        boolean isAdd = CrudUtil.execute("INSERT INTO customer VALUES (?,?,?,?,?,?,?,?)",
                guest.getCustomer_id(),
                guest.getCustomer_name(),
                guest.getDate(),
                guest.getNic(),
                guest.getAddress(),
                guest.getMobile(),
                guest.getEmail(),
                guest.getProvince()
                );
        return isAdd;

    }

    public static boolean updateGuest(Guest guest) throws SQLException, ClassNotFoundException {
        boolean isUpdate = CrudUtil.execute("UPDATE customer SET customer_name=?, date=?, nic=?, address=?, mobile=?, email=?, province=? WHERE customer_id=?",
                guest.getCustomer_name(),
                guest.getDate(),
                guest.getNic(),
                guest.getAddress(),
                guest.getMobile(),
                guest.getEmail(),
                guest.getProvince(),
                guest.getCustomer_id()

        );
        return isUpdate;
    }

    public static ResultSet searchGuest(String guestId) throws SQLException, ClassNotFoundException {
        ResultSet result = CrudUtil.execute("SELECT * FROM customer WHERE customer_id=?",guestId);
        return result;

    }

    public static ObservableList<String> loadGuestIds() throws SQLException, ClassNotFoundException {
        ResultSet resultSet = CrudUtil.execute("SELECT customer_id FROM customer");

        ObservableList<String> options = FXCollections.observableArrayList();
        while (resultSet.next()){
            options.add(resultSet.getString("customer_id"));
        }
        return options;
    }
}
