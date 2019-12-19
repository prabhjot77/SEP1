import java.io.Serializable;
import java.util.ArrayList;

public class ExamSchedule implements Serializable
{
  private String name;
  private ArrayList<Exam> exams;

  public ExamSchedule(String name)
  {
    this.name = name;
    exams = new ArrayList<Exam>();
  }

  public String getName(){
    return name;
  }

  public ArrayList<Exam> getAllExams()
  {
    return exams;
  }

  public void addExam(Exam exam)
  {
    exams.add(exam);
  }
  public void removeExam(Exam exam)
  {
    exams.remove(exam);
  }
  public String toString()
  {
    return name;
  }
}
