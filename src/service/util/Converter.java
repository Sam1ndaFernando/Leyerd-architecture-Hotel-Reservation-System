package service.util;

import lk.RoyalGatesHotels.Dto.*;
import lk.RoyalGatesHotels.entity.*;

public class Converter {
    public ComplainDto toComplainDTO(Complain complain){
        return new ComplainDto(
                complain.getRoomNumber(),
                complain.getHallNumber(),
                complain.getComplainId(),
                complain.getCustomerId(),
                complain.getDate(),
                complain.getTime(),
                complain.getDescription()
        );
    }

    public Complain toComplain(ComplainDto complainDto){
        return new Complain(
                complainDto.getRoomNumber(),
                complainDto.getHallNumber(),
                complainDto.getComplainId(),
                complainDto.getCustomerId(),
                complainDto.getDate(),
                complainDto.getTime(),
                complainDto.getDescription()
        );
    }

    public EmployeeDto toEmployeeDto(Employee employee){
        return new EmployeeDto(
                employee.getEmployeeId(),
                employee.getName(),
                employee.getAddress(),
                employee.getJoin_date(),
                employee.getNic(),
                employee.getEmail(),
                employee.getMobile(),
                employee.getJobRole()
        );

    }

    public Employee toEmployee(EmployeeDto employeeDto){
        return new Employee(
                employeeDto.getEmployeeId(),
                employeeDto.getName(),
                employeeDto.getAddress(),
                employeeDto.getJoin_date(),
                employeeDto.getNic(),
                employeeDto.getEmail(),
                employeeDto.getMobile(),
                employeeDto.getJobRole()
                );

    }

    public GuestDto toGuestDto(Guest guest){
        return new GuestDto(
                guest.getCustomer_id(),
                guest.getCustomer_name(),
                guest.getDate(),
                guest.getNic(),
                guest.getAddress(),
                guest.getMobile(),
                guest.getEmail(),
                guest.getProvince()
        );

    }

    public Guest toGuest(GuestDto guestDto){
        return new Guest(
                guestDto.getCustomer_id(),
                guestDto.getCustomer_name(),
                guestDto.getDate(),
                guestDto.getNic(),
                guestDto.getAddress(),
                guestDto.getMobile(),
                guestDto.getEmail(),
                guestDto.getProvince()
        );
    }

    public HallDto toHallDto(Hall hall){
        return new HallDto(
                hall.getHallType(),
                hall.getHallNumber(),
                hall.getStatus(),
                hall.getPrice()
        );

    }

    public Hall toHall(HallDto hallDto){
        return new Hall(
                hallDto.getHallType(),
                hallDto.getHallNumber(),
                hallDto.getStatus(),
                hallDto.getPrice()
        );
    }

    public HallReservationDto toHallReservationDto(HallReservation hallReservation){
        return new HallReservationDto(
                hallReservation.getHall_number(),
                hallReservation.getCustomer_id(),
                hallReservation.getReservation_id(),
                hallReservation.getCheck_out_date(),
                hallReservation.getCheck_in_date()
        );

    }

    public HallReservation toHallReservation(HallReservationDto hallReservationDto){
        return new HallReservation(
                hallReservationDto.getHall_number(),
                hallReservationDto.getCustomer_id(),
                hallReservationDto.getReservation_id(),
                hallReservationDto.getCheck_out_date(),
                hallReservationDto.getCheck_in_date()
        );

    }

    public MealOdersDto toMealOdersDto(MealOders mealOders){
        return new MealOdersDto(
                mealOders.getOrderId(),
                mealOders.getCustomerId(),
                mealOders.getDate(),
                mealOders.getQty(),
                mealOders.getPkgId()
        );
    }

    public MealOders toMealOders(MealOdersDto mealOdersDto){
        return new MealOders(
                mealOdersDto.getOrderId(),
                mealOdersDto.getCustomerId(),
                mealOdersDto.getDate(),
                mealOdersDto.getQty(),
                mealOdersDto.getPkgId()
        );
    }

    public MealPackgesDto toMealPackgesDto(MealPackges mealPackges){
        return new MealPackgesDto(
                mealPackges.getPkg_id(),
                mealPackges.getPrice(),
                mealPackges.getDescription(),
                mealPackges.getMeal_plan(),
                mealPackges.getType()
        );
    }

    public MealPackges toMealPackges(MealPackgesDto mealPackgesDto){
        return new MealPackges(
                mealPackgesDto.getPkg_id(),
                mealPackgesDto.getPrice(),
                mealPackgesDto.getDescription(),
                mealPackgesDto.getMeal_plan(),
                mealPackgesDto.getType()
        );
    }

    public PaymentDto toPaymentDto(Payment payment){
        return new PaymentDto(
                payment.getPaymentId(),
                payment.getHallReservationId(),
                payment.getRoomReservationId(),
                payment.getTime(),
                payment.getDate(),
                payment.getOrderId(),
                payment.getCustomerId(),
                payment.getAmount()
        );
    }

    public Payment toPayment(PaymentDto paymentDto){
        return new Payment(
                paymentDto.getPaymentId(),
                paymentDto.getHallReservationId(),
                paymentDto.getRoomReservationId(),
                paymentDto.getTime(),
                paymentDto.getDate(),
                paymentDto.getOrderId(),
                paymentDto.getCustomerId(),
                paymentDto.getAmount()
        );
    }

    public RoomDto toRoomDto(Room room){
        return new RoomDto(
                room.getRoomNumber(),
                room.getRoomType(),
                room.getStatus(),
                room.getPrice()
        );
    }
    public Room toRoom(RoomDto roomDto){
        return new Room(
                roomDto.getRoomNumber(),
                roomDto.getRoomType(),
                roomDto.getStatus(),
                roomDto.getPrice()
        );
    }

    public RoomReservationDto toRoomReservationDto(RoomReservation roomReservation){
        return new RoomReservationDto(
                roomReservation.getRoom_number(),
                roomReservation.getCustomer_id(),
                roomReservation.getReservation_id(),
                roomReservation.getCheck_out_date(),
                roomReservation.getCheck_in_date()
        );
    }

    public RoomReservation toRoomReservation(RoomReservationDto roomReservationDto){
        return new RoomReservation(
                roomReservationDto.getRoom_number(),
                roomReservationDto.getCustomer_id(),
                roomReservationDto.getReservation_id(),
                roomReservationDto.getCheck_out_date(),
                roomReservationDto.getCheck_in_date()
        );
    }

    public UsersDto usersDto(Users users){
        return new UsersDto(
                users.getEmpId(),
                users.getName(),
                users.getJobRole(),
                users.getUsername(),
                users.getPassword()
        );
    }

    public Users toUsers(UsersDto usersDto){
        return new Users(
                usersDto.getEmpId(),
                usersDto.getName(),
                usersDto.getJobRole(),
                usersDto.getUsername(),
                usersDto.getPassword()
        );
    }
}
