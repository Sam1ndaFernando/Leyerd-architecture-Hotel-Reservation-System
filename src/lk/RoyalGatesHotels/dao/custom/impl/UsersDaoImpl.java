package lk.RoyalGatesHotels.dao.custom.impl;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lk.RoyalGatesHotels.dao.custom.UsersDao;
import lk.RoyalGatesHotels.entity.Users;
import lk.RoyalGatesHotels.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UsersDaoImpl implements UsersDao {

    public boolean save (Users users) throws SQLException, ClassNotFoundException {
        boolean isAdd = CrudUtil.execute("INSERT INTO user VALUES (?,?,?,?,?)",
                users.getEmpId(),
                users.getName(),
                users.getJobRole(),
                users.getUsername(),
                users.getPassword()

        );
        return isAdd;
    }

    @Override
    public boolean update(Users users) throws SQLException, ClassNotFoundException {
        boolean isUpdate = CrudUtil.execute("UPDATE user SET username=?, password=? WHERE Employee_id=?",
                users.getUsername(),
                users.getPassword(),
                users.getEmpId()
        );
        System.out.println("is update : "+isUpdate);
        return isUpdate;
    }

    @Override
    public boolean delete(Users entity) {
        return false;
    }

    @Override
    public Users search(Object... args) throws SQLException, ClassNotFoundException {
        ResultSet result = CrudUtil.execute("SELECT * FROM user WHERE Employee_id=?",args[0]);
        Users users = new Users(
                result.getString("Employee_id"),
                result.getString("name"),
                result.getString("jobRole"),
                result.getString("username"),
                result.getString("username")
        );
        return (Users) result;
    }

    @Override
    public ObservableList<String> loadEmployeeIds() throws SQLException, ClassNotFoundException {
        ResultSet result = CrudUtil.execute("SELECT employee_id FROM employee");
        ObservableList<String> ids = FXCollections.observableArrayList();
        while(result.next()){
            ids.add(result.getString("employee_id"));
        }

        return ids;
    }
}
