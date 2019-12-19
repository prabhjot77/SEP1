import java.io.Serializable;
import java.util.ArrayList;

public class ExamScheduleList implements Serializable
{
  private ArrayList<ExamSchedule> schedules;

  public ExamScheduleList()
  {
    schedules=new ArrayList<ExamSchedule>();
  }
  public ArrayList<ExamSchedule> getAllExamSchedules()
  {
    return schedules;
  }

  public ExamSchedule getExamSchedule(int index){
    return schedules.get(index);
  }

  public void addSchedule(ExamSchedule examSchedule){
    schedules.add(examSchedule);
  }

  public void removeExam(ExamSchedule examSchedule){
    schedules.remove(examSchedule);
  }

  public String toString()
  {
    String str="";
    for(int i=0;i<schedules.size();i++)
    {
      str+=schedules.get(i).getName();
    }
    return str;
  }
  public boolean equals(Object obj)
  {
    if(!(obj instanceof ExamScheduleList))
    {
      return false;
    }
    ExamScheduleList other = (ExamScheduleList) obj;
    return other.schedules==schedules;
  }
}
