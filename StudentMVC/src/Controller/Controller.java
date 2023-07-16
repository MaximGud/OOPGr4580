package Controller;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import Model.ModelFile;
import Model.Student;
import View.ViewEng;

public class Controller {

    private ModelFile model;
    private ViewEng view;
    private HashMap<Long, Student> students = new HashMap<>();

    public Controller(ModelFile model, ViewEng view) {
        this.model = model;
        this.view = (ViewEng) view;
    }

    private boolean testData(HashMap<Long, Student> students) {
        if (students.size() > 0) {
            return true;
        } else {
            return false;
        }
    }

    public void update() throws NumberFormatException, IOException {
        // MVP
        students = model.getAllHashStudents();
        if (testData(students)) {
            view.printAllHashStudents(students);
        } else {
            System.out.println("Список студентов пуст!");
        }

        // MVC
        // view.printAllStudents(model.getAllStudents());
    }

    public void run() throws NumberFormatException, IOException {
        Command com = Command.NONE;
        boolean getNewIteration = true;
        while (getNewIteration) {
            String command = view.prompt("Enter command:");
            com = Command.valueOf(command.toUpperCase());
            switch (com) {
                case EXIT:
                    getNewIteration = false;
                    System.out.println("Programm stoped");
                    break;
                case LIST:
                    view.printAllHashStudents(model.getAllHashStudents());
                    break;

                case DELETE:
                    String inputId = view.prompt("Enter student ID for delete:");
                    //переводим в лонг
                    Long inputLongId = Long.parseLong(inputId);
                    //удаление студента
                    model.deleteStudent(inputLongId);
                    System.out.println("Student deleted");
                    //печать нового списка
                    view.printAllHashStudents(model.getAllHashStudents());
                    break;

            }

        }

    }
}
