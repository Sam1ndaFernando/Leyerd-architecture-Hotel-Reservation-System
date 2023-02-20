package service.custom;

import javafx.collections.ObservableList;
import lk.RoyalGatesHotels.Dto.HallReservationDto;
import lk.RoyalGatesHotels.entity.HallReservation;
import lk.RoyalGatesHotels.entity.Maintenance;
import service.SuperService;

import java.sql.SQLException;

public interface HallReservationService extends SuperService<HallReservationDto> {
    boolean save(HallReservation entity);
    ObservableList<String> loadReservationIds() throws SQLException, ClassNotFoundException;
    String getLastHallReservationId() throws SQLException, ClassNotFoundException;
    String getReservationDetails(String reservationId) throws SQLException, ClassNotFoundException;
    boolean updateRoomMaintenance(Maintenance maintenance) throws SQLException, ClassNotFoundException;

}
