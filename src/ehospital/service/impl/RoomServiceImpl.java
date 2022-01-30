/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ehospital.service.impl;

import ehospital.dao.RoomDao;
import ehospital.model.Room;
import ehospital.service.RoomService;
import java.util.List;

/**
 *
 * @author hp
 */
public class RoomServiceImpl implements RoomService {

    private RoomDao roomDao;

    public RoomServiceImpl(RoomDao roomDao) {
        this.roomDao = roomDao;
    }

    @Override
    public List<Room> getRoomList() throws Exception {
        return roomDao.getRoomList();
    }

    @Override
    public Room getRoomById(Long roomId) throws Exception {
        return roomDao.getRoomById(roomId);
    }

}
