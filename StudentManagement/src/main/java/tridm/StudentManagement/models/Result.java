package tridm.StudentManagement.models;
import jakarta.persistence.*;

@Entity
@Table(name = "results")
public class Result {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "resultId", nullable = false)
    private Long resultId;

    @ManyToOne
    @JoinColumn(name = "subjectId")
    private Subject subjectId;

    @ManyToOne
    @JoinColumn(name = "studentId", referencedColumnName="studentId")
    private Student studentId;

    @Column(name = "term", nullable = false)
    private int term;

    @Column(name = "year", nullable = false)
    private int year;

    @Column(name = "mark", nullable = false)
    private double mark;

    public Result() {
    }

    public Result(Long resultId, Subject subjectId, Student studentId, int term, int year, double mark) {
        this.resultId = resultId;
        this.subjectId = subjectId;
        this.studentId = studentId;
        this.term = term;
        this.year = year;
        this.mark = mark;
    }

    public Long getResultId() {
        return resultId;
    }

    public void setResultId(Long resultId) {
        this.resultId = resultId;
    }

    public Subject getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Subject subjectId) {
        this.subjectId = subjectId;
    }

    public Student getStudentId() {
        return studentId;
    }

    public void setStudentId(Student studentId) {
        this.studentId = studentId;
    }

    public int getTerm() {
        return term;
    }

    public void setTerm(int term) {
        this.term = term;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getMark() {
        return mark;
    }

    public void setMark(double mark) {
        this.mark = mark;
    }
    
}
