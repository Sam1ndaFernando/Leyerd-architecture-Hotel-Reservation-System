package service.custom.impl;

import javafx.collections.ObservableList;
import lk.RoyalGatesHotels.Dto.RoomDto;
import lk.RoyalGatesHotels.dao.DaoFactory;
import lk.RoyalGatesHotels.dao.DaoTypes;
import lk.RoyalGatesHotels.dao.custom.RoomReservationDao;
import lk.RoyalGatesHotels.dao.custom.RoomsDao;
import lk.RoyalGatesHotels.db.DBConnection;
import lk.RoyalGatesHotels.entity.Room;
import service.custom.RoomsService;
import service.util.Converter;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class RoomsServiceImpl implements RoomsService {

    private final RoomsDao roomsDao;
    private final Converter converter;
    private final Connection connection;

    public RoomsServiceImpl() {
        connection = DBConnection.getInstance().getConnection();
        roomsDao = DaoFactory.getInstance().getDao(connection, DaoTypes.ROOM_DAO);
        converter = new Converter();
    }

    @Override
    public boolean add(RoomDto entity) {
        return false;
    }

    @Override
    public boolean update(RoomDto entity) {
        return false;
    }

    @Override
    public boolean delete(Object... args) {
        return false;
    }

    @Override
    public RoomDto searchById(Object... args) {
        return null;
    }

    @Override
    public List<RoomDto> getAll() {
        return null;
    }

    @Override
    public boolean existByPk(Object... args) {
        return false;
    }

    @Override
    public String getLastAdminRoomId() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public ResultSet getRoomData() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean updateRoomAvailability(String room_number, String unavailable) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public ObservableList<String> loadRoomNumbers() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public int getRoomCount() throws SQLException, ClassNotFoundException {
        return 0;
    }

    @Override
    public int getBookedRoomsCount() throws SQLException, ClassNotFoundException {
        return 0;
    }

    @Override
    public int getAvailableRoomsCount() throws SQLException, ClassNotFoundException {
        return 0;
    }

    @Override
    public double getRoomPrice(String roomNo) throws SQLException, ClassNotFoundException {
        return 0;
    }
}
