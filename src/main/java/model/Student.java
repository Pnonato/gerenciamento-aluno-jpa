package model;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.BitSet;
import java.util.Objects;

@Entity
@Table
public class Student {
    @Id
    @GeneratedValue
    private long id;
    private String name;
    private String ra;
    private String email;
    private BigDecimal grade1;
    private BigDecimal grade2;
    private BigDecimal grade3;
    @Enumerated(EnumType.STRING)
    private Situation situation;

    public Student() {}

    public Student(String name, String ra, String email, BigDecimal grade1, BigDecimal grade2, BigDecimal grade3) {
        this.name = name;
        this.ra = ra;
        this.email = email;
        this.grade1 = grade1;
        this.grade2 = grade2;
        this.grade3 = grade3;

        final double avarage = getAverage();

        if (avarage >= 6.0)
            this.situation = Situation.APPROVED;
        else if (avarage < 4.0)
            this.situation = Situation.FAILED;
        else
            this.situation = Situation.RECOVERY;

    }
    public double getAverage() {
        return grade1
                .add(grade2)
                .add(grade3)
                .divide(BigDecimal.valueOf(3.0), RoundingMode.HALF_UP)
                .doubleValue();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(getId(), student.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Student{}";
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        Objects.requireNonNull(name, "Name cannot be null");
        this.name = name;
    }

    public String getRa() {
        return ra;
    }

    public void setRa(String ra) {
        Objects.requireNonNull(ra, "RA cannot be null");
        this.ra = ra;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        Objects.requireNonNull(email, "email cannot be null");
        this.email = email;
    }

    public BigDecimal getGrade1() {

        return grade1;
    }

    public void setGrade1(BigDecimal grade1) {
        Objects.requireNonNull(grade1, "grade cannot be null");
        this.grade1 = grade1;
    }

    public BigDecimal getGrade2() {
        return grade2;
    }

    public void setGrade2(BigDecimal grade2) {
        Objects.requireNonNull(grade2, "grade cannot be null");
        this.grade2 = grade2;
    }

    public BigDecimal getGrade3() {
        return grade3;
    }

    public void setGrade3(BigDecimal grade3) {
        Objects.requireNonNull(grade3, "grade cannot be null");
        this.grade3 = grade3;
    }

    public Situation getSituation() {
        return situation;
    }

    public void setSituation(Situation situation) {
        this.situation = situation;
    }
}
