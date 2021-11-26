package se.iths.entity;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
    public class Subject {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long subjectID;

        @NotEmpty
        @NotNull
        @Size(min = 3)
        private String subjectName;

        @ManyToMany
        private List<Student> students = new ArrayList<>();

        @ManyToOne
        private Teacher teacher;

        public Subject(String subjectName)
        {
            this.subjectName = subjectName;
        }

        public Subject(){}

        public List<Student> getStudents() {
            return students;
        }

        public void setStudents(List<Student> students) {
            this.students = students;
        }

        public Long getSubjectId() {
            return subjectID;
        }

        public void setSubjectId(Long subjectID) {
            this.subjectID = subjectID;
        }

        public String getSubjectName() {
            return subjectName;
        }

        public void setSubjectName(String subName) {
            this.subjectName = subName;
        }

        public Teacher getTeacher() {
            return teacher;
        }

        public void setTeacher(Teacher teacher) {
            this.teacher = teacher;
        }
    }
