package service.custom.impl;

import lk.RoyalGatesHotels.Dto.PaymentDto;
import lk.RoyalGatesHotels.dao.DaoFactory;
import lk.RoyalGatesHotels.dao.DaoTypes;
import lk.RoyalGatesHotels.dao.custom.MealPackgesDao;
import lk.RoyalGatesHotels.dao.custom.PaymentDao;
import lk.RoyalGatesHotels.db.DBConnection;
import lk.RoyalGatesHotels.entity.Payment;
import service.custom.PaymentService;
import service.util.Converter;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class PaymentServiceImpl implements PaymentService {

    private final PaymentDao paymentDao;
    private final Converter converter;
    private final Connection connection;

    public PaymentServiceImpl() {
        connection = DBConnection.getInstance().getConnection();
        paymentDao = DaoFactory.getInstance().getDao(connection, DaoTypes.PAYMENT_DAO);
        converter = new Converter();
    }

    @Override
    public boolean add(PaymentDto entity) {
        return false;
    }

    @Override
    public boolean update(PaymentDto entity) {
        return false;
    }

    @Override
    public boolean delete(Object... args) {
        return false;
    }

    @Override
    public PaymentDto searchById(Object... args) {
        return null;
    }

    @Override
    public List<PaymentDto> getAll() {
        return null;
    }

    @Override
    public boolean existByPk(Object... args) {
        return false;
    }

    @Override
    public String getLastPaymentId() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public double getTodayEarnings(String date) throws SQLException, ClassNotFoundException {
        return 0;
    }
}
