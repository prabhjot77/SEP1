import javafx.application.Platform;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable
{
  public TableView teachersTable;
  public TableColumn<Teacher, String> teacherNameColumn;
  public TableColumn<Object, Object> emailColumn;
  public Button deleteTeacher;
  public TextField teacherName;
  public Button addTeacher;
  public TextField email;
  public Button deleteCourse;
  public TextField courseName;
  public ComboBox<Teacher> selectTeacher;
  public Button addCourse;
  public TextField studentsNumber;
  public TableColumn<Course, String> courseNameColumn;
  public TableColumn<Course, String> teacherColumn;
  public TableColumn<Course, String> studentsColumn;
  public TableView<Course> coursesTable;
  public TableView<Exam> examTable;
  public TableColumn<Exam, String> selectCourseColumn;
  public TableColumn<Exam, String> selectRoomColumn;
  public TableColumn<Exam, String> dateColumn;
  public TableColumn<Exam, String> coExaminerColumn;
  public Button deleteExam;
  public ComboBox selectCourse;
  public ComboBox selectRoom;
  public ComboBox startHour;
  public ComboBox startMinute;
  public DatePicker selectDate;
  public Button addExam;
  public TextField coExaminer;
  public ComboBox assignSchedule;
  public ComboBox endHour;
  public ComboBox endMinute;
  public Label examWarning;
  public ComboBox isWritten;
  public ComboBox<ExamSchedule> selectSchedule;
  public Button exportSchedule;
  public Button deleteSchedule;
  public TextField scheduleText;
  public Button addSchedule;
  public Label scheduleWarning;
  @FXML Label teacherWarning;
  @FXML private Label roomWarning;
  @FXML private Label teacherExists;
  @FXML private Label roomExists;
  @FXML private Label roomValidation;
  @FXML private Label notEnoughSeats;
  @FXML private Label notSuitable;
  @FXML private Label examExists;
  @FXML private Label courseWarning;
  @FXML private Label courseValidation;
  @FXML private AnchorPane selection;
  @FXML private AnchorPane root;
  @FXML private TextField myText;
  @FXML private TabPane tabpane;
  @FXML private Button addRoom;
  @FXML private TextField seats;
  @FXML private ComboBox<String> projector;
  @FXML private ComboBox<String> hdmi;
  @FXML private ComboBox<String> vgafield;
  @FXML TextField roomNumber;
  @FXML private Button deleterow;

  @FXML TableView<Room> roomsTable;
  @FXML private TableColumn<Room, String> roomNumberTab;
  @FXML private TableColumn<Room, String> projectorTab;
  @FXML private TableColumn<Room, String> hdmiTab;
  @FXML private TableColumn<Room, String> vgaTab;
  @FXML private TableColumn<Room, String> seatsTab;

  private RoomList roomList;
  private ObservableList<Room> allRooms;
  private TeacherList teacherList;
  private ObservableList<Teacher> allTeachers;
  private CourseList courseList;
  private ObservableList<Course> allCourses;
  private ExamList examList;
  private ObservableList<Exam> allExams;
  private ExamScheduleList scheduleList;
  private ObservableList<ExamSchedule> allSchedules;

  private double x = 0;
  private double y = 0;
  private Stage stage;

  private Adapter adapter;

  @Override public void initialize(URL url, ResourceBundle resourceBundle)
  {
    adapter = new Adapter();
    makeDraggable();
    Platform.runLater(() -> root.requestFocus()); // Disable automatic focus of textfield
    // Rooms tab
    roomNumberTab.setCellValueFactory(new PropertyValueFactory<>("number"));
    projectorTab.setCellValueFactory(cellData -> {
      boolean isProjector = cellData.getValue().isProjector();
      String str;
      if (isProjector)
      {
        str = "Available";
      }
      else
      {
        str = "-";
      }

      return new ReadOnlyStringWrapper(str);
    });
    hdmiTab.setCellValueFactory(cellData -> {
      boolean isProjector = cellData.getValue().isHDMI();
      String str;
      if (isProjector)
      {
        str = "Available";
      }
      else
      {
        str = "-";
      }

      return new ReadOnlyStringWrapper(str);
    });
    vgaTab.setCellValueFactory(cellData -> {
      boolean isProjector = cellData.getValue().isVGA();
      String str;
      if (isProjector)
      {
        str = "Available";
      }
      else
      {
        str = "-";
      }

      return new ReadOnlyStringWrapper(str);
    });
    seatsTab.setCellValueFactory(new PropertyValueFactory<>("seatsCapacity"));

    Adapter getdapter = new Adapter();
    File roomFile = new File("rooms.bin");
    if (!roomFile.isFile())
    {
      getdapter.writeRoomData(roomList);
    }
    roomList = getdapter.readRoomData();

    allRooms = FXCollections.observableArrayList();
    if (roomList != null)
    {
      for (int i = 0; i < roomList.getAllRooms().size(); i++)
      {
        allRooms.add(roomList.getRoom(i));
      }
    }
    else
    {
      roomList = new RoomList();
    }

    roomsTable.setItems(allRooms);
    roomsTable.getSortOrder().add(roomNumberTab);

    projector.getItems().addAll("Yes", "No");
    hdmi.getItems().addAll("Yes", "No");
    vgafield.getItems().addAll("Yes", "No");

    // Teachers Tab
    teacherNameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
    emailColumn.setCellValueFactory(new PropertyValueFactory<>("contact"));

    // Make teachers.bin file if doesn't exist.
    File teacherfile = new File("teachers.bin");
    if (!teacherfile.isFile())
    {
      getdapter.writeTeacherData(teacherList);
    }
    teacherList = getdapter.readTeacherData();

    allTeachers = FXCollections.observableArrayList();
    if (teacherList != null)
    {
      for (int i = 0; i < teacherList.getAllTeachers().size(); i++)
      {
        allTeachers.add(teacherList.getTeacher(i));
      }
    }
    else
    {
      teacherList = new TeacherList();
    }

    teachersTable.setItems(allTeachers);
    teachersTable.getSortOrder().add(teacherNameColumn);

    // Courses Tab
    selectTeacher.setItems(allTeachers);
    isWritten.getItems().addAll("Oral", "Written");

    courseNameColumn.setCellValueFactory(new PropertyValueFactory<>("courseName"));
    teacherColumn.setCellValueFactory(cellData -> {
      String teacherName = cellData.getValue().getTeacher().getName();
      return new ReadOnlyStringWrapper(teacherName);
    });
    studentsColumn.setCellValueFactory(cellData -> {
      String students = "" + cellData.getValue().getNumberOfStudents();
      return new ReadOnlyStringWrapper(students);
    });

    // Make courses.bin file if doesn't exist.
    File coursefile = new File("courses.bin");
    if (!coursefile.isFile())
    {
      getdapter.writeCourseData(courseList);
    }
    courseList = getdapter.readCourseData();

    allCourses = FXCollections.observableArrayList();
    if (courseList != null)
    {
      for (int i = 0; i < courseList.getAllCourses().size(); i++)
      {
        allCourses.add(courseList.getCourse(i));
      }
    }
    else
    {
      courseList = new CourseList();
    }

    coursesTable.setItems(allCourses);
    coursesTable.getSortOrder().add(courseNameColumn);

    // Exam Tab
    selectCourse.setItems(allCourses);
    selectRoom.setItems(allRooms);

    coExaminerColumn.setCellValueFactory(new PropertyValueFactory<>("coExaminer"));
    selectCourseColumn.setCellValueFactory(cellData -> {
      String courseName1 = cellData.getValue().getCourse().getCourseName();
      return new ReadOnlyStringWrapper(courseName1);
    });
    selectRoomColumn.setCellValueFactory(cellData -> {
      String room1 = "" + cellData.getValue().getRoom().getNumber();
      return new ReadOnlyStringWrapper(room1);
    });
    dateColumn.setCellValueFactory(cellData -> {
      String date1 = "" + cellData.getValue().getDate().toString();
      return new ReadOnlyStringWrapper(date1);
    });

    // Make exams.bin file if doesn't exist.
    File examFile = new File("exams.bin");
    if (!examFile.isFile())
    {
      getdapter.writeExamData(examList);
    }
    examList = getdapter.readExamData();

    allExams = FXCollections.observableArrayList();
    if (examList != null)
    {
      for (int i = 0; i < examList.getAllExams().size(); i++)
      {
        allExams.add(examList.getExam(i));
      }
    }
    else
    {
      examList = new ExamList();
    }

    examTable.setItems(allExams);
    examTable.getSortOrder().add(selectCourseColumn);

    for (int i = 00; i < 24; i++)
    {
      startHour.getItems().add(i);
      endHour.getItems().add(i);
    }

    for (int i = 00; i < 60; i++)
    {
      startMinute.getItems().add(i);
      endMinute.getItems().add(i);
    }

    // Exam Schedule Tab

    File scheduleFile = new File("schedule.bin");
    if (!scheduleFile.isFile())
    { // Make schedule.bin file if doesn't exist.
      getdapter.writeScheduleData(scheduleList);
    }
    scheduleList = getdapter.readscheduleData();

    if (scheduleList != null)
    {
      for (int i = 0; i < scheduleList.getAllExamSchedules().size(); i++)
      {
        selectSchedule.getItems().add(scheduleList.getExamSchedule(i));
        assignSchedule.getItems().add(scheduleList.getExamSchedule(i));
      }
    }
    else
    {
      scheduleList = new ExamScheduleList();
    }
  }

  // Add a new room in the list
  public void addRoom(ActionEvent e)
  {
    if (roomNumber.getText().equals("") || seats.getText().equals("") || projector.getSelectionModel().isEmpty() || hdmi.getSelectionModel().isEmpty() || vgafield.getSelectionModel().isEmpty()){
      roomWarning.setOpacity(1.0);
      return;
    }
    else {
      roomWarning.setOpacity(0.0);
    }
    String getText = roomNumber.getText();
    Boolean hasProjector = projector.getSelectionModel().getSelectedItem().equals("Yes");
    Boolean hasHDMI = hdmi.getSelectionModel().getSelectedItem().equals("Yes");
    Boolean hasVGA = vgafield.getSelectionModel().getSelectedItem().equals("Yes");
    int numbers = Integer.parseInt(seats.getText());
    Room newRoom = new Room(getText, hasProjector, hasHDMI, hasVGA, numbers);
    roomList.addRoom(newRoom);
    if (roomList.isRoomExists()){
      roomExists.setOpacity(1.0);
      return;
    }
    else {
      roomExists.setOpacity(0.0);
    }

    allRooms.add(newRoom);
    adapter.writeRoomData(roomList);
    roomNumber.clear();
    seats.clear();
    projector.valueProperty().setValue(null);
    hdmi.valueProperty().setValue(null);
    vgafield.valueProperty().setValue(null);
  }

  //Delete a room
  public void deleteRow(ActionEvent e)
  {
    roomList.removeRoom(roomsTable.getSelectionModel().getSelectedItem());
    allRooms.remove(roomsTable.getSelectionModel().getSelectedItem());
    Adapter newAdapter = new Adapter();
    newAdapter.writeRoomData(roomList);
    roomsTable.getSelectionModel().clearSelection();
  }

  // Edit a room
  public void editRoom(ActionEvent e)
  {
    int i = roomsTable.getSelectionModel().getSelectedIndex();
    Room selectedRoom = roomList.getRoom(i);
    String seating = "" + selectedRoom.getSeatsCapacity();
    String projectorValue = (selectedRoom.isProjector()) ? "Yes" : "No";
    String hdmiValue = (selectedRoom.isHDMI()) ? "Yes" : "No";
    String vgaValue = (selectedRoom.isVGA()) ? "Yes" : "No";
    roomNumber.setText(selectedRoom.getNumber());
    seats.setText(seating);
    projector.valueProperty().setValue(projectorValue);
    hdmi.valueProperty().setValue(hdmiValue);
    vgafield.valueProperty().setValue(vgaValue);
    addRoom.setText("Save");
  }




  public void addTeacher(ActionEvent event)
  {
    if (teacherName.getText().equals("") || email.getText().equals("")){
      teacherWarning.setOpacity(1.0);
      return;
    }
    else {
      teacherWarning.setOpacity(0.0);
    }
    Teacher newTeacher = new Teacher(teacherName.getText(), email.getText());
    teacherList.addTeacher(newTeacher);
    if (teacherList.isTeacherExists()){
      teacherExists.setOpacity(1.0);
      return;
    }
    else {
      teacherExists.setOpacity(0.0);
    }
    allTeachers.add(newTeacher);
    adapter.writeTeacherData(teacherList);
    teacherName.clear();
    email.clear();
  }

  public void deleteTeacher(ActionEvent event)
  {
    teacherList.removeTeacher((Teacher) teachersTable.getSelectionModel().getSelectedItem());
    allTeachers.remove(teachersTable.getSelectionModel().getSelectedItem());
    Adapter newAdapter = new Adapter();
    newAdapter.writeTeacherData(teacherList);
    teachersTable.getSelectionModel().clearSelection();
  }

  public void addCourse(ActionEvent event)
  {
    if (courseName.getText().equals("") || selectTeacher.getSelectionModel().isEmpty() || studentsNumber.getText().equals("") || isWritten
        .getSelectionModel().isEmpty())
    {
      courseWarning.setOpacity(1.0);
      return;
    }
    else
    {
      courseWarning.setOpacity(0.0);
    }
    boolean examType = isWritten.getSelectionModel().getSelectedItem().equals("Written");

    Course newCourse = new Course(courseName.getText(), selectTeacher.getSelectionModel().getSelectedItem(), Integer.parseInt(studentsNumber.getText()), examType);
    courseList.addCourse(newCourse);
    if (courseList.getCourseExists()){
      courseValidation.setOpacity(1.0);
      return;
    }
    else {
      courseValidation.setOpacity(0.0);
    }

    allCourses.add(newCourse);
    adapter.writeCourseData(courseList);
    courseName.clear();
    selectTeacher.getSelectionModel().clearSelection();
    studentsNumber.clear();
    isWritten.valueProperty().setValue(null);
  }

  public void deleteCourse(ActionEvent event)
  {
    courseList.removeCourse((Course) coursesTable.getSelectionModel().getSelectedItem());
    allCourses.remove(coursesTable.getSelectionModel().getSelectedItem());
    Adapter newAdapter = new Adapter();
    newAdapter.writeCourseData(courseList);
    coursesTable.getSelectionModel().clearSelection();
  }

  public void addExam(ActionEvent e)
  {

    if (selectCourse.getSelectionModel().isEmpty() || selectRoom.getSelectionModel().isEmpty() || startHour.getSelectionModel().isEmpty() || startMinute.getSelectionModel().isEmpty() || endHour.getSelectionModel().isEmpty() || endMinute.getSelectionModel().isEmpty() || selectDate.getValue() == null || assignSchedule.getValue() == null)
    {
      examWarning.setOpacity(1.0);
      return;
    }
    else
    {
      examWarning.setOpacity(0.0);
    }

    TimePeriod timePeriod = new TimePeriod((int) startHour.getSelectionModel().getSelectedItem(),
        (int) startMinute.getSelectionModel().getSelectedItem(),
        (int) endHour.getSelectionModel().getSelectedItem(),
        (int) endMinute.getSelectionModel().getSelectedItem());
    MyDate myDate = new MyDate(selectDate.getValue().getDayOfMonth(),
        selectDate.getValue().getMonthValue(), selectDate.getValue().getYear(),
        timePeriod);

    roomValidation.setOpacity(0.0);
    Exam newExam = null;
    if (coExaminer.getText().equals(""))
    {
      newExam = new Exam((Course) selectCourse.getSelectionModel().getSelectedItem(), (Room) selectRoom.getSelectionModel().getSelectedItem(), myDate);

    }
    else
    {
      newExam = new Exam((Course) selectCourse.getSelectionModel().getSelectedItem(), (Room) selectRoom.getSelectionModel().getSelectedItem(), myDate, coExaminer.getText());

    }


    ExamSchedule findSchedule = (ExamSchedule) assignSchedule.getSelectionModel().getSelectedItem();


    if (((Room) selectRoom.getSelectionModel().getSelectedItem()).getSeatsCapacity() < ((Course) selectCourse.getSelectionModel().getSelectedItem()).getNumberOfStudents() && ((Course) selectCourse.getSelectionModel().getSelectedItem()).getisWritten()){
      notEnoughSeats.setOpacity(1.0);
      notSuitable.setOpacity(0.0);
      return;
    }
    else if (!(((Course) selectCourse.getSelectionModel().getSelectedItem()).getisWritten()) && !(((Room) selectRoom.getSelectionModel().getSelectedItem()).isProjector())){
      notSuitable.setOpacity(1.0);
      notEnoughSeats.setOpacity(0.0);
      return;
    }
    else {
      notSuitable.setOpacity(0.0);
      notEnoughSeats.setOpacity(0.0);
    }

    examList.addExam(newExam);

    if (examList.getRoomBooked()){
      roomValidation.setOpacity(1.0);
      examExists.setOpacity(0.0);
      return;
    }
    else if (examList.getExamExists()){
      examExists.setOpacity(1.0);
      roomValidation.setOpacity(0.0);
      return;
    }
    else {
      roomValidation.setOpacity(0.0);
      examExists.setOpacity(0.0);
      notEnoughSeats.setOpacity(0.0);
    }



    findSchedule.addExam(newExam);
    allExams.add(newExam);
    adapter.writeExamData(examList);
    adapter.writeScheduleData(scheduleList);
    coExaminer.clear();
    selectCourse.valueProperty().setValue(null);
    selectRoom.valueProperty().setValue(null);
    selectDate.valueProperty().setValue(null);
    startHour.valueProperty().setValue(null);
    startMinute.valueProperty().setValue(null);
    endHour.valueProperty().setValue(null);
    endMinute.valueProperty().setValue(null);
  }


  public void deleteExam(ActionEvent e){
    examList.removeExam(examTable.getSelectionModel().getSelectedItem());
    allExams.remove(examTable.getSelectionModel().getSelectedItem());
    Adapter newAdapter = new Adapter();
    newAdapter.writeExamData(examList);
    examTable.getSelectionModel().clearSelection();
  }

  public void addSchedule(ActionEvent e){
    if (scheduleText.getText().equals("")){
      scheduleWarning.setOpacity(1.0);
      return;
    }
    else {
      scheduleWarning.setOpacity(0.0);
    }



    ExamSchedule newSchedule = new ExamSchedule(scheduleText.getText());
    scheduleList.addSchedule(newSchedule);
    selectSchedule.getItems().add(newSchedule);
    assignSchedule.getItems().add(newSchedule);
    adapter.writeScheduleData(scheduleList);
    scheduleText.clear();
  }

  public void exportSchedule(ActionEvent e){
    ExamSchedule selected = selectSchedule.getValue();
    String filename = selected.getName() + ".xml";
    XMLAdapter xmlAdapter = new XMLAdapter();
    xmlAdapter.writeData(selected, filename);
  }

  // text fields restricted to numbers
  public void keyEnter(KeyEvent event)
  {
    numberOnly(studentsNumber);
    numberOnly(seats);
  }

  public void numberOnly(TextField textField)
  {
    String input = textField.getText();
    String newText = input.replaceAll("[^0-9]", "");
    textField.setText(newText);
    textField.positionCaret(newText.length());
  }

  public void minimizeWindow(MouseEvent event)
  {
    stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    stage.setIconified(true);
  }

  public void closeWindow(MouseEvent e){
    System.exit(0);
  }

  public void makeDraggable()
  {
    StackPane headerArea = (StackPane) tabpane.lookup(".tab-header-area");
    selection.setOnMousePressed((event) -> {
      x = event.getSceneX();
      y = event.getSceneY();
    });

    selection.setOnMouseDragged((event) -> {
      stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
      stage.setX(event.getScreenX() - x);
      stage.setY(event.getScreenY() - y);
    });
  }
}
