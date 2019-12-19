import java.io.Serializable;
import java.util.ArrayList;

/**
 * A class representing a date with a day, month and year.
 * @author Roksana Dziadowicz
 * @version 1.0
 */
public class MyDate implements Serializable
{
  private int day;
  private int month;
  private int year;
  private TimePeriod hours;

  /**
   * Three-argument constructor.
   * @param day the day of the exam
   * @param month the month of the exam
   * @param year the year of the exam
   */
  public MyDate(int day, int month, int year, TimePeriod hours)
  {
    this.hours = hours;
    this.day=day;
    this.month=month;
    this.year=year;
  }

  /**
   * Sets the hour of the start of the exam and the end of the exam.
   * @param hours
   */
  public void setHours(TimePeriod hours)
  {
    this.hours = hours;
  }

  /**
   * Sets the day of the exam.
   * @param day what the exam's day will be set to
   */
  public void setDay(int day)
  {
    this.day = day;
  }
  /**
   * Sets the month of the exam.
   * @param month what the exam's month will be set to
   */
  public void setMonth(int month)
  {
    this.month = month;
  }
  /**
   * Sets the year of the exam.
   * @param year what the exam's year will be set to
   */
  public void setYear(int year)
  {
    this.year = year;
  }

  /**
   * Gets the day of the exam.
   * @return the day of the exam
   */
  public int getDay()
  {
    return day;
  }

  /**
   * Gets the month of the exam.
   * @return the month of the exam
   */
  public int getMonth()
  {
    return month;
  }

  /**
   * Gets the year of the exam.
   * @return the year of the exam
   */
  public int getYear()
  {
    return year;
  }

  /**
   * Gets hours of the exam.
   * @return hours of the exam
   */
  public TimePeriod getHours()
  {
    return hours;
  }

  /**
   * Copies information from MyDate class.
   * @return copied information from MyDate class
   */
  public MyDate copy()
  {
    return new MyDate(day,month,year,hours);
  }

  /**
   * Returns a string representation of the date.
   * @return a string representation of the date in the format: "day/month/year hours"
   */
  public String toString()
  {
    return day + "." + month + "." + year + ", " + hours.toString();
  }

  /**
   * Compares day, month and year of two exams.
   * @param obj the object to compare with
   * @return true if the given object is equal to this exam
   */
  public boolean equals(Object obj)
  {
    if(!(obj instanceof MyDate))
    {
      return false;
    }
    MyDate other=(MyDate)obj;
    return (day==other.day && month==other.month && year==other.year);
  }
}