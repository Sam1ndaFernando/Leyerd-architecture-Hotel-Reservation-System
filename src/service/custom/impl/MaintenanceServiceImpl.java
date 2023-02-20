package service.custom.impl;

import lk.RoyalGatesHotels.Dto.MaintenanceDto;
import lk.RoyalGatesHotels.dao.DaoFactory;
import lk.RoyalGatesHotels.dao.DaoTypes;
import lk.RoyalGatesHotels.dao.custom.HallsDao;
import lk.RoyalGatesHotels.dao.custom.MaintenanceDao;
import lk.RoyalGatesHotels.db.DBConnection;
import lk.RoyalGatesHotels.entity.Maintenance;
import service.custom.MaintenanceService;
import service.util.Converter;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class MaintenanceServiceImpl implements MaintenanceService {

    private final MaintenanceDao maintenanceDao;
    private final Converter converter;
    private final Connection connection;

    public MaintenanceServiceImpl() {
        connection = DBConnection.getInstance().getConnection();
        maintenanceDao = DaoFactory.getInstance().getDao(connection, DaoTypes.MAINTENACE_DAO);
        converter = new Converter();
    }

    @Override
    public boolean add(MaintenanceDto entity) {
        return false;
    }

    @Override
    public boolean update(MaintenanceDto entity) {
        return false;
    }

    @Override
    public boolean delete(Object... args) {
        return false;
    }

    @Override
    public MaintenanceDto searchById(Object... args) {
        return null;
    }

    @Override
    public List<MaintenanceDto> getAll() {
        return null;
    }

    @Override
    public boolean existByPk(Object... args) {
        return false;
    }

    @Override
    public String getLastRoomMaintenanceId() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public String getLastHallMaintenanceId() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean addRoomMaintenance(Maintenance maintenance) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean addHallMaintenance(Maintenance maintenance) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean updateRoomMaintenance(Maintenance maintenance) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean updateHallMaintenance(Maintenance maintenance) throws SQLException, ClassNotFoundException {
        return false;
    }
}
