package service.custom.impl;

import javafx.collections.ObservableList;
import lk.RoyalGatesHotels.Dto.RoomReservationDto;
import lk.RoyalGatesHotels.dao.DaoFactory;
import lk.RoyalGatesHotels.dao.DaoTypes;
import lk.RoyalGatesHotels.dao.custom.PaymentDao;
import lk.RoyalGatesHotels.dao.custom.RoomReservationDao;
import lk.RoyalGatesHotels.db.DBConnection;
import lk.RoyalGatesHotels.entity.RoomReservation;
import service.custom.RoomReservationService;
import service.util.Converter;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class RoomReservationServiceImpl implements RoomReservationService {

    private final RoomReservationDao roomReservationDao;
    private final Converter converter;
    private final Connection connection;

    public RoomReservationServiceImpl() {
        connection = DBConnection.getInstance().getConnection();
        roomReservationDao = DaoFactory.getInstance().getDao(connection, DaoTypes.ROOM_RESERVATION_DAO);
        converter = new Converter();
    }

    @Override
    public boolean add(RoomReservationDto entity) {
        return false;
    }

    @Override
    public boolean update(RoomReservationDto entity) {
        return false;
    }

    @Override
    public boolean delete(Object... args) {
        return false;
    }

    @Override
    public RoomReservationDto searchById(Object... args) {
        return null;
    }

    @Override
    public List<RoomReservationDto> getAll() {
        return null;
    }

    @Override
    public boolean existByPk(Object... args) {
        return false;
    }

    @Override
    public String getLastRoomReservationId() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public ObservableList<String> loadReservationIds() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public String getReservationDetails(String reservationId) throws SQLException, ClassNotFoundException {
        return null;
    }
}
