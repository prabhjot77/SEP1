import persistence.MyXmlConverter;
import persistence.XmlConverterException;

import java.io.IOException;

public class Adapter
{
  private MyFileIO fileIO;

  public Adapter(){
    fileIO = new MyFileIO();
  }

  public void writeRoomData(RoomList roomlist){
    try
    {
      fileIO.writeToFile("rooms.bin", roomlist);
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }

  public RoomList readRoomData(){
    RoomList newlist = null;
    try
    {
      newlist = (RoomList) fileIO.readObjectFromFile("rooms.bin");
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
    catch (ClassNotFoundException e)
    {
      e.printStackTrace();
    }
    return newlist;
  }

  public void writeTeacherData(TeacherList teacherList){
    try
    {
      fileIO.writeToFile("teachers.bin", teacherList);
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }

  public TeacherList readTeacherData(){
    TeacherList newlist = null;
    try
    {
      newlist = (TeacherList) fileIO.readObjectFromFile("teachers.bin");
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
    catch (ClassNotFoundException e)
    {
      e.printStackTrace();
    }
    return newlist;
  }

  public void writeCourseData(CourseList courseList){
    try
    {
      fileIO.writeToFile("courses.bin", courseList);
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }

  public CourseList readCourseData(){
    CourseList newlist = null;
    try
    {
      newlist = (CourseList) fileIO.readObjectFromFile("courses.bin");
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
    catch (ClassNotFoundException e)
    {
      e.printStackTrace();
    }
    return newlist;
  }

  public void writeExamData(ExamList examList){
    try
    {
      fileIO.writeToFile("exams.bin", examList);
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }

  public ExamList readExamData(){
    ExamList newlist = null;
    try
    {
      newlist = (ExamList) fileIO.readObjectFromFile("exams.bin");
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
    catch (ClassNotFoundException e)
    {
      e.printStackTrace();
    }
    return newlist;
  }

  public void writeScheduleData(ExamScheduleList examSchedule){
    try
    {
      fileIO.writeToFile("schedule.bin", examSchedule);
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }

  public ExamScheduleList readscheduleData(){
    ExamScheduleList schedule = null;
    try
    {
      schedule = (ExamScheduleList) fileIO.readObjectFromFile("schedule.bin");
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
    catch (ClassNotFoundException e)
    {
      e.printStackTrace();
    }
    return schedule;
  }
}
