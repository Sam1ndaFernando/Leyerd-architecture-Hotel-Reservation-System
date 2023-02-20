package lk.RoyalGatesHotels.dao.custom.impl;

import lk.RoyalGatesHotels.dao.custom.EmployeeDao;
import lk.RoyalGatesHotels.entity.Employee;
import lk.RoyalGatesHotels.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class EmployeeDaoImpl implements EmployeeDao {

    @Override
    public boolean save(Employee employee) throws SQLException, ClassNotFoundException {
        boolean isAdd = CrudUtil.execute("INSERT INTO employee VALUES (?,?,?,?,?,?,?,?)",
                employee.getEmployeeId(),
                employee.getName(),
                employee.getAddress(),
                employee.getJoin_date(),
                employee.getNic(),
                employee.getEmail(),
                employee.getMobile(),
                employee.getJobRole()
        );
        return isAdd;
    }

    @Override
    public String getLastEmployeeId() throws SQLException, ClassNotFoundException {
        ResultSet result = CrudUtil.execute("SELECT employee_id FROM employee ORDER BY employee_id DESC LIMIT 1");
        if(result.next()){
            return result.getString("employee_id");
        }
        return null;
    }

    @Override
    public List<Employee> getEmployeeData() throws SQLException, ClassNotFoundException {
        ResultSet result = CrudUtil.execute("SELECT * FROM employee");
        List<Employee> list = new ArrayList<>();
        while(result.next()){
            list.add(new Employee(
                    result.getString("employee_id"),
                    result.getString("name"),
                    result.getString("address"),
                    result.getString("join_date"),
                    result.getString("nic"),
                    result.getString("Email"),
                    result.getString("mobile"),
                    result.getString("jobRole")

            ));
        }
        return list;
    }



    @Override
    public boolean update(Employee employee) throws SQLException, ClassNotFoundException {
        boolean isUpdate = CrudUtil.execute("UPDATE employee SET name=?, address=?, nic=?, Email=?, mobile=?, jobRole=? WHERE employee_id=?",
                employee.getName(),
                employee.getAddress(),
                employee.getNic(),
                employee.getEmail(),
                employee.getMobile(),
                employee.getJobRole(),
                employee.getEmployeeId()
        );
        return isUpdate;
    }

    @Override
    public boolean delete(Employee entity) {
        return false;
    }

    @Override
    public Employee search(Object... args) throws SQLException, ClassNotFoundException {
        ResultSet result = CrudUtil.execute("SELECT * FROM employee WHERE employee_id=?",args[0]);
        Employee employee = new Employee(
                result.getString("employee_id"),
                result.getString("name"),
                result.getString("address"),
                result.getString("join_date"),
                result.getString("nic"),
                result.getString("Email"),
                result.getString("mobile"),
                result.getString("jobRole")
        );
        return employee;
    }
}
