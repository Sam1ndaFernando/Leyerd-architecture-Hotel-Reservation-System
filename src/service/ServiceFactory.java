package service;


import service.custom.impl.*;

public class ServiceFactory {
    private static ServiceFactory serviceFactory;

    private ServiceFactory() {
    }

    public static ServiceFactory getInstance() {
        return serviceFactory == null ? serviceFactory = new ServiceFactory() : serviceFactory;
    }

    public <T extends SuperService> T getService(ServiceTypes type) {
        switch (type) {
            case COMPLAIN_SERVICE:
                return (T) new ComplainServiceImpl();

            case EMPLOYEE_SERVICE:
                return (T) new EmployeeServiceImpl();

            case GUEST_SERVICE:
                return (T) new GuestServiceImpl();

            case HALL_RESERVATION_SERVICE:
                return (T) new HallReservationServiceImpl();

            case HALL_SERVICE:
                return (T) new HallsServiceImpl();

            case MAINTENACE_SERVICE:
                return (T) new MaintenanceServiceImpl();

            case MEAL_ORDERS_SERVICE:
                return (T) new MealOdersServiceImpl();

            case MEAL_PACKAGE_SERVICE:
                return (T) new MealPackgesServiceImpl();

            case PAYMENT_SERVICE:
                return (T) new PaymentServiceImpl();

            case ROOM_RESERVATION_SERVICE:
                return (T) new RoomReservationServiceImpl();

            case ROOM_SERVICE:
                return (T) new RoomsServiceImpl();

            case USERS_SERVICE:
                return (T) new UsersServiceImpl();

            default:
                return null;
        }
    }
}
