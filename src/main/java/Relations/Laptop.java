package Relations;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "laptops")
public class Laptop {
    @Id
    @SequenceGenerator(name = "laptop_sequence", initialValue = 100, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "laptop_sequence")
    private int id;
    private String name;
    @ManyToMany
    private List<Student> studentList = new ArrayList<Student>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    @Override
    public String toString() {
        return "Laptop{" + "id=" + id + ", name='" + name + '\'' + '}';
    }
}
