import java.util.ArrayList;

/**
 * A class containing a list of Teacher objects.
 * @author Sahil Simk
 * @version 1.0
 */
public class TeacherList
{
  private ArrayList<Teacher> teachers;

  /**
   * No-argument constructor initializing the TeacherList
   */
  public TeacherList()
  {
    teachers=new ArrayList<Teacher>();
  }

  /**
   * Gets all the teachers.
   * @return all the teachers
   */
  public ArrayList<Teacher> getAllTeachers()
  {
    return teachers;
  }

  /**
   * Gets a String representation of the TeacherList.
   *
   * @return a String containing information about all Teacher objects in the list - each Teacher object followed by a new line character
   */
  public String toString()
  {
    String str="";
    for(int i=0;i<teachers.size();i++)
    {
      str+="Teacher's name:"+teachers.get(i).getName()+" Contact:"+teachers.get(i).getContact()+"Availability:"+teachers.get(i).getAvailability();
    }
    return str;
  }
}
