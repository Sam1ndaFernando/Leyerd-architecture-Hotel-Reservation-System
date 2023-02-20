package service.custom.impl;

import lk.RoyalGatesHotels.Dto.ComplainDto;
import lk.RoyalGatesHotels.dao.DaoFactory;
import lk.RoyalGatesHotels.dao.DaoTypes;
import lk.RoyalGatesHotels.dao.custom.ComplainDao;
import lk.RoyalGatesHotels.db.DBConnection;
import lk.RoyalGatesHotels.entity.Complain;
import service.custom.ComplainService;
import service.util.Converter;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class ComplainServiceImpl implements ComplainService {

    private final ComplainDao complainDao;
    private final Converter converter;
    private final Connection connection;

    public ComplainServiceImpl() {
        connection= DBConnection.getInstance().getConnection();
        complainDao= DaoFactory.getInstance().getDao(connection, DaoTypes.COMPLAIN_DAO);
        converter =new Converter();
    }

    @Override
    public boolean add(ComplainDto complainDto) throws SQLException, ClassNotFoundException {
        return complainDao.save(converter.toComplain(complainDto));
    }

    @Override
    public boolean update(ComplainDto complainDto) throws SQLException, ClassNotFoundException {
        return complainDao.update(converter.toComplain(complainDto));
    }

    @Override
    public boolean delete(Object... args) {
        return false;
    }

    @Override
    public ComplainDto searchById(Object... args) throws SQLException, ClassNotFoundException {
        return converter.toComplainDTO(complainDao.search(args));
    }

    @Override
    public List<ComplainDto> getAll() {
        return null;
    }

    @Override
    public boolean existByPk(Object... args) {
        return false;
    }


    @Override
    public String getLastComplainId() throws SQLException, ClassNotFoundException {
        return complainDao.getLastComplainId();
    }

    @Override
    public int getComplaintCount() throws SQLException, ClassNotFoundException {
        return complainDao.getComplaintCount();
    }
}
