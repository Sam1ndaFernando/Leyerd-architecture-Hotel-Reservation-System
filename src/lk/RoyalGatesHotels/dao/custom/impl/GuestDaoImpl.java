package lk.RoyalGatesHotels.dao.custom.impl;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lk.RoyalGatesHotels.dao.custom.GuestDao;
import lk.RoyalGatesHotels.entity.Guest;
import lk.RoyalGatesHotels.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;


public class GuestDaoImpl implements GuestDao {

    @Override
    public boolean save(Guest guest) throws SQLException, ClassNotFoundException {
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

    @Override
    public boolean update(Guest guest) throws SQLException, ClassNotFoundException {
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

    @Override
    public boolean delete(Guest entity) {
        return false;
    }

    @Override
    public Guest search(Object... args) throws SQLException, ClassNotFoundException {
        ResultSet result = CrudUtil.execute("SELECT * FROM customer WHERE customer_id=?",args[0]);
        Guest guest = new Guest(
                result.getString("customer_id"),
                result.getString("customer_name"),
                result.getString("date"),
                result.getString("nic"),
                result.getString("address"),
                result.getString("mobile"),
                result.getString("email"),
                result.getString("province")
        );
        return guest;
    }

    @Override
    public String getLastGuestId() throws SQLException, ClassNotFoundException {
        ResultSet result = CrudUtil.execute("SELECT employee_id FROM employee ORDER BY employee_id DESC LIMIT 1");
        if(result.next()){
            return result.getString("employee_id");
        }
        return null;
    }

    @Override
    public ObservableList<String> loadGuestIds() throws SQLException, ClassNotFoundException {
        ResultSet resultSet = CrudUtil.execute("SELECT customer_id FROM customer");

        ObservableList<String> options = FXCollections.observableArrayList();
        while (resultSet.next()){
            options.add(resultSet.getString("customer_id"));
        }
        return options;
    }
}
