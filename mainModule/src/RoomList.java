import java.io.Serializable;
import java.util.ArrayList;

public class RoomList implements Serializable
{
  private ArrayList<Room>room;
  private boolean roomExists;
  public RoomList()
  {
    room=new ArrayList<Room>();
    roomExists = false;
  }

  public boolean isRoomExists()
  {
    return roomExists;
  }

  public void setRoomExists(boolean roomExists)
  {
    this.roomExists = roomExists;
  }

  public void addRoom(Room room1)
  {
    int count = 0;
    for (int i = 0; i < room.size(); i++){
      if (room.get(i).equals(room1)){
        count = 1;
      }
    }
    if (count == 0){
      this.setRoomExists(false);
      room.add(room1);
    }
    else {
      this.setRoomExists(true);
    }

  }
  public void removeRoom(Room room1)
  {
    room.remove(room1);
  }
  public void removeRoom(int index)
  {
    room.remove(index);
  }
  public Room getRoom(int index){
    return room.get(index);
  }
  public ArrayList<Room> getAllRooms()
  {
    return room;
  }
  public String toString()
  {
    String str="";
    for(int i=0;i<room.size();i++)
    {
      str+= room.get(i).toString() + "\n";
    }
    return str;
  }

}
