package Model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import Controller.iGetModel;

public class ModelFile implements iGetModel {
    private String fileName = "StudentDB.txt";

    public ModelFile(String fileName) {
        this.fileName = fileName;

        try (FileWriter fw = new FileWriter(fileName, true)) {
            fw.flush();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    // убрали пока list
    // @Override
    // public List<Student> getAllStudents() {
    // List<Student> students = new ArrayList<Student>();
    // try
    // {
    // File file = new File(fileName);
    // FileReader fr = new FileReader(file);
    // BufferedReader reader = new BufferedReader(fr);
    // String line = reader.readLine();
    // while(line!=null)
    // {
    // String[] param = line.split(" ");
    // Student pers = new Student(param[0], Integer.parseInt(param[1]),
    // Integer.parseInt(param[2]));
    // students.add(pers);
    // line = reader.readLine();
    // }

    // }
    // catch(Exception e)
    // {
    // System.out.println(e.getMessage());
    // }

    // return students;
    // }
    // метод сохаренния списка студентов в фал
    public void saveAllStudentToFile(HashMap<Long, Student> students) {
        try (FileWriter fw = new FileWriter(fileName, true)) {
            for (Map.Entry<Long, Student> mapElement : students.entrySet()) {

                fw.write(mapElement.getKey() + " : " + mapElement.getValue());
                fw.append('\n');
            }
            fw.flush();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override // метод получения списка студентов из файла
    public HashMap<Long, Student> getAllHashStudents() {
        // создаем новый список
        HashMap<Long, Student> students = new HashMap<Long, Student>();
        try {
            File file = new File(fileName);
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);
            String line = reader.readLine();
            while (line != null) {
                // читаем строку, разделяем ее по символу ":" разделяющим ключи и значение
                String[] param = line.split(" : ");
                // переводим стринг в лонг (ключ)
                Long number = Long.parseLong(param[0]);
                // убираем пробелы во втрой части строки
                String[] param2 = param[1].trim().split(" ");
                Student pers = new Student(param2[0], Integer.parseInt(param2[1]), Integer.parseInt(param[0]));
                // заносим данные в новый список
                students.put(number, pers);
                line = reader.readLine();
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        // возвращаем  список студентов
        return students;
    }

    @Override // метод удаления студента из списка по ID
    public void deleteStudent(Long idStudent) {
        // считываем список студентов с файла
        HashMap<Long, Student> students2 = getAllHashStudents();
        // удаляем студента в списке по ключу
        if (students2.containsKey(idStudent)) {
            students2.remove(idStudent);
        }
        // записываем новый список студентов в вфайл
        saveAllStudentToFile(students2);

    }
}
