package service.custom;

import lk.RoyalGatesHotels.Dto.ComplainDto;
import lk.RoyalGatesHotels.entity.Complain;
import service.SuperService;

import java.sql.SQLException;

public interface ComplainService extends SuperService<ComplainDto> {

    String getLastComplainId() throws SQLException, ClassNotFoundException;

    int getComplaintCount() throws SQLException, ClassNotFoundException;
}
