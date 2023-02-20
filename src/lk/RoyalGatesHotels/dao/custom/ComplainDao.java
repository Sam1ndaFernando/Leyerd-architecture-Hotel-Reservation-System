package lk.RoyalGatesHotels.dao.custom;

import lk.RoyalGatesHotels.dao.CrudDao;
import lk.RoyalGatesHotels.entity.Complain;

import java.sql.SQLException;

public interface ComplainDao extends CrudDao <Complain,String> {
    String getLastComplainId() throws SQLException, ClassNotFoundException;

    int getComplaintCount() throws SQLException, ClassNotFoundException;
}
