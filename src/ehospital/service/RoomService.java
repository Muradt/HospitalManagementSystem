/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ehospital.service;

import ehospital.model.Room;
import java.util.List;

/**
 *
 * @author hp
 */
public interface RoomService {

    List<Room> getRoomList() throws Exception;

    public Room getRoomById(Long roomId) throws Exception;
}
