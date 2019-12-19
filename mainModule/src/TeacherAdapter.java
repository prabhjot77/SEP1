import java.io.*;
import java.util.ArrayList;

public class TeacherAdapter
{
  public static void main(String[] args)
  {
    TeacherList teacherList = new TeacherList();
    teacherList.addTeacher( new Teacher( "Lars Bech Sørensen", "LBS@via.dk" ) );
    teacherList.addTeacher( new Teacher( "Allan Rune Henriksen", "ALHE@via.dk" ) );
    teacherList.addTeacher( new Teacher( "Mona Wendel Andersen", "MWA@via.dk" ) );
    teacherList.addTeacher( new Teacher( "Line Lindhardt Egsgaard", "LILE@via.dk" ) );

    try
    {

      FileOutputStream fileOut = new FileOutputStream( "teachers.bin" );
      ObjectOutputStream write = new ObjectOutputStream( fileOut );

      for (int i = 0; i < teacherList.getAllTeachers().size(); i++)
      {
        write.writeObject( teacherList.getAllTeachers().get( i ) );
      }
      write.close();
    }

      catch(FileNotFoundException e){
      System.err.println( "File not found" );
      System.exit( 1 );
    }
      catch(IOException e){
      System.err.println( "IO error writing to a file" );
      System.exit( 1 );
    }
      System.out.println( "Done writing!" );



    try
    {
      FileInputStream fileIn = new FileInputStream( "teachers.bin" );
      ObjectInputStream read = new ObjectInputStream( fileIn );

      while (true)
      {

        try
        {
          Teacher teacher = (Teacher) read.readObject();
          System.out.println( teacher.toString() );
        }
        catch (EOFException eof)
        {
          System.err.println( "End of the file" );
          break;
        }
      }

      read.close();
    }

    catch (FileNotFoundException e){
      System.err.println("File not found");
      System.exit( 1 );
    }
    catch (IOException e){
      System.err.println("IO error writing to a file");
    }
    catch (ClassNotFoundException e){
      System.err.println("Class not found");
      System.exit( 1 );
    }

    System.out.println("Done reading!");









  }

}