package service.custom;

import javafx.collections.ObservableList;
import lk.RoyalGatesHotels.Dto.MealPackgesDto;
import lk.RoyalGatesHotels.entity.MealPackges;
import service.SuperService;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface MealPackgesService extends SuperService<MealPackgesDto> {
    boolean save(MealPackges entity);

    String getLastMealPkgId() throws SQLException, ClassNotFoundException;
    ResultSet getMealPackgeData() throws SQLException, ClassNotFoundException;
    ObservableList<String> loadPackageIds() throws SQLException, ClassNotFoundException;
    double getPackagePrice(String pkg_id) throws SQLException, ClassNotFoundException;
    double searchMealPackgeData(String pkg_id) throws SQLException, ClassNotFoundException;
}
