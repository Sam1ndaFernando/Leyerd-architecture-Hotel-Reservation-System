package service.custom;

import lk.RoyalGatesHotels.Dto.PaymentDto;
import lk.RoyalGatesHotels.entity.Payment;
import service.SuperService;

import java.sql.SQLException;

public interface PaymentService extends SuperService <PaymentDto> {
    String getLastPaymentId() throws SQLException, ClassNotFoundException;
    double getTodayEarnings(String date) throws SQLException, ClassNotFoundException;
}
