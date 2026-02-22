package services;

import Persistence.dao.StudentDAO;
import model.Student;

import java.util.Objects;

public class RemoveStudentsService {
    private final StudentDAO dao;

    public RemoveStudentsService(StudentDAO dao) {
        this.dao = dao;
    }

    public void remove(Student student) {
        Objects.requireNonNull(student, "Student cannot be null.");

        dao.remove(student);
    }
}
