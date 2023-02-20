package service.custom.impl;

import lk.RoyalGatesHotels.Dto.EmployeeDto;
import lk.RoyalGatesHotels.dao.DaoFactory;
import lk.RoyalGatesHotels.dao.DaoTypes;
import lk.RoyalGatesHotels.dao.custom.ComplainDao;
import lk.RoyalGatesHotels.dao.custom.EmployeeDao;
import lk.RoyalGatesHotels.db.DBConnection;
import lk.RoyalGatesHotels.entity.Employee;
import service.custom.EmployeeService;
import service.util.Converter;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeDao employeeDao;
    private final Converter converter;
    private final Connection connection;

    public EmployeeServiceImpl() {
        connection= DBConnection.getInstance().getConnection();
        employeeDao= DaoFactory.getInstance().getDao(connection, DaoTypes.EMPLOYEE_DAO);
        converter =new Converter();
    }


    @Override
    public boolean add(EmployeeDto employeeDto) throws SQLException, ClassNotFoundException {
        return employeeDao.save(converter.toEmployee(employeeDto));
    }

    @Override
    public boolean update(EmployeeDto employeeDto) throws SQLException, ClassNotFoundException {
        return employeeDao.update(converter.toEmployee(employeeDto));
    }

    @Override
    public boolean delete(Object... args) {
        return false;
    }

    @Override
    public EmployeeDto searchById(Object... args) throws SQLException, ClassNotFoundException {
        return converter.toEmployeeDto(employeeDao.search(args));
    }

    @Override
    public List<EmployeeDto> getAll() {
        return null;
    }

    @Override
    public boolean existByPk(Object... args) {
        return false;
    }

    @Override
    public boolean save(Employee entity) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public String getLastEmployeeId() throws SQLException, ClassNotFoundException {
        return employeeDao.getLastEmployeeId();
    }

    @Override
    public List<Employee> getEmployeeData() throws SQLException, ClassNotFoundException {
        return employeeDao.getEmployeeData();
    }
}
