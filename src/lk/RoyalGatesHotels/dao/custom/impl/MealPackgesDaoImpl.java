package lk.RoyalGatesHotels.dao.custom.impl;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lk.RoyalGatesHotels.dao.custom.MealPackgesDao;
import lk.RoyalGatesHotels.entity.MealPackges;
import lk.RoyalGatesHotels.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MealPackgesDaoImpl implements MealPackgesDao {

    @Override
    public boolean save(MealPackges mealPackges) throws SQLException, ClassNotFoundException {
        boolean isAdd = CrudUtil.execute("INSERT INTO meal_package VALUES (?,?,?,?,?)",
                mealPackges.getPkg_id(),
                mealPackges.getPrice(),
                mealPackges.getDescription(),
                mealPackges.getMeal_plan(),
                mealPackges.getType()
        );
        return isAdd;
    }

    @Override
    public boolean update(MealPackges mealPackges) throws SQLException, ClassNotFoundException {
        boolean isUpdate = CrudUtil.execute("UPDATE meal_package SET price=?, description=?, meal_plan=?, type=? WHERE pkg_id=?",
                mealPackges.getPrice(),
                mealPackges.getDescription(),
                mealPackges.getMeal_plan(),
                mealPackges.getType(),
                mealPackges.getPkg_id()
        );
        return isUpdate;
    }

    @Override
    public boolean delete(MealPackges entity) {
        return false;
    }

    @Override
    public MealPackges search(Object... args) throws SQLException, ClassNotFoundException {
        ResultSet result = CrudUtil.execute("SELECT * FROM meal_package WHERE pkg_id=?",args[0]);
        MealPackges mealPackges = new MealPackges(
                result.getString("pkg_id"),
                result.getDouble("price"),
                result.getString("description"),
                result.getString("meal_plan"),
                result.getString("type")
        );
        return mealPackges;
    }

    @Override
    public String getLastMealPkgId() throws SQLException, ClassNotFoundException {
        ResultSet result = CrudUtil.execute("SELECT pkg_id FROM meal_package ORDER BY pkg_id DESC LIMIT 1");
        if(result.next()){
            return result.getString("pkg_id");
        }
        return null;
    }

    @Override
    public List<MealPackges> getMealPackgeData() throws SQLException, ClassNotFoundException {
        ResultSet result = CrudUtil.execute("SELECT * FROM meal_package");
        List<MealPackges> list = new ArrayList<>();
        while (result.next()){
            MealPackges mealPackges = new MealPackges(
                    result.getString("pkg_id"),
                    result.getDouble("price"),
                    result.getString("description"),
                    result.getString("meal_plan"),
                    result.getString("type")
            );
            list.add(mealPackges);
        }
        return list;
    }


    @Override
    public ObservableList<String> loadPackageIds() throws SQLException, ClassNotFoundException {
        ResultSet resultSet = CrudUtil.execute("SELECT pkg_id FROM meal_package");

        ObservableList<String> options = FXCollections.observableArrayList();
        while (resultSet.next()){
            options.add(resultSet.getString("pkg_id"));
        }
        return options;
    }

    @Override
    public double getPackagePrice(String pkg_id) throws SQLException, ClassNotFoundException {
        ResultSet resultSet = CrudUtil.execute("SELECT * FROM meal_package WHERE pkg_id=?",pkg_id);
        if(resultSet.next()){
            return Double.parseDouble(resultSet.getString("price"));
        }
        return 0;
    }

    @Override
    public double searchMealPackgeData(String pkg_id) throws SQLException, ClassNotFoundException {
        ResultSet resultSet = CrudUtil.execute("SELECT * FROM meal_package WHERE pkg_id=?",pkg_id);
        if(resultSet.next()){
            return Double.parseDouble(resultSet.getString("price"));
        }
        return 0;
    }
}
