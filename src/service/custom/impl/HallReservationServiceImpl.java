package service.custom.impl;

import javafx.collections.ObservableList;
import lk.RoyalGatesHotels.Dto.HallReservationDto;
import lk.RoyalGatesHotels.dao.DaoFactory;
import lk.RoyalGatesHotels.dao.DaoTypes;
import lk.RoyalGatesHotels.dao.custom.GuestDao;
import lk.RoyalGatesHotels.dao.custom.HallReservationDao;
import lk.RoyalGatesHotels.dao.custom.HallsDao;
import lk.RoyalGatesHotels.db.DBConnection;
import lk.RoyalGatesHotels.entity.HallReservation;
import lk.RoyalGatesHotels.entity.Maintenance;
import service.custom.HallReservationService;
import service.util.Converter;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class HallReservationServiceImpl implements HallReservationService {

    private final HallReservationDao hallReservationDao;
    private  final HallsDao hallsDao;
    private final Converter converter;
    private final Connection connection;

    public HallReservationServiceImpl() {
        connection = DBConnection.getInstance().getConnection();
        hallsDao=DaoFactory.getInstance().getDao(connection,DaoTypes.HALL_DAO);
        hallReservationDao = DaoFactory.getInstance().getDao(connection, DaoTypes.HALL_RESERVATION_DAO);
        converter = new Converter();
    }


    @Override
    public boolean add(HallReservationDto hallReservationDto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean update(HallReservationDto entity) {
        return false;
    }

    @Override
    public boolean delete(Object... args) {
        return false;
    }

    @Override
    public HallReservationDto searchById(Object... args) {
        return null;
    }

    @Override
    public List<HallReservationDto> getAll() {
        return null;
    }

    @Override
    public boolean existByPk(Object... args) {
        return false;
    }

    @Override
    public boolean save(HallReservation entity) {
        return false;
    }

    @Override
    public ObservableList<String> loadReservationIds() throws SQLException, ClassNotFoundException {
        return hallReservationDao.loadReservationIds();
    }

    @Override
    public String getLastHallReservationId() throws SQLException, ClassNotFoundException {
        return hallReservationDao.getLastHallReservationId();
    }

    @Override
    public String getReservationDetails(String reservationId) throws SQLException, ClassNotFoundException {
        return hallReservationDao.getReservationDetails(reservationId);
    }

    @Override
    public boolean updateRoomMaintenance(Maintenance maintenance) throws SQLException, ClassNotFoundException {
        return false;
    }
}
