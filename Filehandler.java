import java.io.*;
import java.util.ArrayList;
import java.util.List;

class FileUtil {
    private final String fileName = "students.txt";

    public void save(List<Student> students) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))) {
            for (Student s : students) {
                String type = (s instanceof GraduateStudent) ? "G" : "S";
                bw.write(type + "," + s.getId() + "," + s.getName() + "," + s.getMarks());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving file");
        }
    }

    public List<Student> load() {
        List<Student> list = new ArrayList<>();
        File file = new File(fileName);
        if (!file.exists()) return list;

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                String type = data[0];
                int id = Integer.parseInt(data[1]);
                String name = data[2];
                double marks = Double.parseDouble(data[3]);

                if (type.equals("G"))
                    list.add(new GraduateStudent(id, name, marks));
                else
                    list.add(new Student(id, name, marks));
            }
        } catch (Exception e) {
            System.out.println("Error loading file");
        }
        return list;
    }
}