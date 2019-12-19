public class DateInterval
{
  private MyDate writtenExamDate;
  private MyDate oralExamDate;
  private MyDate getOralExamDate2;

  public DateInterval(MyDate writtenExamDate, MyDate oralExamDate,
      MyDate getOralExamDate2)
  {
    this.writtenExamDate = writtenExamDate;
    this.oralExamDate = oralExamDate;
    this.getOralExamDate2 = getOralExamDate2;
  }

  public void setWrittenExamDate(MyDate writtenExamDate)
  {
    this.writtenExamDate = writtenExamDate;
  }

  public void setOralExamDate(MyDate oralExamDate)
  {
    this.oralExamDate = oralExamDate;
  }

  public void setGetOralExamDate2(MyDate getOralExamDate2)
  {
    this.getOralExamDate2 = getOralExamDate2;
  }
}
