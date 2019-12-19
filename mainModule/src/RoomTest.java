import java.util.ArrayList;

public class RoomTest
{
  public static void main(String[] Args) throws Exception{
    Room room1 = new Room("301b", true, true, true, 40);
    Room room2 = new Room("301A", true, false, true, 33);
    RoomList roomlist = new RoomList();
    roomlist.addRoom(room1);
    roomlist.addRoom(room2);
    MyFileIO mfIO = new MyFileIO();
    MyFileIO myfile = new MyFileIO();
    mfIO.writeToFile("mainModule/rooms.bin", room1);
    Room[] allRooms = (Room[])myfile.readArrayFromFile("mainModule/rooms.bin");
  }
}
