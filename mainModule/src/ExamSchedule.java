import java.util.ArrayList;
/**
 *  A class containing a list of Exam objects.
 * @author Sahil Simk
 * @version 1.0
 */
public class ExamSchedule
{
  private ArrayList<Exam> exams;

  /**
   * No-argument constructor.
   */
  public ExamSchedule()
  {
    exams = new ArrayList<Exam>();
  }

  /**
   * Gets all exams
   * @return all exams
   */
  public ArrayList<Exam> getAllExams()
  {
    return exams;
  }

  /**
   * Gets all the Exam object with the given oral type of the exam.
   * @return all the Exam objects with the given oral type of the exam
   */

  public ArrayList<Exam> getAllOralExams()
  {
    ArrayList<Exam> exams2 = new ArrayList<>();
    for (int i = 0; i < exams.size(); i++)
    {
      if (!(exams.get(i).getType().equals("Oral")))
      {
        exams2.add(exams.get(i));
      }
    }
    return exams2;
  }

  /**
   * Gets all the Exam object with the given written type of the exam.
   * @return all the Exam objects with the given written type of the exam
   */
  public ArrayList<Exam> getAllWrittenExams()
  {
    ArrayList<Exam> exams2 = new ArrayList<>();
    for (int i = 0; i < exams.size(); i++)
    {
      if (!(exams.get(i).getType().equals("Written")))
      {
        exams2.add(exams.get(i));
      }
    }
    return exams2;
  }

  /**
   * Edit exam.
   * @param exam exam to edit
   */
  public void editExam(Exam exam)
  {

  }

  /**
   * Adds an Exam to the exam schedule.
   * @param exam the exam to add to the exam schedule
   */
  public void addExam(Exam exam)
  {
    exams.add(exam);
  }

  /**
   * Removes an Exam from the exam schedule.
   * @param exam the exam to remove from the exam schedule
   */
  public void removeExam(Exam exam)
  {
    exams.remove(exam);
  }

  /**
   * Gets a String representation of the ExamSchedule.
   * @return a String containing information about all Exam objects in the list - each Exam object followed by a new line character
   */
  public String toString()
  {
    String str="";
    for(int i=0;i<exams.size();i++)
    {
      str+="Course:"+exams.get(i).getCourse()+"Type of the exam:"+exams.get(i).getType()+"Examiner:"+exams.get(i).getExaminer()+""
          + "Room:"+exams.get(i).getRoom()+" Date:"+exams.get(i).getDate();
    }
    return str;
  }

  public boolean equals(Object obj)
  {
    if(!(obj instanceof ExamSchedule))
    {
      return false;
    }
    ExamSchedule other = (ExamSchedule)obj
        return
  }
}
