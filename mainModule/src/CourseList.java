import java.util.ArrayList;

/**
 *  A class containing a list of Course objects
 * @author Sahil Simk
 * @version 1.0
 */
public class CourseList
{
  private ArrayList<Course> courses;

  /**
   * No-argument constructor initializing the CourseList.
   */
  public CourseList()
  {
    courses=new ArrayList<Course>();
  }

  /**
   * Gets all the courses.
   * @return all the courses
   */
  public ArrayList<Course> getAllCourses()
  {
    return courses;
  }

  /**
   * Gets index of the courses.
   * @return  index of all the courses
   */

  public Course getCourse(int index)
  {
    return courses.get(index);
  }

  public void addCourse(Course course)
  {
    courses.add(course);
  }

  public void removeCourse(int index)
  {
    courses.remove(index);
  }

  /**
   * Gets a String representation of the CourseList.
   * @return a String containing information about all Course objects in the list-each Course object ollowed by a new line character
   */
  /**
   * Gets the size of the arrayList
   * @return the size of the arrayList
   */
  public String toString()
  {
    String str="";
    for(int i=0;i<courses.size();i++)
    {
      str+="Course name:"+courses.get(i).getName()+" Teacher:"+courses.get(i).getTeacher()+" Room:"+courses.get(i).getRoom()+""
          + "Exam type:"+courses.get(i).getExamType()+" Number of students:"+courses.get(i).getNumberOfStudents();
    }
    return str;
  }
  public boolean equals(Object obj)
  {
    if(!(obj instanceof CourseList))
    {
      return false;
    }
    CourseList other = (CourseList)obj;
    return other.courses==courses;
  }
}
