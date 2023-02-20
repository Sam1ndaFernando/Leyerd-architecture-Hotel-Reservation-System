package lk.RoyalGatesHotels.dao.custom.impl;

import lk.RoyalGatesHotels.dao.custom.ComplainDao;
import lk.RoyalGatesHotels.entity.Complain;
import lk.RoyalGatesHotels.entity.SuperEntity;
import lk.RoyalGatesHotels.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ComplainDaoImpl implements ComplainDao {

    @Override
    public boolean save(Complain complain) throws SQLException, ClassNotFoundException {
        boolean isAdd = CrudUtil.execute("INSERT INTO complain VALUES (?,?,?,?,?,?,?)",
                complain.getRoomNumber(),
                complain.getHallNumber(),
                complain.getComplainId(),
                complain.getCustomerId(),
                complain.getDate(),
                complain.getTime(),
                complain.getDescription()
        );
        return isAdd;
    }

    @Override
    public boolean update(Complain complain) throws SQLException, ClassNotFoundException {
        boolean isUpdate = CrudUtil.execute("UPDATE complain SET room_number=?, hall_number=?, customer_id=?, date=?, time=?, description=? WHERE complaint_id=?",
                complain.getRoomNumber(),
                complain.getHallNumber(),
                complain.getCustomerId(),
                complain.getDate(),
                complain.getTime(),
                complain.getDescription(),
                complain.getComplainId()

        );
        return isUpdate;
    }

    @Override
    public boolean delete(Complain complain) {
        return false;
    }

    @Override
    public Complain search(Object... args) throws SQLException, ClassNotFoundException {
        ResultSet result = CrudUtil.execute("SELECT * FROM complain WHERE complaint_id=?",args[0]);
        Complain complain = new Complain(
                result.getString("room_number"),
                result.getString("hall_number"),
                result.getString("complaint_id"),
                result.getString("customer_id"),
                result.getString("date"),
                result.getString("time"),
                result.getString("description")
        );
        return complain;
    }

    @Override
    public String getLastComplainId() throws SQLException, ClassNotFoundException {
        ResultSet result = CrudUtil.execute("SELECT complaint_id FROM complain ORDER BY complaint_id DESC LIMIT 1");
        if(result.next()){
            return result.getString("complaint_id");
        }
        return null;
    }

    @Override
    public int getComplaintCount() throws SQLException, ClassNotFoundException {
        ResultSet result = CrudUtil.execute("SELECT COUNT(complaint_id) AS complainCount FROM complain");
        return result.getInt("complainCount");
    }
}
