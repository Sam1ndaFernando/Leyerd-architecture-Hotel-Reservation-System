package service;

import lk.RoyalGatesHotels.Dto.SuperDto;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

public interface SuperService<T extends SuperDto> extends Serializable {

    boolean add(T entity) throws SQLException, ClassNotFoundException;
    boolean update(T entity) throws SQLException, ClassNotFoundException;
    boolean delete(Object... args);
    T searchById(Object... args) throws SQLException, ClassNotFoundException;
    List<T> getAll();
    boolean existByPk(Object... args);

}
