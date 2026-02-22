package services;

import Persistence.dao.StudentDAO;
import model.Student;

import java.util.Objects;

public class RegisterStudentsService {
    private final StudentDAO dao;

    public RegisterStudentsService(StudentDAO dao) {
        this.dao = dao;
    }

    public void register(Student student) {
        Objects.requireNonNull(student, "Student must not be null.");

        dao.save(student);
    }
}
