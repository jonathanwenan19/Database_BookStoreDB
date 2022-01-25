package sample;

public class available_location
{
    public String room_id;
    public String isle;
    public String floor;

    public available_location(String room_id, String isle, String room) {
        this.room_id = room_id;
        this.isle = isle;
        this.floor = room;
    }

    public String getRoom_id() {
        return room_id;
    }

    public String getIsle() {
        return isle;
    }

    public String getFloor() {
        return floor;
    }

    public void setRoom_id(String room_id) {
        this.room_id = room_id;
    }

    public void setIsle(String isle) {
        this.isle = isle;
    }


    public void setFloor(String floor) {
        this.floor = floor;
    }
}
