package com.ashokit.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.internet.MimeMessage;
import java.io.File;

@Component
public class EmailUtils {

    @Autowired
    private JavaMailSender javaMailSender;

    public boolean sendEmail(String subject, String body, String to, File file){
        try {
            MimeMessage mimeMsg = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMsg,true);

            helper.setSubject(subject);
            helper.setText(body,true);
            helper.setTo("ajitkumarjena824@gmail.com");
            helper.addAttachment("Plans-Info",file);
            javaMailSender.send(mimeMsg);
        }catch (Exception e){
            System.out.println("Satyaprakash Swain"+e);
            e.printStackTrace();
        }
        return true;
    }
}
