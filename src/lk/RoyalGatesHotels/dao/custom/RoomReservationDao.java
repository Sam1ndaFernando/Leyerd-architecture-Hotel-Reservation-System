package lk.RoyalGatesHotels.dao.custom;

import javafx.collections.ObservableList;
import lk.RoyalGatesHotels.dao.CrudDao;
import lk.RoyalGatesHotels.entity.RoomReservation;

import java.sql.SQLException;

public interface RoomReservationDao extends CrudDao <RoomReservation,String> {
    String getLastRoomReservationId() throws SQLException, ClassNotFoundException;
    ObservableList<String> loadReservationIds() throws SQLException, ClassNotFoundException;
    String getReservationDetails(String reservationId) throws SQLException, ClassNotFoundException;

}
