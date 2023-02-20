package lk.RoyalGatesHotels.dao;

import lk.RoyalGatesHotels.entity.SuperEntity;

import java.io.Serializable;
import java.sql.SQLException;

public interface CrudDao <T extends SuperEntity,TM extends Serializable> extends SuperDao{
    boolean save (T entity) throws SQLException, ClassNotFoundException;
    boolean update (T entity) throws SQLException, ClassNotFoundException;
    boolean delete (T entity);
    T search (Object... args) throws SQLException, ClassNotFoundException;
}
