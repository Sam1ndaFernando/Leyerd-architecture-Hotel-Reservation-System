package lk.RoyalGatesHotels.dao.custom;

import javafx.collections.ObservableList;
import lk.RoyalGatesHotels.dao.CrudDao;
import lk.RoyalGatesHotels.entity.Hall;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface HallsDao extends CrudDao<Hall,String> {
    String getLastAdminHallId() throws SQLException, ClassNotFoundException;
    List<Hall> getHallData() throws SQLException, ClassNotFoundException;
    boolean updateHallAvailability(String hall_number) throws SQLException, ClassNotFoundException;
    ObservableList<String> loadHallNumbers() throws SQLException, ClassNotFoundException;
    int getBookedHallsCount() throws SQLException, ClassNotFoundException;
    int getAvailableHallsCount() throws SQLException, ClassNotFoundException;
    double getHallPrice(String hallNo) throws SQLException, ClassNotFoundException;


}
