package lk.RoyalGatesHotels.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lk.RoyalGatesHotels.db.DBConnection;
import lk.RoyalGatesHotels.entity.RoomReservation;
import lk.RoyalGatesHotels.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RoomReservationModel {
    public static String getLastRoomReservationId() throws SQLException, ClassNotFoundException {

        ResultSet result = CrudUtil.execute("SELECT reservation_id FROM room_reservation_detail ORDER BY reservation_id DESC LIMIT 1");
        if(result.next()){
            return result.getString("reservation_id");
        }
        return null;
    }

    public static boolean addReservation(RoomReservation roomReservation) throws SQLException, ClassNotFoundException {

        try{

            DBConnection.getInstance().getConnection().setAutoCommit(false);
            boolean isAdd = CrudUtil.execute("INSERT INTO room_reservation_detail VALUES (?,?,?,?,?)",
                    roomReservation.getRoom_number(),
                    roomReservation.getCustomer_id(),
                    roomReservation.getReservation_id(),
                    roomReservation.getCheck_out_date(),
                    roomReservation.getCheck_in_date()
            );

            if (isAdd){
                boolean isSetAvailability = RoomsModel.updateRoomAvailability(roomReservation.getRoom_number(),"Unavailable");

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

    public static ObservableList<String> loadReservationIds() throws SQLException, ClassNotFoundException {
        ResultSet resultSet = CrudUtil.execute("SELECT reservation_id FROM room_reservation_detail");

        ObservableList<String> options = FXCollections.observableArrayList();
        while (resultSet.next()){
            options.add(resultSet.getString("reservation_id"));
        }
        return options;
    }

    public static String getReservationDetails(String reservationId) throws SQLException, ClassNotFoundException {
        ResultSet resultSet = CrudUtil.execute("SELECT room_number FROM room_reservation_detail WHERE reservation_id=?", reservationId);
        if(resultSet.next()){
            return resultSet.getString("room_number");
        }
        return null;
    }
}
