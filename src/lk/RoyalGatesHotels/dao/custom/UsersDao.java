package lk.RoyalGatesHotels.dao.custom;

import javafx.collections.ObservableList;
import lk.RoyalGatesHotels.dao.CrudDao;
import lk.RoyalGatesHotels.entity.Users;

import java.sql.SQLException;

public interface UsersDao extends CrudDao<Users,String> {
    ObservableList<String> loadEmployeeIds() throws SQLException, ClassNotFoundException;

}
