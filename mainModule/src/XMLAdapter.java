import persistence.MyXmlConverter;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;

public class XMLAdapter
{

  private MyXmlConverter c;

  public XMLAdapter(){
    c = new MyXmlConverter();
  }

  public void writeData(ExamSchedule examSchedule, String filename){
    try
    {
      c.toXml( examSchedule, filename );
    }
    catch (Exception e)
    {
      e.getMessage();
    }
  }

  public void writeRoomData(RoomList rooms){



    MyXmlConverter c = new MyXmlConverter(  );
    try
    {
      c.toXml( rooms, "rooms.xml" );
    }
    catch (Exception e)
    {
      e.getMessage();
    }

  }


  public void writeTeacherData(TeacherList teacherList){
    MyXmlConverter c = new MyXmlConverter(  );
    try
    {
      c.toXml( teacherList, "teachers.xml" );
    }
    catch (Exception e){
      e.getMessage();
    }
  }

  public void writeExamData(ExamSchedule exams){
    MyXmlConverter c = new MyXmlConverter(  );
    try
    {
      c.toXml( exams, "exams.xml" );
    }
    catch (Exception e){
      e.getMessage();
    }
  }

  public void writeCourseData(CourseList courseList){
    MyXmlConverter c = new MyXmlConverter(  );
    try
    {
      c.toXml( courseList, "courses.xml" );
    }
    catch (Exception e){
      e.getMessage();
    }
  }

 public RoomList readRoomData(){
    MyXmlConverter c = new MyXmlConverter();
    RoomList roomList = new RoomList();
    try
    {
      roomList = c.fromXml( "rooms.xml", RoomList.class );
    }
    catch (Exception e){
      e.getMessage();
    }
    return roomList;
 }

 public CourseList readCourseData(){
    MyXmlConverter c = new MyXmlConverter(  );
    CourseList courseList = new CourseList();
    try
    {
      courseList = c.fromXml( "courses.xml", CourseList.class );
    }
    catch (Exception e){
      e.getMessage();
    }
    return courseList;
 }

 public ExamSchedule readExamData(){
    MyXmlConverter c = new MyXmlConverter(  );
    ExamSchedule exams = new ExamSchedule("newsch");
    try
    {
      exams = c.fromXml( "exams.xml", ExamSchedule.class );
    }
    catch (Exception e){
      e.getMessage();
    }
    return exams;
}

public TeacherList readTeacherData(){
    MyXmlConverter c = new MyXmlConverter(  );
    TeacherList teacherList = new TeacherList();
    try
    {
      teacherList = c.fromXml( "teachers.xml", TeacherList.class );
    }
    catch (Exception e){
      e.getMessage();
    }
    return teacherList;
}



}
