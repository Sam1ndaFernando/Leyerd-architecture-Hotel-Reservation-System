package service.custom;

import javafx.collections.ObservableList;
import lk.RoyalGatesHotels.Dto.GuestDto;
import lk.RoyalGatesHotels.entity.Guest;
import service.SuperService;

import java.sql.SQLException;

public interface GuestService extends SuperService<GuestDto> {
    String getLastGuestId() throws SQLException, ClassNotFoundException;
    ObservableList<String> loadGuestIds() throws SQLException, ClassNotFoundException;
}
