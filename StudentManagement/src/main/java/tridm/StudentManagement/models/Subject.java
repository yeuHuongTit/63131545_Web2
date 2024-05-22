package tridm.StudentManagement.models;
import jakarta.persistence.*;

@Entity
@Table(name = "subjects")
public class Subject {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "subjectId", nullable = false)
	private Long subjectId;

	@Column(name = "name", nullable = false)
	private String name;

	@Column(name = "nOCredits", nullable = false)
	private int nOCredits;

    public Subject() {
    }

    public Subject(Long subjectId, String name, int nOCredits) {
        this.subjectId = subjectId;
        this.name = name;
        this.nOCredits = nOCredits;
    }

    public Long getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Long subjectId) {
        this.subjectId = subjectId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNOCredits() {
        return nOCredits;
    }

    public void setNOCredits(int nOCredits) {
        this.nOCredits = nOCredits;
    }
    
}
