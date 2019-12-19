import java.io.FileNotFoundException;
import java.io.IOException;

public class RoomAdapter
{
  private MyFileIO mfio;
  private String filename;

  public RoomAdapter(String filename){
    mfio = new MyFileIO();
    this.filename = filename;
  }

  public RoomList getAllRooms(){
    RoomList rooms = new RoomList();
    try
    {
      rooms = (RoomList) mfio.readObjectFromFile(filename);
    }
    catch (FileNotFoundException e){
      System.out.println("File not found");
    }
    catch (IOException e){
      System.out.println("error reading file");
    }
    catch (ClassNotFoundException e){
      System.out.println("class not found");
    }
    return rooms;

  }

  public void saveRooms(RoomList rooms){
    try
    {
      mfio.writeToFile(filename, rooms);
    }
    catch (FileNotFoundException e){
      System.out.println("file not found");
    }
    catch (IOException e){
      System.out.println("error writing to file");
    }
  }
}
