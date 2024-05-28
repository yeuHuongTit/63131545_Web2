package tridm.StudentManagement.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

@Configuration
public class MailConfig {

    @Bean
    public JavaMailSender javaMailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("smtp.gmail.com"); // Thay bằng host SMTP của bạn
        mailSender.setPort(587);

        mailSender.setUsername("tri.dm.63cntt@ntu.edu.vn"); // Thay bằng email của bạn
        mailSender.setPassword("scjrbfaogciwqryp"); // Thay bằng mật khẩu của bạn

        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.debug", "true"); // Chỉ để debug, có thể bỏ qua trong môi trường production

        return mailSender;
    }
}