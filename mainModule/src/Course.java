import java.io.Serializable;

public class Course implements Serializable
{
  private Teacher teacher;
  private int numberOfStudents;
  private String courseName;
  private boolean isWritten;
  public Course(String courseName, Teacher teacher, int numberOfStudents, boolean isWritten)
  {
    this.courseName=courseName;
    this.teacher=teacher;
    this.numberOfStudents=numberOfStudents;
    this.isWritten = isWritten;
  }
  public String getCourseName()
  {
    return courseName;
  }

  public int getNumberOfStudents()
  {
    return numberOfStudents;
  }

  public Teacher getTeacher()
  {
    return teacher;
  }

  public boolean getisWritten()
  {
    return isWritten;
  }
  public void setCourseName(String courseName)
  {
    this.courseName = courseName;
  }

  public void setNumberOfStudents(int numberOfStudents)
  {
    this.numberOfStudents = numberOfStudents;
  }

  public void setTeacher(Teacher teacher)
  {
    this.teacher = teacher;
  }

  public void setWritten(boolean isWritten){
    this.isWritten = isWritten;
  }

  public String toString(){
    return courseName;
  }

  public boolean equals(Object obj)
  {
    if(!(obj instanceof Course))
    {
      return false;
    }
    Course other=(Course)obj;
    return courseName.toLowerCase().equals(other.courseName.toLowerCase());
  }
}
