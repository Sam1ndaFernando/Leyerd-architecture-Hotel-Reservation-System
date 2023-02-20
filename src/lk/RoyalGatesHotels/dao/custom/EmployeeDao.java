package lk.RoyalGatesHotels.dao.custom;

import lk.RoyalGatesHotels.dao.CrudDao;
import lk.RoyalGatesHotels.entity.Employee;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface EmployeeDao extends CrudDao<Employee,String>  {
    boolean save(Employee entity) throws SQLException, ClassNotFoundException;
    String getLastEmployeeId() throws SQLException, ClassNotFoundException;
    List<Employee> getEmployeeData() throws SQLException, ClassNotFoundException;

}
