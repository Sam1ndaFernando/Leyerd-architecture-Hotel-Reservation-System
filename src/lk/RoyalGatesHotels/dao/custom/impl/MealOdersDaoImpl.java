package lk.RoyalGatesHotels.dao.custom.impl;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lk.RoyalGatesHotels.dao.custom.MealOdersDao;
import lk.RoyalGatesHotels.entity.MealOders;
import lk.RoyalGatesHotels.entity.MealPackges;
import lk.RoyalGatesHotels.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MealOdersDaoImpl implements MealOdersDao {
    public boolean save(MealOders mealOders) throws SQLException, ClassNotFoundException {
        boolean isAdd = CrudUtil.execute("INSERT INTO meal_oders VALUES (?,?,?,?,?)",
                mealOders.getOrderId(),
                mealOders.getCustomerId(),
                mealOders.getDate(),
                mealOders.getQty(),
                mealOders.getPkgId()
        );
        return isAdd;
    }

    @Override
    public boolean update(MealOders mealOders) throws SQLException, ClassNotFoundException {
        boolean isUpdate = CrudUtil.execute("UPDATE meal_oders SET customer_id=?, date=?, qty=?, pkg_id=? WHERE oder_id=?",
                mealOders.getCustomerId(),
                mealOders.getDate(),
                mealOders.getQty(),
                mealOders.getPkgId(),
                mealOders.getOrderId()
        );
        return isUpdate;
    }

    @Override
    public boolean delete(MealOders entity) {
        return false;
    }

    @Override
    public MealOders search(Object... args) throws SQLException, ClassNotFoundException {
        ResultSet result = CrudUtil.execute("SELECT * FROM meal_oders WHERE oder_id=?",args[0]);
        MealOders mealOders = new MealOders(
                result.getString("oder_id"),
                result.getString("customer_id"),
                result.getString("date"),
                result.getInt("qty"),
                result.getString("pkg_idpkg_id")
                );
        return mealOders;
    }

    @Override
    public String getLastMealOrdersId() throws SQLException, ClassNotFoundException {
        ResultSet result = CrudUtil.execute("SELECT oder_id FROM meal_oders ORDER BY oder_id DESC LIMIT 1");
        if(result.next()){
            return result.getString("oder_id");
        }
        return null;
    }

    @Override
    public ObservableList<String> loadOrderIds() throws SQLException, ClassNotFoundException {
        ResultSet resultSet = CrudUtil.execute("SELECT oder_id FROM meal_oders");

        ObservableList<String> options = FXCollections.observableArrayList();
        while (resultSet.next()){
            options.add(resultSet.getString("oder_id"));
        }
        return options;
    }
}
