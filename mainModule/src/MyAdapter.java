//import java.io.FileNotFoundException;
//import java.io.IOException;
//import java.util.ArrayList;
//
//public class MyAdapter
//{
//  private String fileName;
//  private MyFileIO fileIO;
//
//  public MyAdapter(String fileName){
//    this.fileName = fileName;
//    fileIO = new MyFileIO();
//  }
//
//  public void saveToFile(Mytest mytest){
//    try
//    {
//      fileIO.writeToFile(fileName, mytest);
//    }
//    catch (FileNotFoundException e){
//      System.out.println("File not found");
//    }
//    catch (IOException e){
//      System.out.println("io erroe");
//    }
//
//  }
//
//  public MyList getFromFile(){
//    MyList myList = new MyList();
//    try
//    {
//      myList = (MyList) fileIO.readObjectFromFile(fileName);
//    }
//    catch (FileNotFoundException e){
//      System.out.println("file not found");
//    }
//    catch (IOException e){
//      System.out.println("IO error");
//      e.printStackTrace();
//    }
//    catch (ClassNotFoundException e){
//      System.out.println("class not found");
//    }
//    return myList;
//  }
//}
