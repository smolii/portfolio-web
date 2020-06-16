package com.smo.service;


import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;
import com.sendgrid.helpers.mail.objects.Personalization;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.stereotype.Service;

import java.io.IOException;


@Service
@Slf4j
public class MailServiceImpl implements MailService {

    @Value("${app.sendgrid.templateId}")
    private String templateId;

    @Autowired
    private SendGrid sendGrid;

    @Override
    public void send(String toAddress, String subject, String content) {

        Email from = new Email("start800m@gmail.com");
        String title = subject;
        Email to = new Email(toAddress);
        Content text = new Content("text/plain", content);
        Mail mail = new Mail(from, title, to, text);

        try {
            Request request = new Request();

            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(mail.build());
            sendGrid.api(request);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Personalization personalization = new Personalization();
        personalization.addTo(to);
        mail.setTemplateId(templateId);
        try {
            mail.build();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
