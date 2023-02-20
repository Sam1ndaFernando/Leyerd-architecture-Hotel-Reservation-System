package lk.RoyalGatesHotels.dao.custom;

import javafx.collections.ObservableList;
import lk.RoyalGatesHotels.dao.CrudDao;
import lk.RoyalGatesHotels.entity.MealOders;

import java.sql.SQLException;

public interface MealOdersDao extends CrudDao <MealOders,String> {
    String getLastMealOrdersId() throws SQLException, ClassNotFoundException;
    ObservableList<String> loadOrderIds() throws SQLException, ClassNotFoundException;
}
