package service.custom;

import lk.RoyalGatesHotels.Dto.MaintenanceDto;
import lk.RoyalGatesHotels.entity.Maintenance;
import service.SuperService;

import java.sql.SQLException;

public interface MaintenanceService extends SuperService<MaintenanceDto> {
    String getLastRoomMaintenanceId() throws SQLException, ClassNotFoundException;
    String getLastHallMaintenanceId() throws SQLException, ClassNotFoundException;
    boolean addRoomMaintenance(Maintenance maintenance) throws SQLException, ClassNotFoundException;
    boolean addHallMaintenance(Maintenance maintenance) throws SQLException, ClassNotFoundException;
    boolean updateRoomMaintenance(Maintenance maintenance) throws SQLException, ClassNotFoundException;

    boolean updateHallMaintenance(Maintenance maintenance) throws SQLException, ClassNotFoundException;
}
