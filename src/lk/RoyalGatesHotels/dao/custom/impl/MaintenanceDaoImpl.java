package lk.RoyalGatesHotels.dao.custom.impl;

import lk.RoyalGatesHotels.dao.custom.MaintenanceDao;
import lk.RoyalGatesHotels.db.DBConnection;
import lk.RoyalGatesHotels.entity.Maintenance;
import lk.RoyalGatesHotels.model.RoomsModel;
import lk.RoyalGatesHotels.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MaintenanceDaoImpl implements MaintenanceDao {

    @Override
    public boolean save(Maintenance entity) {
        return false;
    }

    @Override
    public boolean update(Maintenance entity) {
        return false;
    }

    @Override
    public boolean delete(Maintenance entity) {
        return false;
    }

    @Override
    public Maintenance search(Object... args) {
        return null;
    }

    @Override
    public String getLastRoomMaintenanceId() throws SQLException, ClassNotFoundException {
        ResultSet result = CrudUtil.execute("SELECT maintenance_id FROM room_maintenance ORDER BY maintenance_id DESC LIMIT 1");
        if(result.next()){
            return result.getString("maintenance_id");
        }
        return null;
    }

    @Override
    public String getLastHallMaintenanceId() throws SQLException, ClassNotFoundException {
        ResultSet result = CrudUtil.execute("SELECT maintenance_id FROM hall_maintenance ORDER BY maintenance_id DESC LIMIT 1");
        if(result.next()){
            return result.getString("maintenance_id");
        }
        return null;
    }

    @Override
    public boolean addRoomMaintenance(Maintenance maintenance) throws SQLException, ClassNotFoundException {
        boolean isAdd = CrudUtil.execute("INSERT INTO room_maintenance VALUES(?,?,?,?,?)",
                maintenance.getMaintenanceId(),
                maintenance.getNumber(),
                maintenance.getDate(),
                maintenance.getStartTime(),
                maintenance.getEndTime()
        );
        return isAdd;
    }

    @Override
    public boolean addHallMaintenance(Maintenance maintenance) throws SQLException, ClassNotFoundException {
        boolean isAdd = CrudUtil.execute("INSERT INTO hall_maintenance VALUES(?,?,?,?,?)",
                maintenance.getMaintenanceId(),
                maintenance.getNumber(),
                maintenance.getDate(),
                maintenance.getStartTime(),
                maintenance.getEndTime()
        );
        return isAdd;
    }

    @Override
    public boolean updateRoomMaintenance(Maintenance maintenance) throws SQLException, ClassNotFoundException {
        boolean isUpdate = CrudUtil.execute("UPDATE room_maintenance SET room_number=?, date=?, start_time=?, end_time=? WHERE maintenance_id=?",
                maintenance.getNumber(),
                maintenance.getDate(),
                maintenance.getStartTime(),
                maintenance.getEndTime(),
                maintenance.getMaintenanceId()
        );
        return isUpdate;
    }

    @Override
    public boolean updateHallMaintenance(Maintenance maintenance) throws SQLException, ClassNotFoundException {
        boolean isUpdate = CrudUtil.execute("UPDATE hall_maintenance SET hall_number=?, date=?, start_time=?, end_time=? WHERE maintenance_id=?",
                maintenance.getNumber(),
                maintenance.getDate(),
                maintenance.getStartTime(),
                maintenance.getEndTime(),
                maintenance.getMaintenanceId()
        );
        return isUpdate;

    }
}

