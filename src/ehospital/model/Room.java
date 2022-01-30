package ehospital.model;

public class Room {

    private long id;
    private int roomNumber;
    private int status;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public static void showRooms(Room room) {
        System.out.println(room.getId() + "--" + room.getRoomNumber() + "--" + room.getStatus());
    }

    @Override
    public String toString() {
        return String.valueOf(roomNumber);
    }

}
