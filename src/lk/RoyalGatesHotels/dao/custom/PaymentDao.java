package lk.RoyalGatesHotels.dao.custom;

import lk.RoyalGatesHotels.dao.CrudDao;
import lk.RoyalGatesHotels.entity.Payment;

import java.sql.SQLException;

public interface PaymentDao extends CrudDao<Payment,String> {
    String getLastPaymentId() throws SQLException, ClassNotFoundException;
    double getTodayEarnings(String date) throws SQLException, ClassNotFoundException;
}
