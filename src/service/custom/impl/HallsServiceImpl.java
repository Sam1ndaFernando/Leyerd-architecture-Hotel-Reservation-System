package service.custom.impl;

import javafx.collections.ObservableList;
import lk.RoyalGatesHotels.Dto.HallDto;
import lk.RoyalGatesHotels.dao.DaoFactory;
import lk.RoyalGatesHotels.dao.DaoTypes;
import lk.RoyalGatesHotels.dao.custom.HallsDao;
import lk.RoyalGatesHotels.db.DBConnection;
import lk.RoyalGatesHotels.entity.Hall;
import service.custom.HallsService;
import service.util.Converter;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HallsServiceImpl implements HallsService {
    private final HallsDao hallsDao;
    private final Converter converter;
    private final Connection connection;

    public HallsServiceImpl() {
        connection = DBConnection.getInstance().getConnection();
        hallsDao = DaoFactory.getInstance().getDao(connection, DaoTypes.HALL_DAO);
        converter = new Converter();
    }

    @Override
    public boolean add(HallDto hallDto) throws SQLException, ClassNotFoundException {
       return hallsDao.save(converter.toHall(hallDto));
    }

    @Override
    public boolean update(HallDto hallDto) throws SQLException, ClassNotFoundException {
        return hallsDao.update(converter.toHall(hallDto));
    }

    @Override
    public boolean delete(Object... args) {
        return false;
    }

    @Override
    public HallDto searchById(Object... args) throws SQLException, ClassNotFoundException {
        return converter.toHallDto(hallsDao.search(args));
    }

    @Override
    public List<HallDto> getAll() {
        return null;
    }

    @Override
    public boolean existByPk(Object... args) {
        return false;
    }

    @Override
    public String getLastAdminHallId() throws SQLException, ClassNotFoundException {
        return hallsDao.getLastAdminHallId();
    }

    @Override
    public List<HallDto> getHallData() throws SQLException, ClassNotFoundException {
        List<Hall> hallList = hallsDao.getHallData();
        List<HallDto> list = new ArrayList<>();
        for (int i =0; i<list.size(); i++ ){
            Hall hall = hallList.get(i);
            HallDto hallDto = new HallDto(
                    hall.getHallType(),
                    hall.getHallNumber(),
                    hall.getStatus(),
                    hall.getPrice()
            );
            list.add(hallDto);
        }
        return list;
    }

    @Override
    public boolean updateHallAvailability(String hall_number) throws SQLException, ClassNotFoundException {
        return hallsDao.updateHallAvailability(hall_number);
    }

    @Override
    public ObservableList<String> loadHallNumbers() throws SQLException, ClassNotFoundException {
        return hallsDao.loadHallNumbers();
    }

    @Override
    public int getBookedHallsCount() throws SQLException, ClassNotFoundException {
        return hallsDao.getBookedHallsCount();
    }

    @Override
    public int getAvailableHallsCount() throws SQLException, ClassNotFoundException {
        return hallsDao.getAvailableHallsCount();
    }

    @Override
    public double getHallPrice(String hallNo) throws SQLException, ClassNotFoundException {
        return hallsDao.getHallPrice(hallNo);
    }
}
