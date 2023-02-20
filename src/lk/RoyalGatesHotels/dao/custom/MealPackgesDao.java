package lk.RoyalGatesHotels.dao.custom;

import javafx.collections.ObservableList;
import lk.RoyalGatesHotels.dao.CrudDao;
import lk.RoyalGatesHotels.entity.MealPackges;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface MealPackgesDao extends CrudDao <MealPackges,String> {
    String getLastMealPkgId() throws SQLException, ClassNotFoundException;
    List<MealPackges> getMealPackgeData() throws SQLException, ClassNotFoundException;
    ObservableList<String> loadPackageIds() throws SQLException, ClassNotFoundException;
    double getPackagePrice(String pkg_id) throws SQLException, ClassNotFoundException;
    double searchMealPackgeData(String pkg_id) throws SQLException, ClassNotFoundException;
}
