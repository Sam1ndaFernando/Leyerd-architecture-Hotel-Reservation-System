package lk.RoyalGatesHotels.dao.custom.impl;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lk.RoyalGatesHotels.dao.custom.RoomReservationDao;
import lk.RoyalGatesHotels.db.DBConnection;
import lk.RoyalGatesHotels.entity.RoomReservation;
import lk.RoyalGatesHotels.model.RoomsModel;
import lk.RoyalGatesHotels.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RoomReservationDaoImpl implements RoomReservationDao {
    @Override
    public boolean save (RoomReservation roomReservation) throws SQLException, ClassNotFoundException {
        boolean isAdd = CrudUtil.execute("INSERT INTO room_reservation_detail VALUES (?,?,?,?,?)",
                roomReservation.getRoom_number(),
                roomReservation.getCustomer_id(),
                roomReservation.getReservation_id(),
                roomReservation.getCheck_out_date(),
                roomReservation.getCheck_in_date()
        );
        return isAdd;
    }

    @Override
    public boolean update(RoomReservation entity) {
        return false;
    }

    @Override
    public boolean delete(RoomReservation entity) {
        return false;
    }

    @Override
    public RoomReservation search(Object... args) {
        return null;
    }

    @Override
    public String getLastRoomReservationId() throws SQLException, ClassNotFoundException {

        ResultSet result = CrudUtil.execute("SELECT reservation_id FROM room_reservation_detail ORDER BY reservation_id DESC LIMIT 1");
        if(result.next()){
            return result.getString("reservation_id");
        }
        return null;
    }

    @Override
    public ObservableList<String> loadReservationIds() throws SQLException, ClassNotFoundException {
        ResultSet resultSet = CrudUtil.execute("SELECT reservation_id FROM room_reservation_detail");

        ObservableList<String> options = FXCollections.observableArrayList();
        while (resultSet.next()){
            options.add(resultSet.getString("reservation_id"));
        }
        return options;
    }

    @Override
    public String getReservationDetails(String reservationId) throws SQLException, ClassNotFoundException {
        ResultSet resultSet = CrudUtil.execute("SELECT room_number FROM room_reservation_detail WHERE reservation_id=?", reservationId);
        if(resultSet.next()){
            return resultSet.getString("room_number");
        }
        return null;
    }
}
