/**
 * A class containing Oral objects and methods
 * @author Sahil Simk
 * @version 1.0
 */
public class Oral extends Exam
{
  /**
   * Four-argument constructor.
   * @param course the exam's course
   * @param examiner the exam's examiner
   * @param date the exam's date
   * @param room the exam's room
   */
  public Oral(Room room, Teacher examiner, MyDate date, Course course)
  {
    super(course, examiner, room, date);
  }


  public void planBreak() //????????/
  {

  }
  public void reserveRoom() //??????????
  {

  }

  /**
   * Gets type of the exam.
   * @return "Oral"
   */
  public String getType()
  {
    return "Oral";
  }


  /**
   * Returns a string representation of the oral (exam).
   * @return a string representation of the oral (exam) in the format: " course examiner date room Oral"
   */
  public String toString()
  {
    return super.toString();
  }
}
