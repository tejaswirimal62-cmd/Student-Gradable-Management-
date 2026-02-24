class GraduateStudent extends Student {

    public GraduateStudent(int id, String name, double marks) throws InvalidMarksException {
        super(id, name, marks);
    }

    @Override
    public char calculateGrade() {
        double marks = getMarks();
        if (marks >= 85) {
            return 'A';
        }
        else if (marks >= 65) {
            return 'B';
        }
        else if (marks >= 50) {
            return 'C';
        }
        else {
            return 'F';
        }
    }

    @Override
    public void display() {
        System.out.println("Type  : Graduate Student");
        System.out.println("ID    : " + getId());
        System.out.println("Name  : " + getName());
        System.out.println("Marks : " + getMarks());
        System.out.println("Grade : " + calculateGrade());
        System.out.println("-------------------------");
    }
}
