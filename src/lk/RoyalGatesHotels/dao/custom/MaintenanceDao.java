package lk.RoyalGatesHotels.dao.custom;

import lk.RoyalGatesHotels.dao.CrudDao;
import lk.RoyalGatesHotels.entity.Maintenance;

import java.sql.SQLException;

public interface MaintenanceDao extends CrudDao<Maintenance,String> {
    String getLastRoomMaintenanceId() throws SQLException, ClassNotFoundException;
    String getLastHallMaintenanceId() throws SQLException, ClassNotFoundException;
    boolean addRoomMaintenance(Maintenance maintenance) throws SQLException, ClassNotFoundException;
    boolean addHallMaintenance(Maintenance maintenance) throws SQLException, ClassNotFoundException;
    boolean updateRoomMaintenance(Maintenance maintenance) throws SQLException, ClassNotFoundException;

    boolean updateHallMaintenance(Maintenance maintenance) throws SQLException, ClassNotFoundException;
}
