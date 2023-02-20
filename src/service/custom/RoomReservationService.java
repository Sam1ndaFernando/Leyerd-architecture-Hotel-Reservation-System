package service.custom;

import javafx.collections.ObservableList;
import lk.RoyalGatesHotels.Dto.RoomReservationDto;
import lk.RoyalGatesHotels.entity.RoomReservation;
import service.SuperService;

import java.sql.SQLException;

public interface RoomReservationService extends SuperService<RoomReservationDto> {
    String getLastRoomReservationId() throws SQLException, ClassNotFoundException;
    ObservableList<String> loadReservationIds() throws SQLException, ClassNotFoundException;
    String getReservationDetails(String reservationId) throws SQLException, ClassNotFoundException;

}
