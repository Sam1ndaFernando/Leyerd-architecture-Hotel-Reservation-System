package lk.RoyalGatesHotels.dao.custom.impl;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lk.RoyalGatesHotels.dao.custom.HallReservationDao;
import lk.RoyalGatesHotels.db.DBConnection;
import lk.RoyalGatesHotels.entity.HallReservation;
import lk.RoyalGatesHotels.entity.Maintenance;
import lk.RoyalGatesHotels.model.HallsModel;
import lk.RoyalGatesHotels.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class HallReservationDaoImpl implements HallReservationDao {

    @Override
    public boolean save(HallReservation hallReservation) throws SQLException, ClassNotFoundException {
        boolean isAdd = CrudUtil.execute("INSERT INTO hall_reservation_detail VALUES (?,?,?,?,?)",
                hallReservation.getHall_number(),
                hallReservation.getCustomer_id(),
                hallReservation.getReservation_id(),
                hallReservation.getCheck_out_date(),
                hallReservation.getCheck_in_date()
        );
        return isAdd;
    }

    @Override
    public boolean update(HallReservation entity) {
        return false;
    }

    @Override
    public boolean delete(HallReservation entity) {
        return false;
    }

    @Override
    public HallReservation search(Object... args) {
        return null;
    }

    @Override
    public String getLastHallReservationId() throws SQLException, ClassNotFoundException {
        ResultSet result = CrudUtil.execute("SELECT reservation_id FROM hall_reservation_detail ORDER BY reservation_id DESC LIMIT 1");
        if(result.next()){
            return result.getString("reservation_id");
        }
        return null;
    }

    @Override
    public String getReservationDetails(String reservationId) throws SQLException, ClassNotFoundException {
        ResultSet resultSet = CrudUtil.execute("SELECT hall_number FROM hall_reservation_detail WHERE reservation_id=?", reservationId);
        if(resultSet.next()){
            return resultSet.getString("hall_number");
        }
        return null;
    }

    @Override
    public boolean updateRoomMaintenance(Maintenance maintenance) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public ObservableList<String> loadReservationIds() throws SQLException, ClassNotFoundException {
        ResultSet resultSet = CrudUtil.execute("SELECT reservation_id FROM hall_reservation_detail");

        ObservableList<String> options = FXCollections.observableArrayList();
        while (resultSet.next()){
            options.add(resultSet.getString("reservation_id"));
        }
        return options;
    }
}
