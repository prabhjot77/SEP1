import persistence.MyXmlConverter;
import persistence.XmlConverterException;

import java.util.ArrayList;

public class MyTest
{
  public static void main(String[] args){
   CourseList newList = new CourseList();
   newList.addCourse(new Course("vjjhhmjk", new Teacher("hghhg", "gxgx"), 78, true));

    Adapter myAdapter = new Adapter();
    myAdapter.writeCourseData(newList);

//    MyXmlConverter xml = new MyXmlConverter();
//    try
//    {
//      xml.toXml(rooms, "rooms.xml");
//    }
//    catch (XmlConverterException e)
//    {
//      e.printStackTrace();
//    }

//    RoomList newRoom = null;
//
//    XMLAdapter myxml = new XMLAdapter();
//    newRoom = myxml.readRoomData();
//    System.out.println(newRoom);
  }
}
