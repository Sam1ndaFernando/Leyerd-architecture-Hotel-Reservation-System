package lk.RoyalGatesHotels.model;

import lk.RoyalGatesHotels.db.DBConnection;
import lk.RoyalGatesHotels.entity.Maintenance;
import lk.RoyalGatesHotels.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MaintenanceModel {
    public static String getLastRoomMaintenanceId() throws SQLException, ClassNotFoundException {
        ResultSet result = CrudUtil.execute("SELECT maintenance_id FROM room_maintenance ORDER BY maintenance_id DESC LIMIT 1");
        if(result.next()){
            return result.getString("maintenance_id");
        }
        return null;
    }

    public static String getLastHallMaintenanceId() throws SQLException, ClassNotFoundException {
        ResultSet result = CrudUtil.execute("SELECT maintenance_id FROM hall_maintenance ORDER BY maintenance_id DESC LIMIT 1");
        if(result.next()){
            return result.getString("maintenance_id");
        }
        return null;
    }

    public static boolean addRoomMaintenance(Maintenance maintenance) throws SQLException, ClassNotFoundException {

        try{
            DBConnection.getInstance().getConnection().setAutoCommit(false);
            boolean isAdd = CrudUtil.execute("INSERT INTO room_maintenance VALUES(?,?,?,?,?)",
                    maintenance.getMaintenanceId(),
                    maintenance.getNumber(),
                    maintenance.getDate(),
                    maintenance.getStartTime(),
                    maintenance.getEndTime()
            );
            if (isAdd){
                boolean isSetAvailability = RoomsModel.updateRoomAvailability(maintenance.getNumber(),"Unavailable");

                if(isSetAvailability){
                    DBConnection.getInstance().getConnection().commit();
                    return true;
                }
            }
            DBConnection.getInstance().getConnection().rollback();
            return false;
        }finally{
            DBConnection.getInstance().getConnection().setAutoCommit(true);
        }


    }

    public static boolean addHallMaintenance(Maintenance maintenance) throws SQLException, ClassNotFoundException {
        boolean isAdd = CrudUtil.execute("INSERT INTO hall_maintenance VALUES(?,?,?,?,?)",
                maintenance.getMaintenanceId(),
                maintenance.getNumber(),
                maintenance.getDate(),
                maintenance.getStartTime(),
                maintenance.getEndTime()
        );
        return isAdd;
    }

    public static boolean updateRoomMaintenance(Maintenance maintenance) throws SQLException, ClassNotFoundException {

        try{
            DBConnection.getInstance().getConnection().setAutoCommit(false);
            boolean isUpdate = CrudUtil.execute("UPDATE room_maintenance SET room_number=?, date=?, start_time=?, end_time=? WHERE maintenance_id=?",
                    maintenance.getNumber(),
                    maintenance.getDate(),
                    maintenance.getStartTime(),
                    maintenance.getEndTime(),
                    maintenance.getMaintenanceId()
            );
            if (isUpdate){
                boolean isSetAvailability = RoomsModel.updateRoomAvailability(maintenance.getNumber(),"Unavailable");

                if(isSetAvailability){
                    DBConnection.getInstance().getConnection().commit();
                    return true;
                }
            }
            DBConnection.getInstance().getConnection().rollback();
            return false;
        }finally{
            DBConnection.getInstance().getConnection().setAutoCommit(true);
        }


    }

    public static boolean updateHallMaintenance(Maintenance maintenance) throws SQLException, ClassNotFoundException {
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
