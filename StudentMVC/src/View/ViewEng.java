package View;

import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import Controller.iGetView;
import Model.Student;

public class ViewEng implements iGetView {

  @Override
  public void displayStudents(List<Student> students) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'displayStudents'");
  }

  @Override
  public Student readStudent() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'readStudent'");
  }

  @Override
  public Long getStudentIdToUpdate() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getStudentIdToUpdate'");
  }

  @Override
  public String prompt(String msg) {
    Scanner in = new Scanner(System.in);
    System.out.print(msg);
    return in.nextLine();
  }

  @Override
  public void printAllHashStudents(HashMap<Long, Student> students) {
    System.out.println("------List of students--------");

    students.forEach((key, value) -> System.out.println(key + " " + value));

    System.out.println("===============================");
  }

}
