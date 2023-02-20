package service.custom;

import javafx.collections.ObservableList;
import lk.RoyalGatesHotels.Dto.HallDto;
import lk.RoyalGatesHotels.entity.Hall;
import service.SuperService;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface HallsService extends SuperService<HallDto> {
    String getLastAdminHallId() throws SQLException, ClassNotFoundException;
    List<HallDto> getHallData() throws SQLException, ClassNotFoundException;
    boolean updateHallAvailability(String hall_number) throws SQLException, ClassNotFoundException;
    ObservableList<String> loadHallNumbers() throws SQLException, ClassNotFoundException;
    int getBookedHallsCount() throws SQLException, ClassNotFoundException;
    int getAvailableHallsCount() throws SQLException, ClassNotFoundException;
    double getHallPrice(String hallNo) throws SQLException, ClassNotFoundException;

}
