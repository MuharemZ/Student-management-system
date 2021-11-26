package se.iths.entity;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Teacher {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long teacherId;

    @NotEmpty
    @NotNull
    @Size(min = 3)
    private String teacherFirstName;

    @NotEmpty
    @NotNull
    @Size(min = 3)
    private String teacherSurName;

    @ManyToOne
    private Student student;

    @OneToMany(mappedBy = "teacher", cascade = CascadeType.ALL)
    private List<Subject> subjects;

    {
        subjects = new ArrayList<>();
    }

    public Teacher (String teacherFirstName, String teacherSurName)
    {
        this.teacherFirstName = teacherFirstName;
        this.teacherSurName = teacherSurName;
    }
    public Teacher(){}

    public void addSubject(Subject subject){
        subjects.add(subject);
        subject.setTeacher(this);
    }

    public Long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Long teacher_id) {
        this.teacherId = teacher_id;
    }

    public String getTeacherFirstName() {
        return teacherFirstName;
    }

    public void setTeacherFirstName(String teacherFirstName) {
        this.teacherFirstName = teacherFirstName;
    }

    public String getTeacherSurName() {
        return teacherSurName;
    }

    public void setTeacherSurName(String teacherSurName) {
        this.teacherSurName = teacherSurName;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @JsonbTransient
    public List<Subject> getSubjects()
    {
        return subjects;
    }

    public void setSubjects(List<Subject> subjects)
    {
        this.subjects = subjects;
    }
}