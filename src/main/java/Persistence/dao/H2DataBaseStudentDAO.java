package Persistence.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.NoResultException;
import model.Student;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public class H2DataBaseStudentDAO implements StudentDAO{
    private final EntityManager entityManager;

    public H2DataBaseStudentDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void save(Student student) {
     final EntityTransaction transaction = entityManager.getTransaction();

     transaction.begin();
     entityManager.persist(student);
     transaction.commit();
    }

    @Override
    public List<Student> findAll() {
        final String query = "SELECT s FROM Student s";
        return entityManager.createQuery(query, Student.class).getResultList();
    }

    @Override
    public Optional<Student> findByName(String name) {
        final String query = "SELECT s from Student s WHERE s.name = :name";

        try {
            return Optional.of(entityManager.createQuery(query, Student.class)
                    .setParameter("name", name)
                    .getSingleResult());
        } catch (NoResultException exception) {
            return Optional.empty();
        }
    }

    @Override
    public void update(Student student, String name, String ra, String email, BigDecimal grade1, BigDecimal grade2, BigDecimal grade3) {
     final EntityTransaction transaction = entityManager.getTransaction();

     transaction.begin();

     student.setName(name);
     student.setEmail(email);
     student.setRa(ra);
     student.setGrade1(grade1);
     student.setGrade2(grade2);
     student.setGrade3(grade3);

     transaction.commit();
    }

    @Override
    public void remove(Student student) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        Student managed = entityManager.merge(student);
        entityManager.remove(managed);

        transaction.commit();
    }
}
