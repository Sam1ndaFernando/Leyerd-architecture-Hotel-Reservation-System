package lk.RoyalGatesHotels.dao.custom;

import javafx.collections.ObservableList;
import lk.RoyalGatesHotels.dao.CrudDao;
import lk.RoyalGatesHotels.entity.Room;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface RoomsDao extends CrudDao<Room,String> {
    String getLastAdminRoomId() throws SQLException, ClassNotFoundException;
    List<Room> getRoomData() throws SQLException, ClassNotFoundException;
    boolean updateRoomAvailability(String room_number, String unavailable) throws SQLException, ClassNotFoundException;
    ObservableList<String> loadRoomNumbers() throws SQLException, ClassNotFoundException;
    int getRoomCount() throws SQLException, ClassNotFoundException;
    int getBookedRoomsCount() throws SQLException, ClassNotFoundException;
    int getAvailableRoomsCount() throws SQLException, ClassNotFoundException;
    double getRoomPrice(String roomNo) throws SQLException, ClassNotFoundException;
}
