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
                String value1 = param[1].trim();
                // определяем лишние символы для уделения
                String[] charsToRemove = { ",", "[", "]", "Students", "age=", "name=", "id=" };

                for (String c : charsToRemove) {

                    value1 = value1.replace(String.valueOf(c), "");
                }
                // разделяем по пробелу получивушюся строку на массив строк из значений
                String[] param2 = value1.split(" ");
                // относим их на тип Студент
                Student pers = new Student(param2[1], Integer.parseInt(param2[0]), Integer.parseInt(param2[2]));
                students.put(number, pers);
                line = reader.readLine();
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        // возвращаем новый списко студентов
        return students;
    }

    @Override // метод удаления студента из списка по ID
    public void deleteStudent(String idStudent, HashMap<Long, Student> students) throws FileNotFoundException {
        long idStud = Long.parseLong(idStudent);

        // открываем файл
        File file = new File(fileName);
        Scanner scanner = new Scanner(file);

        while (scanner.hasNext()) {
            // Считываем строки из файла
            String line = scanner.nextLine();

            // Разбиваем строку на пары ключ-значение
            String[] tokens = line.split(":");

            if (tokens.length == 2) {
                // Преобразуем Long в Long
                Long key = Long.parseLong(tokens[0]);
                // разбиваем вторую часть строки на тип данных Student
                // удаляем пунктуацию
                String str = tokens[1].trim().replaceAll("\\p{Punct}", "");
                String[] param2 = str.split(" ");
                Student pers = new Student(param2[1], Integer.parseInt(param2[2]), Integer.parseInt(param2[3]));

                // Если ключ уже есть в коллекции, удаляем его и значение
                if (students.containsKey(idStud)) {
                    students.remove(idStud);
                }

                students.put(key, pers);
            }
        }

        // Закрываем файл
        scanner.close();

        // Записываем коллекцию в файл
        try (FileWriter fw = new FileWriter(fileName, true)) {
            for (Map.Entry<Long, Student> mapElement : students.entrySet()) {

                fw.write(mapElement.getKey() + " " + mapElement.getValue());
                fw.append('\n');
            }
            fw.flush();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
