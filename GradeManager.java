import java.util.List;

class GradeManager implements Storable {
    private List<Student> students;
    private FileUtil fileUtil;

    public GradeManager() {
        fileUtil = new FileUtil();
        students = fileUtil.load();
    }

    public void addStudent(Student s) {
        students.add(s);
    }

    public void showStudents() {
        if (students.isEmpty()) {
            System.out.println("No students available.");
            return;
        }
        for (Student s : students) {
            s.display();
        }
    }

    @Override
    public void saveData() {
        Thread t = new Thread(() -> {
            fileUtil.save(students);
            System.out.println("Data saved successfully (Thread).");
        });
        t.start();

        try {
            t.join(); // ensure thread finishes before exit
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted");
        }
    }

    @Override
    public void loadData() {
        List<Student> loaded = fileUtil.load();
        students.clear();
        students.addAll(loaded);
    }
}