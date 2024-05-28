package tridm.StudentManagement.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Mail {
    private String subject;
    private String msg;
    public Mail(String subject, String msg) {
        this.subject = subject;
        this.msg = msg;
    }
    
}
