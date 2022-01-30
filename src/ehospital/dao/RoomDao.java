package ehospital.dao;

import ehospital.model.Room;

import java.util.List;

public interface RoomDao {

    List<Room> getRoomList() throws Exception;

    public Room getRoomById(Long roomId)  throws Exception;
}
