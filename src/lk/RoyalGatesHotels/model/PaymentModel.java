package lk.RoyalGatesHotels.model;

import lk.RoyalGatesHotels.entity.Payment;
import lk.RoyalGatesHotels.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PaymentModel {
        public static String getLastPaymentId() throws SQLException, ClassNotFoundException {
            ResultSet result = CrudUtil.execute("SELECT payment_id FROM payment ORDER BY payment_id DESC LIMIT 1");
            if(result.next()){
                return result.getString("payment_id");
            }
            return null;
        }

    public static boolean addPayment(Payment payment) throws SQLException, ClassNotFoundException {
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

    public static double getTodayEarnings(String date) throws SQLException, ClassNotFoundException {
            ResultSet resultSet = CrudUtil.execute("SELECT amount FROM payment WHERE date=?",date);
            double amount=0;
            while (resultSet.next()){
                amount+=Double.parseDouble(resultSet.getString("amount"));
            }

            return amount;
    }


}

