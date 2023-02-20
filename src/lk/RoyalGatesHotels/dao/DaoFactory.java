package lk.RoyalGatesHotels.dao;


import lk.RoyalGatesHotels.dao.custom.impl.*;

import java.sql.Connection;

public class DaoFactory {
    public static DaoFactory daoFactory;

    public static DaoFactory getInstance() {
        return daoFactory == null ? daoFactory = new DaoFactory() : daoFactory;
    }

    public <T extends SuperDao> T getDao(Connection connection, DaoTypes type) throws RuntimeException {
        switch (type) {
            case COMPLAIN_DAO:
                return (T) new ComplainDaoImpl();
            case EMPLOYEE_DAO:
                return (T) new EmployeeDaoImpl();
            case GUEST_DAO:
                return (T) new GuestDaoImpl();
            case HALL_DAO:
                return (T) new HallsDaoImpl(connection);
            case HALL_RESERVATION_DAO:
                return (T) new HallReservationDaoImpl();
            case MAINTENACE_DAO:
                return (T) new MaintenanceDaoImpl();
            case MEAL_ORDERS_DAO:
                return (T) new MealOdersDaoImpl();
            case MEAL_PACKAGE_DAO:
                return (T) new MealPackgesDaoImpl();
            case PAYMENT_DAO:
                return (T) new PaymentDaoImpl();
            case ROOM_DAO:
                return (T) new RoomsDaoImpl();
            case ROOM_RESERVATION_DAO:
                return (T) new RoomReservationDaoImpl();
            case USERS_DAO:
                return (T) new UsersDaoImpl();
            default:
                throw new RuntimeException("Dao Type does not exist!");
        }
    }
}
