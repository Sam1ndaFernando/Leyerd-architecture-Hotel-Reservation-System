package service.custom.impl;

import javafx.collections.ObservableList;
import lk.RoyalGatesHotels.Dto.MealPackgesDto;
import lk.RoyalGatesHotels.dao.DaoFactory;
import lk.RoyalGatesHotels.dao.DaoTypes;
import lk.RoyalGatesHotels.dao.custom.MealOdersDao;
import lk.RoyalGatesHotels.dao.custom.MealPackgesDao;
import lk.RoyalGatesHotels.db.DBConnection;
import lk.RoyalGatesHotels.entity.MealPackges;
import service.custom.MealPackgesService;
import service.util.Converter;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class MealPackgesServiceImpl implements MealPackgesService {

    private final MealPackgesDao mealPackgesDao;
    private final Converter converter;
    private final Connection connection;

    public MealPackgesServiceImpl() {
        connection = DBConnection.getInstance().getConnection();
        mealPackgesDao = DaoFactory.getInstance().getDao(connection, DaoTypes.MEAL_PACKAGE_DAO);
        converter = new Converter();
    }

    @Override
    public boolean add(MealPackgesDto entity) {
        return false;
    }

    @Override
    public boolean update(MealPackgesDto entity) {
        return false;
    }

    @Override
    public boolean delete(Object... args) {
        return false;
    }

    @Override
    public MealPackgesDto searchById(Object... args) {
        return null;
    }

    @Override
    public List<MealPackgesDto> getAll() {
        return null;
    }

    @Override
    public boolean existByPk(Object... args) {
        return false;
    }

    @Override
    public boolean save(MealPackges entity) {
        return false;
    }

    @Override
    public String getLastMealPkgId() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public ResultSet getMealPackgeData() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public ObservableList<String> loadPackageIds() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public double getPackagePrice(String pkg_id) throws SQLException, ClassNotFoundException {
        return 0;
    }

    @Override
    public double searchMealPackgeData(String pkg_id) throws SQLException, ClassNotFoundException {
        return 0;
    }
}
