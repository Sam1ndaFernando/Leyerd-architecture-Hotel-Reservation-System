package lk.RoyalGatesHotels.model;

import lk.RoyalGatesHotels.entity.Employee;
import lk.RoyalGatesHotels.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeModel {

    public static String getLastEmployeeId() throws SQLException, ClassNotFoundException {
        ResultSet result = CrudUtil.execute("SELECT employee_id FROM employee ORDER BY employee_id DESC LIMIT 1");
        if(result.next()){
            return result.getString("employee_id");
        }
        return null;
    }

    public static boolean addEmployee(Employee employee) throws SQLException, ClassNotFoundException {
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

    public static boolean updateEmployee(Employee employee) throws SQLException, ClassNotFoundException {
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

    public static ResultSet searchEmployee(String employee_id) throws SQLException, ClassNotFoundException {
        ResultSet result = CrudUtil.execute("SELECT * FROM employee WHERE employee_id=?",employee_id);
        return result;
    }


    public static ResultSet getEmployeeData() throws SQLException, ClassNotFoundException {
        ResultSet result = CrudUtil.execute("SELECT * FROM employee");
        return result;
    }
}
