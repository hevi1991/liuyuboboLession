import java.util.Objects;

public class Student implements Comparable<Student> {
    public String idNo;
    public String name;
    public int score;

    public Student() {
    }

    public Student(String idNo) {
        this.idNo = idNo;
    }

    public Student(String idNo, String name) {
        this.idNo = idNo;
        this.name = name;
    }

    public Student(String idNo, String name, int score) {
        this.idNo = idNo;
        this.name = name;
        this.score = score;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return idNo.equals(student.idNo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idNo);
    }

    @Override
    public int compareTo(Student another) {
        return another.score - this.score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "idNo='" + idNo + '\'' +
                ", name='" + name + '\'' +
                ", score=" + score +
                '}';
    }

    public static void main(String[] args) {
        Array<Student> arr = new Array<Student>();
        arr.addLast(new Student("01", "Alice", 88));
        arr.addLast(new Student("02", "Lisa", 90));
        arr.addLast(new Student("03", "Andrew", 78));
        System.out.println(arr);
    }
}
