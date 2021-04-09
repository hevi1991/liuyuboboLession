import java.util.Objects;

public class Student2 implements Comparable<Student2> {
    public String idNo;
    public String name;
    public int score;

    public Student2() {
    }

    public Student2(String idNo) {
        this.idNo = idNo;
    }

    public Student2(String idNo, String name) {
        this.idNo = idNo;
        this.name = name;
    }

    public Student2(String idNo, String name, int score) {
        this.idNo = idNo;
        this.name = name;
        this.score = score;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student2 student = (Student2) o;
        return idNo.equals(student.idNo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idNo);
    }

    @Override
    public int compareTo(Student2 another) {
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
}
