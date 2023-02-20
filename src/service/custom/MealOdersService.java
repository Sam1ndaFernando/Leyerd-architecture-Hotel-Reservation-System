package service.custom;

import javafx.collections.ObservableList;
import lk.RoyalGatesHotels.Dto.MealOdersDto;
import lk.RoyalGatesHotels.entity.MealOders;
import service.SuperService;

import java.sql.SQLException;

public interface MealOdersService extends SuperService<MealOdersDto> {
    String getLastMealOrdersId() throws SQLException, ClassNotFoundException;
    ObservableList<String> loadOrderIds() throws SQLException, ClassNotFoundException;
}
