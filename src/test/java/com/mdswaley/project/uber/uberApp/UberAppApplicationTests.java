package com.mdswaley.project.uber.uberApp;

import com.mdswaley.project.uber.uberApp.services.EmailSenderService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UberAppApplicationTests {
    @Autowired
    private EmailSenderService emailSenderService;

    @Test
    void contextLoad(){
        emailSenderService.sendEmail("rupeshkumarpanda221@gmail.com",
                "Test send mail", "This is first mail.");
    }

    @Test
    void contestLoad2(){
        String[] emails = {"cigof21135@fanchatu.com",
                "mdswaley075@gmail.com",
                "zk920943@gmail.com",
                "rajasonu9438@gmail.com"
        };

        emailSenderService.sendEmail(emails, "Uber Application Developed by - MD Swaley",
                "This is a test message for checking mails are send or not.");
    }


}
