import java.io.Serializable;

public class Exam implements Serializable
{
  private String coExaminer;
  private MyDate date;
  private Room room;
  private Course course;
  public Exam(Course course, Room room, MyDate date, String coExaminer)
  {
    this.room=room;
    this.coExaminer=coExaminer;
    this.date=date;
    this.course=course;
  }

  public Exam(Course course, Room room, MyDate date)
  {
    this.room=room;
    this.date=date;
    this.course=course;
  }

  public Course getCourse()
  {
    return course;
  }

  public Room getRoom()
  {
    return room;
  }
  public String getCoExaminer()
  {
    return coExaminer;
  }
  public MyDate getDate()
  {
    return date;
  }

  public void setCourse(Course course)
  {
    this.course = course;
  }

  public void setRoom(Room room)
  {
    this.room = room;
  }

  public void setCoExaminer(String coExaminer)
  {
    this.coExaminer = coExaminer;
  }

  public void setDate(MyDate date)
  {
    this.date = date;
  }

  public String toString()
  {
    return "Course:"+course+" Examiner:"+coExaminer+" Date:"+date+" Room:"+room;
  }
  public boolean equals(Object obj)
  {
    if(!(obj instanceof Exam))
    {
      return false;
    }
    Exam other=(Exam)obj;
    return course.equals(other.course);
  }
}
