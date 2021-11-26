package se.iths.utilities;

import se.iths.entity.Student;
import se.iths.entity.Subject;
import se.iths.entity.Teacher;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Singleton
@Startup

public class SampleData {
    @PersistenceContext
    EntityManager entityManager;

    @PostConstruct
    public void sampleData() {
        Teacher teacher1 = new Teacher("Zinedine", "Zidane");
        Teacher teacher2 = new Teacher("Thierry", "Henry");

        Student student1 = new Student("Muharem", "Zecirovic", "muharem.zecirovic@hotmail.com", "1010");
        Student student2 = new Student("Lionel", "Messi", "lionel.messi@hotmail.com", "101010");
        Student student3 = new Student("Cristiano", "Ronaldo", "cristiano.ronaldo@hotmail.com", "10101010");

        Subject subject1 = new Subject("Technology");
        Subject subject2 = new Subject("Math");
        Subject subject3 = new Subject("Language");


        teacher1.addSubject(subject1);
        teacher1.addSubject(subject2);
        teacher1.addSubject(subject3);

        student1.addSubject(subject1);
        student1.addSubject(subject2);

        student2.addSubject(subject2);
        student2.addSubject(subject3);

        student3.addSubject(subject1);
        student3.addSubject(subject2);

        entityManager.persist(teacher1);
        entityManager.persist(teacher2);

        entityManager.persist(student1);
        entityManager.persist(student2);
        entityManager.persist(student3);
    }
}
