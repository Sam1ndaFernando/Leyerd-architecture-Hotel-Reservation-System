package service.custom.impl;

import javafx.collections.ObservableList;
import lk.RoyalGatesHotels.Dto.MealOdersDto;
import lk.RoyalGatesHotels.dao.DaoFactory;
import lk.RoyalGatesHotels.dao.DaoTypes;
import lk.RoyalGatesHotels.dao.custom.HallsDao;
import lk.RoyalGatesHotels.dao.custom.MealOdersDao;
import lk.RoyalGatesHotels.db.DBConnection;
import lk.RoyalGatesHotels.entity.MealOders;
import service.custom.MealOdersService;
import service.util.Converter;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class MealOdersServiceImpl implements MealOdersService {

    private final MealOdersDao mealOdersDao;
    private final Converter converter;
    private final Connection connection;

    public MealOdersServiceImpl() {
        connection = DBConnection.getInstance().getConnection();
        mealOdersDao = DaoFactory.getInstance().getDao(connection, DaoTypes.MEAL_ORDERS_DAO);
        converter = new Converter();
    }

    @Override
    public boolean add(MealOdersDto entity) {
        return false;
    }

    @Override
    public boolean update(MealOdersDto entity) {
        return false;
    }

    @Override
    public boolean delete(Object... args) {
        return false;
    }

    @Override
    public MealOdersDto searchById(Object... args) {
        return null;
    }

    @Override
    public List<MealOdersDto> getAll() {
        return null;
    }

    @Override
    public boolean existByPk(Object... args) {
        return false;
    }

    @Override
    public String getLastMealOrdersId() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public ObservableList<String> loadOrderIds() throws SQLException, ClassNotFoundException {
        return null;
    }
}
