import java.util.ArrayList;

/**
 * A class containing a list of Room objects.
 * @author Sahil Simk
 * @version 1.0
 */
public class RoomList
{
  private ArrayList<Room>rooms;

  /**
   * No-argument constructor initializing the RoomList.
   */
  public RoomList()
  {
    rooms=new ArrayList<Room>();
  }

  /**
   * Adds a Room to the list.
   * @param room the room to add to the list
   */
  public void addRoom(Room room)
  {
    rooms.add(room);
  }

  /**
   * Removes a Room from the list.
   * @param room the room to remove from the list
   */
  public void removeRoom(Room room)
  {
    rooms.remove(room);
  }

  /**
   * Gets all the rooms
   * @return all the rooms
   */
  public ArrayList<Room> getAllRooms()
  {
    return rooms;
  }

  /**
   * Gets the size of the arrayList
   * @return the size of the arrayList
   */
  public int size()
  {
    return rooms.size();
  }

  /**
   * Gets a String representation of the RoomList.
   * @return a String containing information about all Room objects in the list - each Room object followed by a new line character
   */
  public String toString()
  {
    String str="";
    for(int i=0;i<rooms.size();i++)
    {
      str+="Number:"+rooms.get(i).getNumber()+" HDMI:"+rooms.get(i).isHDMI()+" VGA:"+rooms.get(i).isVGA()+""
          + "Projector:"+rooms.get(i).isProjector()+" Seats capacity:"+rooms.get(i).getSeatsCapacity();
    }
    return str;
  }

}
