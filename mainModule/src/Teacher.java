import java.util.ArrayList;

/**
 * A class representing a teacher with a name, unavailability and contact.
 * @author Sahil Simk
 * @version 1.0
 */
public class Teacher
{
  private String name;
  private ArrayList<MyDate>availability;
  private String contact;

  /**
   * Two-argument constructor.
   * @param name the teacher's name
   * @param contact the teacher's contact
   */
  public Teacher(String name, String contact)
  {
    this.name=name;
    this.contact=contact;
    availability=new ArrayList<MyDate>();
  }

  /**
   * Gets the teacher's name.
   * @return the teacher's name
   */
  public String getName()
  {
    return name;
  }

  /**
   * Gets the teacher's unavailability.
   * @return the teacher's unavailability
   */
  public ArrayList<MyDate> getAvailability()
  {
    return availability;
  }

  /**
   * Gets the teacher's contact.
   * @return the teacher's contact
   */
  public String getContact()
  {
    return contact;
  }

  /**
   * Sets the teacher's name.
   * @param name what the teacher's name will be set to
   */
  public void setName(String name)
  {
    this.name = name;
  }

  /**
   * Sets the teacher's unavailability
   * @param availability if the teacher is available in this time
   */
  public void setAvailability(ArrayList<MyDate> availability)
  {
    this.availability = availability;
  }

  /**
   * Sets the teacher's contact.
   * @param contact the teacher's contact
   */

  /**
   * Returns a string representation of the teacher.
   * @return a string representation of the teacher in the format: "Name: name Availability: availability Contact: contact"
   */
  public void setContact(String contact)
  {
    this.contact = contact;
  }
  public String toString()
  {
    return "Name:"+name+"\nAvailability:"+availability+"\nContact:"+contact;
  }

  /**
   * Compares name and contact of two teachers.
   * @param obj the object to compare with
   * @return true if the given object is equal to this teacher
   */
  public boolean equals(Object obj)
  {
    if(!(obj instanceof Teacher))
    {
      return false;
    }
    Teacher other=(Teacher) obj;
    return name.equals(other.name) && contact.equals(other.contact) && availability.equals(other.availability);
  }
}
