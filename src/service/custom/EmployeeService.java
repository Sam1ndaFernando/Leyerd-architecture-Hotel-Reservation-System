package service.custom;

import lk.RoyalGatesHotels.Dto.EmployeeDto;
import lk.RoyalGatesHotels.entity.Employee;
import service.SuperService;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface EmployeeService extends SuperService<EmployeeDto> {

    boolean save(Employee entity) throws SQLException, ClassNotFoundException;
    String getLastEmployeeId() throws SQLException, ClassNotFoundException;
    List<Employee> getEmployeeData() throws SQLException, ClassNotFoundException;
}
