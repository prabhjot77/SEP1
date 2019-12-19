import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class ExamList implements Serializable
{
  private ArrayList<Exam> exams;
  private boolean examExists;
  private boolean roomBooked;
  private boolean notEnoughSeats;

  public ExamList()
  {
    exams=new ArrayList<Exam>();
    examExists = false;
    roomBooked = false;
  }
  public ArrayList<Exam> getAllExams()
  {
    return exams;
  }

  public Exam getExam(int index){
    return exams.get(index);
  }
  public boolean getRoomBooked(){
    return roomBooked;
  }
  public boolean getExamExists(){
    return examExists;
  }

  public boolean isNotEnoughSeats()
  {
    return notEnoughSeats;
  }

  public void setNotEnoughSeats(boolean notEnoughSeats)
  {
    this.notEnoughSeats = notEnoughSeats;
  }

  public void setExamExists(boolean examExists){
    this.examExists = examExists;
  }
  public void setRoomBooked(boolean roomBooked){
    this.roomBooked = roomBooked;
  }
  public void addExam(Exam exam){
    int a = 0;
    int b = 0;
    int c = 0;
    for (int i = 0; i < exams.size(); i++){
      System.out.println(exams.get(i).getRoom().getSeatsCapacity() + ":" + exam.getCourse().getNumberOfStudents());
      if (exams.get(i).equals(exam)){
        b = 1;
        break;
      }
      if (exams.get(i).getDate().equals(exam.getDate()) && exams.get(i).getRoom().equals(exam.getRoom())){
        a = 1;
        break;
      }

    }

    if (a != 0){
      this.setRoomBooked(true);
      this.setExamExists(false);
    }
    else if (b != 0){
      this.setExamExists(true);
      this.setRoomBooked(false);
    }
    else if (c != 0){
      this.setExamExists(false);
      this.setRoomBooked(false);
      System.out.println(c);
    }
    else {
      this.setRoomBooked(false);
      this.setExamExists(false);
      System.out.println(c);
      exams.add(exam);
    }

  }

  public void removeExam(Exam exam){
    exams.remove(exam);
  }

  public String toString()
  {
    String str="";
    for(int i=0;i<exams.size();i++)
    {
      str+="Course: " + exams.get(i).getCourse().getCourseName() + ", Room: " + exams.get(i).getRoom().getNumber() + ", Examiner: " + exams.get(i).getCourse().getTeacher().getName();
    }
    return str;
  }
  public boolean equals(Object obj)
  {
    if(!(obj instanceof ExamList))
    {
      return false;
    }
    ExamList other = (ExamList) obj;
    return other.exams==exams;
  }
}
