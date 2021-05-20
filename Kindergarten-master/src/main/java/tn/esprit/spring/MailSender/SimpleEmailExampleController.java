package tn.esprit.spring.MailSender;

import java.io.File;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
 
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.MimeMessageHelper;

@Controller
public class SimpleEmailExampleController {
 
    @Autowired
    public JavaMailSender emailSender;
 
    @ResponseBody
    @RequestMapping("/sendAttachmentEmail")
    public String sendAttachmentEmail() throws MessagingException {
 
        MimeMessage message = emailSender.createMimeMessage();
 
        boolean multipart = true;
 
        MimeMessageHelper helper = new MimeMessageHelper(message, multipart);
 
        helper.setTo(MyConstants.FRIEND_EMAIL);
        helper.setSubject("Absence ");
         
        helper.setText("Hello, I am sending you this email, to inform you that the driver ....... of id ...... is absent today, from 9h to 12h\r\n" + 
        		"cordially");
         
        String path1 = "C:\\Users\\wiem\\OneDrive\\Bureau\\test.txt";
        String path2 = "C:\\Users\\wiem\\OneDrive\\Bureau\\ppp.txt";
 
        // Attachment 1
        FileSystemResource file1 = new FileSystemResource(new File(path1));
        helper.addAttachment("Txt file", file1);
 
        // Attachment 2
        FileSystemResource file2 = new FileSystemResource(new File(path2));
        helper.addAttachment("test file", file2);
 
        emailSender.send(message);
 
        return "Email Sent!";
    }
 
}