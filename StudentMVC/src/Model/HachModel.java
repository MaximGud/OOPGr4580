package Model;

import java.util.HashMap;

import Controller.iGetModel;

public class HachModel implements iGetModel {
  private HashMap<Long, Student> students;

  public HachModel(HashMap<Long, Student> students) {
    this.students = students;
  }

  @Override
  public void deleteStudent(String idStudent, HashMap<Long, Student> students) {
  }

  @Override
  public HashMap<Long, Student> getAllHashStudents() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getAllHashStudents'");
  }

}
