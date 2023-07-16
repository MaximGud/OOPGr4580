import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import Controller.Controller;
import Controller.iGetModel;
import Model.ModelFile;
import Model.Student;
import View.ViewEng;

public class App {
    public static void main(String[] args) throws Exception {
        // System.out.println("Hello, World!");

        // List<Student> students = new ArrayList<Student>();
        Student s1 = new Student("Sergei", 21, 101);
        Student s2 = new Student("Andrey", 22, 111);
        Student s3 = new Student("Ivan", 22, 121);
        Student s4 = new Student("Igor", 23, 301);
        Student s5 = new Student("Dasha", 25, 171);
        Student s6 = new Student("Lena", 23, 104);
        // students.add(s1);
        // students.add(s2);
        // students.add(s3);
        // students.add(s4);
        // students.add(s5);
        // students.add(s6);

        HashMap<Long, Student> students = new HashMap<>();
        students.put((long) (s1.getId()), s1);
        students.put((long) (s2.getId()), s2);
        students.put((long) (s3.getId()), s3);
        students.put((long) (s4.getId()), s4);
        students.put((long) (s5.getId()), s5);
        students.put((long) (s6.getId()), s6);

        ModelFile fModel = new ModelFile("StudentDB.txt");
        //fModel.saveAllStudentToFile(students);

       
       // iGetModel modelFile = fModel;
        //iGetModel model = new HachModel(students);
        //iGetView view = new ViewEng();
        ViewEng viewEng = new ViewEng();

        //используется модель - через файл, и вид - английский
        Controller control = new Controller(fModel, viewEng);

       System.out.println(fModel.getAllHashStudents());
        // control.update();
        control.run();

    }
}
