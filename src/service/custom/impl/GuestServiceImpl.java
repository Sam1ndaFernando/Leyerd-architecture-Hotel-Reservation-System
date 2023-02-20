package service.custom.impl;

import javafx.collections.ObservableList;
import lk.RoyalGatesHotels.Dto.GuestDto;
import lk.RoyalGatesHotels.dao.DaoFactory;
import lk.RoyalGatesHotels.dao.DaoTypes;
import lk.RoyalGatesHotels.dao.custom.ComplainDao;
import lk.RoyalGatesHotels.dao.custom.GuestDao;
import lk.RoyalGatesHotels.db.DBConnection;
import lk.RoyalGatesHotels.entity.Guest;
import service.custom.GuestService;
import service.util.Converter;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;


public class GuestServiceImpl implements GuestService {

    private final GuestDao guestDao;
    private final Converter converter;
    private final Connection connection;

    public GuestServiceImpl() {
        connection = DBConnection.getInstance().getConnection();
        guestDao = DaoFactory.getInstance().getDao(connection, DaoTypes.GUEST_DAO);
        converter = new Converter();
    }

    @Override
    public boolean add(GuestDto guestDto) throws SQLException, ClassNotFoundException {
        return guestDao.save(converter.toGuest(guestDto));
    }

    @Override
    public boolean update(GuestDto guestDto) throws SQLException, ClassNotFoundException {
        return guestDao.update(converter.toGuest(guestDto));
    }

    @Override
    public boolean delete(Object... args) {
        return false;
    }

    @Override
    public GuestDto searchById(Object... args) throws SQLException, ClassNotFoundException {
        return converter.toGuestDto(guestDao.search(args));
    }

    @Override
    public List<GuestDto> getAll() {
        return null;
    }

    @Override
    public boolean existByPk(Object... args) {
        return false;
    }

    @Override
    public String getLastGuestId() throws SQLException, ClassNotFoundException {
        return guestDao.getLastGuestId();
    }

    @Override
    public ObservableList<String> loadGuestIds() throws SQLException, ClassNotFoundException {
        return guestDao.loadGuestIds();
    }
}
