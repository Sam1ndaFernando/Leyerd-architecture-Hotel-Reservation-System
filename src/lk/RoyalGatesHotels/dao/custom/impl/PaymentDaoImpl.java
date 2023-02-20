package lk.RoyalGatesHotels.dao.custom.impl;

import lk.RoyalGatesHotels.dao.custom.PaymentDao;
import lk.RoyalGatesHotels.entity.Payment;
import lk.RoyalGatesHotels.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PaymentDaoImpl implements PaymentDao {

    public boolean save(Payment payment) throws SQLException, ClassNotFoundException {
        boolean isAdd = CrudUtil.execute("INSERT INTO payment VALUES (?,?,?,?,?,?,?,?)",
                payment.getPaymentId(),
                payment.getHallReservationId(),
                payment.getTime(),
                payment.getDate(),
                payment.getOrderId(),
                payment.getCustomerId(),
                payment.getAmount(),
                payment.getRoomReservationId()
        );
        return isAdd;
    }

    @Override
    public boolean update(Payment entity) {
        return false;
    }

    @Override
    public boolean delete(Payment entity) {
        return false;
    }

    @Override
    public Payment search(Object... args) {
        return null;
    }

    @Override
    public String getLastPaymentId() throws SQLException, ClassNotFoundException {
        ResultSet result = CrudUtil.execute("SELECT payment_id FROM payment ORDER BY payment_id DESC LIMIT 1");
        if(result.next()){
            return result.getString("payment_id");
        }
        return null;
    }

    @Override
    public double getTodayEarnings(String date) throws SQLException, ClassNotFoundException {
        ResultSet resultSet = CrudUtil.execute("SELECT amount FROM payment WHERE date=?",date);
        double amount=0;
        while (resultSet.next()){
            amount+=Double.parseDouble(resultSet.getString("amount"));
        }

        return amount;
    }
}
