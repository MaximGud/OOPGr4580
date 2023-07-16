package Controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;


import Model.Student;

public interface iGetModel {
        
    public HashMap<Long,Student> getAllHashStudents() throws FileNotFoundException, NumberFormatException, IOException;
    public void deleteStudent(Long idStudent);
}
