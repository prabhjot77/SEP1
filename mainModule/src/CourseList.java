import java.io.Serializable;
import java.util.ArrayList;
public class CourseList implements Serializable
{
  private ArrayList<Course> courses;
  private boolean courseExists;

  public CourseList()
  {
    courses=new ArrayList<Course>();
    courseExists = false;
  }
  public ArrayList<Course> getAllCourses()
  {
    return courses;
  }

  public Course getCourse(int index){
    return courses.get(index);
  }

  public boolean getCourseExists(){
    return courseExists;
  }

  public void setCourseExists(boolean courseExists){
    this.courseExists = courseExists;
  }

  public void addCourse(Course course){
    int count = 0;
    for (int i = 0; i < courses.size(); i++){
      if (courses.get(i).equals(course)){
        count = 1;
        break;
      }
    }
    if (count == 0){
      this.setCourseExists(false);
      courses.add(course);
    }
    else {
      this.setCourseExists(true);
    }

  }

  public void removeCourse(Course course){
    courses.remove(course);
  }

  public String toString()
  {
    String str="";
    for(int i=0;i<courses.size();i++)
    {
      str+="Course name:"+courses.get(i).getCourseName()+" Teacher:"+courses.get(i).getTeacher()+""
          +" Number of students:"+courses.get(i).getNumberOfStudents();
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
