package lk.RoyalGatesHotels.dao.custom.impl;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lk.RoyalGatesHotels.dao.custom.HallsDao;
import lk.RoyalGatesHotels.entity.Hall;
import lk.RoyalGatesHotels.util.CrudUtil;
import org.apache.hadoop.ipc.Server;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HallsDaoImpl implements HallsDao {
    Connection connection;

    public HallsDaoImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public boolean save(Hall hall) throws SQLException, ClassNotFoundException {
        boolean isAdd = CrudUtil.execute("INSERT INTO hall VALUES (?,?,?,?)",
                hall.getHallType(),
                hall.getHallNumber(),
                hall.getStatus(),
                hall.getPrice()
        );
        return isAdd;
    }

    @Override
    public boolean update(Hall hall) throws SQLException, ClassNotFoundException {
        boolean isUpdate = CrudUtil.execute("UPDATE hall SET hall_type=?, status=?, price=? WHERE hall_number=?",
                hall.getHallType(),
                hall.getStatus(),
                hall.getPrice(),
                hall.getHallNumber()
        );
        return isUpdate;
    }

    @Override
    public boolean delete(Hall entity) {
        return false;
    }

    @Override
    public Hall search(Object... args) throws SQLException, ClassNotFoundException {
        ResultSet result = CrudUtil.execute("SELECT * FROM hall WHERE hall_number=?",args[0]);
        Hall hall = new Hall(
                result.getString("hall_type"),
                result.getString("hall_number"),
                result.getString("status"),
                result.getDouble("price")
        );
        return hall;
    }

    @Override
    public String getLastAdminHallId() throws SQLException, ClassNotFoundException {
            ResultSet result = CrudUtil.execute("SELECT hall_number FROM hall ORDER BY hall_number DESC LIMIT 1");
            if(result.next()){
                return result.getString("hall_number");
            }
            return null;
        }

    @Override
    public List<Hall> getHallData() throws SQLException, ClassNotFoundException {
        ResultSet result = CrudUtil.execute("SELECT * FROM hall");
        List<Hall> list = new ArrayList<>();
        while (result.next()){
            Hall hall = new Hall(
                    result.getString("hall_type"),
                    result.getString("hall_number"),
                    result.getString("status"),
                    result.getDouble("price")

            );
            list.add(hall);

        }

        return list;
    }

    @Override
    public boolean updateHallAvailability(String hall_number) throws SQLException, ClassNotFoundException {
        boolean isUpdate = CrudUtil.execute("UPDATE hall SET status=? WHERE hall_number=?","Unavailable", hall_number);
        return isUpdate;
    }

    @Override
    public ObservableList<String> loadHallNumbers() throws SQLException, ClassNotFoundException {
        ResultSet resultSet = CrudUtil.execute("SELECT hall_number FROM hall");

        ObservableList<String> options = FXCollections.observableArrayList();
        while (resultSet.next()){
            options.add(resultSet.getString("hall_number"));
        }
        return options;
    }

    @Override
    public int getBookedHallsCount() throws SQLException, ClassNotFoundException {
        ResultSet result = CrudUtil.execute("SELECT hall_number FROM hall WHERE status=?","Unavailable");
        int count=0;
        while (result.next()){
            count++;
        }
        return count;
    }

    @Override
    public int getAvailableHallsCount() throws SQLException, ClassNotFoundException {
        ResultSet result = CrudUtil.execute("SELECT hall_number FROM hall WHERE status=?","Available");
        int count=0;
        while (result.next()){
            count++;
        }
        return count;
    }

    @Override
    public double getHallPrice(String hallNo) throws SQLException, ClassNotFoundException {
        ResultSet resultSet = CrudUtil.execute("SELECT * FROM hall WHERE hall_number=?", hallNo);
        if(resultSet.next()){
            return Double.parseDouble(resultSet.getString("price"));

        }
        return 0;
    }
}
