package service.custom;

import javafx.collections.ObservableList;
import lk.RoyalGatesHotels.Dto.UsersDto;
import lk.RoyalGatesHotels.entity.Users;
import service.SuperService;

import java.sql.SQLException;

public interface UsersService extends SuperService<UsersDto> {
    ObservableList<String> loadEmployeeIds() throws SQLException, ClassNotFoundException;

}
