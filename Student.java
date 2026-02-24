class Student extends Person implements Grading {
    private double marks;

    public Student(int id, String name, double marks) throws InvalidMarksException {
        super(id, name);
        if (marks < 0 || marks > 100) {
            throw new InvalidMarksException("Marks must be between 0 and 100");
        }
        this.marks = marks;
    }

    public double getMarks() {
        return marks;
    }

    @Override
    public char calculateGrade() {
        if (marks >= 80) {
            return 'A';
        }
        else if (marks >= 60) {
            return 'B';
        }
        else if (marks >= 40) {
            return 'C';
        }
        else {
            return 'F';
        }
    }

    @Override
    public void display() {
        System.out.println("ID    : " + getId());
        System.out.println("Name  : " + getName());
        System.out.println("Marks : " + marks);
        System.out.println("Grade : " + calculateGrade());

    }
}