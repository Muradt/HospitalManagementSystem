package ehospital.dao.impl;

import ehospital.dao.DbHelper;
import ehospital.dao.RoomDao;
import ehospital.model.Gender;
import ehospital.model.Room;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class RoomDaoImpl implements RoomDao {

    @Override
    public List<Room> getRoomList() throws Exception {
        List<Room> roomList = new ArrayList<>();
        String sql = "SELECT  ID,ROOM_NUMBER,STATUS FROM ROOM";
        try (Connection c = DbHelper.getConnection();
                PreparedStatement ps = c.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();) {
            while (rs.next()) {
                Room room = new Room();
                room.setId(rs.getLong("ID"));
                room.setRoomNumber(rs.getInt("ROOM_NUMBER"));
                room.setStatus(rs.getInt("STATUS"));
                roomList.add(room);

            }

        }
        return roomList;
    }

    @Override
    public Room getRoomById(Long roomId) throws Exception {
        String sql = "SELECT ID,ROOM_NUMBER FROM ROOM\n"
                + "WHERE ID = ?";
        Room room
                = null;
        try (Connection c = DbHelper.getConnection();
                PreparedStatement ps = c.prepareStatement(sql);) {
            ps.setLong(1, roomId);
            ResultSet rs = ps.executeQuery();
            room
                    = new Room();
            if (rs.next()) {
                room.setId(rs.getLong("ID"));
                room.setRoomNumber(rs.getInt("ROOM_NUMBER"));
            }
        }
        return room;
    }
}
