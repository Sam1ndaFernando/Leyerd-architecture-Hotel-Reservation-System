package service.custom;

import javafx.collections.ObservableList;
import lk.RoyalGatesHotels.Dto.RoomDto;
import lk.RoyalGatesHotels.entity.Room;
import service.SuperService;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface RoomsService extends SuperService<RoomDto> {
    String getLastAdminRoomId() throws SQLException, ClassNotFoundException;
    ResultSet getRoomData() throws SQLException, ClassNotFoundException;
    boolean updateRoomAvailability(String room_number, String unavailable) throws SQLException, ClassNotFoundException;
    ObservableList<String> loadRoomNumbers() throws SQLException, ClassNotFoundException;
    int getRoomCount() throws SQLException, ClassNotFoundException;
    int getBookedRoomsCount() throws SQLException, ClassNotFoundException;
    int getAvailableRoomsCount() throws SQLException, ClassNotFoundException;
    double getRoomPrice(String roomNo) throws SQLException, ClassNotFoundException;
}
