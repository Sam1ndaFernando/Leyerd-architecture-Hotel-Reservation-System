package lk.RoyalGatesHotels.dao.custom;

import javafx.collections.ObservableList;
import lk.RoyalGatesHotels.dao.CrudDao;
import lk.RoyalGatesHotels.entity.HallReservation;
import lk.RoyalGatesHotels.entity.Maintenance;

import java.sql.SQLException;

public interface HallReservationDao extends CrudDao<HallReservation,String> {
    String getLastHallReservationId() throws SQLException, ClassNotFoundException;
    String getReservationDetails(String reservationId) throws SQLException, ClassNotFoundException;
    boolean updateRoomMaintenance(Maintenance maintenance) throws SQLException, ClassNotFoundException;
    ObservableList<String> loadReservationIds() throws SQLException, ClassNotFoundException;

}
