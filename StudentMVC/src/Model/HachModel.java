package Model;

import java.util.HashMap;

import Controller.iGetModel;

public class HachModel implements iGetModel {
  private HashMap<Long, Student> students;

  public HachModel(HashMap<Long, Student> students) {
    this.students = students;
  }

  

  @Override
  public HashMap<Long, Student> getAllHashStudents() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getAllHashStudents'");
  }



  @Override
  public void deleteStudent(Long idStudent) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'deleteStudent'");
  }

}
