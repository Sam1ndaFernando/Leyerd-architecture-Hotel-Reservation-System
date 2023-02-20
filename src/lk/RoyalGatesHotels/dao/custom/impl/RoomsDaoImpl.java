package lk.RoyalGatesHotels.dao.custom.impl;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lk.RoyalGatesHotels.dao.custom.RoomsDao;
import lk.RoyalGatesHotels.entity.Room;
import lk.RoyalGatesHotels.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RoomsDaoImpl implements RoomsDao {

    public boolean save (Room room) throws SQLException, ClassNotFoundException {
        boolean isAdd = CrudUtil.execute("INSERT INTO room VALUES (?,?,?,?)",
                room.getRoomNumber(),
                room.getRoomType(),
                room.getStatus(),
                room.getPrice()
        );
        return isAdd;
    }

    @Override
    public boolean update(Room room) throws SQLException, ClassNotFoundException {
        boolean isUpdate = CrudUtil.execute("UPDATE room SET room_type=?, status=?, price=?, WHERE room_number=?",
                room.getRoomType(),
                room.getStatus(),
                room.getPrice(),
                room.getRoomNumber()
        );
        return isUpdate;
    }

    @Override
    public boolean delete(Room entity) {
        return false;
    }

    @Override
    public Room search(Object... args) throws SQLException, ClassNotFoundException {
        ResultSet result = CrudUtil.execute("SELECT * FROM room WHERE room_number=?",args[0]);
        Room room = new Room(
                result.getString("room_number"),
                result.getString("room_type"),
                result.getString("status"),
                result.getDouble("price")
        );
        return room;
    }

    @Override
    public String getLastAdminRoomId() throws SQLException, ClassNotFoundException {
        ResultSet result = CrudUtil.execute("SELECT room_number FROM room ORDER BY room_number DESC LIMIT 1");
        if(result.next()){
            return result.getString("room_number");
        }
        return null;
    }

    @Override
    public List<Room> getRoomData() throws SQLException, ClassNotFoundException {
        ResultSet result = CrudUtil.execute("SELECT * FROM room");
        List<Room> list = new ArrayList<>();
        while (result.next()){
            Room room = new Room(
                    result.getString("room_number"),
                    result.getString("room_type"),
                    result.getString("status"),
                    result.getDouble("price")
            );
            list.add(room);
        }
        return list;
    }


    @Override
    public boolean updateRoomAvailability(String room_number, String unavailable) throws SQLException, ClassNotFoundException {
        boolean isUpdate = CrudUtil.execute("UPDATE room SET status=? WHERE room_number=?",unavailable, room_number);
        return isUpdate;
    }

    @Override
    public ObservableList<String> loadRoomNumbers() throws SQLException, ClassNotFoundException {
        ResultSet resultSet = CrudUtil.execute("SELECT room_number FROM room");

        ObservableList<String> options = FXCollections.observableArrayList();
        while (resultSet.next()){
            options.add(resultSet.getString("room_number"));
        }
        return options;
    }

    @Override
    public int getRoomCount() throws SQLException, ClassNotFoundException {
        ResultSet result = CrudUtil.execute("SELECT room_number FROM room");
        int count=0;
        while (result.next()){
            count++;
        }
        return count;
    }

    @Override
    public int getBookedRoomsCount() throws SQLException, ClassNotFoundException {
        ResultSet result = CrudUtil.execute("SELECT room_number FROM room WHERE status=?","Unavailable");
        int count=0;
        while (result.next()){
            count++;
        }
        return count;
    }

    @Override
    public int getAvailableRoomsCount() throws SQLException, ClassNotFoundException {
        ResultSet result = CrudUtil.execute("SELECT room_number FROM room WHERE status=?","Available");
        int count=0;
        while (result.next()){
            count++;
        }
        return count;
    }

    @Override
    public double getRoomPrice(String roomNo) throws SQLException, ClassNotFoundException {
        ResultSet resultSet = CrudUtil.execute("SELECT * FROM room WHERE room_number=?", roomNo);
        if(resultSet.next()){
            return Double.parseDouble(resultSet.getString("price"));

        }
        return 0;
    }
}
