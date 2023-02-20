package lk.RoyalGatesHotels.dao.custom;

import javafx.collections.ObservableList;
import lk.RoyalGatesHotels.dao.CrudDao;
import lk.RoyalGatesHotels.entity.Employee;
import lk.RoyalGatesHotels.entity.Guest;

import java.sql.SQLException;

public interface GuestDao extends CrudDao <Guest,String> {
    String getLastGuestId() throws SQLException, ClassNotFoundException;
    ObservableList<String> loadGuestIds() throws SQLException, ClassNotFoundException;

}
