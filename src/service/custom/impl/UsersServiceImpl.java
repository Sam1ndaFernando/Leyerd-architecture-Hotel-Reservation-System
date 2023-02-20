package service.custom.impl;

import javafx.collections.ObservableList;
import lk.RoyalGatesHotels.Dto.UsersDto;
import lk.RoyalGatesHotels.dao.DaoFactory;
import lk.RoyalGatesHotels.dao.DaoTypes;
import lk.RoyalGatesHotels.dao.custom.RoomsDao;
import lk.RoyalGatesHotels.dao.custom.UsersDao;
import lk.RoyalGatesHotels.db.DBConnection;
import lk.RoyalGatesHotels.entity.Users;
import service.custom.UsersService;
import service.util.Converter;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class UsersServiceImpl implements UsersService {

    private final UsersDao usersDao;
    private final Converter converter;
    private final Connection connection;

    public UsersServiceImpl() {
        connection = DBConnection.getInstance().getConnection();
        usersDao = DaoFactory.getInstance().getDao(connection, DaoTypes.USERS_DAO);
        converter = new Converter();
    }

    @Override
    public boolean add(UsersDto entity) {
        return false;
    }

    @Override
    public boolean update(UsersDto entity) {
        return false;
    }

    @Override
    public boolean delete(Object... args) {
        return false;
    }

    @Override
    public UsersDto searchById(Object... args) {
        return null;
    }

    @Override
    public List<UsersDto> getAll() {
        return null;
    }

    @Override
    public boolean existByPk(Object... args) {
        return false;
    }

    @Override
    public ObservableList<String> loadEmployeeIds() throws SQLException, ClassNotFoundException {
        return null;
    }
}
