import java.io.Serializable;
import java.util.ArrayList;

/**
 * A class containing a list of Teacher objects.
 * @author Roksana Dziadowicz
 * @version 1.0
 */
public class TeacherList implements Serializable
{
  private ArrayList<Teacher> teachers;
  private boolean teacherExists;

  /**
   * No-argument constructor initializing the TeacherList
   */
  public TeacherList()
  {
    teachers = new ArrayList<Teacher>();
    teacherExists = false;
  }

  /**
   * Gets all the teachers.
   * @return all the teachers
   */
  public ArrayList<Teacher> getAllTeachers()
  {
    return teachers;
  }

  public Teacher getTeacher(int index){
    return teachers.get(index);
  }

  public boolean isTeacherExists(){
    return teacherExists;
  }

  public void setTeacherExists(boolean teacherExists){
    this.teacherExists = teacherExists;
  }

  public void addTeacher(Teacher teacher){
    int count = 0;
    for (int i = 0; i < teachers.size(); i++){
      if (teachers.get(i).equals(teacher)){
        count = 1;
        break;
      }
    }

    if (count == 0){
      this.setTeacherExists(false);
      teachers.add( teacher );
    }
    else {
      this.setTeacherExists(true);
    }

  }

  public void removeTeacher(Teacher teacher){
    teachers.remove( teacher );
  }

  /**
   * Gets a String representation of the TeacherList.
   *
   * @return a String containing information about all Teacher objects in the list - each Teacher object followed by a new line character
   */
  public String toString()
  {
    String returnStr = "";

    for (int i = 0; i < teachers.size(); i++)
    {
      Teacher temp = teachers.get(i);

      returnStr += temp.getName();
    }
    return returnStr;
  }
}