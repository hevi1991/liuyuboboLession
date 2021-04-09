package src;

import java.util.Objects;

public class Student {
    public String idNo;
    public String name;

    public Student() {
    }

    public Student(String idNo) {
        this.idNo = idNo;
    }

    public Student(String idNo, String name) {
        this.idNo = idNo;
        this.name = name;
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
}
